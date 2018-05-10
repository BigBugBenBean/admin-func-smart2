package com.pccw.immd.adminfunc._sample_.web.controller;

import com.pccw.immd.adminfunc._sample_.domain.SystemHoliday;
import com.pccw.immd.adminfunc._sample_.service.SystemHolidayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/_sample_")
public class _sample_Controller {

	private static final Logger LOG = LoggerFactory.getLogger(_sample_Controller.class);

    @Autowired
    @Qualifier("systemHolidayService.smartics2")
    private SystemHolidayService systemHolidayService;

    @GetMapping(value = "/index.html")
    public String indexPage(){
        List<SystemHoliday> list = systemHolidayService.listAll();
        return "_sample_/index";
    }


}
