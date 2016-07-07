package org.joyiism.dto;

import java.text.SimpleDateFormat;

import org.joyiism.domain.Comment;

public class CommentDTO {
	private int cno;
	private String ccontent;
	private String cregDate;
	private String cmodDate;
	
	
	public CommentDTO() {}
	public CommentDTO(Comment comment) {
		this.cno = comment.getCno();
		this.ccontent = comment.getCcontent();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm");
		this.cregDate = dateFormat.format(comment.getCregDate());
		this.cmodDate = dateFormat.format(comment.getCmodDate());
	}
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public String getCregDate() {
		return cregDate;
	}
	public void setCregDate(String cregDate) {
		this.cregDate = cregDate;
	}
	public String getCmodDate() {
		return cmodDate;
	}
	public void setCmodDate(String cmodDate) {
		this.cmodDate = cmodDate;
	}
	
	@Override
	public String toString() {
		return "CommentDTO [cno=" + cno + ", ccontent=" + ccontent + ", cregDate=" + cregDate + ", cmodDate=" + cmodDate
				+ "]";
	}
}
