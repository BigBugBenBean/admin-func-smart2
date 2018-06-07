package com.pccw.immd.adminfunc.smartics2.service.impl;

import com.pccw.immd.adminfunc.smartics2.domain.AppointmentInfo;
import com.pccw.immd.adminfunc.smartics2.dto.EnquiryCodeInformationDTO;
import com.pccw.immd.adminfunc.smartics2.dto.EnquiryCodeInformationResultDTO;
import com.pccw.immd.adminfunc.smartics2.repository.AppointmentInfoRepository;
import com.pccw.immd.adminfunc.smartics2.service.AppointmentInfoService;
import com.pccw.immd.adminfunc.smartics2.util.Constants;
import com.pccw.immd.adminfunc.smartics2.util.HibernateUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("appointmentInfoService.smartics2")
public class AppointmentInfoServiceImpl implements AppointmentInfoService {

    @Autowired
    @Qualifier ("appointmentInfoRepository.smartics2")
    private AppointmentInfoRepository appointmentInfoRepository;

    public List<AppointmentInfo> listAll() { return appointmentInfoRepository.findAll(); }

    public EnquiryCodeInformationDTO searchByAppTypeHkicTdnoDob(EnquiryCodeInformationDTO dto) {

        List<EnquiryCodeInformationResultDTO> resultList = new ArrayList<EnquiryCodeInformationResultDTO>();

        StringBuffer hql = new StringBuffer();
        hql.append(" SELECT new com.pccw.immd.adminfunc.smartics2.dto.EnquiryCodeInformationResultDTO( ");
        hql.append(" TO_CHAR(APPTRANS.transTime, 'dd/MM/yyyy HH24:MI:SS'), 'ROPbooking', ");
        hql.append(" TO_CHAR(QP.apptDate, 'dd/MM/yyyy') || ' ' || QP.startTime AS appDateTime, QP.officeId, ");
        hql.append(" APPTRANS.appId, APPINFO.appDob, APPINFO.id.trn, APPTRANS.commChannel, APPTRANS.action, APPTRANS.enqCode) ");
        hql.append(" FROM AppointmentInfo APPINFO, AppointmentTrans APPTRANS, QuotaPlan QP ");
        hql.append(" WHERE APPINFO.id.trn = APPTRANS.trn ");
        hql.append(" AND APPINFO.quotaId = QP.quotaId ");

        if (StringUtils.isNotBlank(dto.getHkic())) {
            hql.append(" AND APPINFO.apmidCode = :hkic ");
            hql.append(" AND APPINFO.apmidType = :apmidType ");
        } else if (StringUtils.isNotBlank(dto.getTdNo()) &&
                (StringUtils.isNotBlank(dto.getDobYear()) &&
                    StringUtils.isNotBlank(dto.getDobMonth()) &&
                    StringUtils.isNotBlank(dto.getDobDay()))) {
            hql.append(" AND APPINFO.apmidCode = :tdNo ");
            hql.append(" AND APPINFO.apmidType = :apmidType ");
            hql.append(" AND APPINFO.appDob = :appDob "); // yyyymmdd
        }

        hql.append(" ORDER BY APPINFO.lastUpdDate DESC ");

        Map<String, Object> paramMap = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(dto.getHkic())) {
            paramMap.put("hkic", dto.getHkic());
            paramMap.put("apmidType", Constants.APMIDTYPE_ID);
        } else if (StringUtils.isNotBlank(dto.getTdNo()) &&
                (StringUtils.isNotBlank(dto.getDobYear()) &&
                        StringUtils.isNotBlank(dto.getDobMonth()) &&
                        StringUtils.isNotBlank(dto.getDobDay()))) {
            paramMap.put("tdNo", dto.getTdNo());
            paramMap.put("apmidType", Constants.APMIDTYPE_TD);
            paramMap.put("appDob", dto.getDobYear() + dto.getDobMonth() + dto.getDobDay()); // yyyymmdd
        }

        resultList = HibernateUtils.listByHQL(hql.toString(), paramMap);
        dto.setSearchResults(resultList);
        return dto;
    }
}
