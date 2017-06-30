package com.gionee.nfcPay.dao.mapper;

import com.gionee.common.mapper.IBaseMapper;
import com.gionee.nfcPay.vo.models.NfcUnionCardProductInfoTb;

public interface NfcUnionCardProductInfoTbMapper extends IBaseMapper<NfcUnionCardProductInfoTb>{
    int deleteByPrimaryKey(String cardProductId);

    int insert(NfcUnionCardProductInfoTb record);

    int insertSelective(NfcUnionCardProductInfoTb record);

    NfcUnionCardProductInfoTb selectByPrimaryKey(String cardProductId);

    int updateByPrimaryKeySelective(NfcUnionCardProductInfoTb record);

    int updateByPrimaryKey(NfcUnionCardProductInfoTb record);
}