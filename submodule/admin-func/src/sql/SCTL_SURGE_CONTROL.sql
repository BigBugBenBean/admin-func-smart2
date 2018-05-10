--------------------------------------------------------
--  Remove Surge control related tables, constraint and index.
--------------------------------------------------------
drop table SCTL_AUDIT cascade constraints PURGE;
drop table SCTL_SHARE_POOL cascade constraints PURGE;
drop table SCTL_svc_cfg cascade constraints PURGE;
drop table SCTL_svc_ticket cascade constraints PURGE;
drop table SCTL_trend cascade constraints PURGE;
--------------------------------------------------------


--------------------------------------------------------
--  File created - Tuesday-May-08-2018
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table SCTL_AUDIT
--------------------------------------------------------

  CREATE TABLE "SCTL_AUDIT"
   (	"AUDIT_ID" NUMBER(*,0),
	"TICKET_ID" VARCHAR2(50 BYTE),
	"ALLOTED_DT" TIMESTAMP (6),
	"RELEASE_DT" TIMESTAMP (6),
	"LAST_UPDATE_DT" TIMESTAMP (6),
	"SVC_ID" VARCHAR2(50 BYTE)
   ) ;

   COMMENT ON COLUMN "SCTL_AUDIT"."AUDIT_ID" IS 'The unique ID for this audit record';
   COMMENT ON COLUMN "SCTL_AUDIT"."TICKET_ID" IS 'The Ticket ID';
   COMMENT ON COLUMN "SCTL_AUDIT"."ALLOTED_DT" IS 'The timestamp that allotment happen.';
   COMMENT ON COLUMN "SCTL_AUDIT"."RELEASE_DT" IS 'The timestamp that release happen.';
   COMMENT ON COLUMN "SCTL_AUDIT"."LAST_UPDATE_DT" IS 'The timestamp that last update this record.';
   COMMENT ON COLUMN "SCTL_AUDIT"."SVC_ID" IS 'The service ID assigned to this ticket.';
   COMMENT ON TABLE "SCTL_AUDIT"  IS 'Audit the lifttime of each unique ticket id. The Audit can be turn on / off by application.';
--------------------------------------------------------
--  DDL for Table SCTL_SHARE_POOL
--------------------------------------------------------

  CREATE TABLE "SCTL_SHARE_POOL"
   (	"POOL_ID" NUMBER(*,0),
	"LAST_ALLOTED_DT" TIMESTAMP (6),
	"LAST_RELEASE_DT" TIMESTAMP (6),
	"USAGE_COUNT" NUMBER(*,0),
	"ASSIGNED_COUNT" NUMBER(*,0)
   ) ;

   COMMENT ON COLUMN "SCTL_SHARE_POOL"."POOL_ID" IS 'Pool ID represents the Share Ticket Pool. -1 is reserved.';
   COMMENT ON COLUMN "SCTL_SHARE_POOL"."LAST_ALLOTED_DT" IS 'The timestamp that last allotment happen.';
   COMMENT ON COLUMN "SCTL_SHARE_POOL"."LAST_RELEASE_DT" IS 'The timestamp that last release happen.';
   COMMENT ON COLUMN "SCTL_SHARE_POOL"."USAGE_COUNT" IS 'No. of Tickets in pool has been alloted.';
   COMMENT ON COLUMN "SCTL_SHARE_POOL"."ASSIGNED_COUNT" IS 'Total tickets in pool.';
   COMMENT ON TABLE "SCTL_SHARE_POOL"  IS 'Pool ID (-1) is reserved for sum of all usable tickets.';
--------------------------------------------------------
--  DDL for Table SCTL_SVC_CFG
--------------------------------------------------------

  CREATE TABLE "SCTL_SVC_CFG"
   (	"SVC_ID" VARCHAR2(50 BYTE),
	"GST_ASSIGNED" NUMBER(*,0),
	"MST_ASSIGNED" NUMBER(*,0),
	"PRIORITY" NUMBER(*,0),
	"CLAWBACK" VARCHAR2(1 BYTE),
	"LAST_ALLOTED_DT" TIMESTAMP (6),
	"LAST_RELEASE_DT" TIMESTAMP (6),
	"USED_TICKET" NUMBER(*,0) DEFAULT 0,
	"SVC_DESC" VARCHAR2(255 BYTE),
	"ENABLE" VARCHAR2(1 BYTE),
	"ENABLE_AUDIT" VARCHAR2(1 BYTE),
	"SUCCESS_URL" VARCHAR2(255 BYTE),
	"BUSY_URL" VARCHAR2(255 BYTE),
	"ERROR_URL" VARCHAR2(255 BYTE),
	"SUSPEND_URL" VARCHAR2(255 BYTE)
   ) ;

   COMMENT ON COLUMN "SCTL_SVC_CFG"."SVC_ID" IS 'Service ID uniquely identity an application on surge control.';
   COMMENT ON COLUMN "SCTL_SVC_CFG"."GST_ASSIGNED" IS 'Guarantee number of tickets.
';
   COMMENT ON COLUMN "SCTL_SVC_CFG"."MST_ASSIGNED" IS 'Maximum number of tickets. (MST >= GST)';
   COMMENT ON COLUMN "SCTL_SVC_CFG"."PRIORITY" IS 'Applications with lower priority will be clawed back first.';
   COMMENT ON COLUMN "SCTL_SVC_CFG"."CLAWBACK" IS 'Retrieve alloted tickets by other apps with higher priority';
   COMMENT ON COLUMN "SCTL_SVC_CFG"."LAST_ALLOTED_DT" IS 'The timestamp that last allotment happen.';
   COMMENT ON COLUMN "SCTL_SVC_CFG"."LAST_RELEASE_DT" IS 'The timestamp that last release happen.';
   COMMENT ON COLUMN "SCTL_SVC_CFG"."USED_TICKET" IS 'Sum of tickets (GST + MST) in use.';
   COMMENT ON COLUMN "SCTL_SVC_CFG"."SVC_DESC" IS 'Entry description';
   COMMENT ON COLUMN "SCTL_SVC_CFG"."ENABLE" IS 'Is the application in use?';
   COMMENT ON COLUMN "SCTL_SVC_CFG"."ENABLE_AUDIT" IS 'Is audit enable for this application';
   COMMENT ON COLUMN "SCTL_SVC_CFG"."SUCCESS_URL" IS 'If ticket can be granted, this URL is redirected.';
   COMMENT ON COLUMN "SCTL_SVC_CFG"."BUSY_URL" IS 'If no ticket is available, this URL is redirected.';
   COMMENT ON COLUMN "SCTL_SVC_CFG"."ERROR_URL" IS 'If error found during allocation, this URL is redirected.';
   COMMENT ON COLUMN "SCTL_SVC_CFG"."SUSPEND_URL" IS 'If the service is suspended, this URL is redirected.';
--------------------------------------------------------
--  DDL for Table SCTL_SVC_TICKET
--------------------------------------------------------

  CREATE TABLE "SCTL_SVC_TICKET"
   (	"TICKET_ID" VARCHAR2(20 BYTE),
	"SVC_ID" VARCHAR2(3 BYTE),
	"ALLOTED_DT" TIMESTAMP (6),
	"IS_CLAWBACK" VARCHAR2(1 BYTE),
	"CLAWBACK_SVC_ID" VARCHAR2(3 BYTE)
   ) ;

   COMMENT ON COLUMN "SCTL_SVC_TICKET"."TICKET_ID" IS 'The unique Ticket ID';
   COMMENT ON COLUMN "SCTL_SVC_TICKET"."SVC_ID" IS 'The owner of this ticket';
   COMMENT ON COLUMN "SCTL_SVC_TICKET"."ALLOTED_DT" IS 'The timestamp that allotment happen.';
   COMMENT ON COLUMN "SCTL_SVC_TICKET"."IS_CLAWBACK" IS 'This ticket is a clawback ticket';
   COMMENT ON COLUMN "SCTL_SVC_TICKET"."CLAWBACK_SVC_ID" IS 'Application ID that being clawback';
--------------------------------------------------------
--  DDL for Table SCTL_TREND
--------------------------------------------------------

  CREATE TABLE "SCTL_TREND"
   (	"SVC_ID" VARCHAR2(50 BYTE),
	"LAST_UPDATE_DT" TIMESTAMP (6),
	"GST" NUMBER(*,0),
	"MST" NUMBER(*,0),
	"GST_USAGE" NUMBER(*,0),
	"MST_USAGE" NUMBER(*,0),
	"CLAWBACK" NUMBER(*,0),
	"RCLAWBACK" NUMBER(*,0)
   ) ;

   COMMENT ON COLUMN "SCTL_TREND"."SVC_ID" IS 'Application ID';
   COMMENT ON COLUMN "SCTL_TREND"."LAST_UPDATE_DT" IS 'Last update timestamp';
   COMMENT ON COLUMN "SCTL_TREND"."GST" IS 'GST allocated at this moment';
   COMMENT ON COLUMN "SCTL_TREND"."MST" IS 'MST allocated at this moment';
   COMMENT ON COLUMN "SCTL_TREND"."GST_USAGE" IS 'Current usage of GST';
   COMMENT ON COLUMN "SCTL_TREND"."MST_USAGE" IS 'Current usage of MST';
   COMMENT ON COLUMN "SCTL_TREND"."CLAWBACK" IS 'The count that this application is being clawback.';
   COMMENT ON COLUMN "SCTL_TREND"."RCLAWBACK" IS 'The count that this application request clawback.';
REM INSERTING into SCTL_AUDIT
SET DEFINE OFF;
REM INSERTING into SCTL_SHARE_POOL
SET DEFINE OFF;
REM INSERTING into SCTL_SVC_CFG
SET DEFINE OFF;
Insert into SCTL_SVC_CFG (SVC_ID,GST_ASSIGNED,MST_ASSIGNED,PRIORITY,CLAWBACK,LAST_ALLOTED_DT,LAST_RELEASE_DT,USED_TICKET,SVC_DESC,ENABLE,ENABLE_AUDIT,SUCCESS_URL,BUSY_URL,ERROR_URL,SUSPEND_URL) values ('505',0,2,2,'Y',null,null,0,'TD booking','Y','Y','https://webapp1.es2t.immd.gov.hk/smartics2-client/tdbooking
','https://eservices1.es2t.immd.gov.hk/surgecontrol/gate/html/new_no_ticket.html','https://eservices1.es2t.immd.gov.hk/surgecontrol/gate/htmll/new_invalid_ticket.html','https:/eservices1.es2t.immd.gov.hk/surgecontrol/gate/html/maintenance.html');
Insert into SCTL_SVC_CFG (SVC_ID,GST_ASSIGNED,MST_ASSIGNED,PRIORITY,CLAWBACK,LAST_ALLOTED_DT,LAST_RELEASE_DT,USED_TICKET,SVC_DESC,ENABLE,ENABLE_AUDIT,SUCCESS_URL,BUSY_URL,ERROR_URL,SUSPEND_URL) values ('579',1,3,1,'Y',null,null,0,'ROP booking','Y','Y','https://webapp1.es2t.immd.gov.hk/smartics2-client/ropbooking','https://eservices1.es2t.immd.gov.hk/surgecontrol/gate/html/new_no_ticket.html','https://eservices1.es2t.immd.gov.hk/surgecontrol/gate/htmll/new_invalid_ticket.html','https:/eservices1.es2t.immd.gov.hk/surgecontrol/gate/html/maintenance.html');
REM INSERTING into SCTL_SVC_TICKET
SET DEFINE OFF;
REM INSERTING into SCTL_TREND
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index SCTL_AUDIT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCTL_AUDIT_PK" ON "SCTL_AUDIT" ("AUDIT_ID", "RELEASE_DT")
  ;
--------------------------------------------------------
--  DDL for Index SCTL_SHARE_POOL_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCTL_SHARE_POOL_PK" ON "SCTL_SHARE_POOL" ("POOL_ID")
  ;
--------------------------------------------------------
--  DDL for Index SCTL_APP_CFG_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCTL_APP_CFG_PK" ON "SCTL_SVC_CFG" ("SVC_ID")
  ;
--------------------------------------------------------
--  DDL for Index SCTL_SVC_TICKET_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCTL_SVC_TICKET_PK" ON "SCTL_SVC_TICKET" ("TICKET_ID", "SVC_ID")
  ;
--------------------------------------------------------
--  DDL for Index SCTL_TREND_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCTL_TREND_PK" ON "SCTL_TREND" ("SVC_ID", "LAST_UPDATE_DT")
  ;
--------------------------------------------------------
--  Constraints for Table SCTL_AUDIT
--------------------------------------------------------

  ALTER TABLE "SCTL_AUDIT" MODIFY ("AUDIT_ID" NOT NULL ENABLE);
  ALTER TABLE "SCTL_AUDIT" MODIFY ("ALLOTED_DT" NOT NULL ENABLE);
  ALTER TABLE "SCTL_AUDIT" MODIFY ("SVC_ID" NOT NULL ENABLE);
  ALTER TABLE "SCTL_AUDIT" MODIFY ("RELEASE_DT" NOT NULL ENABLE);
  ALTER TABLE "SCTL_AUDIT" MODIFY ("TICKET_ID" NOT NULL ENABLE);
  ALTER TABLE "SCTL_AUDIT" ADD CONSTRAINT "SCTL_AUDIT_PK" PRIMARY KEY ("AUDIT_ID", "RELEASE_DT")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table SCTL_SHARE_POOL
--------------------------------------------------------

  ALTER TABLE "SCTL_SHARE_POOL" MODIFY ("POOL_ID" NOT NULL ENABLE);
  ALTER TABLE "SCTL_SHARE_POOL" ADD CONSTRAINT "SCTL_SHARE_POOL_PK" PRIMARY KEY ("POOL_ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table SCTL_SVC_CFG
--------------------------------------------------------

  ALTER TABLE "SCTL_SVC_CFG" MODIFY ("SVC_ID" NOT NULL ENABLE);
  ALTER TABLE "SCTL_SVC_CFG" MODIFY ("PRIORITY" NOT NULL ENABLE);
  ALTER TABLE "SCTL_SVC_CFG" MODIFY ("USED_TICKET" NOT NULL ENABLE);
  ALTER TABLE "SCTL_SVC_CFG" ADD CONSTRAINT "SCTL_APP_CFG_PK" PRIMARY KEY ("SVC_ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table SCTL_SVC_TICKET
--------------------------------------------------------

  ALTER TABLE "SCTL_SVC_TICKET" MODIFY ("TICKET_ID" NOT NULL ENABLE);
  ALTER TABLE "SCTL_SVC_TICKET" MODIFY ("SVC_ID" NOT NULL ENABLE);
  ALTER TABLE "SCTL_SVC_TICKET" ADD CONSTRAINT "SCTL_SVC_TICKET_PK" PRIMARY KEY ("TICKET_ID", "SVC_ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table SCTL_TREND
--------------------------------------------------------

  ALTER TABLE "SCTL_TREND" MODIFY ("SVC_ID" NOT NULL ENABLE);
  ALTER TABLE "SCTL_TREND" MODIFY ("LAST_UPDATE_DT" NOT NULL ENABLE);
  ALTER TABLE "SCTL_TREND" MODIFY ("GST" NOT NULL ENABLE);
  ALTER TABLE "SCTL_TREND" MODIFY ("MST" NOT NULL ENABLE);
  ALTER TABLE "SCTL_TREND" MODIFY ("GST_USAGE" NOT NULL ENABLE);
  ALTER TABLE "SCTL_TREND" MODIFY ("MST_USAGE" NOT NULL ENABLE);
  ALTER TABLE "SCTL_TREND" MODIFY ("CLAWBACK" NOT NULL ENABLE);
  ALTER TABLE "SCTL_TREND" MODIFY ("RCLAWBACK" NOT NULL ENABLE);
  ALTER TABLE "SCTL_TREND" ADD CONSTRAINT "SCTL_TREND_PK" PRIMARY KEY ("SVC_ID", "LAST_UPDATE_DT")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SCTL_SVC_TICKET
--------------------------------------------------------

  ALTER TABLE "SCTL_SVC_TICKET" ADD CONSTRAINT "SCTL_SVC_TICKET_FK" FOREIGN KEY ("SVC_ID")
	  REFERENCES "SCTL_SVC_CFG" ("SVC_ID") ENABLE;
