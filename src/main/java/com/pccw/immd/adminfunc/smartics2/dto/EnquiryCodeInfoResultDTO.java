package com.pccw.immd.adminfunc.smartics2.dto;

public class EnquiryCodeInfoResultDTO extends SearchCriteriaDTO {

    private String hkic;
    private String travelDocNo;
    private String dobDay;
    private String dobMonth;
    private String dobYear;

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

    @Override
    public String toString() {
        return "EnquiryCodeInfoSearchCriteriaDTO{" +
                "hkic='" + hkic + '\'' +
                ", travelDocNo='" + travelDocNo + '\'' +
                ", dobDay='" + dobDay + '\'' +
                ", dobMonth='" + dobMonth + '\'' +
                ", dobYear='" + dobYear + '\'' +
                '}';
    }
}
