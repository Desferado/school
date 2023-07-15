package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.StudentsCategories;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
   @Query (value = "SELECT COUNT(name) FROM student", nativeQuery = true)
   Integer getSumAllStudents ();
   @Query (value = "SELECT AVG(age) FROM student", nativeQuery = true)
   Integer getAvgAgeAllStudents ();
   @Query (value = "SELECT * FROM student ORDER BY id DESC LIMIT 5", nativeQuery = true)
   List<StudentsCategories> getFiveLastStudents ();
   Collection<Student> findByAge(int age);
   Student findByName(String name);
   Collection<Student> findByAgeBetween(int min, int max);
   Collection<Student> findStudentsByFaculty (Faculty faculty);
   Optional<Student> findById(Long studentId);
}
