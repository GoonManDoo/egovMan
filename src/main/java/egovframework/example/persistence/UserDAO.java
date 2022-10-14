package egovframework.example.persistence;

import egovframework.example.test.domain.UserVO;

public interface UserDAO {

	//로그인
	public UserVO login(UserVO dto);
	
	
}
