package egovframework.example.test.web;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import egovframework.example.test.domain.UserVO;
import egovframework.example.test.service.UserService;

@Controller
public class UserController {

	/*@Inject
	UserService service;
	
	
	//로그인 폼을 띄우는 부분
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "login/loginForm"; //login/loginForm.jsp를 띄움
	}
	
	//로그인 처리하는 부분
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String loginProcess(HttpSession session, UserVO dto) {
		String returnURL = "";
		if(session.getAttribute("login") !=null) {
			//기존에 login이란 세션 값이 존재한다면
			session.removeAttribute("login"); //기존값 제거
		}
		
		//로그인 성공하면 UserVO 객체를 반환
		UserVO vo = service.login(dto);
		
		if(vo != null) { //로그인 성공
			session.setAttribute("login", vo); //세션에 login이란 이름으로 UserVO 객체를 저장
			returnURL = "redirect:/testList.do"; //로그인 성공 시 게시글 목록 페이지로 이동
		} else { //로그인에 실패할 경우
			returnURL = "redirect:/login"; //로그인 폼으로 다시 이동
		}
		return returnURL; //위에서 설정한 returnURL을 반환해서 이동시킴
	}
	
	//로그아웃
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate(); //세션 전체를 날림
	  //session.removeAttribute("login"); //하나씩 날림
		return "redirect:/testList.do"; //로그아웃 후 게시판 목록으로 이동
	}*/
	
	
}
