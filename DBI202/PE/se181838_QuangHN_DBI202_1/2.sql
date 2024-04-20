
SELECT c.customer_id, c.first_name,	c.last_name, c.city
FROM [customers] c
WHERE c.city = 'Liverpool'
ORDER BY c.customer_id DESC;