package com.pccw.immd.adminfunc.domain;
// Generated May 9, 2018 4:40:02 PM by Hibernate Tools 5.0.6.Final


import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SctlSvcTicket generated by hbm2java
 */
@Entity
@Table(name="SCTL_SVC_TICKET"
)
public class SctlSvcTicket  implements java.io.Serializable {


     private SctlSvcTicketId id;
     private SctlSvcCfg sctlSvcCfg;
     private Date allotedDt;
     private String isClawback;
     private String clawbackSvcId;

    public SctlSvcTicket() {
    }

	
    public SctlSvcTicket(SctlSvcTicketId id, SctlSvcCfg sctlSvcCfg) {
        this.id = id;
        this.sctlSvcCfg = sctlSvcCfg;
    }
    public SctlSvcTicket(SctlSvcTicketId id, SctlSvcCfg sctlSvcCfg, Date allotedDt, String isClawback, String clawbackSvcId) {
       this.id = id;
       this.sctlSvcCfg = sctlSvcCfg;
       this.allotedDt = allotedDt;
       this.isClawback = isClawback;
       this.clawbackSvcId = clawbackSvcId;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="ticketId", column=@Column(name="TICKET_ID", nullable=false, length=20) ), 
        @AttributeOverride(name="svcId", column=@Column(name="SVC_ID", nullable=false, length=3) ) } )
    public SctlSvcTicketId getId() {
        return this.id;
    }
    
    public void setId(SctlSvcTicketId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="SVC_ID", nullable=false, insertable=false, updatable=false)
    public SctlSvcCfg getSctlSvcCfg() {
        return this.sctlSvcCfg;
    }
    
    public void setSctlSvcCfg(SctlSvcCfg sctlSvcCfg) {
        this.sctlSvcCfg = sctlSvcCfg;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ALLOTED_DT")
    public Date getAllotedDt() {
        return this.allotedDt;
    }
    
    public void setAllotedDt(Date allotedDt) {
        this.allotedDt = allotedDt;
    }

    
    @Column(name="IS_CLAWBACK", length=1)
    public String getIsClawback() {
        return this.isClawback;
    }
    
    public void setIsClawback(String isClawback) {
        this.isClawback = isClawback;
    }

    
    @Column(name="CLAWBACK_SVC_ID", length=3)
    public String getClawbackSvcId() {
        return this.clawbackSvcId;
    }
    
    public void setClawbackSvcId(String clawbackSvcId) {
        this.clawbackSvcId = clawbackSvcId;
    }




}


