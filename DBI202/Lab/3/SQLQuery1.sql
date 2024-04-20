DROP TABLE IF EXISTS PRODUCT;
DROP TABLE IF EXISTS CATEGORY;

CREATE TABLE CATEGORY (
	cate_id nvarchar(30) primary key,
	cate_name nvarchar(30)
)

CREATE TABLE PRODUCT (
	pro_id nvarchar(30) PRIMARY KEY,
	cate_id nvarchar(30),
	pro_name nvarchar(30),
	price DECIMAL(20, 3) check (price > 0),
	CONSTRAINT NN FOREIGN KEY(cate_id) References CATEGORY(cate_id)
)

INSERT INTO CATEGORY(cate_id, cate_name) VALUES 
('CATE_1', 'Electronics'),
('CATE_2', 'Apparel and Fashion'),
('CATE_3', 'Home and Kitchen Appliances'),
('CATE_4', 'Health and Beauty'),
('CATE_5', 'Automotive'),
('CATE_6', 'Sports and Outdoors'),
('CATE_7', 'Home and Furniture')

INSERT INTO PRODUCT(pro_id, cate_id, pro_name, price) VALUES
('PRO_1', 'CATE_1', 'Smartphone', 999.000),
('PRO_2', 'CATE_2', 'Jeans', 20.000),
('PRO_3', 'CATE_3', 'Refrigerator', 200.000),
('PRO_4', 'CATE_4', 'Hair Dryer', 60.000),
('PRO_5', 'CATE_5', 'Sedan', 700.000),
('PRO_6', 'CATE_6', 'Running Shoes', 50.000),
('PRO_7', 'CATE_7', 'Sofa', 100.000)

SELECT * FROM PRODUCT WHERE price = 700.000;