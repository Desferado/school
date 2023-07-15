package ru.hogwarts.school.service;


import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.StudentsCategories;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.model.Faculty;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Student findStudent (Long id){
        return studentRepository.findById(id).orElse(null);
    }
    public Collection<Student> getAll (){return studentRepository.findAll();}

    public Student editStudent (Student student){
        return studentRepository.save(student);
    }
    public void deleteStudent (Long id){
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAge(int age) {
        return studentRepository.findByAge(age);
    }
    public Collection<Student> findAllByAgeBetween (int min, int max){
        return studentRepository.findByAgeBetween(min,max);
    }
    public Collection<Student> findStudentsByFaculty (Faculty faculty) {return studentRepository.findStudentsByFaculty(faculty);}

    public Integer getSumAllStudents(){
        return studentRepository.getSumAllStudents();
    }
    public Integer getAvgAgeAllStudents(){
        return studentRepository.getAvgAgeAllStudents();
    }
    public List<StudentsCategories> getFiveLastStudents (){
        return studentRepository.getFiveLastStudents();
    }
}
