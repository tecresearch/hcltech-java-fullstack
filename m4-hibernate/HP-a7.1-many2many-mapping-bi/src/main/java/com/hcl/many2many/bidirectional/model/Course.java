package com.hcl.many2many.bidirectional.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "a7_course_bi")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<Student> students;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course( String title, List<Student> students) {
		
		this.title = title;
		this.students = students;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		
		return "Course [id=" + id + ", title=" + title +"]";
	}

	
}
