
SELECT PM.ModelID,
	PM.Name AS ModelName,
	COUNT(P.ModelID) AS NumberOfProducts
FROM [ProductModel] AS PM
JOIN [Product] AS P ON PM.ModelID = P.ModelID
GROUP BY PM.ModelID, PM.Name
ORDER BY NumberOfProducts DESC