-- USE [PE_DBI202_SPring2024];

CREATE TRIGGER Tri_Del ON stocks
AFTER DELETE
AS
	SELECT P.product_id, P.product_name, D.store_id, S.store_name, D.quantity
	FROM products P
	JOIN deleted D ON P.product_id = D.product_id
	JOIN stores S ON D.store_id = S.store_id

