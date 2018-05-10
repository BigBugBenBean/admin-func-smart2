package com.pccw.immd.adminfunc.repository;

import com.pccw.immd.adminfunc.domain.JobMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("jobMaintenanceRepository")
public interface JobMaintenanceRepository extends JpaRepository<JobMaintenance, Integer> {

    List<JobMaintenance> findAll();


}
