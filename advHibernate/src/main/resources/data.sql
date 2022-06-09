insert into course(id,name) 
values(10001,'Jpa in 50 steps');


insert into course(id,name) 
values(10002,'spring in 50 steps');

insert into course(id,name) 
values(10003,'cloud in 50 steps');










insert into passport(id,number) 
values(40001,'E12345');

insert into passport(id,number) 
values(40002,'M12345');

insert into passport(id,number) 
values(40003,'N12345');




insert into student(id,name,passport_id) 
values(20001,'pk',40001);

insert into student(id,name,passport_id) 
values(20002,'adam',40002);

insert into student(id,name,passport_id) 
values(20003,'jane',40003);



insert into review(id,rating,description,course_id) 
values(50001,'3','begginer Course',10001);

insert into review(id,rating,description,course_id) 
values(50002,'4','good Course',10002);

insert into review(id,rating,description,course_id) 
values(50003,'5','great Course',10003);




insert into student_course(student_id,course_id)
values(20001,10001);

insert into student_course(student_id,course_id)
values(20002,10001);

insert into student_course(student_id,course_id)
values(20003,10001);

insert into student_course(student_id,course_id)
values(20001,10003);





