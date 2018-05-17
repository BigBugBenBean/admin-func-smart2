package com.pccw.immd.adminfunc.smartics2.dto;

import java.util.ArrayList;

public class EnquiryCodeInfoSearchCriteriaDTO extends SearchCriteriaDTO {

    private String hkic;
    private String travelDocNo;
    private String dob;
    private String appointmentType;
    private ArrayList<EnquiryCodeInfoDTO> enquiryCodeInfoList;

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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String getAppointmentType() {
        return appointmentType;
    }

    @Override
    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public ArrayList<EnquiryCodeInfoDTO> getEnquiryCodeInfoList() {
        return enquiryCodeInfoList;
    }

    public void setEnquiryCodeInfoList(ArrayList<EnquiryCodeInfoDTO> enquiryCodeInfoList) {
        this.enquiryCodeInfoList = enquiryCodeInfoList;
    }

    @Override
    public String toString() {
        return "EnquiryCodeInfoSearchCriteriaDTO{" +
                "hkic='" + hkic + '\'' +
                ", travelDocNo='" + travelDocNo + '\'' +
                ", dob='" + dob + '\'' +
                ", appointmentType='" + appointmentType + '\'' +
                ", enquiryCodeInfoList=" + enquiryCodeInfoList +
                '}';
    }
}
