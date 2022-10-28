package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    Logger logger = LoggerFactory.getLogger(FacultyService.class);


    public FacultyService(FacultyRepository facultyRepository) {

        this.facultyRepository = facultyRepository;
    }

    public Faculty add(Faculty newFaculty){

        logger.info("Was invoked method for create faculty");
        return facultyRepository.save(newFaculty);
    }

    public void remove(Long id){

        logger.info("Was invoked method for delete faculty");
        facultyRepository.deleteById(id);
    }

    public Faculty edit( Faculty changedFaculty){

        logger.info("Was invoked method for edit faculty");
        return add(changedFaculty);
    }

    public Faculty find(Long id){

        logger.info("Was invoked method for find faculty by id {id}", id);
        return facultyRepository.findById(id).orElseThrow();
    }

    public Collection<Faculty> findByColor(String color){

        logger.info("Was invoked method for find faculty by color");
        return facultyRepository.findFacultiesByColorIgnoreCase(color);
    }
    public Collection<Faculty> findByName(String name){

        logger.info("Was invoked method for find faculty by name");
        return facultyRepository.findFacultiesByNameIgnoreCase(name);
    }

    public Collection<Student> getStudents(Long id){

        logger.info("Was invoked method for get students of faculty with id {id}", id);

        return find(id).getStudents();
    }

    public List<Faculty> getAllFaculties(){
        return facultyRepository.findAll();
    }

    public String getLongestName() {
        return getAllFaculties().stream()
                .map(s -> s.getName())
                .max(Comparator.comparingInt(String::length)).orElseThrow();

    }
}
