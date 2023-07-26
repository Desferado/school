package ru.hogwarts.school.service;


import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import ch.qos.logback.classic.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.StudentsCategories;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.model.Faculty;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final Logger logger = (Logger) LoggerFactory.getLogger(StudentServiceImpl.class);

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student){
        logger.info("Was invoked method for create student");
        return studentRepository.save(student);
    }

    public Student findStudent (Long id){
        logger.info("Was invoked method for find student");
        return studentRepository.findById(id).orElseGet(() -> {
            logger.warn("There is not student with id = " + id);
            return null;
        });
    }
    public Collection<Student> getAll (){
        logger.info("Was invoked method for get all students");
        return studentRepository.findAll();}

    public Student editStudent (Student student){
        logger.info("Was invoked method for edit student");
        return studentRepository.save(student);
    }
    public void deleteStudent (Long id){
        logger.info("Was invoked method for delete student");
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAge(int age) {
        return studentRepository.findByAge(age);
    }
    public Collection<Student> findAllByAgeBetween (int min, int max){
        logger.info("Was invoked method for find students by age between");
        return studentRepository.findByAgeBetween(min,max);
    }
    public Collection<Student> findStudentsByFaculty (Faculty faculty) {
        logger.info("Was invoked method for find students by faculty");
        return studentRepository.findStudentsByFaculty(faculty);}

    public Integer getSumAllStudents(){
        logger.info("Was invoked method for get sum all students");
        return studentRepository.getSumAllStudents();
    }
    public Integer getAvgAgeAllStudents(){
        logger.info("Was invoked method for get average age all students");
        return studentRepository.getAvgAgeAllStudents();
    }
    public List<StudentsCategories> getFiveLastStudents (){
        logger.info("Was invoked method for get five last students");
        return studentRepository.getFiveLastStudents();
    }
    public List<String> findAllStudentsWhomNameStartWith(String let){
        logger.info("Was invoked method for find all students who name start with ");
        String letUp = let.toUpperCase();
        List <Student> students = studentRepository.findAll();
        return students.stream()
                .map(p->p.getName().toUpperCase())
                .sorted()
                .filter(n->n.startsWith(letUp))
                .collect(Collectors.toList());
    }
}
