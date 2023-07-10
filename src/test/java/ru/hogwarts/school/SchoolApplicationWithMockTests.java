package ru.hogwarts.school;


import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.hogwarts.school.controller.StudentController;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.AvatarRepository;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.service.AvatarService;
import ru.hogwarts.school.service.FacultyService;
import ru.hogwarts.school.service.StudentService;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class SchoolApplicationWithMockTests {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private StudentRepository studentRepository;
	@MockBean
	private AvatarRepository avatarRepository;
//	@MockBean
//	private FacultyRepository facultyRepository;
	@SpyBean
	private StudentService studentService;
	@SpyBean
	private AvatarService avatarService;
//	@SpyBean
//	private FacultyService facultyService;
	@InjectMocks
	private StudentController studentController;
	@Test
	public void saveStudentTest() throws Exception{
		final Long id = 1L;
		final String name = "Harry";

		JSONObject studentObject = new JSONObject();
		studentObject.put("name", name);

		Student student = new Student();
		student.setId(id);
		student.setName(name);
		when(studentRepository.findById(any(Long.class))).thenReturn(Optional.of(student));
		when(studentRepository.save(any(Student.class))).thenReturn(student);

		mockMvc.perform(MockMvcRequestBuilders
						.post("/student") //send
						.content(studentObject.toString())
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()) //receive
				.andExpect(jsonPath("$.id").value(id))
				.andExpect(jsonPath("$.name").value(name));
		mockMvc.perform(MockMvcRequestBuilders
				.get("/student/1")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()) //receive
				.andExpect(jsonPath("$.id").value(id))
				.andExpect(jsonPath("$.name").value(name));
	}
}
