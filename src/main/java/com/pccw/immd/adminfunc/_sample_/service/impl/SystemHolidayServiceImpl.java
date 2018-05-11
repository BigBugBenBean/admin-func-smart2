package com.pccw.immd.adminfunc._sample_.service.impl;

import com.pccw.immd.adminfunc._sample_.domain.SystemHoliday;
import com.pccw.immd.adminfunc._sample_.repository.UmSystemHolidayRepository;
import com.pccw.immd.adminfunc._sample_.service.SystemHolidayService;
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
