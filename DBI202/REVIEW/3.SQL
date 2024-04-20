-- EXE 3
SELECT FilmCategory.CateName AS 'name',
	COUNT(Film.FilmID) AS 'Number of films'
FROM FilmCategory
JOIN Film ON FilmCategory.CateID = Film.CateID
GROUP BY FilmCategory.CateID, FilmCategory.CateName
ORDER BY 'Number of films' ASC;