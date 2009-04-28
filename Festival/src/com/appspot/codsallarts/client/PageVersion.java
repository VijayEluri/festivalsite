package com.appspot.codsallarts.client;

import java.io.Serializable;
import java.util.Date;

public class PageVersion implements Serializable {

	private static final long serialVersionUID = 1L;

	private String content = "";
	private String pageName = "";
	private Date createdAt;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
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
