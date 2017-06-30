package com.gionee.nfcPay.vo.models;

import com.gionee.common.vo.BaseMsgVo;

public class NfcBuscardUserCardInfoTbKey extends BaseMsgVo{
    private String card_id;

    private String user_id;

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}