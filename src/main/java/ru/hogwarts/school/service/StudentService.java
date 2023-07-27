package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.StudentsCategories;

import java.util.Collection;
import java.util.List;

public interface StudentService {
    Student findStudent(Long id);

    Student createStudent(Student student);

    Student editStudent(Student student);

    void deleteStudent(Long id);

    Object findAllByAgeBetween(int min, int max);

    Object findStudentsByFaculty(Faculty faculty);

    Collection<Student> getAll();
    Integer getSumAllStudents();
    Integer getAvgAgeAllStudents();
    List<StudentsCategories> getFiveLastStudents ();
    List<String> findAllStudentsWhomNameStartWith(String let);
    Double getAvgAgeAllStudentsStream();
}
