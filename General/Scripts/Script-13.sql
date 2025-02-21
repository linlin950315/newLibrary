select * from dish d left join dish_flavor df on d.id = df.dish_id 

SELECT * FROM lend l LEFT JOIN book b on l.bookId = b.book_id 
left join student s on s.student_id = l.studentId 
where studentId =1