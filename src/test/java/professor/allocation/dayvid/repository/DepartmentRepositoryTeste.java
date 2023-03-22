package professor.allocation.dayvid.repository;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import professor.allocation.dayvid.entity.Department;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class DepartmentRepositoryTeste {
  
	@Autowired
	DepartmentRepository departmentRepository;
	
	
	@Test
	public void save_create() {
		// Arrange
		
		Department department = new Department();
		department.setId(null);
		department.setName("Department Ciencias Biologicas");
		
		//Act
		department = departmentRepository.save(department);
		
		//Print
		
		System.out.println(department);

	}
	

	@Test
	public void findAll() {
		// Act
		List<Department> departments =  departmentRepository.findAll();
		
		//Print
		System.out.println(departments.toString());
	}
	
	@Test
	public void save_update() {
		// Arrange
		Department department = new Department();
		department.setId(1L);
		department.setName("Department 0");
		//Act
		department = departmentRepository.save(department);
		
		//Print
		System.out.println(department);
		}
	
	@Test
	 public void findById() {
		// Arrange
		Long id = 8L;
		// Act
		Department department = departmentRepository.findById(id).orElse(null);
		//
		System.out.println(department);

	}
	
	@Test
	public void deleteById() {
		//Arrange
		Long id = 1L;
		//Act
		departmentRepository.deleteById(id);
		
	}
	
	@Test
    public void deleteAll() {
        // Act
        departmentRepository.deleteAllInBatch();
    }
	
	@Test
	public void findByNameContainingIgnoreCase() {
		// Act
		List<Department> departments =  departmentRepository.findByNameContainingIgnoreCase("Department");
		
		//Print
		System.out.println(departments.toString());
	}
}
