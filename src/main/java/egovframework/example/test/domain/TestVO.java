package egovframework.example.test.domain;

import org.springframework.web.multipart.MultipartFile;

public class TestVO {

	//모든 클래스는 UID를 가지고 있는데 클래스가 변경되면 값도 달라지기에 미리 명시를 해놓는 것
	private static final long serialVersionUID = 1L;

	private int testId;
	private String testTitle;
	private String testContent;
	private String testName;
	private String testDate;
	
	private String fileName;
	private MultipartFile uploadFile;
	


	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	public String getTestContent() {
		return testContent;
	}

	public void setTestContent(String testContent) {
		this.testContent = testContent;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestDate() {
		return testDate;
	}

	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	

	
	
	


}
