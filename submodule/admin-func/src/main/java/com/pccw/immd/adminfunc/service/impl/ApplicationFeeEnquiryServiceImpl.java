package com.pccw.immd.adminfunc.service.impl;

import com.pccw.immd.adminfunc.domain.VPricePayment;
import com.pccw.immd.adminfunc.repository.UmApplicationCodeRepository;
import com.pccw.immd.adminfunc.repository.UmVPricePaymentRepository;
import com.pccw.immd.adminfunc.service.ApplicationFeeEnquiryService;
import com.pccw.immd.adminfunc.web.controller.ApplicationFeeEnquiryController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("applicationFeeEnquiryService")
public class ApplicationFeeEnquiryServiceImpl implements ApplicationFeeEnquiryService {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationFeeEnquiryController.class);

    @Autowired
    @Qualifier("umApplicationCodeRepository.eservice2")
    private UmApplicationCodeRepository umApplicationCodeRepository;

    @Autowired
    @Qualifier("umVPricePaymentRepository.eservice2")
    private UmVPricePaymentRepository umVPricePaymentRepository;

    @Override
    public List<VPricePayment> listAll() {
        return umVPricePaymentRepository.findAll();
    }
}
