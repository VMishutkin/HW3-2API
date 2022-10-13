package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
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
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.add(faculty);
    }

    @GetMapping("{facultyId}")
    public ResponseEntity<Faculty> findFaculty(@RequestParam Long facultyId) {

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public Faculty updateFaculty(@RequestBody Faculty faculty) {
        return facultyService.add(faculty);
    }

    @DeleteMapping("{facultyId}")
    public Faculty removeFaculty(@RequestParam Long facultyId) {
        return facultyService.remove(facultyId);
    }
}
