package com.gionee.nfcPay.service.org;

import com.gionee.common.exception.BizException;
import com.gionee.nfcPay.vo.models.NfcCoreOrgSafeInfoTab;

/**
 * @author dingyw
 * 机构服务层
 *
 * 2015年11月24日
 */
public interface OrgService {
	
	/**
	 * 根据org_id查找机构信息
	 * @param org_id
	 * @return
	 */
	public NfcCoreOrgSafeInfoTab queryOrgSafeInfo(String org_id,String version)throws BizException;
}
