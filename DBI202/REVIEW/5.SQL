-- EXE 5
SELECT
    Actor.ActorID,
    Actor.ActorFirstName,
    COUNT(FilmActor.FilmID) AS 'Number of films'
FROM
    Actor
JOIN
    FilmActor ON Actor.ActorID = FilmActor.ActorID
GROUP BY
    Actor.ActorID, Actor.ActorFirstName
HAVING
    COUNT(FilmActor.FilmID) > 90
ORDER BY
    'Number of films' ASC;