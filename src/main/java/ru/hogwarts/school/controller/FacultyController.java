package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
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
    public ResponseEntity <Collection<Faculty>> findAllFaculty(
            @RequestParam(required = false) @PathVariable String color) {
        if (color != null && !color.isBlank()) {
            return ResponseEntity.ok(facultyService.findByColor(color));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }
    @GetMapping("{name}")
    public ResponseEntity<Faculty> deleteFaculty (@PathVariable String name){
        facultyService.findByName(name);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity <Collection<Faculty>> findFaculty(
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String name) {
        if (color != null && !color.isBlank()) {
            return ResponseEntity.ok(facultyService.findByColor(color));
        }
        if (name != null && !name.isBlank()){
            return ResponseEntity.ok(facultyService.findByName(name));
        }
         return ResponseEntity.notFound().build();
    }
}
