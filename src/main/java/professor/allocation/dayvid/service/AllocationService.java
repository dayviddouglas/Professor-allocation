package professor.allocation.dayvid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import professor.allocation.dayvid.entity.Allocation;
import professor.allocation.dayvid.repository.AllocationRepository;

@Service
public class AllocationService {
 private final AllocationRepository allocationRepository;
 private final CourseService courseService;
 private final ProfessorService professorService;


  public AllocationService(AllocationRepository allocationRepository, CourseService courseService,
		ProfessorService professorService) {
	super();
	this.allocationRepository = allocationRepository;
	this.courseService = courseService;
	this.professorService = professorService;
}

public List<Allocation> findAll() {
	return allocationRepository.findAll();
	
}

   public Allocation findById(Long id) {
	return allocationRepository.findById(id).orElse(null);
	// Select * from Allocation
	
}
   public List<Allocation> findByProfessor(Long professorId) {
	return allocationRepository.findByProfessorId(professorId);

	
}
   
   public List<Allocation> findByCourse(Long courseId) {
	return allocationRepository.findByCourseId(courseId);
}
   
   public Allocation save(Allocation allocation) {
	allocation.setId(null);
	return saveInternal(allocation);
}

  private Allocation saveInternal(Allocation allocation) {
	  
	if(hasCollision(allocation)) {  
		throw new RuntimeException();
	}
	  
  else{
	  allocation = allocationRepository.save(allocation);
	  return allocation;
  }
	
	
}
 
  public Allocation update (Allocation allocation) {
	Long id = allocation.getId();
	if(id!=null && allocationRepository.existsById(id)) {
		return saveInternal(allocation);
	}else {
		return null;
	}
}
   public void deleteById(Long id) {
	if(allocationRepository.existsById(id)) {
		allocationRepository.deleteById(id);
	}
}
   
   public void deleteAll() {
	allocationRepository.deleteAllInBatch();
	
}
   
   private boolean hasCollision(Allocation currentAllocation, Allocation newAllocation) {
		return !currentAllocation.getId().equals(newAllocation.getId())
				&& currentAllocation.getDay() == newAllocation.getDay()
				&& currentAllocation.getStart().compareTo(newAllocation.getEnd()) < 0
				&& newAllocation.getStart().compareTo(currentAllocation.getEnd()) < 0;
	}
   
   
   boolean hasCollision(Allocation newAllocation) {
		boolean hasCollision = false;

		List<Allocation> currentAllocations = allocationRepository.findByProfessorId(newAllocation.getProfessorId());

		for (Allocation currentAllocation : currentAllocations) {
			hasCollision = hasCollision(currentAllocation, newAllocation);
			if (hasCollision) {
				break;
			}
		}
		

		return hasCollision;
	}
	
	
}
