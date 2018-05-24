package com.pccw.immd.adminfunc.smartics2.web.controller;

import com.pccw.immd.adminfunc.smartics2.dto.EnquiryCodeInformationDTO;
import com.pccw.immd.adminfunc.smartics2.service.UmApplicationIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/smartics2/enquiry")
public class EnquiryCodeInformationController {

    @Autowired
    @Qualifier("umApplicationIdService.smartics2")
    private UmApplicationIdService umApplicationIdService;

    @GetMapping(value = "/enquiryCodeInformation.do")
    public String onlineSubmissionSearchPage(HttpServletRequest request, @ModelAttribute EnquiryCodeInformationDTO enquiryCodeInformationDTO) {

        enquiryCodeInformationDTO.setAppointmentTypes(umApplicationIdService.findAll());
        enquiryCodeInformationDTO.setAppointmentType("ABI");
        return "/../smartics2/EnquiryCodeInformation/enquiry-code-info-search";
    }

    @GetMapping(value = "/enquiryCodeInformationSearchResult.do")
    public String onlineSubmissionResultPage(HttpServletRequest request) {

        return "/../smartics2/EnquiryCodeInformation/enquiry-code-info-result";
    }

}
