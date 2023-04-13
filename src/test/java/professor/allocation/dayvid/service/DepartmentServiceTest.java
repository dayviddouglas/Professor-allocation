package professor.allocation.dayvid.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import ch.qos.logback.core.net.SyslogOutputStream;
import professor.allocation.dayvid.entity.Department;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")

public class DepartmentServiceTest {
	
	@Autowired
	DepartmentService departmentService;
	
	@Test
	public void findAll() {
		//Act
		 List<Department> departments = departmentService.findAll();
		 // Print
		 departments.forEach(System.out::println);
	}
	
	@Test
	public void findById() {
		// Arrange
		Long id = 1L;
		
		// Act
		Department department = departmentService.findById(id);
		// Print
		System.out.println(department);
	}
	
	
	@Test 
	public void save (){
		// Arrange
		Department department = new Department();
		department.setId(null);
		department.setName("Finanças");
		// Act 
		department = departmentService.save(department);
		// Print
		System.out.println(department);
	}
	
	@Test
	public void update() {
		// Arrange
		Department department = new Department();
		department.setId(1L);
		department.setName("Coordenação");
		// Act
		department = departmentService.update(department);
		// Print
		System.out.println(department);
	}
	
	@Test
	public void deleteById() {
		// Arrange
		Long id = 1L;
		// Act
		departmentService.deleteById(id);
		
		
	}
	
	@Test
	public void deleteAll() {
		departmentService.deleteAll();
	}
}
