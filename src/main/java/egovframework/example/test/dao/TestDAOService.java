package egovframework.example.test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.test.domain.Search;
import egovframework.example.test.domain.TestVO;
import egovframework.example.test.service.TestMapper;

@Service("testDAOService")
public class TestDAOService implements TestDAO {

	@Autowired
	private SqlSession sqlSession;
	
	//게시글 목록 보기
	@Override
	public List<TestVO> selectTest(Search search) throws Exception {
		TestMapper mapper = sqlSession.getMapper(TestMapper.class);
		return mapper.selectTest(search);
	}

	//게시글 입력 버튼
	@Override
	public void insertTest(TestVO testVO) throws Exception {
		TestMapper mapper = sqlSession.getMapper(TestMapper.class);
		mapper.insertTest(testVO);
	}

	//글 제목 선택 시 상세보기
	@Override
	public TestVO selectDetail(TestVO testVO) throws Exception {
		TestMapper mapper = sqlSession.getMapper(TestMapper.class);
		return mapper.selectDetail(testVO);
	}

	//글 수정하기
	@Override
	public void updateTest(TestVO testVO) throws Exception {
		TestMapper mapper = sqlSession.getMapper(TestMapper.class);
		mapper.updateTest(testVO);
	}

	//글 삭제하기
	@Override
	public void deleteTest(TestVO testVO) throws Exception {
		TestMapper mapper = sqlSession.getMapper(TestMapper.class);
		mapper.deleteTest(testVO);
	}

	//총 게시글 개수 확인
	@Override
	public int getBoardListCnt(Search search) throws Exception {
		TestMapper mapper = sqlSession.getMapper(TestMapper.class);
		return mapper.getBoardListCnt(search);
	}
	
	
	
}
