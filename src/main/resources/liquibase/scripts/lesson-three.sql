--liquibase formatted sql

--changeset vmish:1

CREATE INDEX students_name_index ON student(name);

--changeset vmish:2

CREATE INDEX faculty_nc_index ON faculty(name, color);