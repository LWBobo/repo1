create database TPCH
USE TPCH

create table region(/*地区表*/
regionkey  integer primary key ,/*地区编号*/
name char(25),/*地区名称*/
comment  varchar(152)/*备注*/);

create table nation(/*国家表*/
nationkey  integer primary key ,/*国家编号*/
name char(25),/*国家名称*/
comment  varchar(152)/*备注*/);

create table Supplier(/*供应商基本表*/
suppkey  integer primary key ,/*供应商编号*/
name char(25),/*供应商名称*/
address varchar(40),/*供应商地址*/
nationkey integer references nation(nationkey),/*国家编号*/
phone char(15),/*供应商电话*/
acctbal real,/*供应商账户余额*/
comment  varchar(101)/*备注*/);

create table part(/*零件基本表*/
partkey  integer primary key ,/*零件编号*/
name varchar(55),/*零件名称*/
mfgr char(25),/*制造厂*/
brand char(10),/*品牌*/
type varchar(25),/*零件类型*/
size integer,/*尺寸*/
container char(10),/*包装*/
retailprice real,/*零售价格*/
comment  varchar(23)/*备注*/);

create table Partsupp(/*零件供应联系表*/
partkey integer references part(partkey),/*零件编号*/
suppkey integer references supplier(suppkey),/*供应商编号*/
availqty integer,/*可用数量*/
supplycost real,/*供应价格*/
comment varchar(199),/*备注*/
primary key (partkey,suppkey)/*定义主码，表级约束*/);

create table Customer(/*顾客表*/
custkey  integer primary key,/*顾客编号*/ 
name  varchar(25),/*姓名*/ 
address varchar(40),/*地址 */ 
nationkey  integer references nation(nationkey),/*国籍编号*/ 
phone  char(15),/*电话*/ 
acctbal  real,/*账户余额*/ 
mktsegment  char(10),/*市场分区*/ 
comment varchar(117)/*备注*/);

create table Orders(/*订单表*/
orderkey  integer primary key,/*订单编号*/
custkey  integer references customer(custkey),/*顾客编号*/
orderstatus  char(1),/*订单状态*/
totalprice  real,/*订单总金额*/
orderdate date ,/*订单日期*/
orderpriority  char(15),/*订单优先级别*/
clerk  char(15),/*记账员*/
shippriority  integer,/*运输优先级别*/
comment  varchar(79)/*备注*/
/*toalprice=sum（lineitem.extendedprice*(1-lineitem.discount)*(1+lineitem.tax)*/);

create table Lineitem(/*订单明细表*/
orderkey  integer references orders(orderkey),/*订单编号*/
partkey  integer references part(partkey),/*零件编号*/
suppkey  integer references supplier(suppkey),/*供应商编号*/
linenumber integer,/*数量*/
quantity  real,/*订单总金额*/
extendedprice real,/*订单明细价格*/
discount real,/*折扣[0.00,1.00] */
tax real,/*税率[0.00,0.08] */
returnflag char(1) ,/* 退货标记*/
linestatus  char(1),/*订单明细状态*/
shipdate  date,/*装运日期*/
commitdate  date,/*委托日期*/
receiptdate   date,/*签收日期*/
shipinstruct  char(25),/*装运说明，如deliver in person*/
shipmode  char(10),/*装运方式，如空运、陆运、铁运和海运*/
comment  varchar(44),/*备注*/
primary key(orderkey,linenumber),
foreign key(partkey,suppkey)references partsupp(partkey,suppkey));
/*其中，订单明细价格extendedprice=quantity*part.retailprice*/