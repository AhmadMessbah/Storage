alter session set "_oracle_script" = true;

create user mft identified by java123;

grant dba to mft;

connect mft/java123;

create table user_tbl
(
    u_username nvarchar2(20),
    u_password nvarchar2(20)
);

create table user_roles
(
    u_username nvarchar2(20),
    role_name  nvarchar2(20)
);

create table LOGS_TBL
(
    ID         NUMBER primary key,
    ACTION     VARCHAR2(255 char),
    CLASS_NAME VARCHAR2(255 char),
    DATA       VARCHAR2(255 char),
    LOG_TYPE   VARCHAR2(255 char),
    User_Id    Number,
    TIME_STAMP TIMESTAMP(6)
);

create sequence logs_seq start with 1 increment by 1;

commit;

