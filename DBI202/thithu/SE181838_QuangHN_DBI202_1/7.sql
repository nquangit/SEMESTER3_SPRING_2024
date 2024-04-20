
SELECT L.LocationID, L.Name AS LocationName, P.ProductID, P.Name AS ProductName, MAX(PI.Quantity) AS Quantity
FROM [Location] AS L
JOIN [ProductInventory] AS PI ON L.LocationID = PI.LocationID
JOIN [Product] AS P ON PI.ProductID = P.ProductID
GROUP BY L.LocationID, L.Name , P.ProductID, P.Name
ORDER BY LocationName ASC, ProductName DESC