package org.joyiism.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "member", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"mid"})
})
public class Member {
	@Id @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "mno", nullable = false)
	private int mno;
	
	@Column(name = "mid", nullable = false, length = 100, unique = true)
	private String mid;
	
	@Column(name = "memail", nullable = false, length = 40)
	private String memail;
	
	@Column(name = "mpwd", nullable = false, length = 20)
	private String mpwd;
	
	@Column(name = "mname", nullable = false, length = 50)
	private String mname;
	
	@Column(name = "mreg_date", nullable = false, 
		columnDefinition = "timestamp default current_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date mregDate;
	
	@Column(name = "mmod_date", nullable = false, 
		columnDefinition="timestamp default current_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date mmodDate;
	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Board> boards;
	
	@OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	public int getMno() {
		return mno;
	}
	public Member setMno(int mno) {
		this.mno = mno;
		return this;
	}
	public String getMid() {
		return mid;
	}
	public Member setMid(String mid) {
		this.mid = mid;
		return this;
	}
	public String getMemail() {
		return memail;
	}
	public Member setMemail(String memail) {
		this.memail = memail;
		return this;
	}
	public String getMpwd() {
		return mpwd;
	}
	public Member setMpwd(String mpwd) {
		this.mpwd = mpwd;
		return this;
	}
	public String getMname() {
		return mname;
	}
	public Member setMname(String mname) {
		this.mname = mname;
		return this;
	}
	public Date getMregDate() {
		return mregDate;
	}
	public Member setMregDate(Date mregDate) {
		this.mregDate = mregDate;
		return this;
	}
	public Date getMmodDate() {
		return mmodDate;
	}
	public Member setMmodDate(Date mmodDate) {
		this.mmodDate = mmodDate;
		return this;
	}
	public List<Board> getBoards() {
		return boards;
	}
	public Member setBoards(List<Board> boards) {
		this.boards = boards;
		return this;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public Member setComments(List<Comment> comments) {
		this.comments = comments;
		return this;
	}
}
