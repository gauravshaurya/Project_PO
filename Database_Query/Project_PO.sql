create SEQUENCE id_sequence
  INCREMENT BY 1 MAXVALUE 5000 CYCLE;

create table tbl_role(
        roleId number(5) primary key not null,
        roleName varchar(20) not null
)

create table tbl_product(
        product_id number(5) primary key not null,
        product_name varchar(100) not null,
        product_price number(10) not null
)

create table tbl_vp(
        vp_id number(10) primary key,
        product_id number(5) not null,
        product_name varchar(100) not null,
        product_price number(10) not null,
        quantity number(10) not null,
        vendorId number(10)
)

create sequence product_id start with 1001 increment by 1;
insert into tbl_product values(product_id.nextval,'Realme X2 Pro',30000);
insert into tbl_product values(product_id.nextval,'MI Mix 3',35000);
insert into tbl_product values(product_id.nextval,'Redmi Note 8 Pro',16000);
insert into tbl_product values(product_id.nextval,'Redmi K20 Pro',33000);
insert into tbl_product values(product_id.nextval,'Canon EOS 1300D',30000);
insert into tbl_product values(product_id.nextval,'Canon EOS 1700D',60000);
insert into tbl_product values(product_id.nextval,'Canon EOS 1500D',45000);
insert into tbl_product values(product_id.nextval,'Nikon D3500',35000);
insert into tbl_product values(product_id.nextval,'Nikon D7200',50000);
insert into tbl_product values(product_id.nextval,'Boosted Electric SkateBoard',80000);
insert into tbl_product values(product_id.nextval,'M1 Electric SkateBoard',70000);
insert into tbl_product values(product_id.nextval,'Mi Electric Scooter Pro',85000);
insert into tbl_product values(product_id.nextval,'MacBook Pro 15',190000);
insert into tbl_product values(product_id.nextval,'Surface Book 2',150000);
insert into tbl_product values(product_id.nextval,'Alienware M15 r2',160000);
insert into tbl_product values(product_id.nextval,'Kindle PaperWhite',12000);
insert into tbl_product values(product_id.nextval,'DJI Mavic Pro',110000);
insert into tbl_product values(product_id.nextval,'Sony wh-1000xm3',27000);
insert into tbl_product values(product_id.nextval,'Bose QuiteComfort 35 II',29000);
insert into tbl_product values(product_id.nextval,'Bose Headphone 700',35000);

commit


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

INSERT INTO tbl_user
VALUES (21,'Block C','Sector-P3','Greater Noida',95,201308,'Uttar Pradesh',
'System',sysdate,'gkshaurya@gmail.com','Y','seller123',9650187167,2,Null,Null,'Gourav Kumar')

INSERT INTO tbl_user
VALUES (22,'Block C','Sector-P3','Noida',95,201308,'Uttar Pradesh',
'System',sysdate,'abhishek@gmail.com','Y','vendor123',9650187167,3,Null,Null,'Abhishek Vishwakarma')

commit

select * from tbl_role

select * from tbl_product

drop table tbl_product;

select * from tbl_user

delete from tbl_user where userId=91

desc tbl_user

select * from tbl_address
 
drop table tbl_user

drop table tbl_role;

select * from tbl_user
