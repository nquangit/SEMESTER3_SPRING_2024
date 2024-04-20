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