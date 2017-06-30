package com.gionee.nfcPay.dao.mapper;

import com.gionee.common.mapper.IBaseMapper;
import com.gionee.nfcPay.vo.models.NfcBuscardUserCardInfoTb;

public interface NfcBuscardUserCardInfoTbMapper extends IBaseMapper<NfcBuscardUserCardInfoTb>{
    int deleteByPrimaryKey(String card_no);

    int insert(NfcBuscardUserCardInfoTb record);

    int insertSelective(NfcBuscardUserCardInfoTb record);

    NfcBuscardUserCardInfoTb selectByPrimaryKey(String card_no);

    int updateByPrimaryKeySelective(NfcBuscardUserCardInfoTb record);

    int updateByPrimaryKey(NfcBuscardUserCardInfoTb record);
}