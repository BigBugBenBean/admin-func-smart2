package com.pccw.immd.adminfunc.domain;
// Generated May 9, 2018 4:40:02 PM by Hibernate Tools 5.0.6.Final


import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SctlAudit generated by hbm2java
 */
@Entity
@Table(name="SCTL_AUDIT"
)
public class SctlAudit  implements java.io.Serializable {


     private SctlAuditId id;
     private String ticketId;
     private Date allotedDt;
     private Date lastUpdateDt;
     private String svcId;

    public SctlAudit() {
    }

	
    public SctlAudit(SctlAuditId id, String ticketId, Date allotedDt, String svcId) {
        this.id = id;
        this.ticketId = ticketId;
        this.allotedDt = allotedDt;
        this.svcId = svcId;
    }
    public SctlAudit(SctlAuditId id, String ticketId, Date allotedDt, Date lastUpdateDt, String svcId) {
       this.id = id;
       this.ticketId = ticketId;
       this.allotedDt = allotedDt;
       this.lastUpdateDt = lastUpdateDt;
       this.svcId = svcId;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="auditId", column=@Column(name="AUDIT_ID", nullable=false, precision=22, scale=0) ), 
        @AttributeOverride(name="releaseDt", column=@Column(name="RELEASE_DT", nullable=false) ) } )
    public SctlAuditId getId() {
        return this.id;
    }
    
    public void setId(SctlAuditId id) {
        this.id = id;
    }

    
    @Column(name="TICKET_ID", nullable=false, length=50)
    public String getTicketId() {
        return this.ticketId;
    }
    
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ALLOTED_DT", nullable=false)
    public Date getAllotedDt() {
        return this.allotedDt;
    }
    
    public void setAllotedDt(Date allotedDt) {
        this.allotedDt = allotedDt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LAST_UPDATE_DT")
    public Date getLastUpdateDt() {
        return this.lastUpdateDt;
    }
    
    public void setLastUpdateDt(Date lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    
    @Column(name="SVC_ID", nullable=false, length=50)
    public String getSvcId() {
        return this.svcId;
    }
    
    public void setSvcId(String svcId) {
        this.svcId = svcId;
    }




}


