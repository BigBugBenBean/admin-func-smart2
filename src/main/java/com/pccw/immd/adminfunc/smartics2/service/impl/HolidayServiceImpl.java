package com.pccw.immd.adminfunc.smartics2.service.impl;

import com.pccw.immd.adminfunc.smartics2.domain.Holiday;
import com.pccw.immd.adminfunc.smartics2.repository.HolidayRepository;
import com.pccw.immd.adminfunc.smartics2.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("holidayService.smartics2")
public class HolidayServiceImpl implements HolidayService {

    @Autowired
    @Qualifier ("holidayRepository.smartics2")
    private HolidayRepository holidayRepository;

    public List<Holiday> listAll() {
        return holidayRepository.findAll();
    }
}
