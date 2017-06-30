package com.gionee.nfcPay.vo.rsp.busCard;

import com.gionee.common.vo.BaseVo;

/**
 * @author dingyw
 *
 * 2017年6月17日
 */
public class QuerySupportCitiesItemVo extends BaseVo{
	/**
	 * 应用id
	 */
	private String aid;
	
	/**
	 * 公交卡图片URL
	 */
	private String icon_url;
	
	/**
	 * 充值金额列表
	 */
	private String[] amount_list;
	
	/**
	 * 开通的城市或公交品牌名
	 */
	private String city_name;
	
	/**
	 * 公交编码
	 */
	private String city_code;
	
	/**
	 * 公交卡编码
	 */
	private String card_id;
	
	/**
	 * 公交卡协议URL
	 */
	private String contract_url;
	
	private String amount_list_str;

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getContract_url() {
		return contract_url;
	}

	public void setContract_url(String contract_url) {
		this.contract_url = contract_url;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getIcon_url() {
		return icon_url;
	}

	public void setIcon_url(String icon_url) {
		this.icon_url = icon_url;
	}

	public String[] getAmount_list() {
		return amount_list;
	}

	public void setAmount_list(String[] amount_list) {
		this.amount_list = amount_list;
	}

	public String getAmount_list_str() {
		return amount_list_str;
	}

	public void setAmount_list_str(String amount_list_str) {
		this.amount_list_str = amount_list_str;
	}

	public String getCity_code() {
		return city_code;
	}

	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}

	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
}
