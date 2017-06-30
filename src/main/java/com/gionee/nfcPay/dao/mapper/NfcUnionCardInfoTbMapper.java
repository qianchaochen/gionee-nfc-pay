package com.gionee.nfcPay.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gionee.common.mapper.IBaseMapper;
import com.gionee.nfcPay.vo.models.NfcUnionCardInfoTb;
import com.gionee.nfcPay.vo.rsp.QueryCardListItemVo;

public interface NfcUnionCardInfoTbMapper extends IBaseMapper<NfcUnionCardInfoTb> {
	int deleteByPrimaryKey(String virtualCardRefId);

	int insert(NfcUnionCardInfoTb record);

	int insertSelective(NfcUnionCardInfoTb record);

	NfcUnionCardInfoTb selectByPrimaryKey(String virtualCardRefId);

	int updateByPrimaryKeySelective(NfcUnionCardInfoTb record);

	int updateByPrimaryKey(NfcUnionCardInfoTb record);

	/**
	 * @param virtualCardRefId
	 * @param virtualCardRefId2
	 * @return
	 */
	NfcUnionCardInfoTb selectCardNewTsmEvent(@Param(value = "virtualCardRefId") String virtualCardRefId,
			@Param(value = "submitTime") String submitTime);

	/**
	 * @param user_id
	 * @return
	 */
	List<QueryCardListItemVo> selectBusCardUnionCardList(@Param(value = "user_id")String user_id);

	/**
	 * @param user_id
	 * @return
	 */
	int selectBusCardUnionCardListSize(@Param(value = "user_id")String user_id);
}