package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface FacultyService {
    Faculty findFaculty(Long id);

    Faculty createFaculty(Faculty faculty);

    Faculty editFaculty(Faculty faculty);

    void deleteFaculty(Long id);

    Object findByColor(String color);

    Collection<Faculty> findByName(String name);

    Object findFacultyByStudents(Student student);
}
