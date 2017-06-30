package com.gionee.nfcPay.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gionee.common.mapper.IBaseMapper;
import com.gionee.nfcPay.vo.models.NfcBuscardSupportCityInfoTb;
import com.gionee.nfcPay.vo.rsp.busCard.QuerySupportCitiesItemVo;

public interface NfcBuscardSupportCityInfoTbMapper extends IBaseMapper<NfcBuscardSupportCityInfoTb> {
    int deleteByPrimaryKey(String city_code);

    int insert(NfcBuscardSupportCityInfoTb record);

    int insertSelective(NfcBuscardSupportCityInfoTb record);

    NfcBuscardSupportCityInfoTb selectByPrimaryKey(String city_code);

    int updateByPrimaryKeySelective(NfcBuscardSupportCityInfoTb record);

    int updateByPrimaryKey(NfcBuscardSupportCityInfoTb record);
    
    /**
	 * @param params
	 * @param orderParam
	 * @return
	 */
	List<QuerySupportCitiesItemVo> selectSupportCityListByParams(
			@Param(value = "params") Map<String, Object> params,
			@Param(value = "orderParam") String orderParam);

	/**
	 * @param params
	 * @return
	 */
	int selectSupportCityListSizeByParams(@Param(value = "params") Map<String, Object> params);

	/**
	 * @param aid
	 * @return
	 */
	NfcBuscardSupportCityInfoTb selectByAid(@Param(value = "aid")String aid);

}