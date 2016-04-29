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
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
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
	
	public int getCno() {
		return cno;
	}
	public Comment setCno(int cno) {
		this.cno = cno;
		return this;
	}
	public String getCcontent() {
		return ccontent;
	}
	public Comment setCcontent(String ccontent) {
		this.ccontent = ccontent;
		return this;
	}
	public Date getCregDate() {
		return cregDate;
	}
	public Comment setCregDate(Date cregDate) {
		this.cregDate = cregDate;
		return this;
	}
	public Date getCmodDate() {
		return cmodDate;
	}
	public Comment setCmodDate(Date cmodDate) {
		this.cmodDate = cmodDate;
		return this;
	}
	public Board getBoard() {
		return board;
	}
	public Comment setBoard(Board board) {
		this.board = board;
		return this;
	}
	public Member getMember() {
		return member;
	}
	public Comment setMember(Member member) {
		this.member = member;
		return this;
	}
}
