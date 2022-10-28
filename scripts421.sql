ALTER TABLE student
    ADD CONSTRAINT age_constraint CHECK ( age> 15),
    ADD CONSTRAINT U_name UNIQUE(name),
ALTER COLUMN age SET DEFAULT 20;
ALTER TABLE faculty
    ADD CONSTRAINT color_name_unique UNIQUE (name, color);