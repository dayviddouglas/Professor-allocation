package professor.allocation.dayvid.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import professor.allocation.dayvid.entity.Professor;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")

public class ProfessorServiceTest {
   
				@Autowired
				ProfessorService professorService;
				
	@Test
	public void findAll() {
		//Act
		List<Professor> professors = professorService.findAll();
		//Print
		professors.forEach(System.out::println);
		
	}
	
	@Test
	public void findById() {
		//Arrange
		Long id = 6L;
		// Act
		Professor professor = professorService.findById(id);
		// Print
		System.out.println(professor);
	}
	
	@Test
	public void findByDepartment() {
		//Arrange
		Long id = 7L;
		// Act
		List<Professor> professors = professorService.findByDepartment(id);
		//Print
		professors.forEach(System.out::println);
	}
	
	@Test
	public void save() {
		//Arrange
		Professor professor = new Professor();
		professor.setId(null);
		professor.setCpf("123.456.789-01");
		professor.setName("José Farias de Souza");
		professor.setDepartmentId(7L);
		// Act
		professor = professorService.save(professor);
		//Print
		System.out.println(professor);
	}
	
	@Test
	public void update() {
		//Arrange
		Professor professor = new Professor();
		professor.setId(1L);
		professor.setCpf("456.745.856-42");
		professor.setName("Joana Maria Duarte de Almeida");
		professor.setDepartmentId(1L);
		// Act
		professor = professorService.update(professor);
		// Print
		System.out.println(professor);
		
	}
	@Test
	public void deleteById() {
		//Arrange
		Long id = 1L;
		//Act
		professorService.deleteById(id);
	}
	
	@Test
	public void deleteAll() {
		professorService.deleteAll();
	}
	
	
}
