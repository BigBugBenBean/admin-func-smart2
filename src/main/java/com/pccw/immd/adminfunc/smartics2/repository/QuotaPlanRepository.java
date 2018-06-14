package com.pccw.immd.adminfunc.smartics2.repository;

/*
 *
 * Generated May 26, 2018 2:31:07 PM by Hibernate Tools 5.0.6.Final
 * FreeMarker 2.3.8
 */

import com.pccw.immd.adminfunc.smartics2.domain.QuotaPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

;

@Repository ("quotaPlanRepository.smartics2")
public interface QuotaPlanRepository extends JpaRepository<QuotaPlan,BigDecimal>{}
