package professor.allocation.dayvid.entity;

import java.time.DayOfWeek;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity 
@Table(name="allocation") 

public class Allocation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	@Column(name = "day", nullable = false)
	private DayOfWeek day;
	@Temporal(TemporalType.TIME)
	@Column(name = "starthour", nullable = false)
	private Date start;
	@Temporal(TemporalType.TIME)
	@Column(name = "endhour",nullable = false)
	private Date end;
	@Column(name = "course_id",nullable = false)
	private Long courseId;
	@Column(name = "professor_id",nullable = false)
	private Long professorId;
	
	
	public Allocation() {
		super();
	}


	public Allocation(Long id, DayOfWeek day, Date start, Date end, Long courseId, Long professorId) {
		super();
		this.id = id;
		this.day = day;
		this.start = start;
		this.end = end;
		this.courseId = courseId;
		this.professorId = professorId;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public DayOfWeek getDay() {
		return day;
	}


	public void setDay(DayOfWeek day) {
		this.day = day;
	}


	public Date getStart() {
		return start;
	}


	public void setStart(Date start) {
		this.start = start;
	}


	public Date getEnd() {
		return end;
	}


	public void setEnd(Date end) {
		this.end = end;
	}


	public Long getCourseId() {
		return courseId;
	}


	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}


	public Long getProfessorId() {
		return professorId;
	}


	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}


	@Override
	public String toString() {
		return "Allocation [id=" + id + ", day=" + day + ", start=" + start + ", end=" + end + ", courseId=" + courseId
				+ ", professorId=" + professorId + "]";
	}
	
	
	
}
