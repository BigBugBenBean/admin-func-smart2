package com.pccw.immd.adminfunc.smartics2.repository;

/*
 *
 * Generated May 26, 2018 10:19:52 AM by Hibernate Tools 5.0.6.Final
 * FreeMarker 2.3.8
 */

import com.pccw.immd.adminfunc.smartics2.domain.AppointmentInfo;
import com.pccw.immd.adminfunc.smartics2.domain.AppointmentInfoId;
import com.pccw.immd.adminfunc.smartics2.dto.EnquiryCodeInformationDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

;

@Repository ("appointmentInfoRepository.smartics2")
public interface AppointmentInfoRepository extends JpaRepository<AppointmentInfo,AppointmentInfoId>{

    List<AppointmentInfo> findAll();
}
