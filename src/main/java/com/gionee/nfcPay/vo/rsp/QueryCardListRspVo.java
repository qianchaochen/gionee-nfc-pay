/**
 * 
 */
package com.gionee.nfcPay.vo.rsp;

import java.util.List;

import com.gionee.common.vo.BaseMsgVo;
import com.gionee.nfcPay.vo.rsp.busCard.QuerySupportCitiesItemVo;

/**
 * @author zhanggq
 *
 *         2017年6月24日
 */
public class QueryCardListRspVo extends BaseMsgVo {
	private int total;
	private List<QueryCardListItemVo> list;
	private List<QuerySupportCitiesItemVo> bus_card_list;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<QueryCardListItemVo> getList() {
		return list;
	}

	public void setList(List<QueryCardListItemVo> list) {
		this.list = list;
	}

	public List<QuerySupportCitiesItemVo> getBus_card_list() {
		return bus_card_list;
	}

	public void setBus_card_list(List<QuerySupportCitiesItemVo> bus_card_list) {
		this.bus_card_list = bus_card_list;
	}
	
	
}
