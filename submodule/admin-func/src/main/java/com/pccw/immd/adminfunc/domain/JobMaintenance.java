package com.pccw.immd.adminfunc.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="JOB_MAINTENANCE")
public class JobMaintenance {

    @Id
    @Column(name ="JOB_MAINTENANCE_ID", length=16)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="job_maintenance_id_seq")
    @SequenceGenerator(name="job_maintenance_id_seq", sequenceName="JOB_MAINTENANCE_ID_SEQ")
    private Long  jobMaintenanceId;

    @Column(name="ACTION", length=10)
    private String action;

    @Column(name ="JOB_NAME", length =200)
    private String jobName;

    @Column(name ="DESCRIPTION", length = 250)
    private String description;

    @Column(name="JOB_CLASS_NAME", length=250)
    private String jobClassName;

    @Column(name ="CRON_EXPRESSION", length = 120)
    private String cronExpression;

    @Column(name ="DATAMAP_JSON", length = 2000)
    private String dataMapJson;

    @Column(name="CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name="EXECUTE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date executeDate;

    public Long getJobMaintenanceId() {
        return jobMaintenanceId;
    }

    public void setJobMaintenanceId(Long jobMaintenanceId) {
        this.jobMaintenanceId = jobMaintenanceId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJobClassName() {
        return jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getDataMapJson() {
        return dataMapJson;
    }

    public void setDataMapJson(String dataMapJson) {
        this.dataMapJson = dataMapJson;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExecuteDate() {
        return executeDate;
    }

    public void setExecuteDate(Date executeDate) {
        this.executeDate = executeDate;
    }
}
