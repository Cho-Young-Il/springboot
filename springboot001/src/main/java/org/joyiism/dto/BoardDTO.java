package org.joyiism.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.joyiism.domain.Attachfile;
import org.joyiism.domain.Board;
import org.joyiism.domain.Comment;

public class BoardDTO {
	private int bno;
	private int bgroup;
	private int bgroupSeq;
	private int bdepth;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private String bregDate;
	private String bmodDate;
	private List<Comment> comments = new ArrayList<>();
	private List<Attachfile> files = new ArrayList<>();
	
	public BoardDTO() {}
	public BoardDTO(Board board) {
		this.bno = board.getBno();
		this.bgroup = board.getBgroup();
		this.bgroupSeq = board.getBgroupSeq();
		this.bdepth = board.getBdepth();
		this.btitle = board.getBtitle();
		this.bcontent = board.getBcontent();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm");
		this.bregDate = dateFormat.format(board.getBregDate());
		this.bmodDate = dateFormat.format(board.getBmodDate());
		
		this.bwriter = board.getMember().getMname();
		
		this.comments = board.getComments();
	}

	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getBgroup() {
		return bgroup;
	}
	public void setBgroup(int bgroup) {
		this.bgroup = bgroup;
	}
	public int getBgroupSeq() {
		return bgroupSeq;
	}
	public void setBgroupSeq(int bgroupSeq) {
		this.bgroupSeq = bgroupSeq;
	}
	public int getBdepth() {
		return bdepth;
	}
	public void setBdepth(int bdepth) {
		this.bdepth = bdepth;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public String getBregDate() {
		return bregDate;
	}
	public void setBregDate(String bregDate) {
		this.bregDate = bregDate;
	}
	public String getBmodDate() {
		return bmodDate;
	}
	public void setBmodDate(String bmodDate) {
		this.bmodDate = bmodDate;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Attachfile> getFiles() {
		return files;
	}
	public void setFiles(List<Attachfile> files) {
		this.files = files;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", bgroup=" + bgroup + ", bgroupSeq=" + bgroupSeq + ", bdepth=" + bdepth
				+ ", btitle=" + btitle + ", bcontent=" + bcontent + ", bwriter=" + bwriter + ", bregDate=" + bregDate
				+ ", bmodDate=" + bmodDate + ", comments=" + comments + ", files=" + files + "]";
	}
}
