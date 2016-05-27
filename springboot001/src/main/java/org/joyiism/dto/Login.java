package org.joyiism.dto;

public class Login {
	private int mno;
	private String mid;
	private String memail;
	private String mpwd;
	private String mname;
	private String mphoto;
	private boolean useCookie;

	public Login() {}	
	public Login(int mno, String mid, String memail, String mname, String mphoto) {
		this.mno = mno;
		this.mid = mid;
		this.memail = memail;
		this.mname = mname;
		this.mphoto = mphoto;
	}

	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMpwd() {
		return mpwd;
	}
	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMphoto() {
		return mphoto;
	}
	public void setMphoto(String mphoto) {
		this.mphoto = mphoto;
	}
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	
	@Override
	public String toString() {
		return "Login [mno=" + mno + ", mid=" + mid + ", mpwd=" + mpwd + ", mname=" + mname + ", mphoto=" + mphoto
				+ ", useCookie=" + useCookie + "]";
	}
}
