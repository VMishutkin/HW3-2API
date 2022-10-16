package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;
import ru.hogwarts.school.model.Faculty;

import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.List;

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
    @GetMapping("/{facultyId}/students")
    public Collection<Student> getStudents(@PathVariable Long facultyId){
        return facultyService.getStudents(facultyId);
    }

    @GetMapping("{facultyId}")
    public ResponseEntity<Faculty> findFaculty(@PathVariable Long facultyId) {
            Faculty foundFaculty = facultyService.find(facultyId);
            if(foundFaculty==null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(foundFaculty);
    }
    @GetMapping()
    public ResponseEntity find(@RequestParam(required = false) String name,
                                    @RequestParam(required = false) String color){
        if(name !=null && !name.isBlank()) {
            return ResponseEntity.ok(facultyService.findByName(name));
        }
        if(color !=null && !color.isBlank()) {
            return ResponseEntity.ok(facultyService.findByColor(color));
        }
            return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public Faculty updateFaculty(@RequestBody Faculty faculty) {

        return facultyService.edit(faculty);
    }

    @DeleteMapping("{facultyId}")
    public ResponseEntity removeFaculty(@PathVariable Long facultyId) {

        facultyService.remove(facultyId);
        return ResponseEntity.ok().build();
    }

}
