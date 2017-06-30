package com.gionee.nfcPay.vo.req.union.notify;

import com.gionee.nfcPay.vo.req.union.BaseUnionReqVo;

/**
 * @author dingyw
 *
 * 2017年6月26日
 */
public class TransResultNotifyReqVo extends BaseUnionReqVo{
	
	/**
	 * 设备卡PAN别名
	 */
	private String virtualCardRefId;
	
	/**
	 * 交易ID
	 * 当出现mPanId且交易为UICS交易时出现；
	 */
	private String transactionId;
	
	/**
	 *  交易类型
	 *  传银行取值，当前如下：
		购物：Purchase
		退货：Refund
		预授权：preAuthorized
		预授权完成：
		preAuthorizedDone
		ATM取款：CashATM
		ATM存款：DepositATM
		ATM转账：TransferATM
	 */
	private String transactionType;
	
	/**
	 * 交易日期
	 * yyMMddHHmmss, 24小时制
	 */
	private String approvalDateTime;
	
	/**
	 *  交易成功：Approved
		交易被拒绝：Declined
		交易处理中：Pending
		已退款：Refunded
	 */
	private String transactionStatus;
	
	/**
	 *  NFC：00
		磁条：01
		远程有卡：02
	 */
	private String paymentMethod;

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
	
}
