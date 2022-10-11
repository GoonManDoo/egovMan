package egovframework.example.test.service;

import java.util.List;

import egovframework.example.test.domain.Search;
import egovframework.example.test.domain.TestVO;

public interface TestService {

	//게시글 전체 목록
	public List<TestVO> selectTest(Search search) throws Exception;

	//글 작성 버튼 구현
	public void insertTest(TestVO testVO) throws Exception;

	//제목 클릭 시 상세보기
	public TestVO selectDetail(TestVO testVO) throws Exception;

	//글 수정하기
	public void updateTest(TestVO testVO) throws Exception;

	//글 삭제하기
	public void deleteTest(TestVO testVO) throws Exception;

	//총 게시글 개수 확인
	public int getBoardListCnt(Search search) throws Exception;
	
	
    


	}