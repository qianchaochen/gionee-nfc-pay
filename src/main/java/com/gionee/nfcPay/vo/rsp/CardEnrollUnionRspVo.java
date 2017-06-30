package com.gionee.nfcPay.vo.rsp;


/**
 * @author dingyw
 *
 * 2017年6月14日
 */
public class CardEnrollUnionRspVo extends BaseUnionRspVo {
	
	/**
	 * 实体卡元数据
	 */
	private CardMetadataVo cardMetadata;
	
	/**
	 * 设备卡元数据
	 */
	private VirtualCardMetadataVo virtualCardMetadata;
	
	/**
	 * 返回客户端时间戳
	 */
	private String submitTime;

	public CardMetadataVo getCardMetadata() {
		return cardMetadata;
	}

	public void setCardMetadata(CardMetadataVo cardMetadata) {
		this.cardMetadata = cardMetadata;
	}

	public VirtualCardMetadataVo getVirtualCardMetadata() {
		return virtualCardMetadata;
	}

	public void setVirtualCardMetadata(VirtualCardMetadataVo virtualCardMetadata) {
		this.virtualCardMetadata = virtualCardMetadata;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
}
