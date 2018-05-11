package com.pccw.immd.adminfunc.audit.impl;

import com.pccw.immd.adminfunc.audit.AuditTrailSearchService;
import com.pccw.immd.adminfunc.domain.AuditTrailSearch;
import com.pccw.immd.adminfunc.dto.LoginUser;
import com.pccw.immd.adminfunc.repository.UmAuditTrailSearchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.pccw.immd.adminfunc.annotation.AccessAudit.AccessActionType;

@Service("auditTrailSearch")
public class AuditTrailSearchImpl implements AuditTrailSearchService {

    private static final Logger LOG = LoggerFactory.getLogger(AuditTrailSearchImpl.class);

    @Autowired
    @Qualifier ("umAuditTrailSearchRepository.eservice2")
    public UmAuditTrailSearchRepository auditTrailSearchRepository;

    @Override
    public void log(String reqSessionId, LoginUser loginUser, String funcId, AccessActionType actionType){
        AuditTrailSearch at = formAuditTrailSearch(reqSessionId, loginUser, funcId, actionType);
        auditTrailSearchRepository.saveAndFlush(at);
    }

    private AuditTrailSearch formAuditTrailSearch(String reqSessionId, LoginUser loginUser, String funcId, AccessActionType actionType) {
        AuditTrailSearch ats = new AuditTrailSearch();
        ats.setOfficeCode(loginUser.getOfficeCode());
        ats.setImmdToken(loginUser.getImmdToken());
        ats.setUserId(loginUser.getUsername());
        ats.setJsessionId(reqSessionId);
        if (actionType == AccessActionType.FUNCTION)
            ats.setFuncId(funcId);
        ats.setLogDatetime(new Date());
        ats.setType(actionType.toString());
        return ats;
    }
}