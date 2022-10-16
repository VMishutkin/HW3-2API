package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public Collection<Student> findStudentsByAge(int age);

    public Collection<Student> findByAgeBetween(int min, int max);

    public Optional<Student> findById(Long id);


}
