package org.joyiism.domain;

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
@Table(name = "attachfile")
public class Attachfile {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fno", nullable = false)
	private int fno;
	
	@Column(name = "fori_name", nullable = false, length = 255)
	private String foriName;
	
	@Column(name = "freal_name", nullable = false, length = 255)
	private String frealName;
	
	@Column(name = "fsaved_dir", nullable = false, length = 255)
	private String fsavedDir;
	
	@Column(name = "fthumb_dir", nullable = false, length = 255)
	private String fthumbDir;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "bno")
	private Board board;
	
	public Attachfile() {}
	public Attachfile(int fno, String foriName, String frealName, String fsavedDir, String fthumbDir, Board board) {
		this.fno = fno;
		this.foriName = foriName;
		this.frealName = frealName;
		this.fsavedDir = fsavedDir;
		this.fthumbDir = fthumbDir;
		this.board = board;
	}
	
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getForiName() {
		return foriName;
	}
	public void setForiName(String foriName) {
		this.foriName = foriName;
	}
	public String getFrealName() {
		return frealName;
	}
	public void setFrealName(String frealName) {
		this.frealName = frealName;
	}
	public String getFsavedDir() {
		return fsavedDir;
	}
	public void setFsavedDir(String fsavedDir) {
		this.fsavedDir = fsavedDir;
	}
	public String getFthumbDir() {
		return fthumbDir;
	}
	public void setFthumbDir(String fthumbDir) {
		this.fthumbDir = fthumbDir;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
}
