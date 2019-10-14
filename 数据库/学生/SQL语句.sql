1.
	select * from student where sdept = 'CS';
mysql> select * from student where sdept = 'CS';
+-----------+-------+------+------+-------+
| Sno       | Sname | Ssex | Sage | Sdept |
+-----------+-------+------+------+-------+
| 201215121 | 李勇  | 男   |   20 | CS    |
| 201215122 | 刘晨  | 女   |   19 | CS    |
| 201215127 | 张琴  | 女   |   19 | CS    |
+-----------+-------+------+------+-------+
	
2.
	select count(sno) '全体学生人数'from student ;
mysql> select count(sno) '全体学生人数'from student ;
+--------------+
| 全体学生人数 |
+--------------+
|            8 |
+--------------+

3.
	select count(sno) '男/女人数' from student group by ssex ;
mysql> select count(sno) '男/女人数' from student group by ssex ;
+-----------+
| 男/女人数 |
+-----------+
|         4 |
|         4 |
+-----------+

4.
	select count(sno) from student group by sdept order by count(sno) desc;
+------------+
| count(sno) |
+------------+
|          3 |
|          3 |
|          2 |
+------------+


5.
	select * from student where sname like '_阳%' ;
mysql> select * from student where sname like '_阳%' ;
+-----------+-------+------+------+-------+
| Sno       | Sname | Ssex | Sage | Sdept |
+-----------+-------+------+------+-------+
| 201215126 | 李阳  | 男   |   18 | IS    |
+-----------+-------+------+------+-------+

6.
	select cname, avg(grade) '平均成绩',count(sno) from sc ,course where sc.cno =course.cno group by sc.cno;
mysql> select cname, avg(grade) '平均成绩',count(sno) from sc ,course where sc.cno =course.cno group by sc.cno;
+----------+----------+------------+
| cname    | 平均成绩 | count(sno) |
+----------+----------+------------+
| 数据库   | 81.6000  |          5 |
| 数学     | 80.6667  |          6 |
| 信息系统 | 86.0000  |          6 |
| 操作系统 | 82.8333  |          6 |
| 数据结构 | 86.0000  |          5 |
| 数据处理 | 78.1667  |          6 |
| C语言    | 78.6000  |          5 |
+----------+----------+------------+

7.
	select sno from sc where sno not in (select sno from sc where grade <80)group by sno having count(sno) > 2;
mysql> select sno from sc where sno not in (select sno from sc where grade <80)group by sno having count(sno) > 2;
+-----------+
| sno       |
+-----------+
| 201215121 |
| 201215122 |
+-----------+


1.
	select * from student where sno not in (select distinct sno from sc );
mysql> select * from student where sno not in (select distinct sno from sc );
+-----------+--------+------+------+-------+
| Sno       | Sname  | Ssex | Sage | Sdept |
+-----------+--------+------+------+-------+
| 201215129 | 黄林林 | 男   |   21 | IS    |
+-----------+--------+------+------+-------+

2.
	select s.sno,s.sname,c.cno,c.cname,sc.grade from student s ,sc ,course c where 
	  sc.sno in (select distinct sno from sc ) and s.sno = sc.sno and sc.cno = c.cno;
mysql> select s.sno,s.sname,c.cno,c.cname,sc.grade from student s ,sc ,course c where 
	  sc.sno in (select distinct sno from sc ) and s.sno = sc.sno and sc.cno = c.cno;
+-----------+-------+-----+----------+-------+
| sno       | sname | cno | cname    | grade |
+-----------+-------+-----+----------+-------+
| 201215122 | 刘晨  | 2   | 数学     |    90 |
| 201215122 | 刘晨  | 3   | 信息系统 |    80 |
| 201215122 | 刘晨  | 4   | 操作系统 |    85 |
| 201215122 | 刘晨  | 6   | 数据处理 |    92 |
| 201215127 | 张琴  | 1   | 数据库   |    81 |
| 201215127 | 张琴  | 2   | 数学     |    72 |
| 201215127 | 张琴  | 3   | 信息系统 |    90 |
| 201215127 | 张琴  | 4   | 操作系统 |    64 |
| 201215127 | 张琴  | 5   | 数据结构 |    79 |
| 201215127 | 张琴  | 6   | 数据处理 |    50 |
| 201215127 | 张琴  | 7   | C语言    |    96 |
| 201215125 | 张立  | 1   | 数据库   |    67 |
| 201215125 | 张立  | 2   | 数学     |    71 |
| 201215125 | 张立  | 3   | 信息系统 |    90 |
| 201215121 | 李勇  | 1   | 数据库   |    92 |
| 201215121 | 李勇  | 2   | 数学     |    85 |
| 201215121 | 李勇  | 3   | 信息系统 |    88 |
| 201215121 | 李勇  | 4   | 操作系统 |    98 |
| 201215121 | 李勇  | 5   | 数据结构 |    89 |
| 201215121 | 李勇  | 6   | 数据处理 |    95 |
| 201215121 | 李勇  | 7   | C语言    |    93 |
| 201215126 | 李阳  | 4   | 操作系统 |    81 |
| 201215126 | 李阳  | 5   | 数据结构 |    90 |
| 201215126 | 李阳  | 6   | 数据处理 |    56 |
| 201215126 | 李阳  | 7   | C语言    |    89 |
| 201215123 | 王敏  | 1   | 数据库   |    90 |
| 201215123 | 王敏  | 2   | 数学     |    84 |
| 201215123 | 王敏  | 3   | 信息系统 |    91 |
| 201215123 | 王敏  | 4   | 操作系统 |    90 |
| 201215123 | 王敏  | 5   | 数据结构 |    80 |
| 201215123 | 王敏  | 6   | 数据处理 |    78 |
| 201215123 | 王敏  | 7   | C语言    |    65 |
| 201215128 | 王方  | 1   | 数据库   |    78 |
| 201215128 | 王方  | 2   | 数学     |    82 |
| 201215128 | 王方  | 3   | 信息系统 |    77 |
| 201215128 | 王方  | 4   | 操作系统 |    79 |
| 201215128 | 王方  | 5   | 数据结构 |    92 |
| 201215128 | 王方  | 6   | 数据处理 |    98 |
| 201215128 | 王方  | 7   | C语言    |    50 |
+-----------+-------+-----+----------+-------+


3.
	  
	  select student.sno,sname,sc.cno,grade,course.cname from 
	  (student left outer join sc on (student.sno = sc.sno))
	  left outer join course on sc.cno = course.cno;
mysql> select student.sno,sname,sc.cno,grade,course.cname from 
	  (student left outer join sc on (student.sno = sc.sno))
	  left outer join course on sc.cno = course.cno;
+-----------+--------+------+-------+----------+
| sno       | sname  | cno  | grade | cname    |
+-----------+--------+------+-------+----------+
| 201215122 | 刘晨   | 2    |    90 | 数学     |
| 201215122 | 刘晨   | 3    |    80 | 信息系统 |
| 201215122 | 刘晨   | 4    |    85 | 操作系统 |
| 201215122 | 刘晨   | 6    |    92 | 数据处理 |
| 201215127 | 张琴   | 1    |    81 | 数据库   |
| 201215127 | 张琴   | 2    |    72 | 数学     |
| 201215127 | 张琴   | 3    |    90 | 信息系统 |
| 201215127 | 张琴   | 4    |    64 | 操作系统 |
| 201215127 | 张琴   | 5    |    79 | 数据结构 |
| 201215127 | 张琴   | 6    |    50 | 数据处理 |
| 201215127 | 张琴   | 7    |    96 | C语言    |
| 201215125 | 张立   | 1    |    67 | 数据库   |
| 201215125 | 张立   | 2    |    71 | 数学     |
| 201215125 | 张立   | 3    |    90 | 信息系统 |
| 201215121 | 李勇   | 1    |    92 | 数据库   |
| 201215121 | 李勇   | 2    |    85 | 数学     |
| 201215121 | 李勇   | 3    |    88 | 信息系统 |
| 201215121 | 李勇   | 4    |    98 | 操作系统 |
| 201215121 | 李勇   | 5    |    89 | 数据结构 |
| 201215121 | 李勇   | 6    |    95 | 数据处理 |
| 201215121 | 李勇   | 7    |    93 | C语言    |
| 201215126 | 李阳   | 4    |    81 | 操作系统 |
| 201215126 | 李阳   | 5    |    90 | 数据结构 |
| 201215126 | 李阳   | 6    |    56 | 数据处理 |
| 201215126 | 李阳   | 7    |    89 | C语言    |
| 201215123 | 王敏   | 1    |    90 | 数据库   |
| 201215123 | 王敏   | 2    |    84 | 数学     |
| 201215123 | 王敏   | 3    |    91 | 信息系统 |
| 201215123 | 王敏   | 4    |    90 | 操作系统 |
| 201215123 | 王敏   | 5    |    80 | 数据结构 |
| 201215123 | 王敏   | 6    |    78 | 数据处理 |
| 201215123 | 王敏   | 7    |    65 | C语言    |
| 201215128 | 王方   | 1    |    78 | 数据库   |
| 201215128 | 王方   | 2    |    82 | 数学     |
| 201215128 | 王方   | 3    |    77 | 信息系统 |
| 201215128 | 王方   | 4    |    79 | 操作系统 |
| 201215128 | 王方   | 5    |    92 | 数据结构 |
| 201215128 | 王方   | 6    |    98 | 数据处理 |
| 201215128 | 王方   | 7    |    50 | C语言    |
| 201215129 | 黄林林 | NULL | NULL  | NULL     |
+-----------+--------+------+-------+----------+

4. 
	select cno,cname from course where cno not in (select distinct cno from sc);
mysql> select cno,cname from course where cno not in (select distinct cno from sc);
Empty set	

5.
	
	select cno,cname from course where cno  in (select distinct cno from sc);
mysql> select cno,cname from course where cno  in (select distinct cno from sc);
+-----+----------+
| cno | cname    |
+-----+----------+
| 1   | 数据库   |
| 2   | 数学     |
| 3   | 信息系统 |
| 4   | 操作系统 |
| 5   | 数据结构 |
| 6   | 数据处理 |
| 7   | C语言    |
+-----+----------+
7 rows in set (0.11 sec)

6.
	
	select student.sno,sname,sc.cno,grade,course.cname from 
	  (student left outer join sc on (student.sno = sc.sno))
	  left outer join course on sc.cno = course.cno;
mysql> select student.sno,sname,sc.cno,grade,course.cname from 
	  (student left outer join sc on (student.sno = sc.sno))
	  left outer join course on sc.cno = course.cno;
+-----------+--------+------+-------+----------+
| sno       | sname  | cno  | grade | cname    |
+-----------+--------+------+-------+----------+
| 201215122 | 刘晨   | 2    |    90 | 数学     |
| 201215122 | 刘晨   | 3    |    80 | 信息系统 |
| 201215122 | 刘晨   | 4    |    85 | 操作系统 |
| 201215122 | 刘晨   | 6    |    92 | 数据处理 |
| 201215127 | 张琴   | 1    |    81 | 数据库   |
| 201215127 | 张琴   | 2    |    72 | 数学     |
| 201215127 | 张琴   | 3    |    90 | 信息系统 |
| 201215127 | 张琴   | 4    |    64 | 操作系统 |
| 201215127 | 张琴   | 5    |    79 | 数据结构 |
| 201215127 | 张琴   | 6    |    50 | 数据处理 |
| 201215127 | 张琴   | 7    |    96 | C语言    |
| 201215125 | 张立   | 1    |    67 | 数据库   |
| 201215125 | 张立   | 2    |    71 | 数学     |
| 201215125 | 张立   | 3    |    90 | 信息系统 |
| 201215121 | 李勇   | 1    |    92 | 数据库   |
| 201215121 | 李勇   | 2    |    85 | 数学     |
| 201215121 | 李勇   | 3    |    88 | 信息系统 |
| 201215121 | 李勇   | 4    |    98 | 操作系统 |
| 201215121 | 李勇   | 5    |    89 | 数据结构 |
| 201215121 | 李勇   | 6    |    95 | 数据处理 |
| 201215121 | 李勇   | 7    |    93 | C语言    |
| 201215126 | 李阳   | 4    |    81 | 操作系统 |
| 201215126 | 李阳   | 5    |    90 | 数据结构 |
| 201215126 | 李阳   | 6    |    56 | 数据处理 |
| 201215126 | 李阳   | 7    |    89 | C语言    |
| 201215123 | 王敏   | 1    |    90 | 数据库   |
| 201215123 | 王敏   | 2    |    84 | 数学     |
| 201215123 | 王敏   | 3    |    91 | 信息系统 |
| 201215123 | 王敏   | 4    |    90 | 操作系统 |
| 201215123 | 王敏   | 5    |    80 | 数据结构 |
| 201215123 | 王敏   | 6    |    78 | 数据处理 |
| 201215123 | 王敏   | 7    |    65 | C语言    |
| 201215128 | 王方   | 1    |    78 | 数据库   |
| 201215128 | 王方   | 2    |    82 | 数学     |
| 201215128 | 王方   | 3    |    77 | 信息系统 |
| 201215128 | 王方   | 4    |    79 | 操作系统 |
| 201215128 | 王方   | 5    |    92 | 数据结构 |
| 201215128 | 王方   | 6    |    98 | 数据处理 |
| 201215128 | 王方   | 7    |    50 | C语言    |
| 201215129 | 黄林林 | NULL | NULL  | NULL     |
+-----------+--------+------+-------+----------+


7.
		select sno,sum(grade) '总分' from sc,course   group by sno order by sum(grade) desc;
mysql> select sno,sum(grade) '总分' from sc,course   group by sno order by sum(grade) desc;
+-----------+------+
| sno       | 总分 |
+-----------+------+
| 201215121 | 4480 |
| 201215123 | 4046 |
| 201215128 | 3892 |
| 201215127 | 3724 |
| 201215122 | 2429 |
| 201215126 | 2212 |
| 201215125 | 1596 |
+-----------+------+

8.
	select cno from course where cname ='数据库';
	select sno,grade from sc where cno in (select cno from course where cname ='数据库') and grade <60;
mysql> select sno,grade from sc where cno in (select cno from course where cname ='数据库') and grade <60;
Empty set

9.
	select sc.sno,sname,sdept,sc.cno,grade from student,sc,course having  max(grade);
mysql> select sc.sno,sname,sdept,sc.cno,grade from student,sc,course having  max(grade);
+-----------+-------+-------+-----+-------+
| sno       | sname | sdept | cno | grade |
+-----------+-------+-------+-----+-------+
| 201215121 | 李勇  | CS    | 1   |    92 |
+-----------+-------+-------+-----+-------+
	
	
	
	
	
	
	
	
	
	
	
	
	