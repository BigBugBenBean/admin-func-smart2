package com.pccw.immd.adminfunc.smartics2.service;

import com.pccw.immd.adminfunc.smartics2.domain.AppointmentInfo;
import com.pccw.immd.adminfunc.smartics2.dto.EnquiryCodeInformationDTO;

import java.util.List;

public interface AppointmentInfoService {

    List<AppointmentInfo> listAll();
    EnquiryCodeInformationDTO searchByAppTypeHkicTdnoDob(EnquiryCodeInformationDTO dto);
}
