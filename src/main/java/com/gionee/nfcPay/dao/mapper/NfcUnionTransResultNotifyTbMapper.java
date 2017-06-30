package com.gionee.nfcPay.dao.mapper;

import com.gionee.nfcPay.vo.models.NfcUnionTransResultNotifyTb;

public interface NfcUnionTransResultNotifyTbMapper {
    int deleteByPrimaryKey(String virtualCardRefId);

    int insert(NfcUnionTransResultNotifyTb record);

    int insertSelective(NfcUnionTransResultNotifyTb record);

    NfcUnionTransResultNotifyTb selectByPrimaryKey(String virtualCardRefId);

    int updateByPrimaryKeySelective(NfcUnionTransResultNotifyTb record);

    int updateByPrimaryKey(NfcUnionTransResultNotifyTb record);
}