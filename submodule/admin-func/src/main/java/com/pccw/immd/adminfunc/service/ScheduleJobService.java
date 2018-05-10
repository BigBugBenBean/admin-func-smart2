package com.pccw.immd.adminfunc.service;

import com.pccw.immd.adminfunc.domain.*;
import com.pccw.immd.adminfunc.dto.CreateScheduleJobDTO;
import com.pccw.immd.adminfunc.dto.ScheduleJobViewDTO;
import com.pccw.immd.adminfunc.dto.ScheduleJobViewHistoryDTO;

import java.util.List;

public interface ScheduleJobService {
    List<JobDetail> listAllJobDetail(String jobGroup);
    List<ScheduleJobViewHistory> listAllJobNameByJobHistory(ScheduleJobViewHistoryDTO scheduleJobViewHistoryDTO);
    List<String> listAllJobNameByJobDetails();
    List<ScheduleJobViewHistory> listAllHistory(String jobName, String status);
    List<ScheduleJobViewHistory> searchScheduleJobHistoryList(ScheduleJobViewHistoryDTO scheduleJobViewHistoryDTO);

    List<Object[]> searchScheduleJobViewList(ScheduleJobViewDTO scheduleJobViewDTO);

    Boolean createScheduleJob(CreateScheduleJobDTO createScheduleJobDTO);
    List<JobMaintenance> searchScheduleJobList(CreateScheduleJobDTO createScheduleJobDTO);
}
