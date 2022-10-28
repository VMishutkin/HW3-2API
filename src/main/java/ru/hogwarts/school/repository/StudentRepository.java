package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findStudentsByAge(int age);

    Collection<Student> findByAgeBetween(int min, int max);

    @Query(value = "SELECT COUNT(id) FROM student", nativeQuery = true)
    Integer countStudents();

    @Query(value = "SELECT AVG(age) FROM student", nativeQuery = true)
    Integer avgAge();

    @Query(value = "SELECT * FROM student ORDER BY ID DESC LIMIT 5", nativeQuery = true)
    Collection<Student> findLastFiveStudents();



}
