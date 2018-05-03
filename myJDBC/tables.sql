--------------------------------------------------------
--  文件已创建 - 星期二-三月-07-2017   
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
Insert into SCOTT.NEWS (NEWSID,NEWSTITLE,NEWSDATE,NEWSCONTENT) values (1,'微软向非洲支援二手电脑',to_date('09-6月 -08','DD-MON-RR'),'微软在最近宣布它正计划向非洲国家提供技术帮助，以加速该地区的数字化进程。据悉，微软已经与纳米比亚政府达成了协议，将在两年内向该国13所学校提供从发达国家淘汰的二手电脑，这些电脑将运行Windows系统，可以登录Google、雅虎等热门网站，不过微软并没有透露出售Windows系统给这些学校的价格。');
Insert into SCOTT.NEWS (NEWSID,NEWSTITLE,NEWSDATE,NEWSCONTENT) values (2,'韩国失窃手机大量流入中国',to_date('09-6月 -09','DD-MON-RR'),'据韩国信息部提供的消息称，目前已经发现中国商人在韩国以每部400—500元(人民币)的价格收购被盗或丢失的市价1—2万元(人民币)的手机，然后成批走私到中国，以每部3000元以下的价格出售。');
Insert into SCOTT.NEWS (NEWSID,NEWSTITLE,NEWSDATE,NEWSCONTENT) values (3,'明基宣布收购西门子手机',to_date('07-6月 -09','DD-MON-RR'),'明基7日下午正式对外宣布收购德国西门子手机事业，这起并购将使BenQ成为全球第四大手机品牌、大中华区第一大手机科技公司，合并后公司年营收将超过100亿美元。');
Insert into SCOTT.NEWS (NEWSID,NEWSTITLE,NEWSDATE,NEWSCONTENT) values (4,'Google股价飙升',to_date('03-6月 -09','DD-MON-RR'),'现今的Google已经成为华尔街的宠儿。上市后的前三个季度里，Google的业绩均超过了分析师的预期。主要竞争对手雅虎和微软都在广告战中大把烧钱，而Google却毫不费力的依靠人们的口口相传继续保持着搜索市场的领先位置。与此同时，Google的股价也一路飙升，目前已较发行价上涨226%，达到227美元。');
Insert into SCOTT.NEWS (NEWSID,NEWSTITLE,NEWSDATE,NEWSCONTENT) values (5,'中国外交部回应“朝鲜发射飞行物”',to_date('06-3月 -17','DD-MON-RR'),'针对有报道称朝鲜今天（6日）在平安北道东仓里一带向朝鲜半岛东部海域发射不明飞行物，中国外交部发言人耿爽在今天（6日）的例行记者会上作出回应。');
REM INSERTING into SCOTT.USER1
SET DEFINE OFF;
Insert into SCOTT.USER1 (ID,NAME,PWD,EMAIL,BIRTHDAY,AGE) values (3,'zhao','123','zhao@163.com',to_date('03-3月 -17','DD-MON-RR'),30);
Insert into SCOTT.USER1 (ID,NAME,PWD,EMAIL,BIRTHDAY,AGE) values (4,'zhao','123','zhao@163.com',to_date('06-3月 -17','DD-MON-RR'),30);
Insert into SCOTT.USER1 (ID,NAME,PWD,EMAIL,BIRTHDAY,AGE) values (5,'小明','111','xiao@1.com',to_date('06-3月 -17','DD-MON-RR'),20);
Insert into SCOTT.USER1 (ID,NAME,PWD,EMAIL,BIRTHDAY,AGE) values (6,'小明','111','xiao@1.com',to_date('06-3月 -17','DD-MON-RR'),20);
Insert into SCOTT.USER1 (ID,NAME,PWD,EMAIL,BIRTHDAY,AGE) values (7,'小明','111','xiao@1.com',to_date('06-3月 -17','DD-MON-RR'),20);
Insert into SCOTT.USER1 (ID,NAME,PWD,EMAIL,BIRTHDAY,AGE) values (8,'aaa','111','xiao@1.com',to_date('06-3月 -17','DD-MON-RR'),20);
Insert into SCOTT.USER1 (ID,NAME,PWD,EMAIL,BIRTHDAY,AGE) values (9,'小明','111','xiao@1.com',to_date('06-3月 -17','DD-MON-RR'),20);
Insert into SCOTT.USER1 (ID,NAME,PWD,EMAIL,BIRTHDAY,AGE) values (10,'小明','111','xiao@1.com',to_date('06-3月 -17','DD-MON-RR'),20);
Insert into SCOTT.USER1 (ID,NAME,PWD,EMAIL,BIRTHDAY,AGE) values (11,'小明','111','xiao@1.com',to_date('06-3月 -17','DD-MON-RR'),20);
Insert into SCOTT.USER1 (ID,NAME,PWD,EMAIL,BIRTHDAY,AGE) values (12,'小明','111','xiao@1.com',to_date('06-3月 -17','DD-MON-RR'),20);
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
