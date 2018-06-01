package com.pccw.immd.adminfunc.smartics2.web.controller;

import com.pccw.immd.adminfunc.smartics2.domain.Holiday;
import com.pccw.immd.adminfunc.smartics2.service.SystemHolidayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/smartics2")
public class Smartics2Controller {

	private static final Logger LOG = LoggerFactory.getLogger(Smartics2Controller.class);

    @Autowired
    @Qualifier("systemHolidayService.smartics2")
    private SystemHolidayService systemHolidayService;

    @GetMapping(value = "/index.html")
    public String indexPage(){
        List<Holiday> list = systemHolidayService.listAll();
        return "smartics2/index";
    }


}
