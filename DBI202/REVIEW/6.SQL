-- EXE 6
SELECT Film.FilmID AS film_id,
	Film.FilmTitle AS title,
	Film.FilmRating AS rating,
	Film.FilmLength AS 'length'
FROM Film
WHERE
	Film.FilmLength >= (SELECT Film.FilmLength FROM Film WHERE Film.FilmTitle = 'THEORY MERMAID')
	AND Film.FilmRating = (SELECT Film.FilmRating FROM Film WHERE Film.FilmTitle = 'THEORY MERMAID')
