package com.pccw.immd.adminfunc.domain;
// Generated May 9, 2018 4:40:02 PM by Hibernate Tools 5.0.6.Final


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SctlSvcCfg generated by hbm2java
 */
@Entity
@Table(name="SCTL_SVC_CFG"
)
public class SctlSvcCfg  implements java.io.Serializable {


     private String svcId;
     private BigDecimal gstAssigned;
     private BigDecimal mstAssigned;
     private BigDecimal priority;
     private String clawback;
     private Date lastAllotedDt;
     private Date lastReleaseDt;
     private BigDecimal usedTicket;
     private String svcDesc;
     private String enable;
     private String enableAudit;
     private String successUrl;
     private String busyUrl;
     private String errorUrl;
     private String suspendUrl;
     private Set<SctlSvcTicket> sctlSvcTickets = new HashSet<SctlSvcTicket>(0);

    public SctlSvcCfg() {
    }

	
    public SctlSvcCfg(String svcId, BigDecimal priority, BigDecimal usedTicket) {
        this.svcId = svcId;
        this.priority = priority;
        this.usedTicket = usedTicket;
    }
    public SctlSvcCfg(String svcId, BigDecimal gstAssigned, BigDecimal mstAssigned, BigDecimal priority, String clawback, Date lastAllotedDt, Date lastReleaseDt, BigDecimal usedTicket, String svcDesc, String enable, String enableAudit, String successUrl, String busyUrl, String errorUrl, String suspendUrl, Set<SctlSvcTicket> sctlSvcTickets) {
       this.svcId = svcId;
       this.gstAssigned = gstAssigned;
       this.mstAssigned = mstAssigned;
       this.priority = priority;
       this.clawback = clawback;
       this.lastAllotedDt = lastAllotedDt;
       this.lastReleaseDt = lastReleaseDt;
       this.usedTicket = usedTicket;
       this.svcDesc = svcDesc;
       this.enable = enable;
       this.enableAudit = enableAudit;
       this.successUrl = successUrl;
       this.busyUrl = busyUrl;
       this.errorUrl = errorUrl;
       this.suspendUrl = suspendUrl;
       this.sctlSvcTickets = sctlSvcTickets;
    }
   
     @Id 

    
    @Column(name="SVC_ID", unique=true, nullable=false, length=50)
    public String getSvcId() {
        return this.svcId;
    }
    
    public void setSvcId(String svcId) {
        this.svcId = svcId;
    }

    
    @Column(name="GST_ASSIGNED", precision=22, scale=0)
    public BigDecimal getGstAssigned() {
        return this.gstAssigned;
    }
    
    public void setGstAssigned(BigDecimal gstAssigned) {
        this.gstAssigned = gstAssigned;
    }

    
    @Column(name="MST_ASSIGNED", precision=22, scale=0)
    public BigDecimal getMstAssigned() {
        return this.mstAssigned;
    }
    
    public void setMstAssigned(BigDecimal mstAssigned) {
        this.mstAssigned = mstAssigned;
    }

    
    @Column(name="PRIORITY", nullable=false, precision=22, scale=0)
    public BigDecimal getPriority() {
        return this.priority;
    }
    
    public void setPriority(BigDecimal priority) {
        this.priority = priority;
    }

    
    @Column(name="CLAWBACK", length=1)
    public String getClawback() {
        return this.clawback;
    }
    
    public void setClawback(String clawback) {
        this.clawback = clawback;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LAST_ALLOTED_DT")
    public Date getLastAllotedDt() {
        return this.lastAllotedDt;
    }
    
    public void setLastAllotedDt(Date lastAllotedDt) {
        this.lastAllotedDt = lastAllotedDt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LAST_RELEASE_DT")
    public Date getLastReleaseDt() {
        return this.lastReleaseDt;
    }
    
    public void setLastReleaseDt(Date lastReleaseDt) {
        this.lastReleaseDt = lastReleaseDt;
    }

    
    @Column(name="USED_TICKET", nullable=false, precision=22, scale=0)
    public BigDecimal getUsedTicket() {
        return this.usedTicket;
    }
    
    public void setUsedTicket(BigDecimal usedTicket) {
        this.usedTicket = usedTicket;
    }

    
    @Column(name="SVC_DESC")
    public String getSvcDesc() {
        return this.svcDesc;
    }
    
    public void setSvcDesc(String svcDesc) {
        this.svcDesc = svcDesc;
    }

    
    @Column(name="ENABLE", length=1)
    public String getEnable() {
        return this.enable;
    }
    
    public void setEnable(String enable) {
        this.enable = enable;
    }

    
    @Column(name="ENABLE_AUDIT", length=1)
    public String getEnableAudit() {
        return this.enableAudit;
    }
    
    public void setEnableAudit(String enableAudit) {
        this.enableAudit = enableAudit;
    }

    
    @Column(name="SUCCESS_URL")
    public String getSuccessUrl() {
        return this.successUrl;
    }
    
    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    
    @Column(name="BUSY_URL")
    public String getBusyUrl() {
        return this.busyUrl;
    }
    
    public void setBusyUrl(String busyUrl) {
        this.busyUrl = busyUrl;
    }

    
    @Column(name="ERROR_URL")
    public String getErrorUrl() {
        return this.errorUrl;
    }
    
    public void setErrorUrl(String errorUrl) {
        this.errorUrl = errorUrl;
    }

    
    @Column(name="SUSPEND_URL")
    public String getSuspendUrl() {
        return this.suspendUrl;
    }
    
    public void setSuspendUrl(String suspendUrl) {
        this.suspendUrl = suspendUrl;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="sctlSvcCfg")
    public Set<SctlSvcTicket> getSctlSvcTickets() {
        return this.sctlSvcTickets;
    }
    
    public void setSctlSvcTickets(Set<SctlSvcTicket> sctlSvcTickets) {
        this.sctlSvcTickets = sctlSvcTickets;
    }




}

