-- EXE 1
SELECT FilmActor.ActorID AS staff_id,
	Actor.ActorFirstName AS first_name,
	Actor.ActorLastName AS last_name
FROM FilmActor
JOIN Actor ON FilmActor.ActorID = Actor.ActorID
WHERE Active = 1
GROUP BY FilmActor.ActorID, Actor.ActorFirstName, Actor.ActorLastName
ORDER BY staff_id ASC;

-- EXE 2
SELECT Film.FilmID AS film_id,
	Film.FilmTitle AS title,
	Film.FilmLength AS 'length',
	Film.FilmRating AS rating
FROM Film
JOIN FilmCategory ON Film.CateID = FilmCategory.CateID
WHERE Film.FilmLength >= 170
ORDER BY film_id;