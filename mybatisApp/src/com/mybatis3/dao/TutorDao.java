package com.mybatis3.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Tutor;

public class TutorDao 
{
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE="com.mybatis3.dao.mapper.TutorMapper.";
	public TutorDao() {
		try {
			InputStream mybatisConfigInputStream = 
					Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
			this.sqlSessionFactory = 
					sqlSessionFactoryBuilder.build(mybatisConfigInputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	/*******************************************
	 	SELECT TUTOR + COURSES JOIN [ 1 : N ]
	 *******************************************/
	public Tutor findTutorByIdWithCourses(Integer tutorId) {
		/*
		<< TutorMapper.xml --> namespace : com.mybatis3.dao.mapper.TutorMapper >>
		<select id="findTutorByIdWithCourses" parameterType="java.lang.Integer"
											  resultMap="tutorWithCoursesResultMap">
			SELECT t.tutor_id, t.name as tutor_name, email,course_id, c.name, description, start_date, end_date
		    FROM tutors t 
		    left outer join courses c 
			on t.tutor_id=c.tutor_id
			where t.tutor_id=#{tutorId}
		</select>
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Tutor tutor = sqlSession.selectOne(NAMESPACE+"findTutorByIdWithCoursesAndAddress");
		return tutor;
	}
}













