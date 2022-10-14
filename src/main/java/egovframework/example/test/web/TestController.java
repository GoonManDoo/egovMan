package egovframework.example.test.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import egovframework.example.test.domain.ReplyVO;
import egovframework.example.test.domain.Search;
import egovframework.example.test.domain.TestVO;
import egovframework.example.test.service.ReplyService;
import egovframework.example.test.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService testServiceImpl;
	
	@Inject
	private ReplyService replyservice;
	
	
	//인터셉터 테스트
	@RequestMapping(value = "/callTestList.do", method = RequestMethod.GET)
	public String home(Model model, RedirectAttributes rttr) {
		System.out.println("┏┯┯┯┯┯┓\\r\\n\" + \r\n" + 
				"				\"┃││∧ ∧│┃살려줘!!\\r\\n\" + \r\n" + 
				"				\"┃│  (≧Д≦)  ┃\\r\\n\" + \r\n" + 
				"				\"┃││ф  ф│┃\\r\\n\" + \r\n" + 
				"				\"┗┷┷┷┷┷┛\\r\\n\" + \r\n" + 
				"				\"");
		
		return "redirect:testList.do";
		
	}
	
	
	// 글 목록 리스트, 페이징, 검색
	@RequestMapping(value = "/testList.do")
	public String testListDo(Model model, @RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range,
			@RequestParam(required = false, defaultValue = "testTitle") String searchType,
			@RequestParam(required = false) String keyword, @ModelAttribute("search") Search search) throws Exception {

		// 검색
		model.addAttribute("search", search);
		search.setSearchType(searchType);
		search.setKeyword(keyword);

		// 전체 게시글 개수를 얻어와 listCnt에 저장
		int listCnt = testServiceImpl.getBoardListCnt(search);

		// 검색
		search.pageInfo(page, range, listCnt);
		// 페이징
		model.addAttribute("pagination", search);
		// 게시글 화면 출력
		model.addAttribute("list", testServiceImpl.selectTest(search));
		
		
		return "test/testList";
	}
	

	// 글 작성 클릭시 글 작성 페이지로 이동
	@RequestMapping(value = "/testRegister.do")
	public String testRegister() {
		return "test/testRegister";
	}
	
	@RequestMapping("/form.do")
	public String form() {

		return "uploadForm";
	}
	
	
	

	// 글 작성 버튼 구현
	@RequestMapping(value = "/insertTest.do")
	public String write(@ModelAttribute("testVO") TestVO testVO, RedirectAttributes rttr, MultipartHttpServletRequest uploadFile) throws Exception {

		// 파일 업로드 처리
		/*String fileName = null;
		MultipartFile uploadFile = testVO.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String originalFileName = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName); // 확장자 구하기
			UUID uuid = UUID.randomUUID(); // UUID 구하기
			fileName = uuid + "." + ext;
			uploadFile.transferTo(new File("C:\\Temp\\download\\" + fileName));
		}
		testVO.setFileName(fileName);*/
		
		// 다중 파일 업로드 처리
		/*String fileName = null;*/
		List<MultipartFile> list = uploadFile.getFiles("uploadFile");
		String src = uploadFile.getParameter("src");
		System.out.println("src value : " + src);
		/*System.out.println("fileName : " + fileName);*/
		System.out.println("uploadFile : " + uploadFile);

		String path = "C:\\Temp\\download\\";
		

		for (MultipartFile mf : list) {
			String originFileName = mf.getOriginalFilename(); // 원본 파일 명
			long fileSize = mf.getSize(); // 파일 사이즈
			

			System.out.println("원본파일명 : " + originFileName);
			System.out.println("파일크기 : " + fileSize);
			
			String fileExtension = originFileName.substring(originFileName.lastIndexOf("."),originFileName.length());
			String uploadFolder = "C:\\Temp\\download\\";

			
			
			UUID uuid = UUID.randomUUID();
			System.out.println("uuid.toString : " + uuid.toString());
			String[] uuids = uuid.toString().split("-");
			
			String uniqueName = uuids[0];
			System.out.println("생성된 고유문자열 : " + uniqueName);
			System.out.println("확장자명 : " + fileExtension);
			System.out.println("UUIDS : " + uuids);
			
			String fileName = path + System.currentTimeMillis() + originFileName;
			
			
			try {
				mf.transferTo(new File(fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			testVO.setFileName(fileName);
			System.out.println("파일네임 : " + fileName + "\n");
			
		}
		testServiceImpl.insertTest(testVO);

		return "redirect:testList.do";
	}
	
	

	// HttpServletRequest 객체안에 모든 데이터들이 들어가는데 getParameter메소드로 testId 원하는 데이터 가져옴
	// 제목 클릭 시 상세보기
	@RequestMapping(value = "/testDetail.do")
	public String viewForm(@ModelAttribute("testVO") TestVO testVO, Model model, HttpServletRequest request)
			throws Exception {

		int testId = Integer.parseInt(request.getParameter("testId"));
		testVO.setTestId(testId);

		TestVO resultVO = testServiceImpl.selectDetail(testVO);
		model.addAttribute("result", resultVO);
		
		//댓글 조회
		List<ReplyVO> reply = null;
		reply = replyservice.list(testId);
		model.addAttribute("reply",reply);

		return "test/testDetail";
	}
	

	// 수정하기
	@RequestMapping(value = "/updateTest.do", method = RequestMethod.POST)
	public String updateTest(@ModelAttribute("testVO") TestVO testVO, MultipartHttpServletRequest request) throws Exception {
		// 파일 업로드 처리
		String fileName = null;
		MultipartFile uploadFiles = testVO.getUploadFiles();
		if (!uploadFiles.isEmpty()) {
			String originalFileName = uploadFiles.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName); // 확장자 구하기
			UUID uuid = UUID.randomUUID(); // UUID 구하기
			fileName = uuid + "." + ext;
			uploadFiles.transferTo(new File("C:\\Temp\\download\\" + fileName));
		}
		testVO.setFileName(fileName);
		testServiceImpl.updateTest(testVO);
		return "redirect:testDetail.do?testId=" + testVO.getTestId();
	}

	// 삭제하기
	@RequestMapping(value = "/deleteTest.do")
	public String deleteTest(@ModelAttribute("testVO") TestVO testVO) throws Exception {
		
		
		// 로컬 파일 삭제
		/*String path = ServletContext.getRealPath("저장된 파일 경로");
		
		//현재 게시판에 존재하는 파일객체를 만듬
		File file = new File(path + "\\" + "저장된 파일 이름");
				
		if(file.exists()) { // 파일이 존재하면
			file.delete(); // 파일 삭제	
		}*/
		
		testServiceImpl.deleteTest(testVO);
		
		
		return "redirect:testList.do";
	}
	

	
	
	
	
}