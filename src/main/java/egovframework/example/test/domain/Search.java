package egovframework.example.test.domain;

//Search 클래스가  Pagination 클래스를 상속받았으므로 기존 Pagination의 특성을 그대로 사용할 수 있다.
public class Search extends Pagination {
	
	private String searchType;
	private String keyword;
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
