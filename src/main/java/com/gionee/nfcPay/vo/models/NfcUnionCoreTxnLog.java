package com.gionee.nfcPay.vo.models;

import java.util.Date;

import com.gionee.common.vo.BaseMsgVo;

public class NfcUnionCoreTxnLog extends BaseMsgVo{
    private String int_txn_no;

    private Date int_txn_date;

    private Date int_txn_time;

    private String user_id;

    private String phone_no;

    private String int_tans_code;

    private String x_tsm_cplc;

    private String cardReferenceId;

    private String cardProductId;

    private String lastDigits;

    private String virtualCardRefId;

    private String virtualCardNum;

    private String cipheredPan;

    private String personize_status;

    private String aid;

    private String card_status_change_reason;

    private String device_status_event;

    private String virtualCards;

    private String tsmLibData;

    private String cardInfoChangeTaskId;

    private String notify_status;

    private String issuerId;

    private String issuer_version;

    private String req_version;

    private String req_sys_code;

    private Date req_trans_date;

    private Date req_trans_time;

    private String req_trans_code;

    private String req_trans_id;

    private String req_channel;

    private String req_trans_back_id;

    private Date req_trans_back_date;

    private Date req_trans_back_time;

    private String req_trans_back_rsp_code;

    private String req_trans_back_rsp_desc;

    private String rcv_sys_code;

    private String rcv_trans_id;

    private Date rcv_trans_date;

    private Date rcv_trans_time;

    private String rcv_rsp_code;

    private String rcv_rsp_desc;

    private String client_ip;

    private String status;

    private String ua;

    private String fail_reason;

    private Date create_date;

    private Date create_time;

    private Date last_upd_time;

    public String getInt_txn_no() {
        return int_txn_no;
    }

    public void setInt_txn_no(String int_txn_no) {
        this.int_txn_no = int_txn_no;
    }

    public Date getInt_txn_date() {
        return int_txn_date;
    }

    public void setInt_txn_date(Date int_txn_date) {
        this.int_txn_date = int_txn_date;
    }

    public Date getInt_txn_time() {
        return int_txn_time;
    }

    public void setInt_txn_time(Date int_txn_time) {
        this.int_txn_time = int_txn_time;
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

    public String getInt_tans_code() {
        return int_tans_code;
    }

    public void setInt_tans_code(String int_tans_code) {
        this.int_tans_code = int_tans_code;
    }

    public String getX_tsm_cplc() {
        return x_tsm_cplc;
    }

    public void setX_tsm_cplc(String x_tsm_cplc) {
        this.x_tsm_cplc = x_tsm_cplc;
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

    public String getVirtualCardRefId() {
        return virtualCardRefId;
    }

    public void setVirtualCardRefId(String virtualCardRefId) {
        this.virtualCardRefId = virtualCardRefId;
    }

    public String getVirtualCardNum() {
        return virtualCardNum;
    }

    public void setVirtualCardNum(String virtualCardNum) {
        this.virtualCardNum = virtualCardNum;
    }

    public String getCipheredPan() {
        return cipheredPan;
    }

    public void setCipheredPan(String cipheredPan) {
        this.cipheredPan = cipheredPan;
    }

    public String getPersonize_status() {
        return personize_status;
    }

    public void setPersonize_status(String personize_status) {
        this.personize_status = personize_status;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getCard_status_change_reason() {
        return card_status_change_reason;
    }

    public void setCard_status_change_reason(String card_status_change_reason) {
        this.card_status_change_reason = card_status_change_reason;
    }

    public String getDevice_status_event() {
        return device_status_event;
    }

    public void setDevice_status_event(String device_status_event) {
        this.device_status_event = device_status_event;
    }

    public String getVirtualCards() {
        return virtualCards;
    }

    public void setVirtualCards(String virtualCards) {
        this.virtualCards = virtualCards;
    }

    public String getTsmLibData() {
        return tsmLibData;
    }

    public void setTsmLibData(String tsmLibData) {
        this.tsmLibData = tsmLibData;
    }

    public String getCardInfoChangeTaskId() {
        return cardInfoChangeTaskId;
    }

    public void setCardInfoChangeTaskId(String cardInfoChangeTaskId) {
        this.cardInfoChangeTaskId = cardInfoChangeTaskId;
    }

    public String getNotify_status() {
        return notify_status;
    }

    public void setNotify_status(String notify_status) {
        this.notify_status = notify_status;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public String getIssuer_version() {
        return issuer_version;
    }

    public void setIssuer_version(String issuer_version) {
        this.issuer_version = issuer_version;
    }

    public String getReq_version() {
        return req_version;
    }

    public void setReq_version(String req_version) {
        this.req_version = req_version;
    }

    public String getReq_sys_code() {
        return req_sys_code;
    }

    public void setReq_sys_code(String req_sys_code) {
        this.req_sys_code = req_sys_code;
    }

    public Date getReq_trans_date() {
        return req_trans_date;
    }

    public void setReq_trans_date(Date req_trans_date) {
        this.req_trans_date = req_trans_date;
    }

    public Date getReq_trans_time() {
        return req_trans_time;
    }

    public void setReq_trans_time(Date req_trans_time) {
        this.req_trans_time = req_trans_time;
    }

    public String getReq_trans_code() {
        return req_trans_code;
    }

    public void setReq_trans_code(String req_trans_code) {
        this.req_trans_code = req_trans_code;
    }

    public String getReq_trans_id() {
        return req_trans_id;
    }

    public void setReq_trans_id(String req_trans_id) {
        this.req_trans_id = req_trans_id;
    }

    public String getReq_channel() {
        return req_channel;
    }

    public void setReq_channel(String req_channel) {
        this.req_channel = req_channel;
    }

    public String getReq_trans_back_id() {
        return req_trans_back_id;
    }

    public void setReq_trans_back_id(String req_trans_back_id) {
        this.req_trans_back_id = req_trans_back_id;
    }

    public Date getReq_trans_back_date() {
        return req_trans_back_date;
    }

    public void setReq_trans_back_date(Date req_trans_back_date) {
        this.req_trans_back_date = req_trans_back_date;
    }

    public Date getReq_trans_back_time() {
        return req_trans_back_time;
    }

    public void setReq_trans_back_time(Date req_trans_back_time) {
        this.req_trans_back_time = req_trans_back_time;
    }

    public String getReq_trans_back_rsp_code() {
        return req_trans_back_rsp_code;
    }

    public void setReq_trans_back_rsp_code(String req_trans_back_rsp_code) {
        this.req_trans_back_rsp_code = req_trans_back_rsp_code;
    }

    public String getReq_trans_back_rsp_desc() {
        return req_trans_back_rsp_desc;
    }

    public void setReq_trans_back_rsp_desc(String req_trans_back_rsp_desc) {
        this.req_trans_back_rsp_desc = req_trans_back_rsp_desc;
    }

    public String getRcv_sys_code() {
        return rcv_sys_code;
    }

    public void setRcv_sys_code(String rcv_sys_code) {
        this.rcv_sys_code = rcv_sys_code;
    }

    public String getRcv_trans_id() {
        return rcv_trans_id;
    }

    public void setRcv_trans_id(String rcv_trans_id) {
        this.rcv_trans_id = rcv_trans_id;
    }

    public Date getRcv_trans_date() {
        return rcv_trans_date;
    }

    public void setRcv_trans_date(Date rcv_trans_date) {
        this.rcv_trans_date = rcv_trans_date;
    }

    public Date getRcv_trans_time() {
        return rcv_trans_time;
    }

    public void setRcv_trans_time(Date rcv_trans_time) {
        this.rcv_trans_time = rcv_trans_time;
    }

    public String getRcv_rsp_code() {
        return rcv_rsp_code;
    }

    public void setRcv_rsp_code(String rcv_rsp_code) {
        this.rcv_rsp_code = rcv_rsp_code;
    }

    public String getRcv_rsp_desc() {
        return rcv_rsp_desc;
    }

    public void setRcv_rsp_desc(String rcv_rsp_desc) {
        this.rcv_rsp_desc = rcv_rsp_desc;
    }

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    public String getFail_reason() {
        return fail_reason;
    }

    public void setFail_reason(String fail_reason) {
        this.fail_reason = fail_reason;
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