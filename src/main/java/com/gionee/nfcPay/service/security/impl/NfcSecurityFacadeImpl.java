package com.gionee.nfcPay.service.security.impl;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gionee.common.exception.BizException;
import com.gionee.epay.client.EpaySDKRcv;
import com.gionee.nfcPay.service.org.OrgService;
import com.gionee.nfcPay.service.security.NfcSecurityFacade;
import com.gionee.nfcPay.vo.models.NfcCoreOrgSafeInfoTab;

/**
 * @author dingyw
 *
 * 2017年6月27日
 */
@Service
public class NfcSecurityFacadeImpl implements NfcSecurityFacade{
	
	/**
	 * 机构服务层
	 */
	@Autowired
	OrgService orgService;


	@Override
	public EpaySDKRcv decryptReqMessage(JSONObject json) throws BizException {
		
		String org_id = json.getString("org_id");
		String version = json.getString("version");

		if (StringUtils.isEmpty(org_id)) {
			throw new BizException("org_id不能为空");
		}
		if (StringUtils.isEmpty(version)) {
			throw new BizException("version不能为空");
		}
		// 获取公钥
		NfcCoreOrgSafeInfoTab epayCoreOrgSafeInfoTab = orgService.queryOrgSafeInfo(org_id, version);

		try {
			EpaySDKRcv epaySDKRcv = new EpaySDKRcv(epayCoreOrgSafeInfoTab.getOrg_rsa_public_key());

			// 结果放在epaySDKRcvReq的message中,不仅需要返回解密后的message,而且要返回整个对象
			epaySDKRcv.getRcvMsg(json.toString());

			return epaySDKRcv;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BizException("解密过程发生异常");
		}

	}

}
