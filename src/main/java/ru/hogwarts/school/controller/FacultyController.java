package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.service.FacultyService;
import ru.hogwarts.school.model.Faculty;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping("faculty")
@RestController
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {

        this.facultyService = facultyService;
    }

    @GetMapping
    public List<Faculty> findFaculties(){
return null;
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {

        return facultyService.add(faculty);
    }

    @GetMapping("{facultyId}")
    public ResponseEntity<Faculty> findFaculty(@PathVariable Long facultyId) {
            Faculty foundFaculty = facultyService.find(facultyId);
            if(foundFaculty==null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(foundFaculty);
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
