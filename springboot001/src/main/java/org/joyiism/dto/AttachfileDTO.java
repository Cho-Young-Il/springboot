package org.joyiism.dto;

import org.joyiism.domain.Attachfile;

public class AttachfileDTO {
	private int fno;
	private String foriName;
	private String frealName;
	private String fsavedDir;
	private String fthumbDir;
	
	public AttachfileDTO() {}
	public AttachfileDTO(Attachfile attachfile) {
		this.fno = attachfile.getFno();
		this.foriName = attachfile.getForiName();
		this.frealName = attachfile.getFrealName();
		this.fsavedDir = attachfile.getFsavedDir();
		this.fthumbDir = attachfile.getFthumbDir();
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
	
	@Override
	public String toString() {
		return "AttachfileDTO [fno=" + fno + ", foriName=" + foriName + ", frealName=" + frealName + ", fsavedDir="
				+ fsavedDir + ", fthumbDir=" + fthumbDir + "]";
	}
}
