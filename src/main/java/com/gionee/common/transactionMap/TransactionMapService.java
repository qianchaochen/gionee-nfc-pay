package com.gionee.common.transactionMap;

import com.gionee.common.action.IBaseAction;
import com.gionee.common.vo.BaseMsgVo;



public interface TransactionMapService {
	
	public IBaseAction<BaseMsgVo> getActionByMap(String TransCode);

}
