package com.gionee.common.transactionMap.impl;


import java.util.Map;

import com.gionee.common.action.IBaseAction;
import com.gionee.common.transactionMap.TransactionMapService;
import com.gionee.common.vo.BaseMsgVo;

/**
 * @author dingyw
 *
 * 2015年1月14日
 */
public class TransactionMapServiceImpl implements TransactionMapService{
	
	private Map<String, IBaseAction<BaseMsgVo>> transactionMap;
	

	@Override
	public IBaseAction<BaseMsgVo> getActionByMap(String TransCode) {
		// TODO Auto-generated method stub
		return transactionMap.get(TransCode);
	}


	public Map<String, IBaseAction<BaseMsgVo>> getTransactionMap() {
		return transactionMap;
	}


	public void setTransactionMap(
			Map<String, IBaseAction<BaseMsgVo>> transactionMap) {
		this.transactionMap = transactionMap;
	}

}
