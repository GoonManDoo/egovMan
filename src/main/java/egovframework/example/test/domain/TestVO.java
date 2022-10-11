package egovframework.example.test.domain;

import java.util.List;

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
	private MultipartFile uploadFiles;
	private List<MultipartFile> list;
	
	/*private MultipartFile uploadFile;*/
	/*private List<TestVO> uploadFile;*/
	/*private List<MultipartFile> fileList;*/
	/*List<MultipartFile> multiFileList*/
	


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

	/*public List<MultipartFile> getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(List<MultipartFile> uploadFile) {
		this.uploadFile = uploadFile;
	}*/

	public List<MultipartFile> getList() {
		return list;
	}

	public void setList(List<MultipartFile> list) {
		this.list = list;
	}

	public MultipartFile getUploadFile() {
		// TODO Auto-generated method stub
		return null;
	}

	public MultipartFile getUploadFiles() {
		return uploadFiles;
	}

	public void setUploadFiles(MultipartFile uploadFiles) {
		this.uploadFiles = uploadFiles;
	}

	/*public List<MultipartFile> getFileList() {
		return fileList;
	}

	public void setFileList(List<MultipartFile> fileList) {
		this.fileList = fileList;
	}*/

	
	

	
	
	


}
