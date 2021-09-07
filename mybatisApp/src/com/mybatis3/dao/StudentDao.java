package com.mybatis3.dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;

public class StudentDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public static final String NAMESPACE = "com.mybatis3.dao.mapper.StudentMapper.";
	
	public StudentDao() {
		try {
			/*
			 * 0. mybatis-config.xml --> InputStream
			 */
			InputStream myBatisConfigInputStream = Resources.getResourceAsStream("mybatis-config.xml");
			
			/*
			 * 1. SqlSessionFactoryBuilder
			 */
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			
			/*
			 * 2. SqlSessionFactory
			 */
			this.sqlSessionFactory = sqlSessionFactoryBuilder.build(myBatisConfigInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***************************************************
	 * INSERT
	***************************************************/
	public int insertStudent(Student student) {
		/*
		 * openSession의 autocommit 여부 설정(true, false)
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int row = sqlSession.insert(NAMESPACE+"insertStudent", student);
		sqlSession.close();
		return row;
	}

	public int insertStudentBySequence1(Student student) {
		/*
		 * openSession의 autocommit 여부 설정(true, false)
		 *  - false로 하면, commit을 반드시 해주어야 함.
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		int row = sqlSession.insert(NAMESPACE+"insertStudentBySequence1", student);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}
	
	public int insertStudentBySequence2(Student student) {
		/*
		 * sequence 실행 후 PK return
		 */
		/*
		 * openSession의 autocommit 여부 설정(true, false)
		 *  - false로 하면, commit을 반드시 해주어야 함.
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		int row = sqlSession.insert(NAMESPACE+"insertStudentBySequence2", student);
		sqlSession.commit();
		sqlSession.close();
		return student.getStudId();
	}
	
	
	/***************************************************
	 * 	SELECT JOIN[students + address + courses(course_enrollment) join] (1 : 1 : N)
	 ***************************************************/
	/*
	 * select sql의 결과타입이 DTO, VO, Domain 객체인 경우
	 * resultMap : studentWithAddressWithCoursesResultMap
	 */
	public Student findStudentByIdWithAddressWithCourses(Integer studId) {
		return sqlSessionFactory.openSession().selectOne(NAMESPACE+"findStudentByIdWithAddressWithCourses", studId);
		
	}

	
	/***************************************************
	 * 	SELECT JOIN[students + courses(course_enrollment) join] (1 : N)
	 ***************************************************/
	/*
	 * select sql의 결과타입이 DTO, VO, Domain 객체인 경우
	 * resultMap : studentWithCoursesResultMap
	 */
	public Student findStudentByIdWithCourses(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Student student = sqlSession.selectOne(NAMESPACE+"findStudentByIdWithCourses", studId);
		sqlSession.close();
		return student;
	}
	
	
	/***************************************************
	 * 	SELECT JOIN[students + addresses join] (1 : 1)
	 ***************************************************/
	/*
	 * select sql의 결과타입이 DTO, VO, Domain 객체인 경우
	 * resultMap : studentWithAddressResultMap
	 */
	public Student findStudentByIdWithAddress(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Student student = sqlSession.selectOne(NAMESPACE+"findStudentByIdWithAddress", studId);
		sqlSession.close();
		return student;
	}
	
	
	/***************************************************
	 * 						SELECT
	 ***************************************************/
	/*
	 * select sql의 결과타입이 DTO, VO, Domain 객체인 경우
	 * resultType : DTO, VO, Domain
	 */
	public Student findStudentById(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*
==4		<< StudentMapper.xml --> namespace "com.mybatis3.dao.mapper.StudentMapper" >>
		
		<select id="findStudentById" parameterTjava.lang.Integer" resultType="com.mybatis3.domain.Student">
			select stud_id as studId, name, email, dob from students where stud_id=#{studId}
		</select> 
		*/
		Student student = sqlSession.selectOne("com.mybatis3.dao.mapper.StudentMapper.findStudentById", studId);
		sqlSession.close();
		return student;
	}

	public List<Student> findAllStudents() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*
		<< StudentMapper.xml --> namespace "com.mybatis3.dao.mapper.StudentMapper" >>
		<select id="findAllStudents" resultType="com.mybatis3.domain.Student">
			select stud_id as studId, name, email, dob from students
		</select>
		*/
		List<Student> studentList = sqlSession.selectList(NAMESPACE+"findAllStudents");
		sqlSession.close();
		return studentList;
	}

	public List<Student> findAllOrderedStudents(String columnName) {

		return null;
	}

	/*
	 * select sql의 결과타입이 Wrapper(String)객체인 경우
	 * resultType : String, Wrapper
	 * resultType Wrapper(String)
	 */
	public String findStudentNameById(Integer userId) {
		
		/*
		<< StudentMapper.xml --> namespace "com.mybatis3.dao.mapper.StudentMapper" >>
		<select id="findStudentNameById" parameterType="java.lang.Integer" resultType="java.lang.String">
			select name from students where stud_id=#{studId}
		</select>
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String name = sqlSession.selectOne(NAMESPACE+"findStudentNameById", userId);
		sqlSession.close();
		return name;
	}

	public List<String> findStudentNameList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<String> nameList = sqlSession.selectList(NAMESPACE+"findStudentNameList");
		sqlSession.close();
		return nameList;
	}
	
	/*
	 * select sql의 결과타입이 DTO, VO, Domain 객체인 경우
	 * resultMap : DTO, VO, Domain
	 */
	public Student findStudentByIdResultMap(Integer studId) {
		/*
		<< StudentMapper.xml --> namespace "com.mybatis3.dao.mapper.StudentMapper" >>
		<select id="findStudentByResultMap" parameterType="java.lang.Integer" resultMap="studentResultMap">
			select stud_id, name, email, dob from students where stud_id=#{studId}
		</select>
		*/
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Student student = sqlSession.selectOne(NAMESPACE+"findStudentByIdResultMap", studId);
		sqlSession.close();
		return student;
	}

	public List<Student> findAllStudentsResultMap() {
		/*
		<< StudentMapper.xml --> namespace "com.mybatis3.dao.mapper.StudentMapper" >>
		<select id="findAllStudentsResultMap" resultMap="studentResultMap">
			selsect stud_id, name, email, dob from students
		</select>	
		*/
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Student> studentList = sqlSession.selectList(NAMESPACE+"findAllStudentsResultMap");
		sqlSession.close();
		return studentList;
	}
	
	
	

	/*
	 * resultType Map
	 */
	public Map findStudentByIdMap(Integer userId) {

		return null;
	}

	public List<Map> findAllStudentsMapList() {

		return null;
	}

	public List<Student> findStudentByIdRangeParamMap(HashMap idRangeMap) {

		return null;
	}

	public List<Student> findStudentsThreeParamMap(HashMap studentsMap) {

		return null;
	}

	public int updateStudentParamMap(Map studentMap) {

		return 0;
	}
	
	
		

	/* @@@@@@@@@@@@@@@@@@@@@@@ UPDATE @@@@@@@@@@@@@@@@@ */
	public int updateStudentById(Student updateStudent) {
		return 0;
	}

	/* @@@@@@@@@@@@@@@@@@@@@@@DELETE@@@@@@@@@@@@@@@@@ */
	public int deleteStudentById(Integer studId) {

		return 0;
	}

	public int deleteStudentByName(String name) {

		return 0;
	}

	public int deleteStudentByNameLike(String name) {

		return 0;
	}

	


}
