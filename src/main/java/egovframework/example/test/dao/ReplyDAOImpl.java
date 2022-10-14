package egovframework.example.test.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import egovframework.example.test.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
	@Inject
	private SqlSession sql;
	
	private static String namespace = "egovframework.sqlmap.mappers.replyMapper";

	//댓글 조회
	@Override
	public List<ReplyVO> list(int testId) throws Exception {
		return sql.selectList(namespace + ".replyList", testId);
	}
	
	//댓글 작성
	@Override
	public void write(ReplyVO vo) throws Exception {
		sql.insert(namespace + ".replyWrite", vo);
	}

	//댓글 수정
	@Override
	public void updateReply(ReplyVO vo) throws Exception {
		sql.update(namespace + ".updateReply", vo);
	}

	//댓글 삭제
	@Override
	public void deleteReply(ReplyVO vo) throws Exception {
		sql.delete(namespace + ".deleteReply", vo);
	}

	

	

}
