create table LOGS_TBL
(
    ID         NUMBER(19) not null
        primary key,
    ACTION     VARCHAR2(255 char),
    CLASS_NAME VARCHAR2(255 char),
    DATA       VARCHAR2(255 char),
    LOG_TYPE   VARCHAR2(255 char),
    User_Id    Number,
    TIME_STAMP TIMESTAMP(6)
);

create sequence logs_seq start with 1 increment by 1;