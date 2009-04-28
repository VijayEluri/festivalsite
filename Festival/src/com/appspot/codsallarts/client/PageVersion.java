package com.appspot.codsallarts.client;

import java.io.Serializable;

public class PageVersion implements Serializable {

	private static final long serialVersionUID = 1L;

	private String content = "";
	private String pageName = "";
	private String createdAt = "";
	private long id = 0;
	
	public PageVersion(){
		
		
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("PV:");
		sb.append(id).append(":").append(pageName).append(":").append(createdAt).append(":").append(content);
		return sb.toString();
	}
	
}
