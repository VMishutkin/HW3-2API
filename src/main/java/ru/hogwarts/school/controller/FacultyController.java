package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.service.FacultyService;
import ru.hogwarts.school.model.Faculty;

@RequestMapping("faculty")
@RestController
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createStudent(@RequestBody Faculty faculty) {
        return facultyService.add(faculty);
    }
    @GetMapping("{facultyId}")
    public Faculty findFaculty(@RequestParam Long facultyId){
        return facultyService.find(facultyId);
    }
    @PutMapping
    public Faculty updateFaculty(@RequestBody Faculty faculty){
        return facultyService.edit(faculty.getId(), faculty);
    }
    @DeleteMapping("{facultyId}")
    public Faculty removeFaculty(@RequestParam Long facultyId){
        return facultyService.remove(facultyId);
    }
}
