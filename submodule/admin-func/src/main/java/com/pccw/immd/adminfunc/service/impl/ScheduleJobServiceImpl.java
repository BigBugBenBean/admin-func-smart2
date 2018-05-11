package com.pccw.immd.adminfunc.service.impl;

import com.pccw.immd.adminfunc.domain.*;
import com.pccw.immd.adminfunc.dto.CreateScheduleJobDTO;
import com.pccw.immd.adminfunc.dto.ScheduleJobViewDTO;
import com.pccw.immd.adminfunc.dto.ScheduleJobViewHistoryDTO;
import com.pccw.immd.adminfunc.repository.HibernateUtils;
import com.pccw.immd.adminfunc.repository.JobMaintenanceRepository;
import com.pccw.immd.adminfunc.repository.UmScheduleJobDetailRepository;
import com.pccw.immd.adminfunc.repository.UmScheduleJobViewHistoryRepository;
import com.pccw.immd.adminfunc.service.ScheduleJobService;
import com.pccw.immd.adminfunc.web.controller.ScheduleJobController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("scheduleJobService")
public class ScheduleJobServiceImpl implements ScheduleJobService {
    private static final Logger LOG = LoggerFactory.getLogger(ScheduleJobController.class);

    private static final String WHERE_CLAUSE = " where ";

    @Autowired
    @Qualifier("umScheduleJobViewHistoryRepository")
    private UmScheduleJobViewHistoryRepository umScheduleJobViewHistoryRepository;

    @Autowired
    @Qualifier("umScheduleJobDetailRepository")
    private UmScheduleJobDetailRepository scheduleJobDetailRepository;

    @Autowired
    @Qualifier("jobMaintenanceRepository")
    JobMaintenanceRepository jobMaintenanceRepository;

    public static final String CREATE_JOB = "INSERT";
    public static final String UPDATE_JOB = "UPDATE";

    @Override
    public List<com.pccw.immd.adminfunc.domain.JobDetail> listAllJobDetail(String jobGroup) {
        return scheduleJobDetailRepository.findAllByJobGroup(jobGroup);
    }

    @Override
    public List<ScheduleJobViewHistory> listAllHistory(String jobName, String status) {
        return umScheduleJobViewHistoryRepository.findAllByJobName(jobName);
    }

    @Override
    public Boolean createScheduleJob(CreateScheduleJobDTO createScheduleJobDTO) {

        boolean isCreated = false;
        try {
            JobMaintenance jobMaintenance = new JobMaintenance();

            jobMaintenance.setJobName(createScheduleJobDTO.getJobName());;
            jobMaintenance.setAction(CREATE_JOB);
            jobMaintenance.setCreateDate(new Timestamp(System.currentTimeMillis()));
            jobMaintenance.setDescription(createScheduleJobDTO.getDescription());
            if (createScheduleJobDTO.getJobClass().equals("") || createScheduleJobDTO.getJobClass()==null) {
                jobMaintenance.setJobClassName(createJobClassName(createScheduleJobDTO.getJobName()));
            } else {
                jobMaintenance.setJobClassName(createScheduleJobDTO.getJobClass());
            }
            jobMaintenance.setCronExpression(createScheduleJobDTO.getCronExpression());
            jobMaintenance.setDataMapJson(createScheduleJobDTO.getDataMap());
            jobMaintenance.setExecuteDate(null);
            jobMaintenanceRepository.save(jobMaintenance);
            isCreated=true;
        } catch (Exception e ) {
            e.printStackTrace();
        }
//        Boolean isCreated = false;
//        JobDetail jobDetail = null;
//        CronScheduleBuilder scheduleBuilder = null;
//
//        String jobName = createScheduleJobDTO.getJobName();
//        String jobDesc = createScheduleJobDTO.getDescription();
//        String jobClassName = createScheduleJobDTO.getJobClass();
//        String cronExpression = createScheduleJobDTO.getCronExpression();
//        String jobDataMap = createScheduleJobDTO.getDataMap();
//
//        try {
//            SchedulerFactory sf = new StdSchedulerFactory();
//            Scheduler scheduler = sf.getScheduler();
//            try{
//                jobDetail = JobBuilder.newJob(
//                        JobUtils.getClass(jobClassName).getClass()
//                )
//                        .withIdentity(jobName)
//                        .withDescription(jobDesc)
//                        .usingJobData(JobUtils.getJobDataMap(jobDataMap))
//                        .build();
//            }catch (ClassNotFoundException e) {
//
//            }catch (IllegalArgumentException e) {
//
//            }catch (Exception e) {
//
//            }
//            try{
//                scheduleBuilder = CronScheduleBuilder
//                        .cronSchedule(cronExpression)
//                        .withMisfireHandlingInstructionDoNothing();
//            }catch (Exception e) {
//
//            }
//            CronTrigger trigger = TriggerBuilder.newTrigger()
//                    .withIdentity(jobName)
//                    .withSchedule(scheduleBuilder)
//                    .build();
//
//            if (jobDetail != null && scheduleBuilder != null) {
//                try {
//                    scheduler.scheduleJob(jobDetail, trigger);
//                    isCreated = true;
//                } catch (ObjectAlreadyExistsException e) {
//
//                } catch (Exception e) {
//
//                }
//            }
//        } catch(SchedulerException e) {
//
//        } catch(Exception e) {
//
//        }
//
//        EntityManager em = HibernateUtils.getEm();
//
//        Session session = HibernateUtils.getSession();
//        session.beginTransaction();
//
//        // Job Detail
//        com.pccw.immd.adminfunc.domain.JobDetail newJobDetail = new com.pccw.immd.adminfunc.domain.JobDetail();
//        newJobDetail.setJobName(createScheduleJobDTO.getJobName());
//        newJobDetail.setJobClassName(createScheduleJobDTO.getJobClass());
//        newJobDetail.setDescription(createScheduleJobDTO.getDescription());
//
//        newJobDetail.setSchedName(createScheduleJobDTO.getSchedName());
//        newJobDetail.setJobGroup(createScheduleJobDTO.getJobGroup());
//        newJobDetail.setIsDurable(createScheduleJobDTO.getIsDurable());
//        newJobDetail.setIsNonconcurrent(createScheduleJobDTO.getIsNonconcurrent());
//        newJobDetail.setIsUpdateData(createScheduleJobDTO.getIsUpdateData());
//        newJobDetail.setRequestsRecovery(createScheduleJobDTO.getRequestsRecovery());
//
//        // Qrtz Cron Triggers
//        QrtzCronTriggers newQrtzCronTriggers = new QrtzCronTriggers();
//        newQrtzCronTriggers.setSchedName(createScheduleJobDTO.getSchedName());
//        newQrtzCronTriggers.setTriggerName(createScheduleJobDTO.getJobName());
//        newQrtzCronTriggers.setTriggerGroup(createScheduleJobDTO.getJobGroup());
//        newQrtzCronTriggers.setCronExpression(createScheduleJobDTO.getCronExpression());
//
//        QrtzTriggers newQrtzTriggers = new QrtzTriggers();
//        newQrtzTriggers.setSchedName(createScheduleJobDTO.getSchedName());
//        newQrtzTriggers.setTriggerName(jobName);
//        newQrtzTriggers.setTriggerGroup(createScheduleJobDTO.getJobGroup());
//        newQrtzTriggers.setJobName(createScheduleJobDTO.getJobName());
//        newQrtzTriggers.setJobGroup(createScheduleJobDTO.getJobGroup());
//        newQrtzTriggers.setTriggerState("WAITING");
//        newQrtzTriggers.setTriggerType("CRON");
//        newQrtzTriggers.setStartTime(1523947610000L);
//
//
//        // save
//        session.save(newJobDetail);
//        session.save(newQrtzTriggers);
//        session.save(newQrtzCronTriggers);
//
//        // commit
//        session.getTransaction().commit();
//        session.close();
        return isCreated;
    }

    @Override
    public List<ScheduleJobViewHistory> listAllJobNameByJobHistory(ScheduleJobViewHistoryDTO scheduleJobViewHistoryDTO) {

        List<ScheduleJobViewHistory> list;

        String jobHistory = "jh";
        int count =0;
        String hql = "from ScheduleJobViewHistory as " + jobHistory;
        Map<String, Object> params = new HashMap<>();

        String whereClause = " WHERE ";
        if (scheduleJobViewHistoryDTO.getJobName() != null && !scheduleJobViewHistoryDTO.getJobName().equals("")) {
            whereClause += jobHistory + ".jobName like '%" + scheduleJobViewHistoryDTO.getJobName() + "%' ";
            count++;
        }
        if (scheduleJobViewHistoryDTO.getStatus() != null && !scheduleJobViewHistoryDTO.getStatus().equals("")) {
            if (count>0) {
                whereClause += " and ";
            }
            whereClause += jobHistory + ".status like '" + scheduleJobViewHistoryDTO.getStatus() + "%' ";
            count++;
        }
        if (scheduleJobViewHistoryDTO.getStartDateTimeFrom() != null && !scheduleJobViewHistoryDTO.getStartDateTimeFrom().equals("")
                && scheduleJobViewHistoryDTO.getStartDateTimeTo() != null && !scheduleJobViewHistoryDTO.getStartDateTimeTo().equals("")) {
            if (count>0) {
                whereClause += " and ";
            }
            whereClause += jobHistory + ".startTime >= '" + scheduleJobViewHistoryDTO.getStartDateTimeFrom() + "'" +
                    " and " + jobHistory + ".startTime <= '" + scheduleJobViewHistoryDTO.getStartDateTimeTo() + "'";
            count++;
        }
        if (scheduleJobViewHistoryDTO.getEndDateTimeFrom() != null && !scheduleJobViewHistoryDTO.getEndDateTimeFrom().equals("")
                && scheduleJobViewHistoryDTO.getEndDateTimeTo() != null && !scheduleJobViewHistoryDTO.getEndDateTimeTo().equals("")) {
            if (count>0) {
                whereClause += " and ";
            }
            whereClause += jobHistory + ".endTime >= '" + scheduleJobViewHistoryDTO.getEndDateTimeFrom() + "'" +
                    " and " + jobHistory + ".endTime <= '" + scheduleJobViewHistoryDTO.getEndDateTimeTo() + "'";
            count++;
        }

        if (count>0) {
            hql += whereClause;
        }


        EntityManager em = HibernateUtils.getEm();
        Query query = em.createQuery(hql);
        list = query.getResultList();

        return list;

    }

    @Override
    public List<String> listAllJobNameByJobDetails() {

        List<String> list;
        String hql = "select distinct jobName from JobDetail ORDER BY jobName ASC";

        EntityManager em = HibernateUtils.getEm();
        Query query = em.createQuery(hql);
        list = query.getResultList();

        return list;
    }

    @Override
    public List<ScheduleJobViewHistory> searchScheduleJobHistoryList(ScheduleJobViewHistoryDTO scheduleJobViewHistoryDTO) {
        String name = "jh";
        String hql = "from ScheduleJobViewHistory " + name;
        Map<String, Object> params = new HashMap<>();
//        hql += getWhereClause(name, scheduleJobViewHistoryDTO, params);

        List<ScheduleJobViewHistory> list = HibernateUtils.listByHQL(hql, params);
        LOG.debug("searchScheduleJobHistoryList: " + list.size());
        return list;
    }

    @Override
    public List<Object[]> searchScheduleJobViewList(ScheduleJobViewDTO scheduleJobViewDTO) {

        List<Object[]>viewList =  new ArrayList<Object[]>();
//        umScheduleJobViewHistoryRepository.getScheduleJobViewList(scheduleJobViewDTO.getJobName(), scheduleJobViewDTO.getCronExpression(),
//                scheduleJobViewDTO.getStatus(), scheduleJobViewDTO.getStartDate().toString(), scheduleJobViewDTO.getEndDate().toString());
        return viewList;
    }

    @Override
    public List<JobMaintenance> searchScheduleJobList(CreateScheduleJobDTO createScheduleJobDTO) {

        List<JobMaintenance> list;

        String jobMaintenance = "jm";
        int count =0;
        String hql = "from JobMaintenance as " + jobMaintenance;
        Map<String, Object> params = new HashMap<>();
        String whereClause = " WHERE ";
        if (createScheduleJobDTO.getJobName() != null && !createScheduleJobDTO.getJobName().equals("")) {
            whereClause += jobMaintenance + ".jobName like '%" + createScheduleJobDTO.getJobName() + "%' ";
            count++;
        }
        if (createScheduleJobDTO.getCronExpression() != null && !createScheduleJobDTO.getCronExpression().equals("")) {
            if (count>0) {
                whereClause += " and ";
            }
            whereClause += jobMaintenance + ".cronExpression like '" + createScheduleJobDTO.getCronExpression() + "%' ";
            count++;
        }
        if (createScheduleJobDTO.getDataMap() != null && !createScheduleJobDTO.getDataMap().equals("")) {
            if (count>0) {
                whereClause += " and ";
            }
            whereClause += jobMaintenance + ".status like '%" + createScheduleJobDTO.getDataMap() + "%' ";
            count++;
        }
        if (createScheduleJobDTO.getDescription() != null && !createScheduleJobDTO.getDescription().equals("")) {
            if (count>0) {
                whereClause += " and ";
            }
            whereClause += jobMaintenance + ".status like '%" + createScheduleJobDTO.getDescription() + "%' ";
            count++;
        }

        if (count>0) {
            hql += whereClause;
        }


        EntityManager em = HibernateUtils.getEm();
        Query query = em.createQuery(hql);
        list = query.getResultList();

        return list;
    }

//    private String getWhereClause(String name, ScheduleJobViewHistoryDTO scheduleJobViewHistoryDTO, Map<String, Object> params) {
//        String whereClause = "";
//        String orderBy = " order by " + name + ".startTime DESC";
//
//        if (scheduleJobViewHistoryDTO.getJobName() != null || scheduleJobViewHistoryDTO.getStatus() != null
//                || scheduleJobViewHistoryDTO.getStartDate() != null || scheduleJobViewHistoryDTO.getEndDate() != null) {
//            if (scheduleJobViewHistoryDTO.getJobName() != null) {
//                whereClause += " and " + name + ".jobName = :jobName";
//                params.put("jobName", scheduleJobViewHistoryDTO.getJobName());
//            }
//            if (scheduleJobViewHistoryDTO.getStatus() != null && !scheduleJobViewHistoryDTO.getStatus().equals("")) {
//                whereClause += " and " + name + ".status = :status";
//                params.put("status", scheduleJobViewHistoryDTO.getStatus());
//            }
//            if (scheduleJobViewHistoryDTO.getStartDate() != null && scheduleJobViewHistoryDTO.getEndDate() != null) {
//                whereClause += " and " + name + ".startTime BETWEEN :startDate AND :endDate";
//                params.put("startDate", scheduleJobViewHistoryDTO.getStartDate());
//                params.put("endDate", scheduleJobViewHistoryDTO.getEndDate());
//            } else if (scheduleJobViewHistoryDTO.getStartDate() != null) {
//                whereClause += " and " + name + ".startTime >= :startDate ";
//                params.put("startDate", scheduleJobViewHistoryDTO.getStartDate());
//            } else if (scheduleJobViewHistoryDTO.getEndDate() != null) {
//                whereClause += " and " + name + ".endTime <= :endDate";
//                params.put("endDate", scheduleJobViewHistoryDTO.getEndDate());
//            }
//        }
//
//        return whereClause.trim().length() == 0? "" : WHERE_CLAUSE + whereClause.substring(4) + orderBy;
//    }

    private String createJobClassName(String jobName) {

        String jobClassName = "";
        String ecJob ="com.immd.eservice2.ec.job.report.";
        String smJob ="com.immd.eservice2.sm.job.report.";

        boolean iseServices = true;
        jobName = jobName.replace("-", "_");
        String[] jobnameparts = jobName.split("_", 2);

        if (jobnameparts.length==1) {
            jobClassName = jobName;
        } else {
            if (iseServices) {
                jobClassName = ecJob + jobnameparts[1];
            } else {
                jobClassName = smJob + jobnameparts[1];
            }
        }
        return jobClassName;
    }

    private String formatDate(String dateToFormat) {

        String dateFormatted = "";
        try {

            SimpleDateFormat dt = new SimpleDateFormat("mm/dd/yyyy hh:mm");
            Date newDate = dt.parse(dateToFormat);
            SimpleDateFormat dt1 = new SimpleDateFormat("dd-MMM-yyyy hh.mm");
            dateFormatted = dt1.format(newDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dateFormatted;
    }
}
