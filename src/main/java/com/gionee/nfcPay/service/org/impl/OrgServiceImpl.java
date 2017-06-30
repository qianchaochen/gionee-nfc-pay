package com.gionee.nfcPay.service.org.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.constant.CommonConstant;
import com.gionee.common.exception.BizException;
import com.gionee.nfcPay.dao.mapper.NfcCoreOrgSafeInfoTabMapper;
import com.gionee.nfcPay.service.cache.OrgSafeInfoCache;
import com.gionee.nfcPay.service.org.OrgService;
import com.gionee.nfcPay.vo.models.NfcCoreOrgSafeInfoTab;

/**
 * @author dingyw
 *
 * 2017年6月27日
 */
@Service
public class OrgServiceImpl implements OrgService{
	/**
	 * 数据库层
	 */
	@Autowired
	NfcCoreOrgSafeInfoTabMapper nfcCoreOrgSafeInfoTabMapper;

	@Override
	public NfcCoreOrgSafeInfoTab queryOrgSafeInfo(String org_id,String version) throws BizException{
		
		//从缓存里面获取信息
		NfcCoreOrgSafeInfoTab result =OrgSafeInfoCache.get(org_id, version);
		if(result!=null){
			return result;
		}
		//如果缓存没有信息，则进行查询
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", CommonConstant.IS_VALID.TRUE.getValue());
		params.put("org_id", org_id);
		params.put("version", version);
		
		//选取等于小于version的列表信息，然后取第一个
		String orderParam = "version desc";// 指定按字段rank排名,倒序排序
		List<NfcCoreOrgSafeInfoTab> list = nfcCoreOrgSafeInfoTabMapper
				.selectAllListByParams(params, orderParam);
		
		if(list==null ||list.size()==0){
			throw new BizException("机构数据异常");
		}
		result=list.get(0);
		//存放到缓存里
		OrgSafeInfoCache.put(org_id, version, result);
		return result;
	}

}

