package com.pccw.immd.adminfunc.dto;

import com.pccw.immd.adminfunc.domain.ScheduleJobViewHistory;
import com.pccw.immd.commons.dto.BaseDTO;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleJobViewHistoryDTO extends BaseDTO {

    private List<ScheduleJobViewHistory> scheduleJobViewHistoryList = new ArrayList<>();

    private String jobName;
    private String status;

    private String startDateFrom;
    private String startDateTo;
    private Integer startHourFrom;
    private Integer startMinuteFrom;
    private Integer startHourTo;
    private Integer startMinuteTo;

    private String endDateFrom;
    private String endDateTo;
    private Integer endHourFrom;
    private Integer endMinuteFrom;
    private Integer endHourTo;
    private Integer endMinuteTo;

    private String startDateTimeFrom;
    private String startDateTimeTo;
    private String endDateTimeFrom;
    private String endDateTimeTo;

    private List<JobStatus> statusList = new ArrayList<>();

    public ScheduleJobViewHistoryDTO() {
        super();

        statusList.add(new JobStatus(0, "SUCCESS"));
        statusList.add(new JobStatus(1, "FAILED"));
        statusList.add(new JobStatus(2, "RUNNING"));
    }

    public List<ScheduleJobViewHistory> getScheduleJobViewHistoryList() {
        return scheduleJobViewHistoryList;
    }

    public void setScheduleJobViewHistoryList(List<ScheduleJobViewHistory> scheduleJobViewHistoryList) {
        this.scheduleJobViewHistoryList = scheduleJobViewHistoryList;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartDateFrom() {
        return startDateFrom;
    }

    public void setStartDateFrom(String startDateFrom) {
        this.startDateFrom = startDateFrom;
    }

    public String getStartDateTo() {
        return startDateTo;
    }

    public void setStartDateTo(String startDateTo) {
        this.startDateTo = startDateTo;
    }

    public String getEndDateFrom() {
        return endDateFrom;
    }

    public void setEndDateFrom(String endDateFrom) {
        this.endDateFrom = endDateFrom;
    }

    public String getEndDateTo() {
        return endDateTo;
    }

    public void setEndDateTo(String endDateTo) {
        this.endDateTo = endDateTo;
    }

    public Integer getStartHourFrom() {
        return startHourFrom;
    }

    public void setStartHourFrom(Integer startHourFrom) {
        this.startHourFrom = startHourFrom;
    }

    public Integer getStartMinuteFrom() {
        return startMinuteFrom;
    }

    public void setStartMinuteFrom(Integer startMinuteFrom) {
        this.startMinuteFrom = startMinuteFrom;
    }

    public Integer getStartHourTo() {
        return startHourTo;
    }

    public void setStartHourTo(Integer startHourTo) {
        this.startHourTo = startHourTo;
    }

    public Integer getStartMinuteTo() {
        return startMinuteTo;
    }

    public void setStartMinuteTo(Integer startMinuteTo) {
        this.startMinuteTo = startMinuteTo;
    }

    public Integer getEndHourFrom() {
        return endHourFrom;
    }

    public void setEndHourFrom(Integer endHourFrom) {
        this.endHourFrom = endHourFrom;
    }

    public Integer getEndMinuteFrom() {
        return endMinuteFrom;
    }

    public void setEndMinuteFrom(Integer endMinuteFrom) {
        this.endMinuteFrom = endMinuteFrom;
    }

    public Integer getEndHourTo() {
        return endHourTo;
    }

    public void setEndHourTo(Integer endHourTo) {
        this.endHourTo = endHourTo;
    }

    public Integer getEndMinuteTo() {
        return endMinuteTo;
    }

    public void setEndMinuteTo(Integer endMinuteTo) {
        this.endMinuteTo = endMinuteTo;
    }

    public List<JobStatus> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<JobStatus> statusList) {
        this.statusList = statusList;
    }

    public String getStartDateTimeFrom() {
        return startDateTimeFrom;
    }

    public void setStartDateTimeFrom(String startDateTimeFrom) {
        this.startDateTimeFrom = startDateTimeFrom;
    }

    public String getStartDateTimeTo() {
        return startDateTimeTo;
    }

    public void setStartDateTimeTo(String startDateTimeTo) {
        this.startDateTimeTo = startDateTimeTo;
    }

    public String getEndDateTimeFrom() {
        return endDateTimeFrom;
    }

    public void setEndDateTimeFrom(String endDateTimeFrom) {
        this.endDateTimeFrom = endDateTimeFrom;
    }

    public String getEndDateTimeTo() {
        return endDateTimeTo;
    }

    public void setEndDateTimeTo(String endDateTimeTo) {
        this.endDateTimeTo = endDateTimeTo;
    }
}
