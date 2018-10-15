package com.akushwah3.springboot.jdbc.h2.example;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.akushwah3.springboot.student.MyBatisUtil;
import com.akushwah3.springboot.student.Student;

@Component
public class StudentDAO {
	public void save(Student student) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("com.akushwah3.springboot.student.StudentMapper.insertStudent", student);
		session.commit();
		session.close();
	}

	public void update(Student student) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.update("com.akushwah3.springboot.student.StudentMapper.updateStudent", student);
		session.commit();
		session.close();
	}

	public void delete(Long id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("com.akushwah3.springboot.student.StudentMapper.deleteStudent", id);
		session.commit();
		session.close();
	}

	public Student getData(Long id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Student student = session.selectOne("com.akushwah3.springboot.student.StudentMapper.selectStudent", id);
		session.close();
		return student;
	}
}
