
CREATE FUNCTION OrderPrice(
	@orderId INT
) AS DECIMAL
	DECLARE @sum_of_list_price DECIMAL
	SELECT @sum_of_list_price=SUM(OI.list_price)
	FROM order_items OI
	RETURN @sum_of_list_price
