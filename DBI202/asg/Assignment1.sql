USE ASSIGNMENT1;
-- Drop Tables if They Exist
DROP TABLE IF EXISTS dbo.transactions_detail;
DROP TABLE IF EXISTS dbo.transactions;
DROP TABLE IF EXISTS dbo.students;
DROP TABLE IF EXISTS dbo.student_cards;
DROP TABLE IF EXISTS dbo.books;
DROP TABLE IF EXISTS dbo.book_types;


-- Create Student Cards Table
CREATE TABLE student_cards (
    card_number NVARCHAR(20) PRIMARY KEY,
	student_name NVARCHAR(255),
    expiration_date DATE,
	major NVARCHAR(255)
);

-- Create Students Table
CREATE TABLE students (
	card_number NVARCHAR(20) PRIMARY KEY References student_cards(card_number),
	email NVARCHAR(30) UNIQUE,
	phone NVARCHAR(30) UNIQUE
);

-- Create Book Types Table
CREATE TABLE book_types (
    book_type_id NVARCHAR(20) PRIMARY KEY,
    type_name NVARCHAR(100)
);

-- Create Books Table
CREATE TABLE books (
    book_id NVARCHAR(20) PRIMARY KEY,
    title NVARCHAR(255),
    author NVARCHAR(255),
    publication_date DATE,
    book_type_id NVARCHAR(20),
	number_of_pages INT CHECK (number_of_pages > 5),
	number_of_copies INT CHECK (number_of_copies > 1),
	price INT CHECK (price > 0),
	import_date DATE,
	shelf_location NVARCHAR(255),
    FOREIGN KEY (book_type_id) REFERENCES book_types(book_type_id)
);

-- Create Transactions Table (Assuming a library transaction log)
CREATE TABLE transactions (
    transaction_id INT PRIMARY KEY,
    card_number NVARCHAR(20),
    checkout_date DATE,
    return_date DATE
	FOREIGN KEY(card_number) references students(card_number)
);

-- Create Transactions Detail Table
CREATE TABLE transactions_detail (
	book_id NVARCHAR(20),
	transaction_id INT,
	quantities INT,
	borrowed_day DATE,
	PRIMARY KEY(transaction_id, book_id),
    FOREIGN KEY (transaction_id) REFERENCES transactions(transaction_id),
    FOREIGN KEY (book_id) REFERENCES books(book_id)
);

-- Insert Sample Data into Book Types Table
INSERT INTO book_types (book_type_id, type_name)
VALUES 
    ('FIN', 'Finance'),
    ('IT', 'Information Technology'),
    ('TRV', 'Travelling'),
    ('LTT', 'Literature'),
	('FL', 'Foreign Language');

-- Insert Sample Data into Student Cards Table
INSERT INTO student_cards (card_number, student_name, expiration_date, major)
VALUES 
    ('SE181838', 'Huynh Ngoc Quang', '2026-01-28', 'Information Assurance'),
	('SE177684', 'Nguyen Van Linh', '2025-05-24', 'Information Assurance'),
	('SE183575', 'Ha Thi Luu Ly', '2026-09-13', 'Information Assurance'),
	('SE193758', 'Nguyen Ngoc Anh Quan', '2027-10-22', 'Information Assurance'),
	('SE179475', 'Nguyen The Anh', '2025-08-30', 'Information Assurance');

-- Insert Sample Data into Students Table
INSERT INTO students (card_number, email, phone)
VALUES 
    ('SE181838', 'quanghnse181838@fpt.edu.vn', '0935410902'),
	('SE177684', 'linhnvse177684@fpt.edu.vn', '0965410302'),
	('SE183575', 'lyhtlse183575@fpt.edu.vn', '0358410302'),
	('SE193758', 'quannnase193758@fpt.edu.vn', '0254123658'),
	('SE179475', 'anhntse179475@fpt.edu.vn', '0321698541');

-- Insert Sample Data into Books Table
INSERT INTO books (book_id, title, author, publication_date, book_type_id, number_of_pages, number_of_copies, price, import_date, shelf_location)
VALUES 
    ('FIN-0001', 'Financial Strategies', 'Emily Johnson', '2021-08-15', 'FIN', 200, 50, 29.99, '2022-01-01', 'A1'),
    ('IT-0001', 'Coding Mastery', 'David Smith', '2022-02-10', 'IT', 300, 30, 39.99, '2022-02-01', 'B2'),
    ('TRV-0001', 'Journey Across Continents', 'Sophia Davis', '2020-12-01', 'TRV', 150, 40, 19.99, '2022-03-01', 'C3'),
    ('LTT-0001', 'Classic Novels Collection', 'Michael Brown', '2019-11-05', 'LTT', 500, 20, 49.99, '2022-04-01', 'D4'),
    ('FL-0001', 'French Language Basics', 'Emma White', '2021-03-01', 'FL', 100, 60, 24.99, '2022-05-01', 'E5'),
	('FIN-0002', 'Investment Strategies', 'Olivia Taylor', '2020-05-20', 'FIN', 250, 45, 34.99, '2022-06-01', 'F6'),
    ('IT-0002', 'Web Development Essentials', 'Matthew Turner', '2021-09-30', 'IT', 400, 25, 49.99, '2022-07-01', 'G7'),
    ('TRV-0002', 'Exploring Asia', 'Aiden Garcia', '2019-11-15', 'TRV', 180, 35, 29.99, '2022-08-01', 'H8'),
    ('LTT-0002', 'Shakespearean Classics', 'Ella Johnson', '2018-08-01', 'LTT', 600, 15, 59.99, '2022-09-01', 'I9'),
    ('FL-0002', 'Spanish Language Basics', 'Liam Robinson', '2020-02-15', 'FL', 120, 55, 27.99, '2022-10-01', 'J10');

-- Insert Sample Data into Transactions Table
INSERT INTO transactions (transaction_id, card_number, checkout_date, return_date)
VALUES 
    (1, 'SE181838', '2022-03-01', '2022-03-15'),
    (2, 'SE177684', '2022-03-05', null),
    (3, 'SE183575', '2022-03-10', '2022-03-25'),
    (4, 'SE193758', '2022-03-15', '2022-03-30'),
    (5, 'SE179475', '2022-03-20', '2022-04-05'),
    (6, 'SE183575', '2022-03-25', '2022-04-10'),
    (7, 'SE181838', '2022-04-01', '2022-04-15'),
    (8, 'SE193758', '2022-04-05', null),
    (9, 'SE177684', '2022-04-10', '2022-04-25'),
    (10, 'SE179475', '2022-04-15', '2022-05-01');

-- Insert Sample Data into Transactions Detail Table
INSERT INTO transactions_detail (book_id, transaction_id, quantities, borrowed_day)
VALUES 
    ('FIN-0001', 1, 2, '2022-03-01'),
    ('IT-0001', 2, 1, '2022-03-05'),
    ('IT-0002', 3, 3, '2022-03-10'),
    ('FIN-0002', 4, 1, '2023-01-15'),
    ('TRV-0002', 5, 2, '2022-03-20'),
    ('TRV-0001', 6, 1, '2023-01-25'),
    ('LTT-0002', 7, 2, '2022-04-01'),
    ('LTT-0001', 8, 1, '2022-04-05'),
    ('FL-0002', 9, 1, '2022-04-10'),
    ('FL-0001', 10, 3, '2022-04-15');





/* 6.1 */
SELECT BOOK.title, BOOK.book_id, BOOK.price, BOOK.author 
FROM books BOOK
WHERE BOOK.book_id = 'IT';
/* 6.2 */
SELECT td.transaction_id, td.book_id, td.borrowed_day, t.card_number
FROM transactions_detail td
JOIN transactions t ON td.transaction_id = t.transaction_id
WHERE td.borrowed_day >= '2023-01-01' AND td.borrowed_day < '2023-02-01';
/* 6.3 */
SELECT t.*
FROM transactions t
WHERE NOT EXISTS (
    SELECT 1
    FROM transactions_detail td
    WHERE td.transaction_id = t.transaction_id AND td.quantities > 0
)
ORDER BY t.checkout_date;
/* 6.4 */
SELECT bt.book_type_id, bt.type_name, COUNT(b.book_id) AS total_books
FROM book_types bt
LEFT JOIN books b ON bt.book_type_id = b.book_type_id
GROUP BY bt.book_type_id, bt.type_name;
/* 6.5 */
SELECT COUNT(DISTINCT card_number) AS total_students_borrowed
FROM transactions;

/* 6.6 */
SELECT b.* 
FROM books b
WHERE b.title LIKE '%SQL%';

/* 6.7 */
SELECT s.card_number, sc.student_name, t.transaction_id, b.title, t.checkout_date, t.return_date
FROM student_cards sc
JOIN students s ON sc.card_number = s.card_number
JOIN transactions t ON t.card_number = s.card_number
JOIN transactions_detail td ON td.transaction_id = t.transaction_id
JOIN books b ON b.book_id = td.book_id
ORDER BY t.checkout_date;

/* 6.8 */
SELECT b.book_id, b.title, COUNT(td.transaction_id) AS borrow_count
FROM books b
JOIN transactions_detail td ON b.book_id = td.book_id
GROUP BY b.book_id, b.title
HAVING COUNT(td.transaction_id) > 20;

/* 6.9 */
UPDATE books
SET books.price = books.price * 0.7
WHERE YEAR(import_date) <= 2014;

/* 6.10 */


/* 6.14 */
IF OBJECT_ID('Tr_Books_Transaction_Update', 'TR') IS NOT NULL
	DROP TRIGGER Tr_Books_Transaction_Update
GO

CREATE TRIGGER Tr_Books_Transaction_Update ON transactions
AFTER UPDATE
AS
	DECLARE @BookID INT
GO