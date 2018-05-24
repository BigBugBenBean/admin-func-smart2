package com.pccw.immd.adminfunc.smartics2.service.impl;

import com.pccw.immd.adminfunc.smartics2.domain.UmApplicationId;
import com.pccw.immd.adminfunc.smartics2.repository.UmApplicationIdRepository;
import com.pccw.immd.adminfunc.smartics2.service.UmApplicationIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("umApplicationIdService.smartics2")
public class UmApplicationIdServiceImpl implements UmApplicationIdService {

    @Autowired
    @Qualifier ("umApplicationIdRepository.smartics2")
    private UmApplicationIdRepository umApplicationIdRepository;

    @Override
    public List<UmApplicationId> findAll() {
        return umApplicationIdRepository.findAll();
    }
}
