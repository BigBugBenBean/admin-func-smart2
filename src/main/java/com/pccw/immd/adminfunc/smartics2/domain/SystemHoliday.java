package com.pccw.immd.adminfunc.smartics2.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Dell on 29/1/2018.
 */
@Entity
@Table(name = "UM_SYSTEM_HOLIDAY")
public class SystemHoliday {

    @Id
    @Column(name = "HOLIDAY_DATE")
    private Date holidayDate;

    public Date getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(Date holidayDate) {
        this.holidayDate = holidayDate;
    }
}
