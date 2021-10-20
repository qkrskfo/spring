
insert into userinfo(userid,password,name,email) values('','','','');

update  userinfo set password='',name='',email='' where userid='';

delete userinfo where userid='';

select userid,password,name,email from userinfo where userid='';

select userid,password,name,email from userinfo;

select count(*) cnt from userinfo where userid='';
