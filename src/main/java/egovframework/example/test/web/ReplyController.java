package egovframework.example.test.web;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	@RequestMapping(value="/replyUpdate.do", method = RequestMethod.POST)
	public String replyUpdate(ReplyVO vo, HttpServletRequest request) throws Exception {
		
		int rno = Integer.parseInt(request.getParameter("rno"));
		vo.setRno(rno);
		
		
		replyService.updateReply(vo);
		
		return "redirect:/testDetail.do?testId=" + vo.getTestId();
		
	}
	
	
	//댓글 삭제
	@RequestMapping(value = "/replyDelete.do", method = RequestMethod.POST)
	public String replyDelete(@ModelAttribute("vo") ReplyVO vo) throws Exception {
		
		replyService.deleteReply(vo);
		
		return "redirect:/testList.do";
		
		
	}

}
