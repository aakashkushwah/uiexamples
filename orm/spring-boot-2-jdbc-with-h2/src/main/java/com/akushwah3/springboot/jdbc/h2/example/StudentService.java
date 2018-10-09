package com.akushwah3.springboot.jdbc.h2.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.akushwah3.springboot.student.Student;

@Component
public class StudentService {

	@Autowired
	StudentDAO studentDao;
	
	public void doSomeOperations() {
		Student student = new Student();
		student.setId(1L);
		student.setName("Aakash");
		student.setPassportNumber("M1851772");
		studentDao.save(student);
		
		System.out.println("---Data saved---");
		
		student = new Student();
		student.setId(1L);
		student.setName("Kushwah");
		student.setPassportNumber("M1851773");
		studentDao.update(student);
		
		System.out.println("---Data updated---");
		
		student = studentDao.getData(1L);
		
		System.out.println(
				"id:" + student.getId() + ", Name:" + student.getName() + ", PassportNumber:" + student.getPassportNumber());
		// delete
		studentDao.delete(1L);
		System.out.println("---Data deleted---");
	}
}
