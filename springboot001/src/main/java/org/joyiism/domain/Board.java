package org.joyiism.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "board")
public class Board {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bno")
	private int bno;

	@Column(name = "bgroup")
	private int bgroup;
	
	@Column(name = "bgroup_seq")
	private int bgroupSeq;
	
	@Column(name = "bdepth")
	private int bdepth;
	
	@Column(name = "btitle", length = 255)
	private String btitle;
	
	@Column(name = "bcontent", columnDefinition = "text")
	private String bcontent;
	
	@Column(name = "breg_date",
		columnDefinition = "timestamp default current_timestamp")
	private Date bregDate;
	
	@Column(name = "bmod_date", 
		columnDefinition = "timestamp default current_timestamp")
	private Date bmodDate;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "mno")
	private Member member;
	
	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
	private List<Attachfile> files;

	public Board() {}
	public Board(int bgroupSeq, int bdepth, String btitle,
			String bcontent, Member member, Date bmodDate) {
		this.bgroupSeq = bgroupSeq;
		this.bdepth = bdepth;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.member = member;
		this.bmodDate = bmodDate;
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
	public Date getBregDate() {
		return bregDate;
	}
	public void setBregDate(Date bregDate) {
		this.bregDate = bregDate;
	}
	public Date getBmodDate() {
		return bmodDate;
	}
	public void setBmodDate(Date bmodDate) {
		this.bmodDate = bmodDate;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
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
		return "Board [bno=" + bno + ", bgroup=" + bgroup + ", bgroupSeq=" + bgroupSeq + ", bdepth=" + bdepth
				+ ", btitle=" + btitle + ", bcontent=" + bcontent + ", bregDate=" + bregDate + ", bmodDate=" + bmodDate
				+ "member" + member + "]";
	}
}
