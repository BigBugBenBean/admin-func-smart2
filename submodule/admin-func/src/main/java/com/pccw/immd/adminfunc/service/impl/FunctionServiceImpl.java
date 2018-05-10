package com.pccw.immd.adminfunc.service.impl;

import com.pccw.immd.adminfunc.domain.Func;
import com.pccw.immd.adminfunc.repository.FuncRepository;
import com.pccw.immd.adminfunc.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service ("functionService.eservice2")
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    @Qualifier("funcRepository")
    private FuncRepository funcRepository;

    /**
      *  TODO: After Function Mapping implemented, update the hard-code logic
      */
    public List<String> resolveFunctionId(String uri){
        List<Func> func = funcRepository.getByDestUrl(uri);
        List<String> funcIdList = new ArrayList<>();
        for (Func funcId : func) {
            funcIdList.add(funcId.getFuncId());

//            func != null)?funcId.getFuncId():null;
        }
        return funcIdList;
    }
}
