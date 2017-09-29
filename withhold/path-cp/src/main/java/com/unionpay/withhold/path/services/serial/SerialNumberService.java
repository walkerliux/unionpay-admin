package com.unionpay.withhold.path.services.serial;


public interface SerialNumberService {

    /**
     * 生成杭州清算中心通信参考号（16位）
     * 
     * @return 通信参考号
     */
    public String generateHZComuRefId();

    /**
     * 生成数据库逻辑主键（12位）
     * 
     * @return TID
     */
    public Long generateDBPrimaryKey();

    /**
     * 报文标识号（16位）
     * 
     * @return 通信参考号
     */
    public String generateHZMsgId();

    /**
     * 明细标识号（16位）
     */
    public String generateTranIden();

}
