package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;


import java.util.Collection;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    public Faculty createFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty (Long id){
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty editFaculty (Faculty faculty){
        return facultyRepository.save(faculty);
    }
    public void deleteFaculty (Long id){
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> findByColor (String color) {
        return  facultyRepository.findByColorIgnoreCase(color);
    }
    public Collection<Faculty> findByName (String name) {
        return  facultyRepository.findByNameIgnoreCase(name);
    }
    public Faculty findFacultyByStudents(Student student){return  facultyRepository.findFacultyByStudents((student));}

}