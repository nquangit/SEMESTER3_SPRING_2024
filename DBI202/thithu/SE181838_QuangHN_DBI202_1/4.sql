SELECT P.ProductID, P.Name AS ProductName, P.Color, P.Cost, P.Price, L.LocationID, L.Name AS LocationName, PI.Shelf, PI.Bin, PI.Quantity
FROM  [Product] AS P
LEFT OUTER JOIN [ProductInventory] AS PI ON PI.ProductID = P.ProductID
LEFT OUTER JOIN [Location] AS L ON PI.LocationID = L.LocationID
WHERE P.Color = 'Yellow'