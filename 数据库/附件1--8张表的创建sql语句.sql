create database TPCH
USE TPCH

create table region(/*������*/
regionkey  integer primary key ,/*�������*/
name char(25),/*��������*/
comment  varchar(152)/*��ע*/);

create table nation(/*���ұ�*/
nationkey  integer primary key ,/*���ұ��*/
name char(25),/*��������*/
comment  varchar(152)/*��ע*/);

create table Supplier(/*��Ӧ�̻�����*/
suppkey  integer primary key ,/*��Ӧ�̱��*/
name char(25),/*��Ӧ������*/
address varchar(40),/*��Ӧ�̵�ַ*/
nationkey integer references nation(nationkey),/*���ұ��*/
phone char(15),/*��Ӧ�̵绰*/
acctbal real,/*��Ӧ���˻����*/
comment  varchar(101)/*��ע*/);

create table part(/*���������*/
partkey  integer primary key ,/*������*/
name varchar(55),/*�������*/
mfgr char(25),/*���쳧*/
brand char(10),/*Ʒ��*/
type varchar(25),/*�������*/
size integer,/*�ߴ�*/
container char(10),/*��װ*/
retailprice real,/*���ۼ۸�*/
comment  varchar(23)/*��ע*/);

create table Partsupp(/*�����Ӧ��ϵ��*/
partkey integer references part(partkey),/*������*/
suppkey integer references supplier(suppkey),/*��Ӧ�̱��*/
availqty integer,/*��������*/
supplycost real,/*��Ӧ�۸�*/
comment varchar(199),/*��ע*/
primary key (partkey,suppkey)/*�������룬��Լ��*/);

create table Customer(/*�˿ͱ�*/
custkey  integer primary key,/*�˿ͱ��*/ 
name  varchar(25),/*����*/ 
address varchar(40),/*��ַ */ 
nationkey  integer references nation(nationkey),/*�������*/ 
phone  char(15),/*�绰*/ 
acctbal  real,/*�˻����*/ 
mktsegment  char(10),/*�г�����*/ 
comment varchar(117)/*��ע*/);

create table Orders(/*������*/
orderkey  integer primary key,/*�������*/
custkey  integer references customer(custkey),/*�˿ͱ��*/
orderstatus  char(1),/*����״̬*/
totalprice  real,/*�����ܽ��*/
orderdate date ,/*��������*/
orderpriority  char(15),/*�������ȼ���*/
clerk  char(15),/*����Ա*/
shippriority  integer,/*�������ȼ���*/
comment  varchar(79)/*��ע*/
/*toalprice=sum��lineitem.extendedprice*(1-lineitem.discount)*(1+lineitem.tax)*/);

create table Lineitem(/*������ϸ��*/
orderkey  integer references orders(orderkey),/*�������*/
partkey  integer references part(partkey),/*������*/
suppkey  integer references supplier(suppkey),/*��Ӧ�̱��*/
linenumber integer,/*����*/
quantity  real,/*�����ܽ��*/
extendedprice real,/*������ϸ�۸�*/
discount real,/*�ۿ�[0.00,1.00] */
tax real,/*˰��[0.00,0.08] */
returnflag char(1) ,/* �˻����*/
linestatus  char(1),/*������ϸ״̬*/
shipdate  date,/*װ������*/
commitdate  date,/*ί������*/
receiptdate   date,/*ǩ������*/
shipinstruct  char(25),/*װ��˵������deliver in person*/
shipmode  char(10),/*װ�˷�ʽ������ˡ�½�ˡ����˺ͺ���*/
comment  varchar(44),/*��ע*/
primary key(orderkey,linenumber),
foreign key(partkey,suppkey)references partsupp(partkey,suppkey));
/*���У�������ϸ�۸�extendedprice=quantity*part.retailprice*/