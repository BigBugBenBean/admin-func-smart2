package com.pccw.immd.adminfunc.smartics2.dto;

import com.pccw.immd.commons.dto.BaseDTO;

import java.util.List;

public class EnquiryCodeInformationDTO extends BaseDTO {

    private String hkic;
    private String tdNo;
    private String dobDay;
    private String dobMonth;
    private String dobYear;
    private String appointmentType;

    private List<EnquiryCodeInformationResultDTO> searchResults;

    public String getHkic() {
        return hkic;
    }

    public void setHkic(String hkic) {
        this.hkic = hkic;
    }

    public String getTdNo() {
        return tdNo;
    }

    public void setTdNo(String tdNo) {
        this.tdNo = tdNo;
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

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public List<EnquiryCodeInformationResultDTO> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<EnquiryCodeInformationResultDTO> searchResults) {
        this.searchResults = searchResults;
    }
}
