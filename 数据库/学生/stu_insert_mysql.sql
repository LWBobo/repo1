CREATE TABLE Student
(Sno CHAR(9) PRIMARY KEY,
Sname CHAR(20) UNIQUE,
Ssex CHAR(2),
Sage SMALLINT,
Sdept CHAR(20) );

insert into student values('201215121','李勇','男',20,'CS');
insert into student values('201215122','刘晨','女',19,'CS');
insert into student values('201215123','王敏','女',18,'MA');
insert into student values('201215125','张立','男',19,'IS');
insert into student values('201215126','李一平','男',18,'IS');
insert into student values('201215127','张琴','女',19,'CS');
insert into student values('201215128','王方','女',20,'MA');
insert into student values('201215129','黄林林','男',21,'IS');

CREATE TABLE Course
(Cno CHAR(4) PRIMARY KEY,
Cname CHAR(40),
Cpno CHAR(4),
Ccredit SMALLINT,
);

insert into course values('1','数据库','5',4);
insert into course values('2','数学',null,2);
insert into course values('3','信息系统','1',4);
insert into course values('4','操作系统','6',3);
insert into course values('5','数据结构','7',4);
insert into course values('6','数据处理',null,2);
insert into course values('7','C语言','6',4);


CREATE TABLE SC
(Sno CHAR(9),
Cno CHAR(4),
Grade SMALLINT,
PRIMARY KEY (Sno,Cno))

insert into sc values('201215121','1',92);
insert into sc values('201215121','2',85);
insert into sc values('201215121','3',88);
insert into sc values('201215121','4',98);
insert into sc values('201215121','5',89);
insert into sc values('201215121','6',95);
insert into sc values('201215121','7',93);
insert into sc values('201215122','2',90);
insert into sc values('201215122','3',80);
insert into sc values('201215122','4',85);
insert into sc values('201215122','6',92);
insert into sc values('201215123','1',90);
insert into sc values('201215123','2',84);
insert into sc values('201215123','3',91);
insert into sc values('201215123','4',90);
insert into sc values('201215123','5',80);
insert into sc values('201215123','6',78);
insert into sc values('201215123','7',65);
insert into sc values('201215128','1',78);
insert into sc values('201215128','2',82);
insert into sc values('201215128','3',77);
insert into sc values('201215128','4',79);
insert into sc values('201215128','5',92);
insert into sc values('201215128','6',98);
insert into sc values('201215128','7',50);
insert into sc values('201215125','1',67);
insert into sc values('201215125','2',71);
insert into sc values('201215125','3',90);
insert into sc values('201215126','4',81);
insert into sc values('201215126','5',90);
insert into sc values('201215126','6',56);
insert into sc values('201215126','7',89);
insert into sc values('201215127','1',81);
insert into sc values('201215127','2',72);
insert into sc values('201215127','3',90);
insert into sc values('201215127','4',64);
insert into sc values('201215127','5',79);
insert into sc values('201215127','6',50);
insert into sc values('201215127','7',96);