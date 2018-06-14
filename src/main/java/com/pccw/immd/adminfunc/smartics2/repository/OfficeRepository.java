package com.pccw.immd.adminfunc.smartics2.repository;

/*
 *
 * Generated May 24, 2018 4:33:02 PM by Hibernate Tools 5.0.6.Final
 * FreeMarker 2.3.8
 */;

import com.pccw.immd.adminfunc.smartics2.domain.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository ("officeRepository.smartics2")
public interface OfficeRepository extends JpaRepository<Office,String>{

    public List<Office> findAll();

}
