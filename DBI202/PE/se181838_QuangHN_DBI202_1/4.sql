
SELECT p.product_id, p.product_name, p.list_price
FROM [products] p
WHERE p.list_price >= 1500 AND p.list_price <= 2000;