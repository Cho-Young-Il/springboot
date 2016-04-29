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
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
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
	
	public int getFno() {
		return fno;
	}
	public Attachfile setFno(int fno) {
		this.fno = fno;
		return this;
	}
	public String getForiName() {
		return foriName;
	}
	public Attachfile setForiName(String foriName) {
		this.foriName = foriName;
		return this;
	}
	public String getFrealName() {
		return frealName;
	}
	public Attachfile setFrealName(String frealName) {
		this.frealName = frealName;
		return this;
	}
	public String getFsavedDir() {
		return fsavedDir;
	}
	public Attachfile setFsavedDir(String fsavedDir) {
		this.fsavedDir = fsavedDir;
		return this;
	}
	public String getFthumbDir() {
		return fthumbDir;
	}
	public Attachfile setFthumbDir(String fthumbDir) {
		this.fthumbDir = fthumbDir;
		return this;
	}
	public Board getBoard() {
		return board;
	}
	public Attachfile setBoard(Board board) {
		this.board = board;
		return this;
	}
}
