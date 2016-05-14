package org.joyiism.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cno;
	
	@Column(name = "ccontent", nullable = false, 
		columnDefinition = "text")
	private String ccontent;
	
	@Column(name = "creg_date", nullable = false, 
		columnDefinition = "timestamp default current_timestamp")
	private Date cregDate;
	
	@Column(name = "cmod_date", nullable = false, 
			columnDefinition = "timestamp default current_timestamp")
	private Date cmodDate;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "bno")
	private Board board;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "mno")
	private Member member;
	
	public Comment() {}
	public Comment(int cno, String ccontent, Date cregDate, Date cmodDate, Board board, Member member) {
		this.cno = cno;
		this.ccontent = ccontent;
		this.cregDate = cregDate;
		this.cmodDate = cmodDate;
		this.board = board;
		this.member = member;
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
	public Date getCregDate() {
		return cregDate;
	}
	public void setCregDate(Date cregDate) {
		this.cregDate = cregDate;
	}
	public Date getCmodDate() {
		return cmodDate;
	}
	public void setCmodDate(Date cmodDate) {
		this.cmodDate = cmodDate;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
}
