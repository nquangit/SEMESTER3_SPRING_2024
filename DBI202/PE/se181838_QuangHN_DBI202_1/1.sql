CREATE TABLE Staff (
	StaffID NCHAR(7) PRIMARY KEY,
	Phone NCHAR(10),
	Name NVARCHAR(30)
)

CREATE TABLE Event(
	EventID NCHAR(20) PRIMARY KEY,
	EventName NVARCHAR(30)
)

CREATE TABLE Work (
	Hours FLOAT,
	StaffID NCHAR(7),
	EventID NCHAR(20),
	CONSTRAINT Fk_Staff FOREIGN KEY (StaffID) REFERENCES Staff(StaffID),
	CONSTRAINT Fk_Event FOREIGN KEY (EventID) REFERENCES Event(EventID)
)