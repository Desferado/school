package ru.hogwarts.school.service;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;
import ch.qos.logback.classic.Logger;

import java.util.Collection;


@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepository;
    private final Logger logger = (Logger) LoggerFactory.getLogger(StudentServiceImpl.class);

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
    this.facultyRepository = facultyRepository;
    }


    public Faculty createFaculty(Faculty faculty){
        logger.info("Was invoked method for create faculty");
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty (Long id){
        logger.info("Was invoked method for find faculty");
        return facultyRepository.findById(id).orElseGet(() -> {
            logger.warn("There is not faculty with id = " + id);
            return null;
        });
    }

    public Faculty editFaculty (Faculty faculty){
        logger.info("Was invoked method for edit faculty");
        return facultyRepository.save(faculty);
    }
    public void deleteFaculty (Long id){
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> findByColor (String color) {
        logger.info("Was invoked method for find faculty by color");
        return  facultyRepository.findByColorIgnoreCase(color);
    }
    public Collection<Faculty> findByName (String name) {
        logger.info("Was invoked method for find faculty by name");
        return  facultyRepository.findByNameIgnoreCase(name);
    }
    public Faculty findFacultyByStudents(Student student){
        logger.info("Was invoked method for find faculty by student");
        return  facultyRepository.findFacultyByStudents((student));}

}
