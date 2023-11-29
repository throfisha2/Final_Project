CREATE TABLE IF NOT EXISTS PROJECTS
(
    ID INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    NAME VARCHAR(30) NOT NULL UNIQUE
    );

CREATE TABLE IF NOT EXISTS DEPARTMENT(
    ID INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    NAME VARCHAR(30) NOT NULL,
    NUMBER INTEGER NOT NULL,
    PROJECT_ID INTEGER REFERENCES PROJECTS(ID)

    CONSTRAINT NUMBER_CHECK CHECK ( NUMBER >= 1 AND NUMBER <= 30 )
    );

CREATE TABLE IF NOT EXISTS EMPLOYEES
(
    ID INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    FIRSTNAME VARCHAR(30) NOT NULL,
    LASTNAME VARCHAR(30) NOT NULL,
    POSITION VARCHAR(30) NOT NULL,
    DEPARTMENT_ID INTEGER REFERENCES DEPARTMENT(ID)

);