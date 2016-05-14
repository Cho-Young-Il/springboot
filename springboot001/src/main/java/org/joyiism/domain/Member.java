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
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
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
	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	public Member() {}
	public Member(int mno, String mid, String memail, String mpwd, String mname, Date mregDate, Date mmodDate,
			List<Board> boards, List<Comment> comments) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.memail = memail;
		this.mpwd = mpwd;
		this.mname = mname;
		this.mregDate = mregDate;
		this.mmodDate = mmodDate;
		this.boards = boards;
		this.comments = comments;
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
	public Date getMregDate() {
		return mregDate;
	}
	public void setMregDate(Date mregDate) {
		this.mregDate = mregDate;
	}
	public Date getMmodDate() {
		return mmodDate;
	}
	public void setMmodDate(Date mmodDate) {
		this.mmodDate = mmodDate;
	}
	public List<Board> getBoards() {
		return boards;
	}
	public void setBoards(List<Board> boards) {
		this.boards = boards;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	@Override
	public String toString() {
		return "Member [mno=" + mno + ", mid=" + mid + ", memail=" + memail + ", mpwd=" + mpwd + ", mname=" + mname
				+ ", mregDate=" + mregDate + ", mmodDate=" + mmodDate + ", boards=" + boards + ", comments=" + comments
				+ "]";
	}
}
