package professor.allocation.dayvid.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import professor.allocation.dayvid.entity.Course;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class CourseRepositoryTeste {
  
	@Autowired
	CourseRepository courseRepository;
	
	@Test
	public void save_create() {
		// Arrange
		
		Course course = new Course();
		course.setId(null);
		course.setName("História");
		
		//Act
		course = courseRepository.save(course);
		
		//Print
		
		System.out.println(course);

	}
	
	@Test
	public void findAll() {
		// Act
		List<Course> courses =  courseRepository.findAll();
		
		//Print
		System.out.println(courses.toString());
	}
	
	@Test
	public void save_update() {
		// Arrange
		Course course = new Course();
		course.setId(1L);
		course.setName("Direito");
		//Act
		course = courseRepository.save(course);
		
		//Print
		System.out.println(course);
		}
	@Test
	 public void findById() {
		// Arrange
		Long id = 1L;
		// Act
		Course course = courseRepository.findById(id).orElse(null);
		//
		System.out.println(course);

	}
	
	@Test
	public void deleteById() {
		//Arrange
		Long id = 4L;
		//Act
		courseRepository.deleteById(id);
		
	}
	
	@Test
    public void deleteAll() {
        // Act
        courseRepository.deleteAllInBatch();
    }
	@Test
	public void findByNameContainingIgnoreCase() {
		// Act
		List<Course> courses =  courseRepository.findByNameContainingIgnoreCase("Dir");
		
		//Print
		System.out.println(courses.toString());
	}
	
}
