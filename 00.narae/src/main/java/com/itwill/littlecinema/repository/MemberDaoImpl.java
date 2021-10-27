package com.itwill.littlecinema.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.littlecinema.domain.Member;
import com.itwill.littlecinema.repository.interface_dao.MemberDao;

@Repository
public class MemberDaoImpl implements MemberDao{

	public static final String NAMESPACE = "mapper.MemberMapper.";

	@Autowired
	private SqlSession sqlSession;
	
	//회원가입
	@Override
	public int insert(Member member) throws Exception {
		return sqlSession.insert(NAMESPACE + "insertMember", member);
	}

	//회원 상세 정보
	@Override
	public Member select(String id) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "selectById", id);
	}

	//회원 수정
	@Override
	public int update(Member member) throws Exception {
		return sqlSession.update(NAMESPACE + "updateMember", member);
	}

	//회원 탈퇴
	@Override
	public int delete(String id) throws Exception {
		return sqlSession.delete(NAMESPACE + "deleteMember", id);
	}

	//아아디 존재 여부 확인
	@Override
	public boolean existedMember(String id) throws Exception {
		int count = sqlSession.selectOne(NAMESPACE+"existedMember", id);
		if(count==1) {
			return true;
		} else {
			return false;
		}
	}
	
}
