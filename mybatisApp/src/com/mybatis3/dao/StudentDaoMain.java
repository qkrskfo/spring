package com.mybatis3.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mybatis3.domain.Student;

public class StudentDaoMain {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		
		// select
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
		
		System.out.println("--------- findStudentByIdWithAddressWithCourses ---------");
		System.out.println("### "+studentDao.findStudentByIdWithAddressWithCourses(1));
		
		
		//insert
		System.out.println("---------insertStudent(Dto)--------------------------");
		Student student1 = new Student(1002, "박여름", "summer@gmail.com", new Date());
		//System.out.println("### "+studentDao.insertStudent(student1));
		
		System.out.println("---------insertStudentBySequence1--------------------");
		Student student2 = new Student(0, "시퀀스1", "seq1@gmail.com", new Date());
		System.out.println("### low "+studentDao.insertStudentBySequence1(student2));
		
		System.out.println("---------insertStudentBySequence2--------------------");
		Student student3 = new Student(0, "시퀀스2", "seq1@gmail.com", new Date());
		System.out.println("### pk "+studentDao.insertStudentBySequence2(student3));
		System.out.println("### student3 : "+student3);
		System.out.println("### " + studentDao.findStudentById(student3.getStudId()));
		
		
		System.out.println("---------updateStudentById---------------------------");
		Student student4 = studentDao.findStudentById(4);
		student4.setName("김수정");
		student4.setEmail("soojeong@gmail.com");
		System.out.println("### "+studentDao.updateStudentById(student4));
		
		
		System.out.println("---------deleteStudentById---------------------------");
		System.out.println("### "+studentDao.deleteStudentById(student3.getStudId()));
		
		System.out.println("---------deleteStudentByName-------------------------");
		System.out.println("### "+studentDao.deleteStudentByName(student2.getName()));
		
		System.out.println("---------deleteStudentByNameLike---------------------");
		System.out.println("### "+studentDao.deleteStudentByNameLike("여"));
		
		System.out.println("---------findStudentByIdMap--------------------------");
		Map studentMap = studentDao.findStudentByIdMap(1);
		System.out.println(studentMap);
		BigDecimal stud_id = (BigDecimal)studentMap.get("STUD_ID");
		String name = (String)studentMap.get("NAME");
		String email = (String)studentMap.get("EMAIL");
		String phone = (String)studentMap.get("PHONE");
		Date dob = (Date)studentMap.get("DOB");
		System.out.println(stud_id+" "+name+" "+email+" "+phone+" "+dob);
		
		System.out.println("---------findAllStudentsMapList----------------------");
		List<Map> studentMapList = studentDao.findAllStudentsMapList();
		//System.out.println(studentMapList);
		for(Map studentRowMap : studentMapList) {
			System.out.println(studentRowMap);
		}
		
		System.out.println("---------findAllOrderedStudents------------------");
		System.out.println("---------findStudentByIdRangeParamMap(parameter Map)-");
		System.out.println("---------updateStudentParamMap(parameter Map)--------");
		System.out.println("---------findStudentsThreeParamMap(parameter Map)----");
		System.out.println("---------findStudentByIdNestedfindAddressById-----------");
		System.out.println("---------updateStudentDynamicSql---------");
		System.out.println("---------findStudentCount----------------");
		
		
	}
}
