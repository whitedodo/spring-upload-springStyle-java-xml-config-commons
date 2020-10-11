package com.website.example;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	private final String UPLOAD_PATH = "c:" + File.separator + "temp" + File.separator; 

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "insert";
	}
	
	@RequestMapping(value = "/fileupload",method = RequestMethod.POST)
	public String upload(MultipartFile uploadfile, Model model) throws IOException{
		
	    logger.info("upload() POST 호출");
	    logger.info("파일 이름: {}", uploadfile.getOriginalFilename());
	    logger.info("파일 크기: {}", uploadfile.getSize());

	    String result = saveFile(uploadfile);
	    
	    if(result !=null){ // 파일 저장 성공
	    	
	        model.addAttribute("result", result);
	        
	    } else { // 파일 저장 실패
	    	
	        model.addAttribute("result","fail");
	        
	    }
	    
	    return "home";

	}
	
	@RequestMapping(value = "/fileupload2", method = RequestMethod.POST)
	public String multiupload(@RequestParam("uploadfiles") MultipartFile[] file, Model model) throws IOException {
		
		logger.info("Welcome multi file! The client locale is {}.", "Hello");
		
	    String result = "";
	    
	    for(MultipartFile f : file){
	        result += saveFile(f);
	    }
	    
		return "home";
	}
	

	private String saveFile(MultipartFile file) throws IOException{
	
		// 파일 이름 변경
	    UUID uuid = UUID.randomUUID();
	    String saveName = uuid + "_" + file.getOriginalFilename();
	
	    logger.info("saveName: {}",saveName);

        String fileName = file.getOriginalFilename();
        String contentType = file.getContentType();
        long filesize = file.getSize();
        // byte[] bytes = file.getBytes();
        
        //System.out.println("파일명:" + fileName);
        //System.out.println("컨텐츠 타입:" + contentType);
        //System.out.println("파일크기:" + filesize);
	    
	    // 저장할 File 객체를 생성(껍데기 파일)ㄴ
	    File saveFile = new File(UPLOAD_PATH, saveName); // 저장할 폴더 이름, 저장할 파일 이름
	
	    try {
	        file.transferTo(saveFile); // 업로드 파일에 saveFile이라는 껍데기 입힘
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	
	    return saveName;
	}
	
}
