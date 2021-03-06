package com.jixianxueyuan.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by pengchao on 12/7/15.
 */
public class TradeDTO implements Serializable {
    private Long id;
    private String internalTradeNo;
    private String tradeType;
    private String tradeStatus;
    private String payType;
    private String subject;
    private BigDecimal totalFee;
    private String createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInternalTradeNo() {
        return internalTradeNo;
    }

    public void setInternalTradeNo(String internalTradeNo) {
        this.internalTradeNo = internalTradeNo;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
