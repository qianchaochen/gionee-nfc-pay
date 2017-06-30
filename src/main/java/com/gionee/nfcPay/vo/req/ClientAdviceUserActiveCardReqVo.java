package com.gionee.nfcPay.vo.req;

import com.gionee.nfcPay.vo.req.union.BaseUnionReqVo;

/**
 * Created by qiancc on 2017/6/27.
 */
public class ClientAdviceUserActiveCardReqVo extends BaseUnionReqVo {

    /**
     * 加密的实体卡号
     */
    private String user_id;

    /**
     * 用户手机号
     */
    private String phone_no;

    /**
     * 卡号
     */
    private String card_no;

    /**
     * 应用id
     */
    private String aid;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }
}
