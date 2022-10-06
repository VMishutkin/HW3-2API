package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.service.StudentService;
import ru.hogwarts.school.model.Student;

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
    public Student findStudent(@RequestParam Long studentId){
        return studentService.find(studentId);
    }
    @PutMapping
    public Student updateStudent(@RequestBody Student student){
        return studentService.edit(student.getId(), student);
    }
    @DeleteMapping("{studentId}")
    public Student removeStudent(@RequestParam Long studentId){
        return studentService.remove(studentId);
    }



}
