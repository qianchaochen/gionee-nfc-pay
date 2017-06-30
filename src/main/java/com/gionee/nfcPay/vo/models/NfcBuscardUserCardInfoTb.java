package com.gionee.nfcPay.vo.models;

import java.util.Date;

import com.gionee.common.vo.BaseMsgVo;

public class NfcBuscardUserCardInfoTb extends BaseMsgVo{
    private String card_no;

    private String card_id;

    private String city_code;

    private String user_id;

    private String phone_no;

    private String aid;

    private String xTsmCplc;

    private String card_product_name;

    private String card_logo_url;

    private String customer_service_tel_no;

    private Date create_date;

    private Date create_time;

    private Date last_upd_time;

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

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

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getxTsmCplc() {
        return xTsmCplc;
    }

    public void setxTsmCplc(String xTsmCplc) {
        this.xTsmCplc = xTsmCplc;
    }

    public String getCard_product_name() {
        return card_product_name;
    }

    public void setCard_product_name(String card_product_name) {
        this.card_product_name = card_product_name;
    }

    public String getCard_logo_url() {
        return card_logo_url;
    }

    public void setCard_logo_url(String card_logo_url) {
        this.card_logo_url = card_logo_url;
    }

    public String getCustomer_service_tel_no() {
        return customer_service_tel_no;
    }

    public void setCustomer_service_tel_no(String customer_service_tel_no) {
        this.customer_service_tel_no = customer_service_tel_no;
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