package com.mybatis3.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.mybatis3.domain.Student;

public class StudentDaoMain {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		
		System.out.println("---------findStudentById-----------------------------");
		System.out.println("### " + studentDao.findStudentById(1));
		System.out.println("### " + studentDao.findStudentById(7));
		
		System.out.println("---------findAllStudents-----------------------------");
		System.out.println("### "+studentDao.findAllStudents());
		
		System.out.println("---------findStudentNameById-------------------------");
		System.out.println("### "+studentDao.findStudentNameById(2));
		
		System.out.println("---------findStudentNameList-------------------------");
		System.out.println("### "+studentDao.findStudentNameList());

		System.out.println("---------findStudentByIdResultMap--------------------");
		System.out.println("### "+studentDao.findStudentByIdResultMap(5));
		
		System.out.println("---------findAllStudentsResultMap--------------------");
		System.out.println("### "+studentDao.findAllStudentsResultMap());
		
		System.out.println("---------findStudentByIdWithAddress------------------");
		System.out.println("### "+studentDao.findStudentByIdWithAddress(2));
		
		System.out.println("---------findStudentByIdWithCourses------------------");
		System.out.println("### "+studentDao.findStudentByIdWithCourses(1));
		
		
		System.out.println("---------insertStudent(Dto)--------------------------");
		Student student1 = new Student(1000, "박여름", "summer@gmail.com", new Date());
		System.out.println("### "+studentDao.insertStudent(student1));
		
		System.out.println("---------insertStudentBySequence1--------------------");
		Student student2 = new Student(0, "시퀀스1", "seq1@gmail.com", new Date());
		System.out.println("### "+studentDao.insertStudentBySequence1(student2));
		
		System.out.println("---------insertStudentBySequence2--------------------");
		
		
		
		System.out.println("---------updateStudentById---------------------------");
		System.out.println("---------deleteStudentById---------------------------");
		System.out.println("---------deleteStudentByName-------------------------");
		System.out.println("---------deleteStudentByNameLike---------------------");
		
		System.out.println("---------findAllOrderedStudents------------------");
		System.out.println("---------findStudentByIdRangeParamMap(parameter Map)-");
		System.out.println("---------updateStudentParamMap(parameter Map)--------");
		System.out.println("---------findStudentsThreeParamMap(parameter Map)----");
		System.out.println("---------findStudentByIdNestedfindAddressById-----------");
		System.out.println("---------updateStudentDynamicSql---------");
		System.out.println("---------findStudentCount----------------");
		
		System.out.println("---------findStudentByIdMap--------------------------");
		System.out.println("---------findAllStudentsMapList----------------------");
	}
}
