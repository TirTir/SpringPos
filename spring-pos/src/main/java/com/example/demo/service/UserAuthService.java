package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.UserAuthRequest;
import com.example.demo.UserRegisterRequest;

import com.example.demo.dao.MemberDao;
import com.example.demo.dto.Member;

@Service
public class UserAuthService {
	@Autowired
	private MemberDao memberDao;
	
	public UserAuthService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public Member login(UserAuthRequest req) throws Exception{
		Member member = memberDao.selectByUserId(req.getUserId());
        if (member != null && member.getPassword().equals(req.getPassword())) {
            return member;
        } else {
            throw new Exception("아이디 또는 비밀번호가 올바르지 않습니다.");
        }
	}
	
	public void join(UserRegisterRequest req){
		Member member = new Member(req.getUserName(), req.getUserId(), req.getPassword(), "직원");
		memberDao.insert(member);
	}
}
