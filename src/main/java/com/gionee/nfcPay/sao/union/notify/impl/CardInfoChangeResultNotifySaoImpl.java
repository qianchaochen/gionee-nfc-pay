/**
 * 
 */
package com.gionee.nfcPay.sao.union.notify.impl;

import com.gionee.common.exception.BizException;
import com.gionee.common.utils.AmigoHttpUtils;
import com.gionee.nfcPay.sao.union.impl.CommonUnionSaoImpl;
import com.gionee.nfcPay.vo.UnionResultVo;
import com.gionee.nfcPay.vo.req.union.notify.CardInfoChangeOperationResultNotifyReqVo;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gionee.nfcPay.sao.union.notify.CardInfoChangeResultNotifySao;

import java.io.IOException;

/**
 * @author zhanggq
 *
 * 2017年6月28日
 */
@Service
public class CardInfoChangeResultNotifySaoImpl extends CommonUnionSaoImpl implements CardInfoChangeResultNotifySao{
    Logger log = LoggerFactory.getLogger(getClass());
    private String card_info_change_result_notify_url;

    @Override
    public void cardInfoChangeResultNotify(CardInfoChangeOperationResultNotifyReqVo vo) throws BizException {
        super.setHeaderMap(vo);
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("event", vo.getEvent());
        jsonBody.put("virtualCardRefId", vo.getVirtualCardRefId());
        jsonBody.put("result", vo.getResult());
        jsonBody.put("taskId", vo.getTaskId());

        try {
            UnionResultVo unionResultVo = AmigoHttpUtils.unionPost(card_info_change_result_notify_url, jsonBody.toString(), super.getHeaderMap());
            JSONObject resultJson = JSONObject.fromObject(unionResultVo.getResult());
            if(resultJson == null){
                throw new BizException("卡面更新操作结果失败！");
            }
            System.out.println(resultJson);

        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            throw new BizException("卡面更新操作失败！");
        }

    }
    
    public String getCard_info_change_result_notify_url() {
        return card_info_change_result_notify_url;
    }

    @Value("#{nfcPay_config['card_info_change_result_notify_url']}")
    public void setCard_info_change_result_notify_url(String card_info_change_result_notify_url) {
        this.card_info_change_result_notify_url = card_info_change_result_notify_url;
    }

}
