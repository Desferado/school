ALTER TABLE student
    ADD CONSTRAINT ageConstraint CHECK ( age > 16 );
ALTER TABLE student
    ADD CONSTRAINT nameConstraint UNIQUE (name);
ALTER TABLE student
    ALTER COLUMN name SET NOT NULL;
ALTER TABLE faculty
    ADD CONSTRAINT facultyConstraint UNIQUE (name, color);
ALTER TABLE student
    ALTER COLUMN age SET DEFAULT 20;