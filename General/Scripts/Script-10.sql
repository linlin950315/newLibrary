select * from class c
left join student s  on s.student_class_no = c.class_no 
where c.class_name ='classC';

select * from class c
inner join student s  on s.student_class_no = c.class_no 
where c.class_name ='classC';

select s.student_id , s.student_name from student s 
inner join class c on c.class_no = s.student_class_no 
where c.class_name = 'classC';

select c.class_name  from student s 
left join class c on c.class_no = s.student_class_no 
where s.student_name ='student A';



CREATE DATABASE jmp DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
