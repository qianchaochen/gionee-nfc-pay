package com.gionee.nfcPay.dao.mapper;

import com.gionee.common.mapper.IBaseMapper;
import com.gionee.nfcPay.vo.models.NfcCoreOrgSafeInfoTab;

public interface NfcCoreOrgSafeInfoTabMapper extends IBaseMapper<NfcCoreOrgSafeInfoTab>{
    int deleteByPrimaryKey(String seq_no);

    int insert(NfcCoreOrgSafeInfoTab record);

    int insertSelective(NfcCoreOrgSafeInfoTab record);

    NfcCoreOrgSafeInfoTab selectByPrimaryKey(String seq_no);

    int updateByPrimaryKeySelective(NfcCoreOrgSafeInfoTab record);

    int updateByPrimaryKey(NfcCoreOrgSafeInfoTab record);
}