package com.itwill.member;

import java.util.ArrayList;
import java.util.List;

public class MemberDao {

	public MemberDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Member> member_list() {
		List<Member> memberList = new ArrayList<Member>();
		memberList.add(new Member("summer", "박여름"));
		memberList.add(new Member("isfp", "박나래"));
		memberList.add(new Member("istp", "임수진"));
		memberList.add(new Member("zzz", "루피"));
		return memberList;
	}
	
	public Member member_detail(String id) {
		Member member = new Member(id, id+"님");
		return member;
	}
}
