package com.pccw.immd.adminfunc.smartics2.dto;

public class EnquiryCodeInfoDTO extends SearchCriteriaDTO {

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

    @Override
    public String toString() {
        return "EnquiryCodeInfoDTO{" +
                "transDateTime='" + transDateTime + '\'' +
                ", appType='" + appType + '\'' +
                ", appDateTime='" + appDateTime + '\'' +
                ", appointmentOffice='" + appointmentOffice + '\'' +
                ", applicantId='" + applicantId + '\'' +
                ", dob='" + dob + '\'' +
                ", trn='" + trn + '\'' +
                ", channel='" + channel + '\'' +
                ", status='" + status + '\'' +
                ", enquiryCode='" + enquiryCode + '\'' +
                '}';
    }
}
