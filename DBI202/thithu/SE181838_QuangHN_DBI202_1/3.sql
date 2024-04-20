SELECT [ProductInventory].ProductID, [ProductInventory].LocationID, [ProductInventory].Quantity
FROM [ProductInventory]
WHERE [ProductInventory].LocationID = 7 AND [ProductInventory].Quantity > 250