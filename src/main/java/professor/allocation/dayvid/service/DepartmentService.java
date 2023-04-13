package professor.allocation.dayvid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import professor.allocation.dayvid.entity.Department;
import professor.allocation.dayvid.repository.DepartmentRepository;

@Service
public class DepartmentService {
  private final DepartmentRepository departmentRepository;

	public DepartmentService(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}
  
	
	 public List<Department> findAll(){
		 return departmentRepository.findAll();
	 }
	 public Department findById (Long id) {
		 return departmentRepository.findById(id).orElse(null);
	 }
	 
	 public Department save(Department department) {
		 department.setId(null);
		return department = departmentRepository.save(department);
	 }
	 
	 public Department update(Department department) {
		 Long id = department.getId();
		 if(id != null && departmentRepository.existsById(id)) {
			 return department = departmentRepository.save(department);
		 }
		 else {
			 return null;
		 }
	 }
	 public void deleteById(Long id) {
		 if(departmentRepository.existsById(id)) {
			departmentRepository.deleteById(id);
		 }
	 }
	 
	 public void deleteAll() {
		departmentRepository.deleteAllInBatch();
	}
  
}
