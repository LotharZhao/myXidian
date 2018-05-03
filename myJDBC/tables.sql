--------------------------------------------------------
--  �ļ��Ѵ��� - ���ڶ�-����-07-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table NEWS
--------------------------------------------------------

  CREATE TABLE "SCOTT"."NEWS" 
   (	"NEWSID" NUMBER, 
	"NEWSTITLE" VARCHAR2(128 BYTE), 
	"NEWSDATE" DATE DEFAULT sysdate, 
	"NEWSCONTENT" VARCHAR2(4000 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USER1
--------------------------------------------------------

  CREATE TABLE "SCOTT"."USER1" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(30 BYTE), 
	"PWD" VARCHAR2(50 BYTE), 
	"EMAIL" VARCHAR2(100 BYTE), 
	"BIRTHDAY" DATE, 
	"AGE" NUMBER(3,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "SCOTT"."USERS" 
   (	"USERID" NUMBER, 
	"PWD" VARCHAR2(128 BYTE) DEFAULT 123456, 
	"GRADE" NUMBER DEFAULT 1
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into SCOTT.NEWS
SET DEFINE OFF;
Insert into SCOTT.NEWS (NEWSID,NEWSTITLE,NEWSDATE,NEWSCONTENT) values (1,'΢�������֧Ԯ���ֵ���',to_date('09-6�� -08','DD-MON-RR'),'΢����������������ƻ�����޹����ṩ�����������Լ��ٸõ��������ֻ����̡���Ϥ��΢���Ѿ������ױ������������Э�飬������������ù�13��ѧУ�ṩ�ӷ��������̭�Ķ��ֵ��ԣ���Щ���Խ�����Windowsϵͳ�����Ե�¼Google���Ż���������վ������΢��û��͸¶����Windowsϵͳ����ЩѧУ�ļ۸�');
Insert into SCOTT.NEWS (NEWSID,NEWSTITLE,NEWSDATE,NEWSCONTENT) values (2,'����ʧ���ֻ����������й�',to_date('09-6�� -09','DD-MON-RR'),'�ݺ�����Ϣ���ṩ����Ϣ�ƣ�Ŀǰ�Ѿ������й������ں�����ÿ��400��500Ԫ(�����)�ļ۸��չ�������ʧ���м�1��2��Ԫ(�����)���ֻ���Ȼ�������˽���й�����ÿ��3000Ԫ���µļ۸���ۡ�');
Insert into SCOTT.NEWS (NEWSID,NEWSTITLE,NEWSDATE,NEWSCONTENT) values (3,'���������չ��������ֻ�',to_date('07-6�� -09','DD-MON-RR'),'����7��������ʽ���������չ��¹��������ֻ���ҵ�����𲢹���ʹBenQ��Ϊȫ����Ĵ��ֻ�Ʒ�ơ����л�����һ���ֻ��Ƽ���˾���ϲ���˾��Ӫ�ս�����100����Ԫ��');
Insert into SCOTT.NEWS (NEWSID,NEWSTITLE,NEWSDATE,NEWSCONTENT) values (4,'Google�ɼ����',to_date('03-6�� -09','DD-MON-RR'),'�ֽ��Google�Ѿ���Ϊ�����ֵĳ�������к��ǰ���������Google��ҵ���������˷���ʦ��Ԥ�ڡ���Ҫ���������Ż���΢���ڹ��ս�д����Ǯ����Googleȴ�����������������ǵĿڿ��ഫ���������������г�������λ�á����ͬʱ��Google�Ĺɼ�Ҳһ·�����Ŀǰ�ѽϷ��м�����226%���ﵽ227��Ԫ��');
Insert into SCOTT.NEWS (NEWSID,NEWSTITLE,NEWSDATE,NEWSCONTENT) values (5,'�й��⽻����Ӧ�����ʷ�������',to_date('06-3�� -17','DD-MON-RR'),'����б����Ƴ��ʽ��죨6�գ���ƽ������������һ�����ʰ뵺���������䲻��������й��⽻�������˹�ˬ�ڽ��죨6�գ������м��߻���������Ӧ��');
REM INSERTING into SCOTT.USER1
SET DEFINE OFF;
Insert into SCOTT.USER1 (ID,NAME,PWD,EMAIL,BIRTHDAY,AGE) values (3,'zhao','123','zhao@163.com',to_date('03-3�� -17','DD-MON-RR'),30);
Insert into SCOTT.USER1 (ID,NAME,PWD,EMAIL,BIRTHDAY,AGE) values (4,'zhao','123','zhao@163.com',to_date('06-3�� -17','DD-MON-RR'),30);
Insert into SCOTT.USER1 (ID,NAME,PWD,EMAIL,BIRTHDAY,AGE) values (5,'С��','111','xiao@1.com',to_date('06-3�� -17','DD-MON-RR'),20);
Insert into SCOTT.USER1 (ID,NAME,PWD,EMAIL,BIRTHDAY,AGE) values (6,'С��','111','xiao@1.com',to_date('06-3�� -17','DD-MON-RR'),20);
Insert into SCOTT.USER1 (ID,NAME,PWD,EMAIL,BIRTHDAY,AGE) values (7,'С��','111','xiao@1.com',to_date('06-3�� -17','DD-MON-RR'),20);
Insert into SCOTT.USER1 (ID,NAME,PWD,EMAIL,BIRTHDAY,AGE) values (8,'aaa','111','xiao@1.com',to_date('06-3�� -17','DD-MON-RR'),20);
Insert into SCOTT.USER1 (ID,NAME,PWD,EMAIL,BIRTHDAY,AGE) values (9,'С��','111','xiao@1.com',to_date('06-3�� -17','DD-MON-RR'),20);
Insert into SCOTT.USER1 (ID,NAME,PWD,EMAIL,BIRTHDAY,AGE) values (10,'С��','111','xiao@1.com',to_date('06-3�� -17','DD-MON-RR'),20);
Insert into SCOTT.USER1 (ID,NAME,PWD,EMAIL,BIRTHDAY,AGE) values (11,'С��','111','xiao@1.com',to_date('06-3�� -17','DD-MON-RR'),20);
Insert into SCOTT.USER1 (ID,NAME,PWD,EMAIL,BIRTHDAY,AGE) values (12,'С��','111','xiao@1.com',to_date('06-3�� -17','DD-MON-RR'),20);
Insert into SCOTT.USER1 (ID,NAME,PWD,EMAIL,BIRTHDAY,AGE) values (77,'sql',null,null,null,null);
REM INSERTING into SCOTT.USERS
SET DEFINE OFF;
Insert into SCOTT.USERS (USERID,PWD,GRADE) values (10000,'10000',1);
Insert into SCOTT.USERS (USERID,PWD,GRADE) values (20000,'20000',2);
--------------------------------------------------------
--  DDL for Index NEWS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."NEWS_PK" ON "SCOTT"."NEWS" ("NEWSID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index USER1_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."USER1_PK" ON "SCOTT"."USER1" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index USERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."USERS_PK" ON "SCOTT"."USERS" ("USERID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table NEWS
--------------------------------------------------------

  ALTER TABLE "SCOTT"."NEWS" ADD CONSTRAINT "NEWS_PK" PRIMARY KEY ("NEWSID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "SCOTT"."NEWS" MODIFY ("NEWSID" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."NEWS" MODIFY ("NEWSTITLE" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."NEWS" MODIFY ("NEWSDATE" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."NEWS" MODIFY ("NEWSCONTENT" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USER1
--------------------------------------------------------

  ALTER TABLE "SCOTT"."USER1" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."USER1" ADD CONSTRAINT "USER1_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "SCOTT"."USERS" MODIFY ("USERID" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."USERS" MODIFY ("PWD" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."USERS" MODIFY ("GRADE" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."USERS" ADD CONSTRAINT "USERS_PK" PRIMARY KEY ("USERID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
