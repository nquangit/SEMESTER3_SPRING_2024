CREATE PROCEDURE staff_order
	@staffID INT,
	@countOrders INT OUTPUT
AS 
	SELECT @countOrders=COUNT(O.order_id)
	FROM orders O
	WHERE O.staff_id = @staffID
	GROUP BY O.staff_id
