package com.gionee.nfcPay.vo.models;

import java.util.Date;

import com.gionee.common.vo.BaseMsgVo;

public class NfcUnionDeviceInfoTb extends BaseMsgVo{
    private String xTsmCplc;

    private String status;

    private Date create_date;

    private Date create_time;

    private Date last_upd_time;

    public String getxTsmCplc() {
        return xTsmCplc;
    }

    public void setxTsmCplc(String xTsmCplc) {
        this.xTsmCplc = xTsmCplc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getLast_upd_time() {
        return last_upd_time;
    }

    public void setLast_upd_time(Date last_upd_time) {
        this.last_upd_time = last_upd_time;
    }
}