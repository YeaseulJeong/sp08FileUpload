package com.encore.spring.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MultiFileVO {
	
	// 필드 선언_ form 에서 사용한 이름을 필드 변수명으로 지정 해야한다  
	private String userName;
	private List<MultipartFile> file;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}
	
	
	

}
