SELECT P.product_id, P.product_name, SUM(S.quantity) AS 'sum of quantity on stocks'
FROM products P
JOIN stocks S ON P.product_id = S.product_id
LEFT JOIN order_items OI ON P.product_id = OI.product_id
WHERE OI.order_id IS NULL
GROUP BY P.product_id, P.product_name