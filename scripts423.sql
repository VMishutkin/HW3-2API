SELECT S.name, S.age, faculty.name FROM student as S JOIN faculty ON S.faculty_id = faculty.id ;
SELECT S.name, S.age FROM student as S JOIN avatar a on S.id = a.student_id