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
    role_name nvarchar2(20)
);

commit;