package egovframework.example.test.service;

import java.util.ArrayList;

import egovframework.example.test.domain.UserDetailsDto;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

public interface UserDao {
	public UserDetailsDto selectUser(String username);
	public ArrayList<String> getAuthList(String username);
}