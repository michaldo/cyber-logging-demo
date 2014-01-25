package com.cybercom.demo.logging.base;


public class CoolToString {
	
	private String content;
	
	private int contentHashCode;
	
	public CoolToString(String s){
		content = s;
		contentHashCode = s.hashCode();
	}
	
	public String toString() {
		return content + "=>" + contentHashCode; 
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getContentHashCode() {
		return contentHashCode;
	}

	public void setContentHashCode(int contentHashCode) {
		this.contentHashCode = contentHashCode;
	}

}
