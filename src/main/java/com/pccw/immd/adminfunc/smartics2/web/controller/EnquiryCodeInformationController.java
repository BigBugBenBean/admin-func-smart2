package com.pccw.immd.adminfunc.smartics2.web.controller;

import com.pccw.immd.adminfunc.smartics2.dto.EnquiryCodeInformationDTO;
import com.pccw.immd.adminfunc.smartics2.service.AppointmentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/smartics2/enquiry")
public class EnquiryCodeInformationController {

    @Autowired
    @Qualifier("appointmentInfoService.smartics2")
    private AppointmentInfoService appointmentInfoService;

    @GetMapping(value = "/enquiryCodeInformation.do")
    public String loadEnquiryCodeInfoSearch(HttpServletRequest request, @ModelAttribute EnquiryCodeInformationDTO enquiryCodeInformationSearchDTO) {

        return "/../smartics2/EnquiryCodeInformation/enquiry-code-info-search";
    }

    @PostMapping(value = "/enquiryCodeInformationSearchResult.do")
    public String searchEnquiryCodeInfo(HttpServletRequest request, @ModelAttribute EnquiryCodeInformationDTO enquiryCodeInformationSearchDTO) {

        appointmentInfoService.searchByAppTypeHkicTdnoDob(enquiryCodeInformationSearchDTO);
        return "/../smartics2/EnquiryCodeInformation/enquiry-code-info-result";
    }

}
