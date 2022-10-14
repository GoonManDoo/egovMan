package egovframework.example.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import egovframework.example.test.domain.ReplyVO;

@Service
public interface ReplyService {

	//댓글 조회
	public List<ReplyVO> list(int testId) throws Exception;
	
	//댓글 입력
	public void write(ReplyVO vo) throws Exception;
	
	//댓글 수정
	public void updateReply(ReplyVO vo) throws Exception;
	
	//댓글 삭제
	public void deleteReply(ReplyVO vo) throws Exception;
	
}
