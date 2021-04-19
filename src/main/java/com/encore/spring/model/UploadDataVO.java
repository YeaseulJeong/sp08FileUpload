package com.encore.spring.model;

import org.springframework.web.multipart.MultipartFile;

public class UploadDataVO {
	
	//필드 선언_ form 에서 사용한 이름을 필드 변수명으로 지정 해야한다  
	private String userName;
	private MultipartFile uploadFile;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	
	
	

}
