package com.gionee.nfcPay.dao.mapper;

import com.gionee.common.mapper.IBaseMapper;
import com.gionee.nfcPay.vo.models.NfcUnionCoreTxnLog;

public interface NfcUnionCoreTxnLogMapper extends IBaseMapper<NfcUnionCoreTxnLog>{
    int deleteByPrimaryKey(String int_txn_no);

    int insert(NfcUnionCoreTxnLog record);

    int insertSelective(NfcUnionCoreTxnLog record);

    NfcUnionCoreTxnLog selectByPrimaryKey(String int_txn_no);

    int updateByPrimaryKeySelective(NfcUnionCoreTxnLog record);

    int updateByPrimaryKey(NfcUnionCoreTxnLog record);
}