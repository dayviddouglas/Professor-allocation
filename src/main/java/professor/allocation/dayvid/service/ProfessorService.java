package professor.allocation.dayvid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import professor.allocation.dayvid.entity.Professor;
import professor.allocation.dayvid.repository.ProfessorRepository;

@Service
public class ProfessorService {
  private final ProfessorRepository professorRepository;

	public ProfessorService(ProfessorRepository professorRepository) {
		super();
		this.professorRepository = professorRepository;
	}
   
	public List<Professor>findAll(){
		return professorRepository.findAll();
	}
	
	public Professor findById(Long id) {
		return professorRepository.findById(id).orElse(null);
	}
	
	
	public Professor save(Professor professor) {
		professor.setId(null);
		return professor = professorRepository.save(professor);
	}
	
	public List<Professor> findByDepartment(Long id){
		return professorRepository.findByDepartmentId(id);
	}
	
	public Professor update(Professor professor) {
		Long id = professor.getId();
		if(id != null && professorRepository.existsById(id)) {
			return professor = professorRepository.save(professor);
		}else {
			return null;
		}
	}
	
	public void deleteById(Long id) {
		if(professorRepository.existsById(id)) {
			professorRepository.deleteById(id);
		}
	}
	
	public void deleteAll() {
		professorRepository.deleteAllInBatch();
	}
	
	
  
}
