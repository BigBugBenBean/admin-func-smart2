package com.pccw.immd.adminfunc.smartics2.service.impl;

import com.pccw.immd.adminfunc.smartics2.domain.AppointmentInfo;
import com.pccw.immd.adminfunc.smartics2.dto.EnquiryCodeInformationDTO;
import com.pccw.immd.adminfunc.smartics2.dto.EnquiryCodeInformationResultDTO;
import com.pccw.immd.adminfunc.smartics2.repository.AppointmentInfoRepository;
import com.pccw.immd.adminfunc.smartics2.service.AppointmentInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service("appointmentInfoService.smartics2")
public class AppointmentInfoServiceImpl implements AppointmentInfoService {

    @PersistenceContext( unitName = "smartics2")
    private EntityManager em;

    @Autowired
    @Qualifier ("appointmentInfoRepository.smartics2")
    private AppointmentInfoRepository appointmentInfoRepository;

    public List<AppointmentInfo> listAll() { return appointmentInfoRepository.findAll(); }

    public EnquiryCodeInformationDTO searchByAppTypeHkicTdnoDob(EnquiryCodeInformationDTO dto) {

        List<EnquiryCodeInformationResultDTO> resultList = new ArrayList<EnquiryCodeInformationResultDTO>();

        StringBuffer hql = new StringBuffer();
        hql.append(" SELECT new com.pccw.immd.adminfunc.smartics2.dto.EnquiryCodeInformationResultDTO( ");
        hql.append(" APPTRANS.transTime, 'ROPBooking', APPINFO.apptEndtime, QP.officeId, APPTRANS.appId, ");
        hql.append(" APPINFO.appDob, APPINFO.id.trn, APPTRANS.commChannel, APPTRANS.action, APPTRANS.enqCode) ");
        //hql.append(" FROM AppointmentInfo APPINFO INNER JOIN AppointmentTrans APPTRANS ON APPINFO.appointmentInfoId.trn = APPTRANS.trn ");
        //hql.append(" INNER JOIN QuotaPlan QP ON APPINFO.quotaId = QP.quotaId ");
        hql.append(" FROM AppointmentInfo APPINFO, AppointmentTrans APPTRANS, QuotaPlan QP ");
        hql.append(" WHERE APPINFO.id.trn = APPTRANS.trn ");
        hql.append(" AND APPINFO.quotaId = QP.quotaId ");

        if (StringUtils.isNotBlank(dto.getHkic())) {
            hql.append(" AND APPINFO.apmidCode = :hkic ");
        } else if (StringUtils.isNotBlank(dto.getTdNo()) &&
                (StringUtils.isNotBlank(dto.getDobYear()) &&
                    StringUtils.isNotBlank(dto.getDobMonth()) &&
                    StringUtils.isNotBlank(dto.getDobDay()))) {
            hql.append(" AND APPINFO.apmidCode = :tdNo ");
            hql.append(" AND APPINFO.appDob = :dob "); // yyyymmdd
        }

        hql.append(" ORDER BY APPINFO.lastUpdDate DESC ");

        Query qry = em.createQuery(hql.toString());
        if (StringUtils.isNotBlank(dto.getHkic())) {
            qry.setParameter("hkic", dto.getHkic());
        } else if (StringUtils.isNotBlank(dto.getTdNo()) &&
                (StringUtils.isNotBlank(dto.getDobYear()) &&
                        StringUtils.isNotBlank(dto.getDobMonth()) &&
                        StringUtils.isNotBlank(dto.getDobDay()))) {
            qry.setParameter("tdNo", dto.getTdNo());
            qry.setParameter("dob", dto.getDobYear() + dto.getDobMonth() + dto.getDobDay()); // yyyymmdd
        }
        dto.setSearchResults(qry.getResultList());
        return dto;
    }

}
