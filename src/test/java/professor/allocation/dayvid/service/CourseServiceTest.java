package professor.allocation.dayvid.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import professor.allocation.dayvid.entity.Course;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class CourseServiceTest {
    
	@Autowired
	CourseService courseService;
	
	@Test
	 public void findAll () {
		// Act
		List<Course> courses = courseService.findAll();
		
		// Print
		 courses.forEach(System.out::println);	
	}
	@Test
	public void findById() {
		// Arrange
		Long id = 5L;
		// Act
		Course course = courseService.findById(id);
		// Print
		System.out.println(course);
	}
	
	@Test
	 public void save () {
		// Arrange
		Course course = new Course();
		course.setId(null);
		course.setName("Radiologia");
		// Act
		course = courseService.save(course);
		// Print
		System.out.println(course);
	}
	
	@Test
	public void update() {
		// Arrange 
		Course course = new Course();
		course.setId(8L);
		course.setName("Matemática");
		// Act
		course = courseService.update(course);
		// Print
		System.out.println(course);
	}
	
	@Test 
	public void deleteById() {
		// Arrange
		Long id = 1L;
		
		// Act
		courseService.deleteById(id);
		
	}
	
	@Test
	public void deleteAll() {
		// Act
		courseService.deleteAll();
	}
	
}
