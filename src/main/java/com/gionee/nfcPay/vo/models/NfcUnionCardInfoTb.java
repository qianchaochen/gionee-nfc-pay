package com.gionee.nfcPay.vo.models;

import java.util.Date;

public class NfcUnionCardInfoTb {
    private String virtualCardRefId;

    private String user_id;

    private String phone_no;

    private String virtualCardNum;

    private String xTsmCplc;

    private String cardReferenceId;

    private String cardProductId;

    private String lastDigits;

    private String aid;

    private String status;

    private String personize_status;

    private String tsm_ssid;

    private String tsm_sign;

    private String tsm_event;

    private Date tsm_rcv_time;

    private Date create_date;

    private Date create_time;

    private Date last_update_time;

    public String getVirtualCardRefId() {
        return virtualCardRefId;
    }

    public void setVirtualCardRefId(String virtualCardRefId) {
        this.virtualCardRefId = virtualCardRefId;
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

    public String getVirtualCardNum() {
        return virtualCardNum;
    }

    public void setVirtualCardNum(String virtualCardNum) {
        this.virtualCardNum = virtualCardNum;
    }

    public String getxTsmCplc() {
        return xTsmCplc;
    }

    public void setxTsmCplc(String xTsmCplc) {
        this.xTsmCplc = xTsmCplc;
    }

    public String getCardReferenceId() {
        return cardReferenceId;
    }

    public void setCardReferenceId(String cardReferenceId) {
        this.cardReferenceId = cardReferenceId;
    }

    public String getCardProductId() {
        return cardProductId;
    }

    public void setCardProductId(String cardProductId) {
        this.cardProductId = cardProductId;
    }

    public String getLastDigits() {
        return lastDigits;
    }

    public void setLastDigits(String lastDigits) {
        this.lastDigits = lastDigits;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPersonize_status() {
        return personize_status;
    }

    public void setPersonize_status(String personize_status) {
        this.personize_status = personize_status;
    }

    public String getTsm_ssid() {
        return tsm_ssid;
    }

    public void setTsm_ssid(String tsm_ssid) {
        this.tsm_ssid = tsm_ssid;
    }

    public String getTsm_sign() {
        return tsm_sign;
    }

    public void setTsm_sign(String tsm_sign) {
        this.tsm_sign = tsm_sign;
    }

    public String getTsm_event() {
        return tsm_event;
    }

    public void setTsm_event(String tsm_event) {
        this.tsm_event = tsm_event;
    }

    public Date getTsm_rcv_time() {
        return tsm_rcv_time;
    }

    public void setTsm_rcv_time(Date tsm_rcv_time) {
        this.tsm_rcv_time = tsm_rcv_time;
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

    public Date getLast_update_time() {
        return last_update_time;
    }

    public void setLast_update_time(Date last_update_time) {
        this.last_update_time = last_update_time;
    }
}