package com.itwill.member;

import java.util.List;

public class MemberService {
	private MemberDao memberDao;
	public MemberService() {
		memberDao = new MemberDao();
	}
	
	public List<Member> member_list() {
		return memberDao.member_list();
	}
	
	public Member member_detail(String id) {
		return memberDao.member_detail(id);
	}
}

