create SEQUENCE id_sequence
  INCREMENT BY 1 MAXVALUE 5000 CYCLE;

create table tbl_role(
        roleId int primary key not null,
        roleName varchar(20) not null
)

create table tbl_user(
        userId number(5) primary key,
        userName VARCHAR2(20) not null,
        address varchar(150) not null,
        phone number(10) not null,
        email varchar(50) not null,
        userPass varchar2(20) not null,
        status_flag char(1),
        roleId not null,
        created_By varchar(10),
        created_date date,
        updated_by varchar2(20),
        updated_date date,
        foreign key (roleId) references tbl_role(roleId)
 )
 
INSERT INTO tbl_role
VALUES (1,'Buyer')

select * from tbl_role

select * from tbl_user
 
drop table tbl_user

drop table tbl_role;
