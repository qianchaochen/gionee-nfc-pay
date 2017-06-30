package com.gionee.nfcPay.dao.mapper;

import com.gionee.common.mapper.IBaseMapper;
import com.gionee.nfcPay.vo.models.NfcUnionCardIssuerInfoTb;

public interface NfcUnionCardIssuerInfoTbMapper extends IBaseMapper<NfcUnionCardIssuerInfoTb> {
	int deleteByPrimaryKey(String issuerId);

	int insert(NfcUnionCardIssuerInfoTb record);

	int insertSelective(NfcUnionCardIssuerInfoTb record);

	NfcUnionCardIssuerInfoTb selectByPrimaryKey(String issuerId);

	int updateByPrimaryKeySelective(NfcUnionCardIssuerInfoTb record);

	int updateByPrimaryKey(NfcUnionCardIssuerInfoTb record);
}