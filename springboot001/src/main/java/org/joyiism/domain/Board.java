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
	@Column(name = "bno", nullable = false)
	private int bno;
	
	@Column(name = "btitle", nullable = false, length = 255)
	private String btitle;
	
	@Column(name = "bcontent", nullable = false, 
		columnDefinition = "text")
	private String bcontent;
	
	@Column(name = "breg_date", nullable = false, 
		columnDefinition = "timestamp default current_timestamp")
	private Date bregDate;
	
	@Column(name = "bmod_date", nullable = false, 
		columnDefinition = "timestamp default current_timestamp")
	private Date bmodDate;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "mno")
	private Member member;
	
	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
	private List<Attachfile> files;
	
	public int getBno() {
		return bno;
	}
	public Board setBno(int bno) {
		this.bno = bno;
		return this;
	}
	public String getBtitle() {
		return btitle;
	}
	public Board setBtitle(String btitle) {
		this.btitle = btitle;
		return this;
	}
	public String getBcontent() {
		return bcontent;
	}
	public Board setBcontent(String bcontent) {
		this.bcontent = bcontent;
		return this;
	}
	public Date getBregDate() {
		return bregDate;
	}
	public Board setBregDate(Date bregDate) {
		this.bregDate = bregDate;
		return this;
	}
	public Date getBmodDate() {
		return bmodDate;
	}
	public Board setBmodDate(Date bmodDate) {
		this.bmodDate = bmodDate;
		return this;
	}
	public Member getMember() {
		return member;
	}
	public Board setMember(Member member) {
		this.member = member;
		return this;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public Board setComments(List<Comment> comments) {
		this.comments = comments;
		return this;
	}
	public List<Attachfile> getFiles() {
		return files;
	}
	public Board setFiles(List<Attachfile> files) {
		this.files = files;
		return this;
	}
}
