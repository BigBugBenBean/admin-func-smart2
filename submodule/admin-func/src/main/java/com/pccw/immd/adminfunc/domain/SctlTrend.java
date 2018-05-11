package com.pccw.immd.adminfunc.domain;
// Generated May 9, 2018 4:40:02 PM by Hibernate Tools 5.0.6.Final


import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * SctlTrend generated by hbm2java
 */
@Entity
@Table(name="SCTL_TREND"
)
public class SctlTrend  implements java.io.Serializable {


     private SctlTrendId id;
     private BigDecimal gst;
     private BigDecimal mst;
     private BigDecimal gstUsage;
     private BigDecimal mstUsage;
     private BigDecimal clawback;
     private BigDecimal rclawback;

    public SctlTrend() {
    }

    public SctlTrend(SctlTrendId id, BigDecimal gst, BigDecimal mst, BigDecimal gstUsage, BigDecimal mstUsage, BigDecimal clawback, BigDecimal rclawback) {
       this.id = id;
       this.gst = gst;
       this.mst = mst;
       this.gstUsage = gstUsage;
       this.mstUsage = mstUsage;
       this.clawback = clawback;
       this.rclawback = rclawback;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="svcId", column=@Column(name="SVC_ID", nullable=false, length=50) ), 
        @AttributeOverride(name="lastUpdateDt", column=@Column(name="LAST_UPDATE_DT", nullable=false) ) } )
    public SctlTrendId getId() {
        return this.id;
    }
    
    public void setId(SctlTrendId id) {
        this.id = id;
    }

    
    @Column(name="GST", nullable=false, precision=22, scale=0)
    public BigDecimal getGst() {
        return this.gst;
    }
    
    public void setGst(BigDecimal gst) {
        this.gst = gst;
    }

    
    @Column(name="MST", nullable=false, precision=22, scale=0)
    public BigDecimal getMst() {
        return this.mst;
    }
    
    public void setMst(BigDecimal mst) {
        this.mst = mst;
    }

    
    @Column(name="GST_USAGE", nullable=false, precision=22, scale=0)
    public BigDecimal getGstUsage() {
        return this.gstUsage;
    }
    
    public void setGstUsage(BigDecimal gstUsage) {
        this.gstUsage = gstUsage;
    }

    
    @Column(name="MST_USAGE", nullable=false, precision=22, scale=0)
    public BigDecimal getMstUsage() {
        return this.mstUsage;
    }
    
    public void setMstUsage(BigDecimal mstUsage) {
        this.mstUsage = mstUsage;
    }

    
    @Column(name="CLAWBACK", nullable=false, precision=22, scale=0)
    public BigDecimal getClawback() {
        return this.clawback;
    }
    
    public void setClawback(BigDecimal clawback) {
        this.clawback = clawback;
    }

    
    @Column(name="RCLAWBACK", nullable=false, precision=22, scale=0)
    public BigDecimal getRclawback() {
        return this.rclawback;
    }
    
    public void setRclawback(BigDecimal rclawback) {
        this.rclawback = rclawback;
    }




}


