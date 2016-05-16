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
	public Board(int bno, String btitle, String bcontent, Date bregDate, Date bmodDate, Member member,
			List<Comment> comments, List<Attachfile> files) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bregDate = bregDate;
		this.bmodDate = bmodDate;
		this.member = member;
		this.comments = comments;
		this.files = files;
	}
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
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
}
