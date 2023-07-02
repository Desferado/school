package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Student findStudent (Long id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student editStudent (Student student){
        return studentRepository.save(student);
    }
    public void deleteStudent (Long id){
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAge(int age) {
        return studentRepository.findByAge(age);
    }
    public Collection<Student> findByAgeBetween (int min, int max){
        return studentRepository.findByAgeBetween(min,max);
    }
    public Student findByName(String name){
        return studentRepository.findByName(name);
    }
    public Collection<Student> findStudentsByFaculty (Faculty faculty) {return studentRepository.findStudentsByFaculty(faculty);}
}
