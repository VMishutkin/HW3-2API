package ru.hogwarts.school.service;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentsRepository;

    private Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository) {

        this.studentsRepository = studentRepository;
    }

    public Student add(Student newStudent) {

        logger.info("Was invoked method for create student");
        return studentsRepository.save(newStudent);
    }

    public void remove(Long id) {

        logger.info("Was invoked method for delete student");
        studentsRepository.deleteById(id);
    }

    public Student edit(Student changedStudent) {

        logger.info("Was invoked method for edit student");
        return add(changedStudent);
    }

    public Student find(Long id) {

        logger.info("Was invoke method for search {id} student", id);
        return studentsRepository.findById(id).get();
    }

    public Collection<Student> findByAge(int age) {

        logger.info("Was invoke method for search student with age {age}", age);
        return studentsRepository.findStudentsByAge(age);
    }

    public Collection<Student> findByAgeInRange(int min, int max) {

        logger.info("Was invoke method for search students with age from {min} to {max}", min, max);
        return studentsRepository.findByAgeBetween(min, max);
    }

    public Faculty getFaculty(Long id) {

        logger.info("Was invoked method for get student");
        return studentsRepository.findById(id).orElseThrow().getFaculty();
    }

    public Integer countStudents() {

        logger.info("Was invoked method for count students");
        return studentsRepository.countStudents();
    }

    public Integer countAverageAge() {

        logger.info("Was invoked method for cout average age of all students");
        return studentsRepository.avgAge();
    }

    public List<Student> getAllStudents() {
        return studentsRepository.findAll();
    }

    public Collection<Student> findLastFiveStudents() {

        logger.info("Was invoked method for find last five students");
        return studentsRepository.findLastFiveStudents();
    }

    public List<Student> getStudentsByNameStartsWithA() {
        return getAllStudents().stream()
                .peek(s -> s.setName(s.getName().toUpperCase()))
                .filter(s -> s.getName().startsWith("A"))
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    public Double getAverageAge() {
        return getAllStudents().stream()
                .mapToInt(s -> s.getAge())
                .summaryStatistics()
                .getAverage();


    }

    public void getSixStudentsParallel() {
        List<Student> students = getAllStudents();
        if (students.size() > 5) {
            System.out.println(students.get(0).getName());
            System.out.println(students.get(1).getName());
            new Thread(() -> {
                System.out.println(students.get(2).getName());
                System.out.println(students.get(3).getName());
            }).start();
            new Thread(() -> {
                System.out.println(students.get(4).getName());
                System.out.println(students.get(5).getName());
            }).start();
        }


    }

    public void printNameSync(Student... students) {

            Arrays.stream(students).forEach((s) -> System.out.println(s));

    }

    public void getSixStudentsSync() {
        List<Student> students = getAllStudents();
        if (students.size() > 5) {

            synchronized (this) {
                printNameSync(students.get(0), students.get(1));
            }
            new Thread(() -> {
                synchronized (this) {
                    printNameSync(students.get(2), students.get(3));
                }
            }).start();
            new Thread(() -> {
                synchronized (this) {
                    printNameSync(students.get(4), students.get(5));
                }
            }).start();
        }
    }
}
