UPDATE lineitem a ,part b SET a.extendedprice=a.linenumber*b.retailprice where a.partkey=b.partkey;

UPDATE lineitem a ,part b SET a.quantity=a.linenumber*b.retailprice*a.discount*(1+a.tax) where a.partkey=b.partkey;

UPDATE orders a , lineitem b Set a.totalprice = b.quantity where a.orderkey = b.orderkey;