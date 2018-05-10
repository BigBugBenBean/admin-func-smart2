package com.pccw.immd.adminfunc.web.controller;

import com.pccw.immd.adminfunc.domain.JobMaintenance;
import com.pccw.immd.adminfunc.domain.ScheduleJob;
import com.pccw.immd.adminfunc.domain.ScheduleJobView;
import com.pccw.immd.adminfunc.domain.ScheduleJobViewHistory;
import com.pccw.immd.adminfunc.dto.CreateScheduleJobDTO;
import com.pccw.immd.adminfunc.dto.JobStatus;
import com.pccw.immd.adminfunc.dto.ScheduleJobDetailDTO;
import com.pccw.immd.adminfunc.dto.ScheduleJobViewDTO;
import com.pccw.immd.adminfunc.dto.ScheduleJobViewHistoryDTO;
import com.pccw.immd.adminfunc.service.ScheduleJobService;
import com.pccw.immd.adminfunc.web.interceptor.BreadcrumbInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.pccw.immd.adminfunc.web.interceptor.BreadcrumbInterceptor.FUNC_ID_KEY;

@Controller
public class ScheduleJobController {
    private static final Logger LOG = LoggerFactory.getLogger(ScheduleJobController.class);

    @Autowired
    @Qualifier("scheduleJobService")
    private ScheduleJobService scheduleJobService;

    /**
     * Schedule Job View
     * /e-Services-2/enquiry
     */

    @GetMapping(value = "/e-Services-2/enquiry/scheduleJobView.do")
    public String scheduleJobViewSearchPage(HttpServletRequest request, @ModelAttribute ScheduleJobViewDTO scheduleJobViewDTO) {

        request.setAttribute(FUNC_ID_KEY, BreadcrumbInterceptor.FUNC_ID.Schedule_Job_View_Job);
        List<JobStatus> statusList = scheduleJobViewDTO.getStatusList();

        List<String> jobNameList = scheduleJobService.listAllJobNameByJobDetails();
        if (jobNameList.size() > 0) {
            scheduleJobViewDTO.setJobNameList(jobNameList);
        }

        return "/eServices2/ScheduleJob/schedule-job-view-search";
    }

    @PostMapping(value = "/e-Services-2/enquiry/scheduleJobView_Search.do")
    public String scheduleJobViewResultPage(HttpServletRequest request, @ModelAttribute ScheduleJobViewDTO scheduleJobViewDTO) {

        request.setAttribute(FUNC_ID_KEY, BreadcrumbInterceptor.FUNC_ID.Schedule_Job_View_Job);
        if (scheduleJobViewDTO.getStatus() != null && !scheduleJobViewDTO.equals("")) {
            scheduleJobViewDTO.setStatus(scheduleJobViewDTO.getStatus().toUpperCase());
        }
        String dateRegex = "\\d{2}/\\d{2}/\\d{4}\\d{2}\\d{2}";
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyyHHmm");
        if (!scheduleJobViewDTO.getStartTime().equals("")
                && scheduleJobViewDTO.getStartHour() != null
                && scheduleJobViewDTO.getStartMinute() != null
                ) {

            String tmpStartHour = String.format("%02d", scheduleJobViewDTO.getStartHour());
            String tmpStartMinute = String.format("%02d", scheduleJobViewDTO.getStartMinute());
            String startDateStr = scheduleJobViewDTO.getStartTime() + tmpStartHour + tmpStartMinute;

            if (!startDateStr.equals("")) {
                if (scheduleJobViewDTO.getStartHour() < 0 || scheduleJobViewDTO.getStartHour() >= 24) {
                    // TODO: exception case
                    LOG.debug("InvalidStartHour");
                }
                if (scheduleJobViewDTO.getStartMinute() < 0 || scheduleJobViewDTO.getStartMinute() >= 60) {
                    // TODO: exception case
                    LOG.debug("InvalidStartMinute");
                }
                Boolean isValidStartDate = startDateStr.matches(dateRegex);
                if (!isValidStartDate) {
                    // TODO: exception case
                    LOG.debug("InvalidStartDate");
                }
                try {
                    Date startDate = dateFormat.parse(startDateStr);
                    Long startLong = startDate.getTime();
                    scheduleJobViewDTO.setStartDate(startDate);
                } catch (ParseException e) {
                    // TODO: exception case
                    LOG.debug("ERROR: Date parse error");
                }
            }
        }

        // endDate
        if (!scheduleJobViewDTO.getEndTime().equals("")
                && scheduleJobViewDTO.getEndHour() != null
                && scheduleJobViewDTO.getEndMinute() != null
                ) {
            //
            String tmpEndHour = String.format("%02d", scheduleJobViewDTO.getEndHour());
            String tmpEndMinute = String.format("%02d", scheduleJobViewDTO.getEndMinute());
            String endDateStr = scheduleJobViewDTO.getEndTime() + tmpEndHour + tmpEndMinute;
            if (!endDateStr.equals("")) {
                if (scheduleJobViewDTO.getEndHour() < 0 || scheduleJobViewDTO.getEndHour() >= 24) {
                    // TODO: exception case
                    LOG.debug("InvalidEndHour");
                }
                if (scheduleJobViewDTO.getEndMinute() < 0 || scheduleJobViewDTO.getEndMinute() >= 60) {
                    // TODO: exception case
                    LOG.debug("InvalidEndMinute");
                }
                Boolean isValidEndDate = endDateStr.matches(dateRegex);
                if (!isValidEndDate) {
                    // TODO: exception case
                    LOG.debug("InvalidEndDate");
                }
                try {
                    Date endDate = dateFormat.parse(endDateStr);
                    Long endLong = endDate.getTime();
                    scheduleJobViewDTO.setEndDate(endDate);
                } catch (ParseException e) {
                    // TODO: exception case
                    LOG.debug("ERROR: Date parse error");
                }
            }
        }

//        List<Object[]>list = scheduleJobService.searchScheduleJobViewList(scheduleJobViewDTO);
//        LOG.debug("list: " + list.size());

//        if (list.size() > 0) {
//            scheduleJobViewDTO.setScheduleJobViewList(list);
//        }

        return "/eServices2/ScheduleJob/schedule-job-view-result";
    }


    /**
     * Schedule Job View History
     * /e-Services-2/enquiry
     */

    @GetMapping(value = "/e-Services-2/enquiry/scheduleJobViewHistory.do")
    public String scheduleJobViewHistSearchPage(HttpServletRequest request, @ModelAttribute ScheduleJobViewHistoryDTO scheduleJobViewHistoryDTO) {

        request.setAttribute(FUNC_ID_KEY, BreadcrumbInterceptor.FUNC_ID.Schedule_Job_View_Job_History);
        List<ScheduleJobViewHistory> scheduleJobViewHistoryList = scheduleJobService.listAllJobNameByJobHistory(scheduleJobViewHistoryDTO);
        LOG.debug("scheduleJobViewHistSearchPage scheduleJobViewHistoryList size: " + scheduleJobViewHistoryList.size());

        if (scheduleJobViewHistoryList.size() > 0) {
            scheduleJobViewHistoryDTO.setScheduleJobViewHistoryList(scheduleJobViewHistoryList);
        }
        List<JobStatus> statusList = scheduleJobViewHistoryDTO.getStatusList();
        LOG.debug("scheduleJobViewHistSearchPage statusList size: " + statusList.size());

        return "/eServices2/ScheduleJob/schedule-job-view-history-search";
    }

    @PostMapping(value = "/e-Services-2/enquiry/scheduleJobViewHistory_Search.do")
    public String searchScheduleJobViewHistory(HttpServletRequest request, @ModelAttribute ScheduleJobViewHistoryDTO scheduleJobViewHistoryDTO) {

        request.setAttribute(FUNC_ID_KEY, BreadcrumbInterceptor.FUNC_ID.Schedule_Job_View_Job_History);
        if (scheduleJobViewHistoryDTO.getStartDateFrom() != null && !scheduleJobViewHistoryDTO.getStartDateFrom().isEmpty()) {
            String startDateFrom = scheduleJobViewHistoryDTO.getStartDateFrom() + ' ';
            if (scheduleJobViewHistoryDTO.getStartHourFrom() != null && scheduleJobViewHistoryDTO.getStartMinuteFrom() != null) {
                startDateFrom = scheduleJobViewHistoryDTO.getStartHourFrom().toString()
                        + '.' + scheduleJobViewHistoryDTO.getStartMinuteFrom().toString();
            }
            scheduleJobViewHistoryDTO.setStartDateTimeFrom(startDateFrom);
        }
        if (scheduleJobViewHistoryDTO.getStartDateTo() != null && !scheduleJobViewHistoryDTO.getStartDateTo().isEmpty()) {
            String startDateTo = scheduleJobViewHistoryDTO.getStartDateTo() + ' ';
            if (scheduleJobViewHistoryDTO.getStartHourTo() != null && scheduleJobViewHistoryDTO.getStartMinuteTo() != null) {
                startDateTo = scheduleJobViewHistoryDTO.getStartHourTo().toString()
                        + '.' + scheduleJobViewHistoryDTO.getStartMinuteTo().toString();
            }
            scheduleJobViewHistoryDTO.setStartDateTimeTo(startDateTo);
        }
        if (scheduleJobViewHistoryDTO.getEndDateFrom() != null && !scheduleJobViewHistoryDTO.getEndDateFrom().isEmpty()) {
            String endDateFrom = scheduleJobViewHistoryDTO.getEndDateFrom() + '.';
            if (scheduleJobViewHistoryDTO.getEndHourFrom() != null && scheduleJobViewHistoryDTO.getEndMinuteFrom() != null) {
                endDateFrom = scheduleJobViewHistoryDTO.getEndHourFrom().toString()
                        + '.' + scheduleJobViewHistoryDTO.getEndMinuteFrom().toString();
            }
            scheduleJobViewHistoryDTO.setEndDateTimeFrom(endDateFrom);
        }

        if (scheduleJobViewHistoryDTO.getEndDateTo() != null && !scheduleJobViewHistoryDTO.getEndDateTo().isEmpty()) {
            String endDateTo = scheduleJobViewHistoryDTO.getEndDateTo() + ' ';

            if (scheduleJobViewHistoryDTO.getEndHourTo() != null && scheduleJobViewHistoryDTO.getEndMinuteTo() != null) {
                endDateTo = scheduleJobViewHistoryDTO.getEndHourTo().toString()
                        + '.' + scheduleJobViewHistoryDTO.getEndMinuteTo().toString();
            }
            scheduleJobViewHistoryDTO.setEndDateTimeTo(endDateTo);
        }

        List<ScheduleJobViewHistory> results = scheduleJobService.listAllJobNameByJobHistory(scheduleJobViewHistoryDTO);
        if (results != null && results.size() > 0) {
            scheduleJobViewHistoryDTO.setScheduleJobViewHistoryList(results);
        }
        return "/eServices2/ScheduleJob/schedule-job-view-history-result";
    }

    /**
     * Schedule Job
     * /e-Services-2/maintenance/
     */

    @GetMapping(value = "/e-Services-2/maintenance/scheduleJob.do")
    public String scheduleJobSearchPage(HttpServletRequest request, @ModelAttribute ScheduleJobViewDTO scheduleJobViewDTO) {
        request.setAttribute(FUNC_ID_KEY, BreadcrumbInterceptor.FUNC_ID.Schedule_Job_View_Job);
        return "/eServices2/ScheduleJob/schedule-job-search";
    }

    @PostMapping(value = "/e-Services-2/maintenance/scheduleJobSearch_Result.do")
    public String scheduleJobResultPage(HttpServletRequest request, @ModelAttribute CreateScheduleJobDTO createScheduleJobDTO) {
        request.setAttribute(FUNC_ID_KEY, BreadcrumbInterceptor.FUNC_ID.Schedule_Job_View_Job);

        List<JobMaintenance> list = scheduleJobService.searchScheduleJobList(createScheduleJobDTO);
        if (list.size() > 0) {
            createScheduleJobDTO.setScheduleJobList(list);
        }
        return "/eServices2/ScheduleJob/schedule-job-result";
    }

    @GetMapping(value = "/e-Services-2/maintenance/scheduleJob_Create.do")
    public String scheduleJobCreatePage(HttpServletRequest request, @ModelAttribute CreateScheduleJobDTO createScheduleJobDTO) {
        request.setAttribute(FUNC_ID_KEY, BreadcrumbInterceptor.FUNC_ID.Schedule_Job_View_Job);

        return "/eServices2/ScheduleJob/schedule-job-create";
    }

    @PostMapping(value = "/e-Services-2/maintenance/scheduleJob_Success.do")
    public String scheduleJobCreateSuccessPage(HttpServletRequest request, @ModelAttribute CreateScheduleJobDTO createScheduleJobDTO) {
        request.setAttribute(FUNC_ID_KEY, BreadcrumbInterceptor.FUNC_ID.Schedule_Job_Create_Job);

        if (createScheduleJobDTO.getJobName() != null
                && createScheduleJobDTO.getJobClass() != null
                && createScheduleJobDTO.getCronExpression() != null
                && createScheduleJobDTO.getDataMap() != null
                && createScheduleJobDTO.getDescription() != null
                ) {
            Boolean isCreated = scheduleJobService.createScheduleJob(createScheduleJobDTO);
            if (!isCreated) {
                // create failure
            }
        }
        return "/eServices2/ScheduleJob/schedule-job-create-success";
    }

    @GetMapping(value = "/e-Services-2/maintenance/scheduleJob_Update.do")
    public String scheduleJobUpdatePage(HttpServletRequest request, @ModelAttribute CreateScheduleJobDTO createScheduleJobDTO) {
        request.setAttribute(FUNC_ID_KEY, BreadcrumbInterceptor.FUNC_ID.Schedule_Job_Create_Job);

        if (createScheduleJobDTO.getJobName() != null
                && createScheduleJobDTO.getJobClass() != null
                && createScheduleJobDTO.getCronExpression() != null
                && createScheduleJobDTO.getDataMap() != null
                && createScheduleJobDTO.getDescription() != null
                ) {

        }
        return "/eServices2/ScheduleJob/schedule-job-update";
    }
}
