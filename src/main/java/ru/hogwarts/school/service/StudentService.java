package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface StudentService {
    Student findStudent(Long id);

    Student createStudent(Student student);

    Student editStudent(Student student);

    void deleteStudent(Long id);

    Object findAllByAgeBetween(int min, int max);

    Object findStudentsByFaculty(Faculty faculty);

    Collection<Student> getAll();
}
