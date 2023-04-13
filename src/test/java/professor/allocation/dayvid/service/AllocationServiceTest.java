package professor.allocation.dayvid.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import professor.allocation.dayvid.entity.Allocation;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")

public class AllocationServiceTest {
	
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");
	@Autowired
	AllocationService allocationService;
	
	
 @Test
 public void findAll() {
	 // Act
	 List<Allocation> allocations = allocationService.findAll();
	 
	 //Print
	 allocations.forEach(System.out::println);
 }
 
 
 @Test 
 public void findByProfessor() {
	 //Arrange
	 Long id = 1L;
	 
	 // Act
	 List<Allocation> allocations= allocationService.findByProfessor(id);
	 
	 //Print
	 System.out.println(allocations);
 }
 
 @Test 
 public void findByCourse() {
     // Arrange
     Long id = 1L;

     // Act
     List<Allocation> allocations = allocationService.findByCourse(id);

     // Print
     allocations.forEach(System.out::println);
 }
 
 @Test
 public void findById() {
     // Arrange
     Long id = 2L;

     // Act
     Allocation allocation = allocationService.findById(id);

     // Print
     System.out.println(allocation);
 }
 
 @Test
 public void save() throws ParseException {
	 //Arrange
	 Allocation allocation = new Allocation();
	 allocation.setId(null);
	 allocation.setDay(DayOfWeek.MONDAY);
	 allocation.setStart(sdf.parse("15:00-0300"));
	 allocation.setEnd(sdf.parse("17:00-0300"));
	 allocation.setProfessorId(6L);
	 allocation.setCourseId(8L);
	 
	 // Act
	 allocation = allocationService.save(allocation);
	 
	 // Print
	 System.out.println(allocation);
 }
 
 @Test
   public void update() throws ParseException {
	 //Arrange
	 Allocation allocation = new Allocation();
	 allocation.setId(1L);
	 allocation.setDay(DayOfWeek.THURSDAY);
	 allocation.setStart(sdf.parse("15:00-0300"));
	 allocation.setEnd(sdf.parse("16:00-0300"));
	 allocation.setProfessorId(1L);
	 allocation.setCourseId(1L);
	 
	// Act
    allocation = allocationService.save(allocation);
		 
    // Print
    System.out.println(allocation);
 }
    
  @Test
  public void deleteById() {
	  //Arrange
	 Long id = 1L;
	 // Act
	 allocationService.deleteById(id);
    
 }
  
  @Test
  public void deleteAll() {
	  allocationService.deleteAll();
  }
 
 
 
 
 
}
