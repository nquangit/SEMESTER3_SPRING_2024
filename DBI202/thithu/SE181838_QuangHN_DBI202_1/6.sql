
SELECT TOP 1
	P.ProductID,
	P.Name,
	SUM(PI.Quantity) AS TotalQuantity
FROM [Product] AS P
JOIN [ProductInventory] AS PI ON P.ProductID = P.ProductID
GROUP BY P.ProductID, P.Name
ORDER BY TotalQuantity DESC;