package egovframework.example.test.dao;

import java.util.List;

import egovframework.example.test.domain.Search;
import egovframework.example.test.domain.TestVO;

public interface TestDAO {

	//게시글 목록 보기
	public List<TestVO> selectTest(Search search) throws Exception;

	//게시글 입력 버튼
	public void insertTest(TestVO testVO) throws Exception;

	//글 제목 클릭 시 상세보기
	public TestVO selectDetail(TestVO testVO) throws Exception;

	//글 수정하기
	public void updateTest(TestVO testVO) throws Exception;
	
	//글 삭제하기
	public void deleteTest(TestVO testVO) throws Exception;

	//총 게시글 개수 확인
	public int getBoardListCnt(Search search) throws Exception;
	
	

}