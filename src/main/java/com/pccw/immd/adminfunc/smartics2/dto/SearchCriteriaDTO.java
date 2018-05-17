package com.pccw.immd.adminfunc.smartics2.dto;

import com.pccw.immd.commons.dto.BaseDTO;

public class SearchCriteriaDTO extends BaseDTO {

    protected String appointmentType;

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    @Override
    public String toString() {
        return "SearchCriteriaDTO{" +
                "appointmentType='" + appointmentType + '\'' +
                '}';
    }
}
