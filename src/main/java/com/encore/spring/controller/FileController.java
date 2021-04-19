package com.encore.spring.controller;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.model.UploadDataVO;

@Controller
public class FileController {
	
	@RequestMapping("fileupload.do")
	public ModelAndView fileupload(UploadDataVO vo, HttpServletRequest request) throws Exception{
		//1. 업로드 된 파일을 받아온다
		MultipartFile mFile = vo.getUploadFile();
		System.out.println("MultipartFile:: "+ mFile);
		
		/* 2. 업로드 된 파일이 있다면 아래의 로직을 전개
		 * file size
		 * 업로드한 file 이름
		 */
		
		if((mFile.isEmpty()) !=true) {   // 업로드한 파일이 있다면
			System.out.println("파일의 사이즈:: "+ mFile.getSize());
			System.out.println("업로드된 파일의 이름:: "+ mFile.getOriginalFilename());
			System.out.println("getName():: "+ mFile.getName());
		}
		
		//업로드한 파일을 서버에 transfer  즉  원본 파일을 copy 해서 서버 특정한 경로로 이동 
		// _ 서버 경로를 지정해주는 것 
		String root= request.getSession().getServletContext().getRealPath("/");   // 최상위 파일인 webapp
		String path = root+"\\upload\\";
		
		// 업로드한 파일의 copy본을 transfer
		File copyFile = new File(path+mFile.getOriginalFilename());
		mFile.transferTo(copyFile); // 이때 copy본이 이동한다
		System.out.println("path: "+path);
		
		
		return new ModelAndView("upload_result", "uploadfile", mFile.getOriginalFilename());
	}
	
	@RequestMapping("fileDown.do")
	public ModelAndView filedown(String filename, HttpServletRequest request) throws Exception{   //upload_result.jsp 에서 ?다음에 보낸 filename 자동바인딩
		System.out.println("다운로드된 파일의 이름:: "+ filename);
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root+"\\upload\\";
		
		HashMap map = new HashMap();
		map.put("path", path);  // upload 된 파일이 현재 path 에 저장되어 있는 것. 여기에 있는 특정한 파일을 다운로드 하는 것
		
		// 실제로 출력 결과 페이지가 없는 bean 처리는 BeanNameViewResolver 가 담당
		return new ModelAndView("downloadView", map);  // servlet-context에서  결과 페이지가 없는 처리를 downloadView 로 넘겨주면 util.DownloadView로 인식하게끔 설정해둠
	}
	

}
