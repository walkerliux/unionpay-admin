package com.unionpay.withhold.path.services.rtwithhold.impl;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unionpay.withhold.common.bean.ResultBean;
import com.unionpay.withhold.common.constants.ComConst;
import com.unionpay.withhold.path.constants.bean.MessageStrBean;
import com.unionpay.withhold.path.constants.bean.RTWithholdRespBean;
import com.unionpay.withhold.path.constants.bean.RTWithholdSerNumBean;
import com.unionpay.withhold.path.constants.enums.ErrorCodePCP;
import com.unionpay.withhold.path.constants.enums.MessageTypeEnum;
import com.unionpay.withhold.path.exception.CPBusException;
import com.unionpay.withhold.path.model.ChnlCpdkLog;
import com.unionpay.withhold.path.services.assmsg.MessageAssemble;
import com.unionpay.withhold.path.services.rtwithhold.PaymentRecordSrv;
import com.unionpay.withhold.path.services.rtwithhold.RealtimeWithholdSrv;
import com.unionpay.withhold.path.services.sendmsg.MessageSend;
import com.unionpay.withhold.path.services.serial.SerialNumberService;
import com.unionpay.withhold.service.path.cp.dto.req.RTWithholdAppReqDto;

@Service("realtimeWithholdSrv")
public class RealtimeWithholdSrvImpl implements RealtimeWithholdSrv {

    private static final Logger logger = LoggerFactory.getLogger(RealtimeWithholdSrvImpl.class);

    @Autowired
    private SerialNumberService serialNumberService;
    @Resource
    private MessageAssemble messageAssemble;
    @Resource
    private PaymentRecordSrv paymentRecordSrv;
    @Resource
    private MessageSend messageSend;

    @Override
    public ResultBean applyRTWithhold(RTWithholdAppReqDto rtWithholdAppReqDto) {
        try {
            // 业务规则校验
            businessCheck(rtWithholdAppReqDto);
            // 报文组装
            RTWithholdSerNumBean trWithholdSerNumBean = messageAssemble.assembleRTWithhold(rtWithholdAppReqDto);
            logger.info("[assembled realtime withhold message is]:" + trWithholdSerNumBean.toString());
            byte[] signedMsg = messageAssemble.sign(trWithholdSerNumBean);
            logger.info("[assembled realtime withhold message is]:" + new String(signedMsg, ComConst.CHARSET));
            // 记录通道报文流水信息
            ChnlCpdkLog chnlCpdkLog = paymentRecordSrv.createPaymentRec(trWithholdSerNumBean);
            // 更新核心交易流水支付信息
            paymentRecordSrv.updateTxnPaymentRec(chnlCpdkLog);
            // 发送报文
            MessageStrBean messageBean = new MessageStrBean();
            messageBean.setMessageType(MessageTypeEnum.RTWH);
            messageBean.setSendMsgBytes(signedMsg);
            messageSend.sendMessage(messageBean);
        }
        catch (CPBusException e) {
            logger.error(e.getErrCode() + "" + e.getErrMsg());
            return new ResultBean(e.getErrCode(), e.getErrMsg());
        }
        catch (UnsupportedEncodingException e) {
            logger.error("[UnsupportedEncodingException]", e);
            return new ResultBean(ErrorCodePCP.SIGN_FAILED.getValue(), ErrorCodePCP.SIGN_FAILED.getDisplayName());
        }
        return new ResultBean(ComConst.SUC_RET_COD);
    }

    private void businessCheck(RTWithholdAppReqDto rtWithholdAppReqDto) throws CPBusException {
        // TODO 主流水校验
        // TODO 订单状态校验
        // TODO 交易判重
    }

    @Override
    public void hdlRespRTWithhold(RTWithholdRespBean rtWithholdRespBean) {
        // TODO Auto-generated method stub

    }

    @Override
    public void recordSendMsgErrInfo(CPBusException exception, byte[] message) {
        // TODO Auto-generated method stub
        
    }

}
