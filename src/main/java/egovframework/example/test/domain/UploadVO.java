package egovframework.example.test.domain;

import org.springframework.web.multipart.MultipartFile;

public class UploadVO {

	private String nmae;
	private MultipartFile file;
	
	public String getNmae() {
		return nmae;
	}
	public void setNmae(String nmae) {
		this.nmae = nmae;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
