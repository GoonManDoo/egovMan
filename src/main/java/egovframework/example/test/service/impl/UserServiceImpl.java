package egovframework.example.test.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import egovframework.example.persistence.UserDAO;
import egovframework.example.test.domain.UserVO;
import egovframework.example.test.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	UserDAO dao;
	
	//회원가입
	@Override
	public UserVO login(UserVO dto) {
		return dao.login(dto);
	}
	
	

}
