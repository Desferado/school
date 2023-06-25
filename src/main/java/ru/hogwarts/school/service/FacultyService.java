package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
@Service
public class FacultyService {
    private final HashMap<Long, Faculty> facultyMap = new HashMap<>();
    private long counter = 0;


    public Faculty createFaculty(Faculty faculty){
        faculty.setId(++counter);
        facultyMap.put(counter,faculty);
        return faculty;
    }

    public Faculty findFaculty (long id){
        return facultyMap.get(id);
    }

    public Faculty editFaculty (Faculty faculty){
        facultyMap.put(faculty.getId(),faculty);
        return faculty;
    }
    public Faculty deleteFaculty (long id){
        return facultyMap.remove(id);
    }

    public Collection<Faculty> findByColor (String color) {
        Collection<Faculty> facultyCollection = new ArrayList<>();
        for (Faculty faculty: facultyMap.values()) {
            if (faculty.getColor().equals(color)){
                facultyCollection.add(faculty);
            }
        }
        return facultyCollection;
    }
}
