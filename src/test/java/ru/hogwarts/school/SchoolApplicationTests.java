package ru.hogwarts.school;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.hogwarts.school.controller.StudentController;
import ru.hogwarts.school.model.Student;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SchoolApplicationTests {
	@LocalServerPort
	private int port;
	@Autowired
	private StudentController studentController;

	@Autowired
	private TestRestTemplate restTemplate;
	@Test
	public void contextLoads() throws Exception {
		Assertions.assertThat(studentController).isNotNull();
	}
	@Test
	public void testDefaultMessage() throws Exception{
		Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port,String.class)).isNotNull();
	}
	@Test
	public void testGetStudents() throws Exception{
		Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port,String.class)).isNotEmpty();
	}
	@Test
	public void testPostStudent() throws Exception{
		Student student = new Student();
		student.setAge(20);
		student.setName("Ron");
		Assertions.
				assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/student",student, String.class)).isNotEmpty();
	}
	@Test
	public void testPutStudent() throws Exception{
		Student student = new Student();
		HttpEntity<Student> httpStudent = new HttpEntity<>(student);
		student.setAge(20);
		student.setName("Ron");
		ResponseEntity<Student> studentEntity = restTemplate.exchange(
				"http://localhost:" + port + "/student",
				HttpMethod.PUT,
				httpStudent,
				Student.class);
		Assertions.
				assertThat(studentEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	@Test
	public void testDeleteStudent() throws Exception{
		Student student = new Student();
		HttpEntity<Student> httpStudent = new HttpEntity<>(student);
		student.setAge(20);
		student.setName("Ron");
		ResponseEntity<Student> studentEntity = restTemplate.exchange(
				"http://localhost:" + port + "/student/del/2",
				HttpMethod.DELETE,
				httpStudent,
				Student.class);
		Assertions.
				assertThat(studentEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
