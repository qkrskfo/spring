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
	 * DELETE
	***************************************************/
	
	public int deleteStudentById(Integer studId) {
		return sqlSessionFactory.openSession(true).delete(NAMESPACE+"deleteStudentById", studId);
	}

	public int deleteStudentByName(String name) {
		return sqlSessionFactory.openSession(true).delete(NAMESPACE+"deleteStudentByName", name);
	}
	
	public int deleteStudentByNameLike(String name) {
		return sqlSessionFactory.openSession(true).delete(NAMESPACE+"deleteStudentByNameLike", name);
	}
	
	/***************************************************
	 * UPDATE
	***************************************************/
	public int updateStudentById(Student student) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int updateRow = sqlSession.update(NAMESPACE+"updateStudentById", student);
		sqlSession.close();
		return updateRow;
	}
	
	
	/***************************************************
	 * INSERT
	***************************************************/
	public int insertStudent(Student student) {
		/*
		 * openSession??? autocommit ?????? ??????(true, false)
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int row = sqlSession.insert(NAMESPACE+"insertStudent", student);
		sqlSession.close();
		return row;
	}

	public int insertStudentBySequence1(Student student) {
		/*
		 * openSession??? autocommit ?????? ??????(true, false)
		 *  - false??? ??????, commit??? ????????? ???????????? ???.
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		int row = sqlSession.insert(NAMESPACE+"insertStudentBySequence1", student);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}
	
	public int insertStudentBySequence2(Student student) {
		/*
		 * sequence ?????? ??? PK return
		 */
		/*
		 * openSession??? autocommit ?????? ??????(true, false)
		 *  - false??? ??????, commit??? ????????? ???????????? ???.
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
	 * select sql??? ??????????????? DTO, VO, Domain ????????? ??????
	 * resultMap : studentWithAddressWithCoursesResultMap
	 */
	public Student findStudentByIdWithAddressWithCourses(Integer studId) {
		return sqlSessionFactory.openSession().selectOne(NAMESPACE+"findStudentByIdWithAddressWithCourses", studId);
		
	}

	
	/***************************************************
	 * 	SELECT JOIN[students + courses(course_enrollment) join] (1 : N)
	 ***************************************************/
	/*
	 * select sql??? ??????????????? DTO, VO, Domain ????????? ??????
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
	 * select sql??? ??????????????? DTO, VO, Domain ????????? ??????
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
	 * select sql??? ??????????????? DTO, VO, Domain ????????? ??????
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
	 * select sql??? ??????????????? Wrapper(String)????????? ??????
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
	 * select sql??? ??????????????? DTO, VO, Domain ????????? ??????
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
	
	/*************************************************
	?????????????????? Map(HashMap)??? ????????? ????????? ??? ??????.
	 *************************************************/
	/*
	 * resultType Map
	 */
	public Map findStudentByIdMap(Integer studId) {
		return sqlSessionFactory.openSession().selectOne(NAMESPACE+"findStudentByIdMap", studId);
	}
	
	public List<Map> findAllStudentsMapList() {
		return sqlSessionFactory.openSession().selectList(NAMESPACE+"findAllStudentsMapList");
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
	


}
