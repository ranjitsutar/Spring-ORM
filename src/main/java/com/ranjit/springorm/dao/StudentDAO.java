package com.ranjit.springorm.dao;


import java.util.List;


import org.springframework.orm.hibernate5.HibernateTemplate;

import com.ranjit.springorm.entites.Student;

import jakarta.transaction.Transactional;


public class StudentDAO {

	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	// Insart 
	public int insert(Student student) {
		
		Integer res = (Integer)this.hibernateTemplate.save(student);
		return res;
	}
	
	
	
	// get the single data(object)
	
	public Student getStudentById(int studentId) {
		
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
		
	}
	
	public List<Student> getAllStudent(){
		
		List<Student> allStudent = this.hibernateTemplate.loadAll(Student.class);
		return allStudent;
		
	}
	// get All Student
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Transactional
	// Delete Student By Id
	public Student deletStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
		return student;
	}
	
	@Transactional
	//	Update Student By Id
	public void updateStudentById(Student student) {
		this.hibernateTemplate.update(student);
		
	}
	
	
	
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
}
