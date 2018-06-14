package com.pccw.immd.adminfunc.smartics2.dto;

import com.pccw.immd.adminfunc.smartics2.util.DateUtils;
import com.pccw.immd.commons.dto.BaseDTO;

import java.math.BigDecimal;

public class EnquiryCodeInformationResultDTO extends BaseDTO {

    private String transDateTime;
    private String appType;
    private String appDateTime;
    private String appointmentOffice;
    private String applicantId;
    private String dob;
    private String trn;
    private String channel;
    private String status;
    private String enquiryCode;

    public String getTransDateTime() {
        return transDateTime;
    }

    public void setTransDateTime(String transDateTime) {
        this.transDateTime = transDateTime;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getAppDateTime() {
        return appDateTime;
    }

    public void setAppDateTime(String appDateTime) {
        this.appDateTime = appDateTime;
    }

    public String getAppointmentOffice() {
        return appointmentOffice;
    }

    public void setAppointmentOffice(String appointmentOffice) {
        this.appointmentOffice = appointmentOffice;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getTrn() {
        return trn;
    }

    public void setTrn(String trn) {
        this.trn = trn;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEnquiryCode() {
        return enquiryCode;
    }

    public void setEnquiryCode(String enquiryCode) {
        this.enquiryCode = enquiryCode;
    }

    public EnquiryCodeInformationResultDTO(String transDateTime, String appType, String appDateTime, String appointmentOffice, String applicantId, String dob, BigDecimal trn, String channel, String status, String enquiryCode) {
        this.transDateTime = transDateTime;
        this.appType = appType;
        this.appDateTime = appDateTime;
        this.appointmentOffice = appointmentOffice;
        this.applicantId = String.valueOf(applicantId);
        this.dob = DateUtils.format(dob);
        this.trn = String.valueOf(trn);
        this.channel = channel;
        this.status = status;
        this.enquiryCode = enquiryCode;
    }
}
