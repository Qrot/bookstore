package com.qrot.bookstore.background.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.qrot.bookstore.util.UploadUtil;


@RestController
@RequestMapping("api/1")
@CrossOrigin
public class FileUploadController {
	
//	@PostMapping(path="/coverFile",consumes="multipart/form/data",produces="application/json")
//	public String upload(@RequestBody MultipartFile file, Map<String, Object> map) {
//		String localPath = "../../../../../../resource/static/img";
//		String msg = "";
//		String imgPath = UploadUtil.uploadImg(file, localPath, file.getOriginalFilename());
//		if(imgPath!=null) {
//			msg = imgPath;
//		}else {
//			msg = "上传失败！";
//		}
//		return msg;
//	}
	
	
	
}
