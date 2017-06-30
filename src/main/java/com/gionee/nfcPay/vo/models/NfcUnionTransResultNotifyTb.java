package com.gionee.nfcPay.vo.models;

public class NfcUnionTransResultNotifyTb {
    private String virtualCardRefId;

    private String transactionId;

    private String transactionType;

    private String approvalDateTime;

    private String transactionStatus;

    private String paymentMethod;

    private String transTimeSource;

    private String transNoSource;

    public String getVirtualCardRefId() {
        return virtualCardRefId;
    }

    public void setVirtualCardRefId(String virtualCardRefId) {
        this.virtualCardRefId = virtualCardRefId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getApprovalDateTime() {
        return approvalDateTime;
    }

    public void setApprovalDateTime(String approvalDateTime) {
        this.approvalDateTime = approvalDateTime;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTransTimeSource() {
        return transTimeSource;
    }

    public void setTransTimeSource(String transTimeSource) {
        this.transTimeSource = transTimeSource;
    }

    public String getTransNoSource() {
        return transNoSource;
    }

    public void setTransNoSource(String transNoSource) {
        this.transNoSource = transNoSource;
    }
}