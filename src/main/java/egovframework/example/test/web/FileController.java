package egovframework.example.test.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileController {
	
	@RequestMapping("/upload.do")
	public String upload(MultipartHttpServletRequest multipartRequest, 
			HttpServletRequest request, Model model) throws Exception {
		
		String UPLOAD_DIR = "repo";	
		
		// UPLOAD_DIR의 실제 경로 가져오는 것.
		String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
		
		// 1. id, name 파라미터 읽어오기
		Map map = new HashMap();	// (KEY, Value)
		// String id = multipartRequest.getParameter("id");
		// String name = multipartRequest.getParameter("name");
		Enumeration<String> e = multipartRequest.getParameterNames();
		
		while (e.hasMoreElements()) {
			String name = e.nextElement();	// id
			String value = multipartRequest.getParameter(name);
			
			map.put(name, value);
		}
		
		// 2. 파일 담고있는 파라미터 읽어오기
		Iterator<String> it = multipartRequest.getFileNames();
		List<String> fileList = new ArrayList<String>();
		
		while (it.hasNext()) {
			String paramfName = it.next();
			MultipartFile mFile = multipartRequest.getFile(paramfName);
			String oName = mFile.getOriginalFilename();	// 실제 업로드된 파일 이름
			fileList.add(oName);
			
			// 파일 업로드할 경로 확인
			File file = new File(uploadPath + "\\" + paramfName);
			
			if (mFile.getSize() != 0) {
				if (!file.exists()) {
					if (file.getParentFile().mkdirs()) {
						file.createNewFile(); 	// 임시로 파일을 생성한다.
					}
				}
				mFile.transferTo(new File(uploadPath + "\\" + oName));	// 파일 업로드
			}
		}
		
		map.put("fileList", fileList);
		model.addAttribute("map", map);
		
		return "result";
	}
	
	@RequestMapping("/download.do")
	public void download(@RequestParam("filename") String filename, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String UPLOAD_DIR = "repo";
		String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
		
		File file = new File(uploadPath + "\\" + filename);
		
		// 클라이언트로부터 넘어오는 파일 이름에 한글 있는 경우 깨짐 방지.
		filename = URLEncoder.encode(filename, "UTF-8");
		filename = filename.replace("+", " ");
		// 다운로드 준비 (서버에서 클라이언트에게 다운로드 준비 시키는 부분_다운로드 창 띄움)
		response.setContentLength((int)file.length());
		response.setContentType("application/x-msdownload;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + filename + ";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		// 	실제 다운로드를 하는 부분
		FileInputStream in = new FileInputStream(file);	// 파일 읽기 준비
		OutputStream out = response.getOutputStream();
		byte[] buffer = new byte[104];
		
		while ( true ) {
			int count = in.read(buffer);
			
			if ( count == -1 ) {
				break;
			}
			out.write(buffer, 0, count); // 다운로드 (0% ..... 100%)
		}
		
		in.close();
		out.close();
	}
}