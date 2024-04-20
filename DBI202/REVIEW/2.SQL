-- EXE 2
SELECT Film.FilmID AS film_id,
	Film.FilmTitle AS title,
	Film.FilmLength AS 'length',
	Film.FilmRating AS rating
FROM Film
JOIN FilmCategory ON Film.CateID = FilmCategory.CateID
WHERE Film.FilmLength >= 170
ORDER BY film_id;