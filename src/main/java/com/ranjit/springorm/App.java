package com.ranjit.springorm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ranjit.springorm.dao.StudentDAO;
import com.ranjit.springorm.entites.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("congiguration.xml");
    	StudentDAO studentDAO = context.getBean("studentDAO",StudentDAO.class);
    	Student student1 = new Student(1,"Ranjit","Rourkela" );
    	
    	int res = studentDAO.insert(student1);
    	System.out.println(res);
    
   
    }
}
