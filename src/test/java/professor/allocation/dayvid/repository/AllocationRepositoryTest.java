package professor.allocation.dayvid.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import professor.allocation.dayvid.entity.Allocation;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationRepositoryTest {
	
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");
	
    @Autowired 
    AllocationRepository allocationRepository;
    
    @Test
    public void save_create() throws ParseException {
    	// Arrange
        Allocation allocation = new Allocation();
        allocation.setId(null);
        allocation.setDay(DayOfWeek.TUESDAY);
        allocation.setStart(sdf.parse("19:00-0300"));
        allocation.setEnd(sdf.parse("20:00-0300"));
        allocation.setProfessorId(1L);
        allocation.setCourseId(1L);
        
     // Act
        allocation = allocationRepository.save(allocation);

        // Print
        System.out.println(allocation);
    	
    }
    @Test
    public void findAll() {
    	//Act
		List<Allocation> allocations = allocationRepository.findAll();
		
		//Print 
	    System.out.println(allocations);
	} 
    
    @Test
    public void findById() {
        // Arrange
        Long id = 1L;

        // Act
        Allocation allocation = allocationRepository.findById(id).orElse(null);

        // Print
        System.out.println(allocation);
    }
    
    @Test
    public void findByProfessorId() {
        // Arrange
        Long professorId = 1L;

        // Act
        List<Allocation> allocations = allocationRepository.findByProfessorId(professorId);

        // Print
        System.out.println(allocations);
    }
    
    @Test
    public void findByCourseId() {
        // Arrange
        Long courseId = 1L;

        // Act
        List<Allocation> allocations = allocationRepository.findByCourseId(courseId);

        // Print
        System.out.println(allocations);
    }
    
    @Test
    public void deleteById() {
        // Arrange
        Long id = 1L;

        // Act
        allocationRepository.deleteById(id);
    }
    
    @Test
    public void deleteAll() {
        // Act
        allocationRepository.deleteAllInBatch();
    }
    
}
