package com.ranjit.springorm.dao;


import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.ranjit.springorm.entites.Student;

public class StudentDAO {

	@Transactional
	private HibernateTemplate hibernateTemplate;
	
	public int insert(Student student) {
		
		Integer res = (Integer)this.hibernateTemplate.save(student);
		return res;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
}
