package ru.hogwarts.school.service;


import java.util.Collection;
import java.util.List;
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
    public Double getAvgAgeAllStudentsStream(){
        logger.info("Was invoked method for get average age all students");
        List <Student> students = studentRepository.findAll();
        return students.stream().map(Student::getAge).mapToInt(Integer::intValue).average().getAsDouble();
    }
    public void getThreads(){
        List <Student> students = studentRepository.findAll();
        printStudentName(students.get(0));
         printStudentName(students.get(1));
        new Thread (()->{
        printStudentName(students.get(2));
        printStudentName(students.get(3));}).start();
        new Thread (()->{
        printStudentName(students.get(4));
        printStudentName(students.get(5));}).start();
    }
    private void printStudentName(Student student){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(student.getName());
    }
    public void getSynchroThreads(){
        List <Student> students = studentRepository.findAll();
        printStudentNameSynchro(students.get(0));
        printStudentNameSynchro(students.get(1));
        new Thread (()->{
            printStudentNameSynchro(students.get(2));
            printStudentNameSynchro(students.get(3));}).start();
        new Thread (()->{
            printStudentNameSynchro(students.get(4));
            printStudentNameSynchro(students.get(5));}).start();
    }
    private synchronized void printStudentNameSynchro(Student student){
        System.out.println(student.getName());
    }

}
