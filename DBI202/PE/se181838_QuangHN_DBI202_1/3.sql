
SELECT c.customer_id, c.first_name, c.last_name, c.city, c.state
FROM [customers] c
WHERE c.city = 'Bellmore' OR c.city = 'New York'
ORDER BY c.city ASC, c.customer_id ASC;