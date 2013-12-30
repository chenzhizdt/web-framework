---------------------------------------------
-- Export file for user PMTOOLS            --
-- Created by Chen on 2013/12/30, 16:52:12 --
---------------------------------------------

spool db.log

prompt
prompt Creating table APPUSER
prompt ======================
prompt
create table APPUSER
(
  id         NUMBER not null,
  username   VARCHAR2(100) not null,
  password   VARCHAR2(100) not null,
  nickname   VARCHAR2(100),
  createtime DATE,
  updatetime DATE,
  coupleid   NUMBER,
  sex        NVARCHAR2(1)
)
;
comment on table APPUSER
  is '�û���';
comment on column APPUSER.id
  is 'ID';
comment on column APPUSER.username
  is '�û���';
comment on column APPUSER.password
  is '����';
comment on column APPUSER.nickname
  is '�ǳ�';
comment on column APPUSER.createtime
  is '����ʱ��';
comment on column APPUSER.updatetime
  is '����ʱ��';
comment on column APPUSER.coupleid
  is 'COUPLEID';
comment on column APPUSER.sex
  is '0:�� 1:Ů';
alter table APPUSER
  add constraint PK_APPUSER_ID primary key (ID);

prompt
prompt Creating table COUPLE
prompt =====================
prompt
create table COUPLE
(
  id         NUMBER not null,
  name       VARCHAR2(100) not null,
  loveindex  NUMBER default 0 not null,
  createtime DATE not null,
  updatetime DATE not null,
  userid1    NUMBER not null,
  userid2    NUMBER not null
)
;
comment on table COUPLE
  is 'COUPLE��';
comment on column COUPLE.name
  is 'COUPLE����';
comment on column COUPLE.loveindex
  is '����ָ��';
comment on column COUPLE.createtime
  is '����ʱ��';
comment on column COUPLE.updatetime
  is '����ʱ��';
comment on column COUPLE.userid1
  is 'USER1';
comment on column COUPLE.userid2
  is 'USER2';
alter table COUPLE
  add constraint PK_COUPLE_ID primary key (ID);

prompt
prompt Creating table LOVEHISTORY
prompt ==========================
prompt
create table LOVEHISTORY
(
  id           NUMBER not null,
  content      VARCHAR2(1000),
  createtime   DATE,
  coupleid     NUMBER,
  createuserid NUMBER,
  createname   VARCHAR2(100)
)
;
comment on table LOVEHISTORY
  is '������ʷ��';
comment on column LOVEHISTORY.content
  is '����';
comment on column LOVEHISTORY.createtime
  is '����ʱ��';
comment on column LOVEHISTORY.coupleid
  is 'COUPLEID';
comment on column LOVEHISTORY.createuserid
  is 'CREATEUSERID';
comment on column LOVEHISTORY.createname
  is '����������';
alter table LOVEHISTORY
  add constraint PK_LOVEHISTORY_ID primary key (ID);

prompt
prompt Creating table PET
prompt ==================
prompt
create table PET
(
  id         NUMBER not null,
  name       VARCHAR2(100) not null,
  heartindex NUMBER default 0 not null,
  type       NVARCHAR2(1) not null,
  coupleid   NUMBER not null
)
;
comment on table PET
  is '�����';
comment on column PET.name
  is '������';
comment on column PET.heartindex
  is '����ָ��';
comment on column PET.type
  is '��������';
comment on column PET.coupleid
  is 'COUPLE ID';
alter table PET
  add constraint PK_PET_ID primary key (ID);

prompt
prompt Creating sequence HIBERNATE_SEQUENCE
prompt ====================================
prompt
create sequence HIBERNATE_SEQUENCE
minvalue 1000000
maxvalue 1000000000
start with 1000020
increment by 1
cache 20;


spool off
