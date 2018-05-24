package com.pccw.immd.adminfunc.smartics2.dto;

import com.pccw.immd.adminfunc.smartics2.domain.UmApplicationId;
import com.pccw.immd.commons.dto.BaseDTO;

import java.util.List;

public class EnquiryCodeInformationDTO extends BaseDTO {

    //Search Page
    private String hkic;
    private String travelDocNo;
    private String dobDay;
    private String dobMonth;
    private String dobYear;
    private List<UmApplicationId> appointmentTypes;
    private String appointmentType;
    private List<SearchResult> searchResults;

    public EnquiryCodeInformationDTO() {
    }

    public EnquiryCodeInformationDTO(String hkic, String travelDocNo, String dobDay, String dobMonth, String dobYear, List<UmApplicationId> appointmentTypes, String appointmentType, List<SearchResult> searchResults) {
        this.hkic = hkic;
        this.travelDocNo = travelDocNo;
        this.dobDay = dobDay;
        this.dobMonth = dobMonth;
        this.dobYear = dobYear;
        this.appointmentTypes = appointmentTypes;
        this.appointmentType = appointmentType;
        this.searchResults = searchResults;
    }

    public String getHkic() {
        return hkic;
    }

    public void setHkic(String hkic) {
        this.hkic = hkic;
    }

    public String getTravelDocNo() {
        return travelDocNo;
    }

    public void setTravelDocNo(String travelDocNo) {
        this.travelDocNo = travelDocNo;
    }

    public String getDobDay() {
        return dobDay;
    }

    public void setDobDay(String dobDay) {
        this.dobDay = dobDay;
    }

    public String getDobMonth() {
        return dobMonth;
    }

    public void setDobMonth(String dobMonth) {
        this.dobMonth = dobMonth;
    }

    public String getDobYear() {
        return dobYear;
    }

    public void setDobYear(String dobYear) {
        this.dobYear = dobYear;
    }

    public List<UmApplicationId> getAppointmentTypes() {
        return appointmentTypes;
    }

    public void setAppointmentTypes(List<UmApplicationId> appointmentTypes) {
        this.appointmentTypes = appointmentTypes;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public List<SearchResult> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<SearchResult> searchResults) {
        this.searchResults = searchResults;
    }

    private class SearchResult {
        protected String transDateTime;
        protected String appType;
        protected String appDateTime;
        protected String appointmentOffice;
        protected String applicantId;
        protected String dob;
        protected String trn;
        protected String channel;
        protected String status;
        protected String enquiryCode;

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
    }

    @Override
    public String toString() {
        return "EnquiryCodeInformationDTO{" +
                "hkic='" + hkic + '\'' +
                ", travelDocNo='" + travelDocNo + '\'' +
                ", dobDay='" + dobDay + '\'' +
                ", dobMonth='" + dobMonth + '\'' +
                ", dobYear='" + dobYear + '\'' +
                ", appointmentTypes=" + appointmentTypes +
                ", appointmentType='" + appointmentType + '\'' +
                ", searchResults=" + searchResults +
                '}';
    }
}
