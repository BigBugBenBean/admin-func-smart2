package com.pccw.immd.adminfunc.web.controller;

import com.pccw.immd.adminfunc.domain.Func;
import com.pccw.immd.adminfunc.domain.SystemParam;
import com.pccw.immd.adminfunc.dto.IvrsDTO;
import com.pccw.immd.adminfunc.repository.FuncRepository;
import com.pccw.immd.adminfunc.repository.UserMenuRepository;
import com.pccw.immd.adminfunc.service.IVRSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/e-Services-2/maintenance")
public class IVRSController {

    private static final Logger LOG = LoggerFactory.getLogger(IVRSController.class);

    @Autowired
    @Qualifier("ivrsService.eservice2")
    private IVRSService ivrsService;

    @GetMapping(value = "/ivrs.do")
    public String ivrsPage(@ModelAttribute IvrsDTO ivrsDTO) {

        List<SystemParam> list = ivrsService.listAll();
        if (list.size() > 0) {
            ivrsDTO.setSystemParamList(list);
        }

        return "/eServices2/IVRS/ivrs";
    }

    @PostMapping(value = "/ivrs_Success.do")
    public String ivrsSuccessPage(@ModelAttribute IvrsDTO ivrsDTO) {

        LOG.debug("");

        String es1 = ivrsDTO.getIVRS_STATUS_ES1();
        String es2 = ivrsDTO.getIVRS_STATUS_ES2();

        if (es1 != null) {
            switch (es1) {
                case "Y": {
                    ivrsDTO.setIVRS_STATUS_ES1("Y");
                    break;
                }
                case "N": {
                    ivrsDTO.setIVRS_STATUS_ES1("N");
                    break;
                }
                default: {
                    ivrsDTO.setIVRS_STATUS_ES1(null);
                    break;
                }
            }
        }

        if (es2 != null) {
            switch (es2) {
                case "Y": {
                    ivrsDTO.setIVRS_STATUS_ES2("Y");
                    break;
                }
                case "N": {
                    ivrsDTO.setIVRS_STATUS_ES2("N");
                    break;
                }
                default: {
                    ivrsDTO.setIVRS_STATUS_ES2(null);
                    break;
                }
            }
        }


        List<SystemParam> result = ivrsService.updateSystemParam(ivrsDTO);
        ivrsDTO.setSystemParamList(result);

        return "/eServices2/IVRS/ivrs-success";
    }

    @Autowired
    @Qualifier("funcRepository")
    FuncRepository funcRepository;

    @GetMapping(value = "/ivrs_menuservice.do")
    public void ivrsPage() {
        Map<String, String> functionsFromDb = new HashMap<>();
        List<Func> functionsForUserRole = funcRepository.findFunctionsByUserRoles("R01");
        for (Func functions : functionsForUserRole) {
            functionsFromDb.put(functions.getFuncDesc(), functions.getDestUrl());
        }
        LOG.debug("map: " + functionsFromDb );


    }



}
