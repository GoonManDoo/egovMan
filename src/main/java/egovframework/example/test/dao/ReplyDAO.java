package egovframework.example.test.dao;

import java.util.List;

import egovframework.example.test.domain.ReplyVO;

public interface ReplyDAO {

	//댓글 조회
	public List<ReplyVO> list(int testId) throws Exception;
	
	//댓글 작성
	public void write(ReplyVO vo) throws Exception;
	
	//댓글 수정
	public void updateReply(ReplyVO vo) throws Exception;
	
	//댓글 삭제
	public void deleteReply(ReplyVO vo) throws Exception;
}
