package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collections;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @GetMapping("{id}")
    public ResponseEntity <Faculty> getFaculty (@PathVariable Long  id){
        Faculty faculty = facultyService.findFaculty(id);
        return ResponseEntity.ok(faculty);
    }
    @PostMapping
    public Faculty createFaculty (@RequestBody Faculty faculty){
        return facultyService.createFaculty(faculty);
    }

    @PutMapping
    public ResponseEntity <Faculty> editFaculty(@RequestBody Faculty faculty){
        Faculty faculty1 = facultyService.editFaculty(faculty);
        return ResponseEntity.ok(faculty1);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> deleteFaculty (@PathVariable Long  id){
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{color}")
    public ResponseEntity.BodyBuilder findAllFacultyByColor(
            @RequestParam(required = false) @PathVariable String color) {
        if (color != null && !color.isBlank()) {
            facultyService.findByColor(color);
            return ResponseEntity.ok();
        }
        Collections.emptyList();
        return ResponseEntity.ok();
    }
    @GetMapping("{name}")
    public ResponseEntity<Faculty> deleteFaculty (@PathVariable String name){
        facultyService.findByName(name);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity.BodyBuilder findAllFaculty(
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String name) {
        if (color != null && !color.isBlank()) {
            facultyService.findByColor(color);
            return ResponseEntity.ok();
        }
        if (name != null && !name.isBlank()){
            facultyService.findByName(name);
            return ResponseEntity.ok();
        }

         return (ResponseEntity.BodyBuilder) ResponseEntity.notFound();
    }
    @GetMapping("/{id}/students")
    public ResponseEntity <Faculty> findFacultyByStudents (@RequestParam (required = false) Student student) {
        return ResponseEntity.ok((Faculty) facultyService.findFacultyByStudents(student));
    }
}
