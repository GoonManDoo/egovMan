package egovframework.example.test.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import egovframework.example.test.dao.ReplyDAO;
import egovframework.example.test.domain.ReplyVO;
import egovframework.example.test.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	private ReplyDAO dao;

	//댓글 조회
	@Override
	public List<ReplyVO> list(int testId) throws Exception {
		return dao.list(testId);
	}

	//댓글 입력
	@Override
	public void write(ReplyVO vo) throws Exception {
		dao.write(vo);
	}

	//댓글 수정
	@Override
	public void updateReply(ReplyVO vo) throws Exception {
		dao.updateReply(vo);
	}

	//댓글 삭제
	@Override
	public void deleteReply(ReplyVO vo) throws Exception {
		dao.deleteReply(vo);
	}
	
	

}
