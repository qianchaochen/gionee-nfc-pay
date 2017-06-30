package com.gionee.nfcPay.vo.models;

import java.util.Date;

public class NfcCoreOrgSafeInfoTab {
    private String seq_no;

    private String org_id;

    private String version;

    private String status;

    private String secret_key;

    private String org_rsa_public_key;

    private Date create_tm;

    private Date create_date;

    private Date last_upd_tm;

    private String operator;

    private String auditor;

    private String is_256_key_length;

    public String getSeq_no() {
        return seq_no;
    }

    public void setSeq_no(String seq_no) {
        this.seq_no = seq_no;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }

    public String getOrg_rsa_public_key() {
        return org_rsa_public_key;
    }

    public void setOrg_rsa_public_key(String org_rsa_public_key) {
        this.org_rsa_public_key = org_rsa_public_key;
    }

    public Date getCreate_tm() {
        return create_tm;
    }

    public void setCreate_tm(Date create_tm) {
        this.create_tm = create_tm;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getLast_upd_tm() {
        return last_upd_tm;
    }

    public void setLast_upd_tm(Date last_upd_tm) {
        this.last_upd_tm = last_upd_tm;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getIs_256_key_length() {
        return is_256_key_length;
    }

    public void setIs_256_key_length(String is_256_key_length) {
        this.is_256_key_length = is_256_key_length;
    }
}