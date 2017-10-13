package com.unionpay.withhold.path.constants.bean;

import java.io.Serializable;

import com.unionpay.withhold.path.constants.enums.MessageTypeEnum;

public class MessageStrBean implements Serializable {

    private static final long serialVersionUID = -7572376438853746664L;
    /**
     * 要发送报文
     */
    private String sendMsg;
    /**
     * 要发送报文
     */
    private byte[] sendMsgBytes;
    /**
     * 报文类型
     */
    private MessageTypeEnum messageType;

    public MessageStrBean() {
        super();
    }

    public MessageStrBean(String sendMsg, MessageTypeEnum messageType) {
        super();
        this.sendMsg = sendMsg;
        this.messageType = messageType;
    }

    public MessageStrBean(byte[] sendMsgBytes, MessageTypeEnum messageType) {
        super();
        this.sendMsgBytes = sendMsgBytes;
        this.messageType = messageType;
    }

    public String getSendMsg() {
        return sendMsg;
    }

    public void setSendMsg(String sendMsg) {
        this.sendMsg = sendMsg;
    }

    public MessageTypeEnum getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageTypeEnum messageType) {
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        return "MessageBeanStr [sendMsg=" + sendMsg + ", messageType=" + messageType + "]";
    }

    public byte[] getSendMsgBytes() {
        return sendMsgBytes;
    }

    public void setSendMsgBytes(byte[] sendMsgBytes) {
        this.sendMsgBytes = sendMsgBytes;
    }

}
