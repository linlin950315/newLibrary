select * from dish d left join dish_flavor df on d.id = df.dish_id 

SELECT dish.name,dish.id,dish.status,category.name FROM dish inner JOIN category ON dish.category_id = category.id



select * from dish d 

, category.name, category.id  



alter table student add constraint id primary key (id);

CREATE TABLE Borrow (
    BorrowID INT PRIMARY KEY,
    BookID INT,
    ReaderID INT,
    BorrowDate DATE,
    ReturnDate DATE,
    BorrowStatus VARCHAR(10)
);


create table lend_record(

book_id int,

date_lend datetime not null,

date_return datetime not null,

student_id varchar(11),

foreign key (book_id) references book(book_id),

foreign key (student_id) references student(student_id));


create table repository(

book_id int ,

lend int not null,

foreign key (book_id) references book(book_id));

alter table lend  add constraint lend_id primary key (lend_id);


select
b.book_name,b.book_id 
from
    lend l
left JOIN 
    book b ON l.bookId  = b.book_id 
    where l.studentId =2
    


