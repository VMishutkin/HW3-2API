SELECT S.name, S.age, faculty.name FROM student as S JOIN faculty ON S.faculty = faculty.id ;
SELECT S.name, S.age FROM student as S RIGHT JOIN avatar a on S.id = a.student_id