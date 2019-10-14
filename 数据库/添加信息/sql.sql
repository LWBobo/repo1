select c.custkey,c.name from lineitem l,supplier s,customer c where 


select partkey from part where name='酷睿i7-7700k';
select suppkey from supplier where name='Intel英特尔';
select orderkey from lineitem where partkey=(select partkey from part where name='酷睿i7-7700k') 
		and suppkey=(select suppkey from supplier where name='Intel英特尔');

select custkey from orders where orderkey = (select orderkey from lineitem where partkey=(select partkey from part where name='酷睿i7-7700k') 
		and suppkey=(select suppkey from supplier where name='Intel英特尔'));
		
		
select custkey,name from customer where custkey not in(select custkey from orders where orderkey = (select orderkey from lineitem where partkey=(select partkey from part where name='酷睿i7-7700k') 
		and suppkey=(select suppkey from supplier where name='Intel英特尔')));
		
		
		
		
		
		
		
select custkey from orders where  totalprice>500000;
select custkey from orders group by custkey having avg(totalprice)>500000;
select custkey,name,address from customer where address='中国' and custkey in 
	(select custkey from orders group by custkey having avg(totalprice)>500000);
	
	
	
	
select custkey from customer where name='天猫商城';
select orderkey from orders where custkey =(select custkey from customer where name='天猫商城');
select custkey from customer where name='唯品会';
select orderkey from orders where custkey =(select custkey from customer where name='唯品会');
select orderkey from orders where (select orderkey from orders where custkey =(select custkey from customer where name='天猫商城')) not in 
	(select orderkey from orders where custkey =(select custkey from customer where name='唯品会'));

select p.* from part p,lineitem l where l.orderkey in (select orderkey from orders where (select orderkey from orders where custkey =(select custkey from customer where name='天猫商城')) in 
	(select orderkey from orders where custkey =(select custkey from customer where name='唯品会')));
	
	
	
select orderkey from orders where custkey =(select custkey from customer where name='天猫商城')
not exists
select orderkey from orders where custkey =(select custkey from customer where name='唯品会');

select p.* from part p,lineitem l where l.orderkey in (
select orderkey from orders where custkey =(select custkey from customer where name='天猫商城')
union
select orderkey from orders where custkey =(select custkey from customer where name='唯品会')
) and p.partkey = l.partkey;



select orderkey from orders where (select orderkey from orders where custkey =(select custkey from customer where name='天猫商城')) not in 
	(select orderkey from orders where custkey =(select custkey from customer where name='唯品会'));
	
	
	
	
select orderkey from orders where custkey =(select custkey from customer where name='天猫商城')
and custkey not in 
(select orderkey from orders where custkey =(select custkey from customer where name='唯品会'));
	
	
	
select p.* from part p,lineitem l where l.orderkey in (
select orderkey from orders where custkey =(select custkey from customer where name='天猫商城')
and custkey not in 
(select orderkey from orders where custkey =(select custkey from customer where name='唯品会'))
)and p.partkey = l.partkey;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	