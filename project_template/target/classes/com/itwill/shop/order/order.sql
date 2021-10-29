--0.guard1님 이 상품1번과 2번 주문
insert into orders(o_no,o_desc,o_date,o_price,userid) values (orders_o_no_SEQ.nextval,'비글외1종',sysdate-2,1050000,'guard1');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,1);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,2);



--1. 멤버 한사람의 주문전체목록
select * from orders where userid='guard1';

--2. 주문한개(멤버 한사람의) 
select * from orders where o_no=1;


--3. 주문한개의  주문상세 여러개(주문상세)
select * from order_item where o_no = 1;

--4. 주문한개의 주문상세,제품정보 여러개(주문상세,제품)
select * from orders o join order_item oi on o.o_no=oi.o_no  join  product p on oi.p_no=p.p_no 
where o.userid='guard1' and o.o_no = 1;

--5. 주문한개삭제(주문1개삭제,주문상세삭제)
--on delete cascade
delete from order_item where o_no=1;
delete from orders where o_no=1;
--rollback;
--6. 멤버한사람의 주문내역전체삭제
----on delete cascade
--select j_no from orders where userid='guard1';
delete from order_item where o_no in(select o_no from orders where userid='guard1');
delete from orders where userid='guard1';
