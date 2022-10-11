package egovframework.example.test.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import egovframework.example.test.domain.ReplyVO;
import egovframework.example.test.service.ReplyService;

@Controller
public class ReplyController {
	
	@Inject
	private ReplyService replyService;
	
	//댓글 조회
	
	//댓글 작성
	@RequestMapping(value = "/reply.do", method = RequestMethod.POST)
	public String postWrite(ReplyVO vo) throws Exception {
		
		replyService.write(vo);
		
		return "redirect:/testDetail.do?testId=" + vo.getTestId();
	}
	
	//댓글 수정
	
	
	//댓글 삭제

}
