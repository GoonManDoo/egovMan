package egovframework.example.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import egovframework.example.test.domain.UserVO;


@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	SqlSession sqlSession;
	
	//로그인에 성공하면 유저 정보를 담고 있는 UserVO 객체를 반환한다.
	//로그인
	@Override
	public UserVO login(UserVO dto) {
		return sqlSession.selectOne("egovframework.sqlmap.mappers.userMapper.login", dto);
	}

	

}
