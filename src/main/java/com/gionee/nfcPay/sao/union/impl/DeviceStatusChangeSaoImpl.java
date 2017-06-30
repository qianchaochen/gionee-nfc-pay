package com.gionee.nfcPay.sao.union.impl;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gionee.common.exception.BizException;
import com.gionee.common.utils.AmigoHttpUtils;
import com.gionee.nfcPay.sao.union.DeviceStatusChangeSao;
import com.gionee.nfcPay.vo.req.union.DeviceStatusChangeReqVo;

/**
 * 设备状态变更
 * 
 * @author dingyw
 *
 *         2017年6月15日
 */
@Service
public class DeviceStatusChangeSaoImpl extends CommonUnionSaoImpl implements DeviceStatusChangeSao {
	Logger log = LoggerFactory.getLogger(getClass());
	private String union_device_status_change_url;

	@Override
	public void changeDeviceStatus(DeviceStatusChangeReqVo vo) throws BizException {
		vo.setxTsmCplc(vo.getSecureElement());
		super.setHeaderMap(vo);

		JSONObject jsonBody = new JSONObject();
		jsonBody.put("event", vo.getEvent());
		jsonBody.put("secureElement", vo.getSecureElement());
		try {

			AmigoHttpUtils.unionPost(union_device_status_change_url, jsonBody.toString(),
					super.getHeaderMap());
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new BizException("请求银联设备状态变更失败");
		}
	}

	public String getUnion_device_status_change_url() {
		return union_device_status_change_url;
	}

	@Value("#{nfcPay_config['union_device_status_change_url']}")
	public void setUnion_device_status_change_url(String union_device_status_change_url) {
		this.union_device_status_change_url = union_device_status_change_url;
	}

}
