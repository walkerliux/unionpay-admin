package com.unionpay.withhold.path.services.sendmsg;

import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.path.constants.bean.MessageStrBean;
import com.unionpay.withhold.path.exception.CPBusException;

public interface MessageSend {

    /**
     * 发送报文至第三方
     * 
     * @param messageBean
     * @return
     * @throws HZRealFeException
     */
    public ResultBean sendMessage(MessageStrBean messageBean) throws CPBusException;

}
