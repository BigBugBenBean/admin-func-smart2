package com.pccw.immd.adminfunc.smartics2.repository;

/*
 *
 * Generated May 26, 2018 1:27:42 PM by Hibernate Tools 5.0.6.Final
 * FreeMarker 2.3.8
 */

import com.pccw.immd.adminfunc.smartics2.domain.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

;import java.util.Date;

@Repository ("holidayRepository.smartics2")
public interface HolidayRepository extends JpaRepository<Holiday,Date>{
}
