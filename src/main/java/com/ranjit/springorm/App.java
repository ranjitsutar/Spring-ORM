package com.ranjit.springorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

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
//    	Student student1 = new Student(1,"Ranjit","Rourkela" );
    	
//    	int res = studentDAO.insert(student1);
//    	System.out.println(res);
    	
    	
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    	boolean go=true;
    	while(true) {
    		
    		System.out.println("PRESS 1 for add new Student");    		
    		System.out.println("PRESS 2 for display all Student");
    		System.out.println("PRESS 3 for get single Student");
    		System.out.println("PRESS 4 for delete student");
    		System.out.println("PRESS 5 for update student ");
    		System.out.println("PRESS 6 for Exit");
    		
    		try {
				
    			int input= Integer.parseInt(reader.readLine());
    			
    			switch (input) {
				case 1:
					// add new Student
					System.out.println("Enter Student Id : ");
					int studentId= Integer.parseInt(reader.readLine());
					
					System.out.println("Enter Student name : ");
					String studentName=reader.readLine();
					
					System.out.println("Enter Student Id : ");
					String studentCity= reader.readLine();
					
					Student student = new Student();
					student.setStudentId(studentId);
					student.setStudentName(studentName);
					student.setStudentCity(studentCity);
					
					int result= studentDAO.insert(student);
					System.out.println(result);
					System.out.println("Student added");
					
					break;
				case 2:
					// display all Student
					List<Student> allStudent = studentDAO.getAllStudent();
					System.out.println("********************************************");
					for(Student st: allStudent) {
						System.out.println(st.getStudentId());
						System.out.println(st.getStudentName());
						System.out.println(st.getStudentCity());
						System.out.println("____________________________________");
					}
					System.out.println("********************************************");

					
					break;
				case 3:
					// get single Student
					System.out.println("Enter Student Id : ");
					int id= Integer.parseInt(reader.readLine());
					
					Student st = studentDAO.getStudentById(id);
					
						System.out.println(st.getStudentId());
						System.out.println(st.getStudentName());
						System.out.println(st.getStudentCity());
						System.out.println("____________________________________");
					
					break;
				case 4:
					// delete student
					System.out.println("Enter Student Id : ");
					int deleteid= Integer.parseInt(reader.readLine());
					
					Student student2 = studentDAO.deletStudent(deleteid);
					
					System.out.println(student2.getStudentId());
					System.out.println(student2.getStudentName());
					System.out.println(student2.getStudentCity());
					System.out.println("____________________________________");
					
					break;
				case 5:
					// update student
					System.out.println("Enter Student Id : ");
					int updateId= Integer.parseInt(reader.readLine());
					
					System.out.println("Enter Student name : ");
					String updateName=reader.readLine();
					
					System.out.println("Enter Student Id : ");
					String updateCity= reader.readLine();
					
					Student updatestudent = new Student();
					updatestudent.setStudentName(updatestudent.getStudentName());
					updatestudent.setStudentCity(updatestudent.getStudentCity());
					
					studentDAO.updateStudentById(updatestudent);
					

					break;
				case 6:
					// Exit
					go=false;
					break;

				default:
					System.out.println("Invalid Input type between 1 to 6");
					break;
				}
    			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

    		
    	}
    	
    	
    	
    }
}
