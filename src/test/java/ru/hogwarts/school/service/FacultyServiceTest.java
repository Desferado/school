package ru.hogwarts.school.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.hogwarts.school.model.Faculty;

import static org.junit.jupiter.api.Assertions.*;
import static ru.hogwarts.school.FacultyConstants.*;

class FacultyServiceTest {
      private final FacultyService facultyService = new FacultyService();

      @BeforeEach
      public void createCollection(){
          facultyService.createFaculty(faculty3);
          facultyService.createFaculty(faculty1);
          facultyService.createFaculty(faculty2);
      }


    @Test
    void findFaculty() {
        Faculty expected = facultyService.findFaculty(id);
        Assertions.assertEquals(expected,faculty3);
    }

    @Test
    void editFaculty() {
        Faculty expected = facultyService.createFaculty(faculty2);
        Assertions.assertEquals(expected,faculty2);
    }

    @Test
    void deleteFaculty() {
        Faculty expected = facultyService.deleteFaculty(0);
        assertNull(expected);
    }
}