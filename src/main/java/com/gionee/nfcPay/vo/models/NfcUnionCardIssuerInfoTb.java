package com.gionee.nfcPay.vo.models;

import java.util.Date;

import com.gionee.common.vo.BaseMsgVo;

public class NfcUnionCardIssuerInfoTb extends BaseMsgVo{
    private String issuerId;

    private String version;

    private String name;

    private String description;

    private String logo;

    private String contactNumber;

    private String debitCallCenterNumber;

    private String creditCallCenterNumber;

    private String debitEmail;

    private String creditEmail;

    private String debitWebsite;

    private String creditWebsite;

    private String debitTcUrl;

    private String creditTcUrl;

    private String tcOption;

    private String mobileAppList;

    private Date create_date;

    private Date create_time;

    private Date last_upd_time;

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDebitCallCenterNumber() {
        return debitCallCenterNumber;
    }

    public void setDebitCallCenterNumber(String debitCallCenterNumber) {
        this.debitCallCenterNumber = debitCallCenterNumber;
    }

    public String getCreditCallCenterNumber() {
        return creditCallCenterNumber;
    }

    public void setCreditCallCenterNumber(String creditCallCenterNumber) {
        this.creditCallCenterNumber = creditCallCenterNumber;
    }

    public String getDebitEmail() {
        return debitEmail;
    }

    public void setDebitEmail(String debitEmail) {
        this.debitEmail = debitEmail;
    }

    public String getCreditEmail() {
        return creditEmail;
    }

    public void setCreditEmail(String creditEmail) {
        this.creditEmail = creditEmail;
    }

    public String getDebitWebsite() {
        return debitWebsite;
    }

    public void setDebitWebsite(String debitWebsite) {
        this.debitWebsite = debitWebsite;
    }

    public String getCreditWebsite() {
        return creditWebsite;
    }

    public void setCreditWebsite(String creditWebsite) {
        this.creditWebsite = creditWebsite;
    }

    public String getDebitTcUrl() {
        return debitTcUrl;
    }

    public void setDebitTcUrl(String debitTcUrl) {
        this.debitTcUrl = debitTcUrl;
    }

    public String getCreditTcUrl() {
        return creditTcUrl;
    }

    public void setCreditTcUrl(String creditTcUrl) {
        this.creditTcUrl = creditTcUrl;
    }

    public String getTcOption() {
        return tcOption;
    }

    public void setTcOption(String tcOption) {
        this.tcOption = tcOption;
    }

    public String getMobileAppList() {
        return mobileAppList;
    }

    public void setMobileAppList(String mobileAppList) {
        this.mobileAppList = mobileAppList;
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