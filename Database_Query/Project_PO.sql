create SEQUENCE id_sequence
  INCREMENT BY 1 MAXVALUE 5000 CYCLE;

create table tbl_role(
        roleId number(5) primary key not null,
        roleName varchar(20) not null
)

create table tbl_user(
        userId number(5) primary key,
        userName VARCHAR2(20) not null,
        phone number(10) not null,
        email varchar(50) not null,
        houseNo number(5) not null,
        address1 VARCHAR2(20) not null,
        address2 number(20) not null,
        city varchar(50) not null,
        state varchar2(20) not null,
        userPass varchar2(20) not null,
        roleId not null,
        is_active char(1),
        created_By varchar(10),
        created_date date,
        updated_by varchar2(20),
        updated_date date,
        foreign key (roleId) references tbl_role(roleId)
)
 
create table tbl_address(
        houseNo number(5) primary key,
        address1 VARCHAR2(20) not null,
        address2 number(20) not null,
        city varchar(50) not null,
        state varchar2(20) not null
)
 
INSERT INTO tbl_role
VALUES (3,'Vendor')

select * from tbl_role

select * from tbl_user

select * from tbl_address
 
drop table tbl_user

drop table tbl_address

drop table tbl_role;
