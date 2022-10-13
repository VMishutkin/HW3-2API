package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;


    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty add(Faculty newFaculty){
        return facultyRepository.save(newFaculty);
    }

    public void remove(Long id){
        facultyRepository.deleteById(id);
    }

    public Faculty edit( Faculty changedFaculty){
        return add(changedFaculty);
    }

    public Faculty find(Long id){

        return facultyRepository.findById(id).get();
    }

}
