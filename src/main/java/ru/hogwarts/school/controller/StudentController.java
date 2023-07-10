package ru.hogwarts.school.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;


@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public Collection<Student> getAll(){ return studentService.getAll();}

    @PostMapping
    public Student createStudent (@RequestBody Student student){
        return studentService.createStudent(student);
    }
    @PutMapping
    public ResponseEntity <Student> editStudent(@RequestBody Student student){
        Student student1 = studentService.editStudent(student);
        if (student1 == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(student1);
    }

    @GetMapping("{id}")
    public ResponseEntity <Student> getStudent (@PathVariable Long  id){
        Student student = studentService.findStudent(id);
        if (student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity <Student> deleteStudent (@PathVariable Long  id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("age")
    public ResponseEntity.BodyBuilder findAllStudentByAge(
            @RequestParam (required = false) int min,
            @RequestParam (required = false) int max) {
        studentService.findAllByAgeBetween(min, max);
        return ResponseEntity.ok();
    }
    @GetMapping("/faculty")
    public ResponseEntity.BodyBuilder findStudentsByFaculty (@RequestParam (required = false) Faculty faculty) {
        studentService.findStudentsByFaculty(faculty);
        return ResponseEntity.ok();
    }
}
