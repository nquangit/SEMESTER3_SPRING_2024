
SELECT c.customer_id, CONCAT(c.first_name, ' ', c.last_name) AS full_name, COUNT(o.order_id) AS number_of_order
FROM customers c
LEFT JOIN orders o ON c.customer_id = o.customer_id
GROUP BY c.customer_id, CONCAT(c.first_name, ' ', c.last_name)
ORDER BY number_of_order DESC;