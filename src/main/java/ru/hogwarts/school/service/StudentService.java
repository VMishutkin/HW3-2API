package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentsRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentsRepository = studentRepository;
    }

    public Student add(Student newStudent) {
        return studentsRepository.save(newStudent);
    }

    public void remove(Long id) {
        studentsRepository.deleteById(id);
    }

    /*  public Student edit(Long id, Student changedStudent) {
          studentsRepository.put(id, changedStudent);
        return changedStudent;
    }
*/
    public Student find(Long id) {
    return studentsRepository.findById(id).get();
    }

}
