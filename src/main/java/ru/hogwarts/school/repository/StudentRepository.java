package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
   Collection<Student> findByAge(int age);
   Student findByName(String name);
   Collection<Student> findByAgeBetween(int min, int max);
   Collection<Student> findStudentsByFaculty (Faculty faculty);
   Optional<Student> findById(Long studentId);
}
