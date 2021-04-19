package com.encore.spring.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.model.MultiFileVO;
import com.encore.spring.model.UploadDataVO;

@Controller
public class MultiFileController {
	
	@RequestMapping("multiupload.do")
	public ModelAndView fileupload(MultiFileVO vo, HttpServletRequest request) throws Exception{
		//1. 업로드 된 파일을 받아온다
		List<MultipartFile> mFile = vo.getFile();
		System.out.println("MultipartFile:: "+ mFile);
		
		/* 2. 업로드 된 파일이 있다면 아래의 로직을 전개
		 * file size
		 * 업로드한 file 이름
		 */
		
		if((mFile.isEmpty()) !=true) {   // 업로드한 파일이 있다면
			for(MultipartFile file : mFile) {
			System.out.println("파일의 사이즈:: "+ file.getSize());
			System.out.println("업로드된 파일의 이름:: "+ file.getOriginalFilename());
			System.out.println("getName()???:: "+ file.getName());
			System.out.println("끝");
		}
		}
		
		//업로드한 파일을 서버에 transfer  즉  원본 파일을 copy 해서 서버 특정한 경로로 이동    (서버 tomcat 의 절대경로 들어가서 바로 저장)
		// _ 서버 경로를 지정해주는 것 
		//String root= request.getSession().getServletContext().getRealPath("/");
		//String path = root+"\\upload\\";
		
		//선생님은  (이클립스의 절대경로로 들어가서 upload 파일에 저장한 후 이클립스가 가동되면서 서버에 업로드)
		String path="C:\\JYS_PlayData\\springWorkspace\\sp08_FileUpload\\src\\main\\webapp\\upload\\";
		
		
		// 업로드한 파일의 copy본을 transfer
		System.out.println("시작");
		for(MultipartFile file : mFile) {
		File copyFile = new File(path+file.getOriginalFilename());
		file.transferTo(copyFile); // 이때 copy본이 이동한다
		System.out.println("path: "+path);
		}
		
		
		return new ModelAndView("multiUpload_result", "mFile", mFile);
	
}
	
	@RequestMapping("multiDownloadFile.do")
	public ModelAndView multidownload (String file) throws Exception{
		System.out.println("fileName:: "+ file);
		String path="C:\\JYS_PlayData\\springWorkspace\\sp08_FileUpload\\src\\main\\webapp\\upload\\";
		
		HashMap map = new HashMap();
		map.put("path", path);  // upload 된 파일이 현재 path 에 저장되어 있는 것. 여기에 있는 특정한 파일을 다운로드 하는 것
		
		// 실제로 출력 결과 페이지가 없는 bean 처리는 BeanNameViewResolver 가 담당
		return new ModelAndView("downloadView", map);  // servlet-context에서  결과 페이지가 없는 처리를 downloadView 로 넘겨주면 util.DownloadView로 인식하게끔 설정해둠
	}
}

