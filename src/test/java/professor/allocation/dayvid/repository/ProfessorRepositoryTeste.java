
package professor.allocation.dayvid.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import professor.allocation.dayvid.entity.Professor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorRepositoryTeste {
    @Autowired
    ProfessorRepository professorRepository;
    
    @Test
	public void save_create() {
		// Arrange
		Professor professor = new Professor();
		professor.setId(null);
		professor.setName("Gilmara Maria");
		professor.setDepartmentId(7L);
		professor.setCpf("536.956.254-82");
		
		
		//Act
		professor = professorRepository.save(professor);
		
		//Print
		System.out.println(professor);

	}
    
    
    @Test
	public void findAll() {
		// Act
		List<Professor> professors =  professorRepository.findAll();
		
		//Print
		System.out.println(professors.toString());
	}
    
    @Test
     public void findProfessorByDepartmentId() {
    	//Arrange
		Long departmentId = 1L;
		
		//Act
		List<Professor> professors = professorRepository.findByDepartmentId(departmentId);
		
		// Print
		System.out.println(professors);
		

	}    
    @Test
	public void save_update() {
		// Arrange
		Professor professor = new Professor();
		professor.setId(1L);
		professor.setName("Ana marques");
		//Act
		professor = professorRepository.save(professor);
		
		//Print
		System.out.println(professor);
		}
    @Test
	 public void findById() {
		// Arrange
		Long id = 5L;
		// Act
		Professor professor = professorRepository.findById(id).orElse(null);
		//
		System.out.println(professor);
	}
    
    
    @Test
	public void deleteById() {
		//Arrange
		Long id = 5L;
		//Act
		professorRepository.deleteById(id);
	}
    
    @Test
    public void deleteAll() {
        // Act
       professorRepository.deleteAllInBatch();
    }
    @Test
	public void findByNameContainingIgnoreCase() {
		// Act
		List<Professor> professors =  professorRepository.findByNameContainingIgnoreCase("Angela");
		
		//Print
		System.out.println(professors.toString());
	}
    
}
