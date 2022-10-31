package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.StudentService;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

@RequestMapping("student")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.add(student);
    }

    @GetMapping("{studentId}")
    public ResponseEntity<Student> findStudent(@PathVariable Long studentId) {
        Student foundStudent = studentService.find(studentId);
        if (foundStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.edit(student);
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity removeStudent(@PathVariable Long studentId) {
        studentService.remove(studentId);
        return ResponseEntity.ok().build();
    }


    @GetMapping({"byAge/{age}"})
    public Collection<Student> findStudentsByAge(@PathVariable int age) {
        return studentService.findByAge(age);
    }

    @GetMapping("byAge")
    public Collection<Student> findStudentsByAgeInRange(@RequestParam int min, @RequestParam int max) {
        return studentService.findByAgeInRange(min, max);
    }

    @GetMapping("/count")
    public Integer countStudents() {
        return studentService.countStudents();
    }

    @GetMapping("/avgage")
    public Integer printAverageAge() {
        return studentService.countAverageAge();
    }

    @GetMapping("/lastfive")
    public Collection<Student> printLastFiveStudents() {
        return studentService.findLastFiveStudents();
    }

    @GetMapping("getfaculty/{studentId}")
    public Faculty getFaculty(@PathVariable Long studentId) {
        return studentService.getFaculty(studentId);
    }

    @GetMapping("/nameStartsWithA")
    public List<Student> getStudentsByNameStartsWithA() {
        return studentService.getStudentsByNameStartsWithA();
    }

    @GetMapping("/getAverageAge")
    public Double getAverageAge() {
        return studentService.getAverageAge();
    }

    @GetMapping("/getsix/parallel")
    public ResponseEntity getSixStudentsParallel() {
        studentService.getSixStudentsParallel();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getsix/sync")
    public ResponseEntity getSixStudentsSync() {
        studentService.getSixStudentsSync();
        return ResponseEntity.ok().build();
    }


}
