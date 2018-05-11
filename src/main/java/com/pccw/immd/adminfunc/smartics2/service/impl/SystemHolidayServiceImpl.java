package com.pccw.immd.adminfunc.smartics2.service.impl;

import com.pccw.immd.adminfunc.smartics2.domain.SystemHoliday;
import com.pccw.immd.adminfunc.smartics2.repository.UmSystemHolidayRepository;
import com.pccw.immd.adminfunc.smartics2.service.SystemHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("systemHolidayService.smartics2")
public class SystemHolidayServiceImpl implements SystemHolidayService {

    @Autowired
    @Qualifier ("umSystemHolidayRepository.smartics2")
    private UmSystemHolidayRepository umSystemHolidayRepository;

    @Override
    public List<SystemHoliday> listAll() {
        return umSystemHolidayRepository.findAllByOrderByHolidayDateAsc();
    }
}
