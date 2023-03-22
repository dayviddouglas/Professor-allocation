package professor.allocation.dayvid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import professor.allocation.dayvid.entity.Course;
import professor.allocation.dayvid.entity.Professor;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Long>{
	List<Course> findByNameContainingIgnoreCase(String name);
}
