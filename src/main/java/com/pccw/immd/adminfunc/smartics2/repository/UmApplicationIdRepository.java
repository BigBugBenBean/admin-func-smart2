package com.pccw.immd.adminfunc.smartics2.repository;

/*
 *
 * Generated May 21, 2018 10:09:10 AM by Hibernate Tools 5.0.6.Final
 * FreeMarker 2.3.8
 */

import com.pccw.immd.adminfunc.smartics2.domain.UmApplicationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

;

@Repository ("umApplicationIdRepository.smartics2")
public interface UmApplicationIdRepository extends JpaRepository<UmApplicationId,String>{

    List<UmApplicationId> findAll();
}
