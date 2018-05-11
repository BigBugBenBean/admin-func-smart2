create table UM_SYSTEM_HOLIDAY (
    HOLIDAY_DATE timestamp not null,
    primary key (HOLIDAY_DATE)
);

Insert into UM_SYSTEM_HOLIDAY (HOLIDAY_DATE) values (to_date('25-DEC-17','DD-MON-RR'));
Insert into UM_SYSTEM_HOLIDAY (HOLIDAY_DATE) values (to_date('26-DEC-17','DD-MON-RR'));