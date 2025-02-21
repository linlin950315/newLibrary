SHOW CREATE TABLE Book;

SHOW GRANTS FOR CURRENT_USER();

UPDATE book SET categoryId = 7 WHERE book_id = 1;

UPDATE Book SET 
                         book_name = 'he', 
                        counts = 3, 
                         categoryId = 5 
                         WHERE book_id = 2
                         
ALTER TABLE Book ADD description  VARCHAR(100) DEFAULT null
ALTER TABLE Book ADD createUser  VARCHAR(100) DEFAULT null
ALTER TABLE Book ADD price  VARCHAR(100) DEFAULT null

ALTER TABLE Book ADD status int DEFAULT null

SHOW GRANTS FOR CURRENT_USER();

SHOW GRANTS FOR CURRENT_USER();

SHOW TABLE STATUS LIKE 'book';

SHOW VARIABLES LIKE 'read_only';

DESCRIBE book;

SHOW TRIGGERS FROM library LIKE 'Book';

ALTER TABLE book 
ADD COLUMN price DECIMAL(10, 2)

ALTER TABLE book
DROP COLUMN book_id;

SHOW CREATE TABLE book;

ALTER TABLE book DROP COLUMN book_id;

CREATE TABLE category (
    category_id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- 自增主键
    category_name VARCHAR(255) NOT NULL UNIQUE      -- 分类名称，唯一
);

DROP TABLE category;

