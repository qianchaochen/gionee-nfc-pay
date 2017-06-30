package com.gionee.nfcPay.dao.mapper;

import org.apache.ibatis.annotations.Param;

import com.gionee.common.mapper.IBaseMapper;
import com.gionee.nfcPay.vo.models.NfcBuscardBusiCtrlInfoTb;

public interface NfcBuscardBusiCtrlInfoTbMapper extends IBaseMapper<NfcBuscardBusiCtrlInfoTb>{
    int deleteByPrimaryKey(String operation);

    int insert(NfcBuscardBusiCtrlInfoTb record);

    int insertSelective(NfcBuscardBusiCtrlInfoTb record);

    NfcBuscardBusiCtrlInfoTb selectByPrimaryKey(String operation);

    int updateByPrimaryKeySelective(NfcBuscardBusiCtrlInfoTb record);

    int updateByPrimaryKey(NfcBuscardBusiCtrlInfoTb record);
    
    NfcBuscardBusiCtrlInfoTb selectByOperation(@Param(value="operation")String operation);
}