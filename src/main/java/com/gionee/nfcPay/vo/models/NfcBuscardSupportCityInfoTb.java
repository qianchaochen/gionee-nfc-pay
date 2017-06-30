package com.gionee.nfcPay.vo.models;

import java.util.Date;

import com.gionee.common.vo.BaseMsgVo;

public class NfcBuscardSupportCityInfoTb extends BaseMsgVo{
    private String city_code;

    private String city_name;

    private String aid;

    private String card_id;

    private String card_name;

    private String status;

    private String icon_url;

    private String detail_icon_url;

    private String contract_url;

    private String amount_list;

    private String customer_service_tel;

    private Date create_date;

    private Date create_time;

    private Date last_upd_time;

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getDetail_icon_url() {
        return detail_icon_url;
    }

    public void setDetail_icon_url(String detail_icon_url) {
        this.detail_icon_url = detail_icon_url;
    }

    public String getContract_url() {
        return contract_url;
    }

    public void setContract_url(String contract_url) {
        this.contract_url = contract_url;
    }

    public String getAmount_list() {
        return amount_list;
    }

    public void setAmount_list(String amount_list) {
        this.amount_list = amount_list;
    }

    public String getCustomer_service_tel() {
        return customer_service_tel;
    }

    public void setCustomer_service_tel(String customer_service_tel) {
        this.customer_service_tel = customer_service_tel;
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