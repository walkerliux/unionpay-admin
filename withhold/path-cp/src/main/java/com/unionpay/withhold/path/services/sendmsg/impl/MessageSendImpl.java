package com.unionpay.withhold.path.services.sendmsg.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.path.constants.bean.MessageStrBean;
import com.unionpay.withhold.path.constants.enums.CacheKeyCP;
import com.unionpay.withhold.path.constants.enums.ErrorCodePCP;
import com.unionpay.withhold.path.exception.CPBusException;
import com.unionpay.withhold.path.netty.client.NettyClientBootstrap;
import com.unionpay.withhold.path.netty.client.SocketChannelHelper;
import com.unionpay.withhold.path.services.cache.DataCache;
import com.unionpay.withhold.path.services.rtwithhold.RealtimeWithholdSrv;
import com.unionpay.withhold.path.services.sendmsg.MessageSend;
import com.unionpay.withhold.path.utils.MsgLogUtil;
import com.unionpay.withhold.path.utils.thread.ThreadPoolProcessor;

@Service("messageSend")
public class MessageSendImpl implements MessageSend {

    private static final Logger logger = LoggerFactory.getLogger(MessageSendImpl.class);

    private ResultBean resultBean = null;

    @Resource
    private DataCache dataCache;

    @Resource
    private RealtimeWithholdSrv realtimeWithholdSrv;

    @Override
    public ResultBean sendMessage(MessageStrBean messageBean) throws CPBusException {
        byte[] sendMsg = messageBean.getSendMsgBytes();
        logger.info("【sendMsg is~~~】:" + "\n" + MsgLogUtil.formatLogHex(sendMsg));
        logger.info("【sendMsg length is~~~】:" + sendMsg.length);

        ThreadPoolProcessor pool = ThreadPoolProcessor.getInstanceCached();
        MsgSender msgSender = new MsgSender(sendMsg);
        pool.execute(msgSender);

        resultBean = new ResultBean();
        resultBean.setResultBool(true);
        return resultBean;
    }

    class MsgSender implements Runnable {

        private byte[] sendMsgFe;

        public MsgSender(byte[] sendMsg) {
            super();
            sendMsgFe = new byte[sendMsg.length];
            System.arraycopy(sendMsg, 0, sendMsgFe, 0, sendMsg.length);
        }

        @Override
        public void run() {
            try {
                SocketChannelHelper socketChannelHelper = SocketChannelHelper.getInstance();
                String hostAddress = socketChannelHelper.getMessageConfigService().getString("HOST_ADDRESS", dataCache.getValue(CacheKeyCP.HOSTADDR));// 主机名称
                int hostPort = socketChannelHelper.getMessageConfigService().getInt("HOST_PORT", Integer.parseInt(dataCache.getValue(CacheKeyCP.HOSTPORT)));// 主机端口
                NettyClientBootstrap bootstrap = new NettyClientBootstrap(hostPort, hostAddress);
                bootstrap.sendMessage(sendMsgFe);
            }
            catch (Exception e) {
                logger.error("【send message to ChinaPay failed！！！】", e);
                CPBusException exception = new CPBusException(ErrorCodePCP.SEND_FAILED.getValue(), ErrorCodePCP.SEND_FAILED.getDisplayName());
                realtimeWithholdSrv.recordSendMsgErrInfo(exception, sendMsgFe);
            }
        }

    }

}
