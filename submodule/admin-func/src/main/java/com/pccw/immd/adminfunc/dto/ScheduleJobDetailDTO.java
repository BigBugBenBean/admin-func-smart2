package com.pccw.immd.adminfunc.dto;

import com.pccw.immd.adminfunc.domain.ScheduleJobViewHistory;
import com.pccw.immd.commons.dto.BaseDTO;

import java.util.ArrayList;
import java.util.List;

public class ScheduleJobDetailDTO extends BaseDTO {

//    private List<JobDetail> jobDetailList = new ArrayList<>();
    private List<JobStatus> statusList = new ArrayList<>();
    private List<ScheduleJobViewHistory> jobNameList = new ArrayList<>();

    public ScheduleJobDetailDTO() {
        super();


        statusList.add(new JobStatus(0, "SUCCESS"));
        statusList.add(new JobStatus(1, "FAILED"));
        statusList.add(new JobStatus(2, "RUNNING"));
    }




    public List<ScheduleJobViewHistory> getJobNameList() {
        return jobNameList;
    }

    public void setJobNameList(List<ScheduleJobViewHistory> jobNameList) {
        this.jobNameList = jobNameList;
    }

    public List<JobStatus> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<JobStatus> statusList) {
        this.statusList = statusList;
    }


    //



    //    @Valid
//    @JsonProperty("jobName")
//    private String jobName = null;
//
//    public String getJobName() {
//        return jobName;
//    }
//
//    public void setJobName(String jobName) {
//        this.jobName = jobName;
//    }
}
