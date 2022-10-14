package egovframework.example.test.domain;


public class UserVO {

	private String mbr_code = "";
	private String mbrId = "";
	private String mbrPw = "";
	private String mbrPw_check = "";
	private String mbr_name = "";
	
	
	public String getMbr_code() {
		return mbr_code;
	}
	public void setMbr_code(String mbr_code) {
		this.mbr_code = mbr_code;
	}
	public String getMbrId() {
		return mbrId;
	}
	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}
	public String getMbrPw() {
		return mbrPw;
	}
	public void setMbrPw(String mbrPw) {
		this.mbrPw = mbrPw;
	}
	public String getMbrPw_check() {
		return mbrPw_check;
	}
	public void setMbrPw_check(String mbrPw_check) {
		this.mbrPw_check = mbrPw_check;
	}
	public String getMbr_name() {
		return mbr_name;
	}
	public void setMbr_name(String mbr_name) {
		this.mbr_name = mbr_name;
	}
	
	@Override
	public String toString() {
		return "UserVO [mbr_code=" + mbr_code + ", mbrId=" + mbrId + ", mbrPw=" + mbrPw + ", mbrPw_check=" + mbrPw_check
				+ ", mbr_name=" + mbr_name + "]";
	}
	
	
	
}
