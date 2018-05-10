package com.pccw.immd.adminfunc._sample_.repository;

import com.pccw.immd.adminfunc._sample_.domain.SystemHoliday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dell on 24/1/2018.
 */
@Repository ("umSystemHolidayRepository.smartics2")
public interface UmSystemHolidayRepository extends JpaRepository<SystemHoliday,Integer>{

    List<SystemHoliday> findAllByOrderByHolidayDateAsc();
}
