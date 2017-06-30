/**
 * 
 */
package com.gionee.action.union;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONStyle;

import com.gionee.common.TestBaseAction;
import com.gionee.common.utils.AmigoHttpUtils;

/**
 * @author zhanggq
 *
 * 2017年6月22日
 */
public class TestCardEnrollAction extends TestBaseAction{
	public void excuete(){
		//指定执行环境
		this.setEnv("localhost");
		//设置请求url
		String url=this.getUrl();
		//指定交易码
		this.setTrans_code("310002");
	
		//创建报文头
		JSONObject jsonReq = this.getHeader();
		
		//创建报文体
		JSONObject jsonBody = new JSONObject();

		jsonBody.put("xTsmCplc", "1234567890");
		jsonBody.put("user_id", "E096D034365146B0A73DFAC5AB94A333");
		jsonBody.put("phone_no", "13760464403");
		JSONObject cipheredCardInfo=new JSONObject();
        
        cipheredCardInfo.put("cardInfo", "6222000100020003|15816883431");
        cipheredCardInfo.put("pin", "123456");
        cipheredCardInfo.put("cvn2", "");
		jsonBody.put("cipheredCardInfo", cipheredCardInfo);
//		jsonBody.put("cipheredCardInfo", "{\"cardInfo\":\"5EB0B9A8EC6A7B59918D729425FD2577BE406CAAEE2B5D7490E6666D97B240056D24382BC31E048C0F18FC84EB6B08118B0A6E4F8205AE5531056E6A1F48ABA6F6A20859B6F031061DB0AC75A147B9CCE72BD5C142F610F0B17F5ACE7CA5C4CDB196813CE72C2A3396549D49F7FA4C3D0C04587CCFB68793035D4C503D612B6CE8025A7AAA33A31A5CF583C84FEE7A16EBBE5B0A0D9D10F716E7F80A362634357940F57A37A213BFFEE3D649248A85607830522A930662CF563DCE00BAB2B03F85EFB36EE642A08AC4412240230C23BF94EF48940C8F3221018393DF0D5CD77EC9F989CA4DD507FEC0A37322050F85F7FBB3779AA5D7E8FC8DD9A925512EE102\",\"cvn2\":\"4FA9D690749217E74B41702381984158A09E7AD6DD40214433E103DE3C7938F5664711A45B60AB051E245254C982C0D5234B96A3BCC49EB74B6784B3F8F7DF20836B977E12BE341EFFD763C18E34E4E1475BAA1A693A09C791FDA56A68FE1FDD6326D3C198D82BE7518F857E5D2FD00B478359E70DEC60D3CCC0C3A35F9BD70F420013DBFEA74B5F21AED41731CEF9A0AE6746424499218CBD2CE5F6BCD8A385FB1842B3B451E9618A2E0060F89542390E66C2A3D2CB19C79EAAF4781059E4BE7415CF89AB7BA5C1828C8CB6791E0C65793409B2BD2DC57151ACB136B97115A87EB2DB4E38AE4306FE3716F1D1CA0A2B91891C115505DC49E6BE9F90D6BC3EA4\"}");
//		jsonBody.put("riskInfo", "{\"deviceType\":\"1\",\"deviceLanguage\":\"zho\",\"deviceName\":\"SM-A9000\",\"applyChannel\":\"01\",\"extensiveDeviceLocation\":\"+38.99/+117.23\",\"captureMethod\":\"manual\",\"sourceIP\":\"218.69.17.94\",\"deviceSIMNumber\":\"0\",\"fullDeviceNumber\":\"13588888888,13577777777\",\"accountIDHash\":\"sDHZE0SGRk214Oy8DbP7uQ\"}");
		JSONObject riskInfo=new JSONObject();
		riskInfo.put("deviceType", "1"); //1:手机，2:平板，3:手表
		riskInfo.put("deviceName", "sunsnow的手机");
		//用户移动设备卡申请渠道类型。00:银行自有渠道，01: 手机厂商渠道，02: 银联渠道，03: 运营商渠道
		riskInfo.put("applyChannel", "01");
		riskInfo.put("extensiveDeviceLocation", "+37.12/-121.23");
		//表示卡号录入方式。manual：用户手输入卡号，camera：表示摄像头捕捉得到卡号，unknow：未知的获取卡号方式
		riskInfo.put("captureMethod", "manual"); 
		riskInfo.put("deviceNumber", "3431"); 
		riskInfo.put("sourceIP", "127.0.0.1"); 
		riskInfo.put("deviceSIMNumber", "1"); //智能设备中的SIM卡数量
		
		
		jsonBody.put("riskInfo", riskInfo);
		//报文体加入到报文头 
		jsonReq.put("body", jsonBody);
		
		
		String req_plain=jsonReq.toJSONString(JSONStyle.NO_COMPRESS);
		System.out.println(req_plain);
		try {
			this.setEncrypt_open(true);
			this.setSign_open(true);
			String req = this.getSDKRequest(req_plain);
			String response=AmigoHttpUtils.post(url, req);
			System.out.println("response:"+response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		TestCardEnrollAction t=new TestCardEnrollAction();
		t.excuete();
	}
}
