package professor.allocation.dayvid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import professor.allocation.dayvid.entity.Course;
import professor.allocation.dayvid.repository.CourseRepository;

@Service
public class CourseService {
 private final CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}


    public List<Course>findAll(){
    	return courseRepository.findAll();
    }
    
    public Course findById(Long id) {
    	return courseRepository.findById(id).orElse(null);
    }
    
    
    public Course save(Course course) {
    	course.setId(null);
    	return course = courseRepository.save(course);
    	
    }
    
    public Course update(Course course) {
    	Long id = course.getId();
    	if(id!= null && courseRepository.existsById(id)) {
    		return  course = courseRepository.save(course);
    	}
    	else {
			return null;
		}
    }
    
    public void deleteById(Long id) {
    	if(courseRepository.existsById(id)) {
    		 courseRepository.deleteById(id);
    	}
    }
    
    public void deleteAll() {
		courseRepository.deleteAllInBatch();
	}
    
 
}
