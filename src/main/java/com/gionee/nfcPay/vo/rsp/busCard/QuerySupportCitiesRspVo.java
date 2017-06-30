package com.gionee.nfcPay.vo.rsp.busCard;

import java.util.List;

import com.gionee.common.vo.BaseVo;

/**
 * @author dingyw
 *
 *         2017年6月17日
 */
public class QuerySupportCitiesRspVo extends BaseVo {
	private int total;

	/**
	 * 开通城市列表
	 */
	private List<QuerySupportCitiesItemVo> list;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<QuerySupportCitiesItemVo> getList() {
		return list;
	}

	public void setList(List<QuerySupportCitiesItemVo> list) {
		this.list = list;
	}

}
