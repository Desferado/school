-- liquibase formatted sql

-- changeset dfedorov:1
CREATE INDEX student_name_id ON student (name);
-- changeset dfedorov:2
CREATE INDEX faculty_nc_id ON faculty (name,color);