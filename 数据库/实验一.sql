create database TPCH;
USE TPCH;


drop table if exists Part;
create table Part(  
partkey integer,    /* 零件编号*/ 
name varchar(10),	/* 零件名称*/
mfgr char(25),		/* 制造厂*/
brand char(10),		/* 品牌*/
type varchar(25),	/* 零件类型*/
size integer,		/* 尺寸*/
container char(10), /* 包装*/
retailprice real,	/* 零售价格*/
comment varchar(23),	/* 备注*/
primary key(partkey)

);

drop table if exists Supplier;
create table Supplier(
suppkey integer, 	/* 供应编号*/
name char(25),		/* 供应商名称*/
address varchar(40),/* 供应商地址*/
nationkey integer,	/* 国家编号*/
phone char(15),		/* 供应商电话*/
acctbal real,		/* 供应商账户余额*/
comment varchar(101),/* 备注*/
primary key(suppkey)

);


drop table if exists Partsupp;
create table Partsupp(
partkey integer,		/* 零件编号*/
suppkey integer,		/* 供应商编号*/
availqty  integer,		/* 可用数量*/
supplycost  real,		/* 供应价格*/
comment varchar(199),	/* 备注*/
primary key(partkey,suppkey)

);