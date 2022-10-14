package egovframework.example.test.service;

import egovframework.example.test.domain.UserVO;

public interface UserService {
	
	//로그인
	public UserVO login(UserVO dto);
}
