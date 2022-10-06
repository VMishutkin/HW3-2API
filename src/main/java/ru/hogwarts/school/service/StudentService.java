package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {
    private final Map<Long, Student> students;
    private Long id;

    public StudentService() {
        this.students = new HashMap<Long, Student>();
        id=0l;
    }

    public Student add(Student newStudent){
        newStudent.setId(++id);
        students.put(id, newStudent);
        return newStudent;
    }

    public Student remove(Long id){
        Student removedStudent = students.get(id);
        students.remove(id);
        return removedStudent;
    }

    public Student edit(Long id, Student changedStudent){
        students.put(id, changedStudent);
        return changedStudent;
    }

    public Student find(Long id){
        return students.get(id);
    }

}
