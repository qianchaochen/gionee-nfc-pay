package com.gionee.nfcPay.dao.mapper;

import com.gionee.common.mapper.IBaseMapper;
import com.gionee.nfcPay.vo.models.NfcUnionDeviceInfoTb;

public interface NfcUnionDeviceInfoTbMapper extends IBaseMapper<NfcUnionDeviceInfoTb>{
    int deleteByPrimaryKey(String xTsmCplc);

    int insert(NfcUnionDeviceInfoTb record);

    int insertSelective(NfcUnionDeviceInfoTb record);

    NfcUnionDeviceInfoTb selectByPrimaryKey(String xTsmCplc);

    int updateByPrimaryKeySelective(NfcUnionDeviceInfoTb record);

    int updateByPrimaryKey(NfcUnionDeviceInfoTb record);
}