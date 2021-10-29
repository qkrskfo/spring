--insert into userinfo(userid,password,name,email) values(?,?,?,?);
insert into userinfo(userid,password,name,email) values('xxx','xxx','xxx','xxx');

--update  userinfo set password=?,name=?,email=? where userid=?;
update  userinfo set password='yyy',name='yyy',email='yyy' where userid='xxx';

--delete userinfo where userid=?
delete userinfo where userid='xxx';

--select userid,password,name,email from userinfo where userid=?;
select userid,password,name,email from userinfo where userid='xxx';

select userid,password,name,email from userinfo;

--select count(*) cnt from userinfo where userid=?
select count(*) cnt from userinfo where userid='xxx'