
SELECT TOP 1
	Sum_Quantity.product_id, Sum_Quantity.product_name
FROM (
	SELECT
		p.product_id, p.product_name, SUM(oi.quantity) AS total_quantities
	FROM products p
	JOIN order_items oi ON p.product_id = oi.product_id
	JOIN orders o ON oi.order_id = o.order_id
	WHERE YEAR(o.order_date) = 2016
	GROUP BY p.product_id, p.product_name
) AS Sum_Quantity
ORDER BY Sum_Quantity.total_quantities DESC;

