USE FilmManager;

DROP TABLE IF EXISTS FilmActor;
DROP TABLE IF EXISTS Actor;
DROP TABLE IF EXISTS Film;
DROP TABLE IF EXISTS FilmCategory;


CREATE TABLE Actor (
	ActorID SMALLINT PRIMARY KEY,
	ActorFirstName NVARCHAR(50),
	ActorLastName NVARCHAR(50),
	ActorBirth SMALLDATETIME
)

CREATE TABLE FilmCategory (
	CateID SMALLINT PRIMARY KEY,
	CateName NVARCHAR(50)
)

CREATE TABLE Film (
	FilmID SMALLINT PRIMARY KEY,
	FilmTitle NVARCHAR(100),
	FilmLength SMALLINT,
	FilmRating VARCHAR(10),
	CateID SMALLINT,
	CONSTRAINT FK_Film FOREIGN KEY (CateID) REFERENCES FilmCategory(CateID)
)

CREATE TABLE FilmActor (
	ActorID SMALLINT,
	FilmID SMALLINT,
	Active BIT NOT NULL,
	LastUpdated SMALLDATETIME NOT NULL,
	JoinedDate SMALLDATETIME NOT NULL,
	CONSTRAINT PK_FilmActor PRIMARY KEY(ActorID, FilmID),
	CONSTRAINT CK_Dates CHECK(LastUpdated <= GETDATE() AND JoinedDate <= GETDATE() AND JoinedDate <= LastUpdated), 
	CONSTRAINT FK_Actor FOREIGN KEY (ActorID) REFERENCES Actor(ActorID),
	CONSTRAINT FK_FilmActor FOREIGN KEY (FilmID) REFERENCES Film(FilmID)
)


INSERT INTO Actor (ActorID, ActorFirstName, ActorLastName, ActorBirth) VALUES
(1, 'ALEC', 'HAMMOND', '1990-10-03'),
(2, 'RICHARD', 'MAY', '1989-05-15'),
(3, 'JAMES', 'CLARKSON', '1979-12-17'),
(4, 'JEREMY', 'CLARKSON', '1960-04-11'),
(5, 'MATT', 'LEBLANC', '1967-07-25'),
(6, 'SABINE', 'SCHMITZ', '1969-05-14'),
(7, 'CHRIS', 'HARRIS', '1975-01-20'),
(8, 'RORY', 'REID', '1979-01-11'),
(9, 'THE', 'STIG', '2000-01-02'),
(10, 'FRED', 'FLINTSTONE', '1999-05-03');

INSERT INTO FilmCategory (CateID, CateName)
VALUES
(1, 'MUSIC'),
(2, 'ACTION'),
(3, 'DRAMA'),
(4, 'COMEDY'),
(5, 'ROMANCE'),
(6, 'HORROR'),
(7, 'DOCUMENTARY'),
(8, 'SCIENCE FICTION'),
(9, 'FANTASY'),
(10, 'THRILLER'),
(11, 'ANIMATION'),
(12, 'ADVENTURE'),
(13, 'CRIME'),
(14, 'MYSTERY'),
(15, 'FAMILY'),
(16, 'WAR'),
(17, 'WESTERN'),
(18, 'SPORT'),
(19, 'FANTASY'),
(20, 'SUPERHERO'),
(21, 'ROMANTIC COMEDY'),
(22, 'MUSICAL'),
(23, 'BIOPIC'),
(24, 'TECHNOLOGY'),
(25, 'FUTURISTIC'),
(26, 'ESPIONAGE'),
(27, 'SUPERNATURAL'),
(28, 'CULINARY'),
(29, 'POLITICAL'),
(30, 'TIME TRAVEL'),
(31, 'SURREAL'),
(32, 'MARTIAL ARTS'),
(33, 'ESPIONAGE'),
(34, 'PSYCHOLOGICAL THRILLER'),
(35, 'COMING OF AGE'),
(36, 'UTOPIAN'),
(37, 'DYSTOPIAN'),
(38, 'MAGICAL REALISM'),
(39, 'EPISTOLARY'),
(40, 'ZOMBIE APOCALYPSE');


INSERT INTO Film (FilmID, FilmTitle, FilmRating, FilmLength, CateID) VALUES
(1, 'AFRICAN EGG', 'R', 170, 7),
(2, 'MYSTICAL SUNSET', 'PG-13', 125, 8),
(3, 'COSMIC JOURNEY', 'PG', 110, 5),
(4, 'THRILLING ADVENTURE', 'PG-13', 145, 9),
(5, 'TIMELESS LOVE', 'PG', 120, 3),
(6, 'EXPLOSION CHRONICLES', 'R', 155, 7),
(7, 'ECHOES OF SILENCE', 'PG', 135, 23),
(8, 'WONDERS OF NATURE', 'G', 100, 22),
(9, 'HAUNTED NIGHT', 'R', 180, 16),
(10, 'FANTASY REALM', 'PG', 150, 1),
(11, 'MAGIC MEADOW', 'G', 95, 18),
(12, 'SPACETIME ODYSSEY', 'PG-13', 130, 30),
(13, 'SECRET GARDEN', 'PG', 110, 21),
(14, 'CITY OF LIGHTS', 'R', 160, 29),
(15, 'UNDERWATER EXPLORERS', 'PG', 115, 12),
(16, 'HEIST OF THE CENTURY', 'R', 140, 13),
(17, 'SERENADE IN THE SKY', 'G', 105, 22),
(18, 'MIND GAMES', 'PG-13', 125, 34),
(19, 'EPIC LOVE STORY', 'PG', 150, 35),
(20, 'JUNGLE QUEST', 'PG-13', 135, 12),
(21, 'CLOCKWORK CONUNDRUM', 'PG', 125, 31),
(22, 'FIRE AND ICE', 'R', 155, 19),
(23, 'ODYSSEY OF THE LOST', 'PG-13', 140, 14),
(24, 'DREAMSCAPE', 'G', 100, 27),
(25, 'INFERNO', 'R', 160, 33),
(26, 'WORLD OF WONDER', 'PG', 110, 8),
(27, 'LEGENDARY WARRIOR', 'PG-13', 145, 32),
(28, 'GASTRONOMIC DELIGHT', 'R', 170, 28),
(29, 'POLITICAL INTRIGUE', 'PG', 120, 29),
(30, 'TIMELESS ROMANCE', 'PG-13', 130, 5);


INSERT INTO FilmActor (ActorID, FilmID, Active, LastUpdated, JoinedDate) VALUES
(
    -- Subquery to get ActorID for actor whose first name is "ALEC"
	(SELECT ActorID FROM Actor WHERE ActorFirstName = 'ALEC'),
    -- Subquery to get FilmID for film title "AFRICAN EGG"
	(SELECT FilmID FROM Film WHERE FilmTitle = 'AFRICAN EGG'),
    1, -- Active is set to 1
    DATEADD(day, -5, GETDATE()), -- LastUpdate is 5 days ago
    '2005-12-12' -- JoinedDate is Dec 12 2005
);

-- ADD MORE SAMPLE DATA
INSERT INTO FilmActor (ActorID, FilmID, Active, LastUpdated, JoinedDate) VALUES
(2, 2, 1, '2022-03-02', '2022-02-14'),
(2, 7, 0, '2020-03-08', '2019-10-04'),
(3, 3, 1, '2022-03-03', '2022-02-13'),
(4, 4, 1, '2022-03-04', '2022-02-12'),
(5, 5, 1, '2022-03-05', '2022-02-11'),
(6, 6, 1, '2022-03-06', '2022-02-10'),
(6, 3, 1, '2016-04-15', '2009-11-12'),
(7, 7, 1, '2022-03-07', '2022-02-09'),
(8, 8, 1, '2022-03-08', '2022-02-08'),
(9, 9, 1, '2022-03-09', '2022-02-07'),
(10, 10, 1, '2022-03-10', '2022-02-06');


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

-- EXE 3
SELECT FilmCategory.CateName AS 'name',
	COUNT(Film.FilmID) AS 'Number of films'
FROM FilmCategory
JOIN Film ON FilmCategory.CateID = Film.CateID
GROUP BY FilmCategory.CateID, FilmCategory.CateName
ORDER BY 'Number of films' ASC;

-- EXE 4
SELECT TOP 1
	FilmCategory.CateName AS 'name',
	COUNT(Film.FilmID) AS 'Number of films'
FROM FilmCategory
JOIN Film ON FilmCategory.CateID = Film.CateID
GROUP BY FilmCategory.CateID, FilmCategory.CateName
ORDER BY 'Number of films' DESC, 'name' ASC;

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

-- EXE 6
SELECT Film.FilmID AS film_id,
	Film.FilmTitle AS title,
	Film.FilmRating AS rating,
	Film.FilmLength AS 'length'
FROM Film
WHERE
	Film.FilmLength >= (SELECT Film.FilmLength FROM Film WHERE Film.FilmTitle = 'THEORY MERMAID')
	AND Film.FilmRating = (SELECT Film.FilmRating FROM Film WHERE Film.FilmTitle = 'THEORY MERMAID')

-- EXE 7
CREATE PROCEDURE NumberOfFilm
    @catName VARCHAR(25),
    @count INT OUTPUT
AS
BEGIN
    SELECT @count = COUNT(Film.FilmID)
    FROM FilmCategory
    JOIN Film ON FilmCategory.CateID = Film.CateID
    WHERE FilmCategory.CateName = @catName;
END;

DECLARE @filmCount INT;
EXEC NumberOfFilm 'DOCUMENTARY', @filmCount OUTPUT;
SELECT @filmCount

CREATE TRIGGER trgPreventDuplicateFilmTitle
ON Film
AFTER INSERT, UPDATE
AS
BEGIN
    IF EXISTS (
        SELECT 1
        FROM Film
        WHERE FilmTitle IN (SELECT FilmTitle FROM inserted)
    )
    BEGIN
        RAISERROR('Duplicate film title. Insertion aborted.', 16, 1);
        ROLLBACK;
    END
END;

