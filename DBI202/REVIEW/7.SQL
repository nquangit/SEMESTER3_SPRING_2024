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