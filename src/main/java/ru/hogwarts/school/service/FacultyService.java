package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {
    private final Map<Long, Faculty> faculties;
    private Long id;


    public FacultyService() {
        this.faculties = new HashMap<Long, Faculty>();
        id=0l;
    }

    public Faculty add(Faculty newFaculty){
        faculties.put(++id, newFaculty);
        return newFaculty;
    }

    public Faculty remove(Long id){
        Faculty removedFaculty = faculties.get(id);
        faculties.remove(id);
        return removedFaculty;
    }

    public Faculty edit(Long id, Faculty changedFaculty){
        faculties.put(id, changedFaculty);
        return changedFaculty;
    }

    public Faculty find(Long id){
        return faculties.get(id);
    }

}
