drop table GUEST;
create table GUEST(
        guest_no number(10) primary key,
		guest_name varchar2(100) not null,
		guest_date date not null,
		guest_email varchar2(100),
		guest_homepage varchar2(100),
		guest_title varchar2(255) not null,
		guest_content varchar2(4000) not null);

drop sequence guest_no_seq;
create sequence guest_no_seq  increment by 1 start with 1;

insert into GUEST values(guest_no_seq.nextval , '김경가', sysdate, 'guard1@naver.com', 'http://www.naver.com', '방명록 사용법1', '방명록처럼 사용하시면 됩니다1');
insert into GUEST values(guest_no_seq.nextval , '김경나', sysdate, 'guard2@naver.com', 'http://www.daum.net', '방명록 사용법2', '방명록처럼 사용하시면 됩니다2');
insert into GUEST values(guest_no_seq.nextval , '김경다', sysdate, 'guard3@naver.com', 'http://www.google.com', '방명록 사용법3', '방명록처럼 사용하시면 됩니다3');
insert into GUEST values(guest_no_seq.nextval , '김경라', sysdate, 'guard4@naver.com', 'http://www.nate.com', '방명록 사용법4', '방명록처럼 사용하시면 됩니다4');


--delete from guest where guest_no = 1;

update guest set guest_name='name수정',
                 guest_email='email수정',
                 guest_homepage='homepage수정',
                 guest_title='title수정',
                 guest_content='content수정'
where guest_no = 3;

select * from guest;

select * from guest where guest_no = 3;

commit;

DESC guest;







