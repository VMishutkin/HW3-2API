package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    private final StudentRepository studentsRepository;

    public StudentService(StudentRepository studentRepository) {

        this.studentsRepository = studentRepository;
    }

    public Student add(Student newStudent) {
        return studentsRepository.save(newStudent);
    }

    public void remove(Long id) {
        studentsRepository.deleteById(id);
    }

    public Student edit(Student changedStudent) {
        return add(changedStudent);
    }

    public Student find(Long id) {
        return studentsRepository.findById(id).get();
    }

    public Collection<Student> findByAge(int age) {
        return studentsRepository.findStudentsByAge(age);
    }

    public Collection<Student> findByAgeInRange(int min, int max) {
        return studentsRepository.findByAgeBetween(min, max);
    }

    public Faculty getFaculty(Long id){
        return studentsRepository.findById(id).orElseThrow().getFaculty();
    }

    public Integer countStudents(){
        return studentsRepository.countStudents();
    }
    public Integer countAverageAge(){
        return studentsRepository.avgAge();
    }
    public Collection<Student> findLastFiveStudents(){
        return studentsRepository.findLastFiveStudents();
    }

}
