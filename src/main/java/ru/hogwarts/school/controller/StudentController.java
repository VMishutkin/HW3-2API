package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.StudentService;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

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
    public ResponseEntity<Student> findStudent(@PathVariable Long studentId){
        Student foundStudent = studentService.find(studentId);
        if(foundStudent==null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(foundStudent);
    }
    @PutMapping
    public Student updateStudent(@RequestBody Student student){
        return studentService.edit(student);
    }
    @DeleteMapping("{studentId}")
    public ResponseEntity removeStudent(@PathVariable Long studentId){
        studentService.remove(studentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping({"byAge/{age}"})
    public Collection<Student> findStudentsByAge(@PathVariable int age){
        return studentService.findByAge(age);
    }

    @GetMapping("byAge")
    public Collection<Student> findStudentsByAgeInRange(@RequestParam int min, @RequestParam int max){
        return studentService.findByAgeInRange(min,max);
    }

    @GetMapping("{studentId}/faculty")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long studentId){
        return ResponseEntity.ok(studentService.getFaculty(studentId));
    }



}
