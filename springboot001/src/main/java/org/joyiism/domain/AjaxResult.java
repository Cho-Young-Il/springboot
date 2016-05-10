package org.joyiism.domain;

import org.springframework.stereotype.Component;

@Component
public class AjaxResult {
	private String status;
	private Object data;
	
	public String getStatus() {
		return status;
	}
	public AjaxResult setStatus(String status) {
		this.status = status;
		return this;
	}
	public Object getData() {
		return data;
	}
	public AjaxResult setData(Object data) {
		this.data = data;
		return this;
	}
}
