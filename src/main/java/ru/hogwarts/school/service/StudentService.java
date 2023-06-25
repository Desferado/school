package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
@Service
public class StudentService {
    private final HashMap<Long, Student> studentMap = new HashMap<>();
    private long counter = 0;
    public Student createStudent(Student student){
        student.setId(++counter);
        studentMap.put(counter,student);
        return student;
    }

    public Student findStudent (long id){
        return studentMap.get(id);
    }

    public Student editStudent (Student student){
        studentMap.put(student.getId(),student);
        return student;
    }
    public Student deleteStudent (long id){
        return studentMap.remove(id);
    }

    public Collection<Student> findByAge(int age) {
        Collection<Student> studentCollection = new ArrayList<>();
        for (Student student: studentMap.values()) {
            if (student.getAge() == age){
                studentCollection.add(student);
            }
        }
        return studentCollection;
    }
}
