package professor.allocation.dayvid.entity;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "professor")

public class Professor {
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "cpf", nullable = false, unique = true,length =14)
	private String cpf;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(name = "department_id",nullable = false)
	private Long departmentId;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@JsonIgnoreProperties({"professors"})
	@ManyToOne(optional = false)/* O opcional = false: Significa a cardinalidade mínima é 1. Caso fosse true, a cardinalidade mínima é 0.*/
	@JoinColumn(name="department_id", nullable = false,insertable = false,updatable = false) /* O insertable e o updatable = false, significa que as modificações e/ou inserções serão feitas apenas na própria classe.*/
	private Department department;
	 @JsonProperty(access = JsonProperty.Access.READ_ONLY)
	 @OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy="professor")
	private List<Allocation> allocations;
	
	
	
	public Professor() {
		super();
	}

	public Professor(Long id, String name, String cpf, Long departmentId) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.departmentId = departmentId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", name=" + name + ", cpf=" + cpf + ", departmentId=" + departmentId
				+ ", department=" + department + "]";
	}

	

	
	
	
	
}
