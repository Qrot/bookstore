package com.qrot.bookstore.file;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qrot.bookstore.background.model.Book;
import com.qrot.bookstore.reception.mapper.ReceBookMapper;

@Controller
@RequestMapping("/")
@CrossOrigin
public class FileUploadController {

	private final ResourceLoader resourceLoader;
	
	@Autowired
	ReceBookMapper bookMapper;
	
	@Autowired
    public FileUploadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
	
	/**
    *
    * @param file 要上传的文件
    * @return
    */
   @RequestMapping("fileUpload")
   @ResponseBody
   public String upload( MultipartFile file, Map<String, Object> map){

       // 要上传的目标文件存放路径
       String localPath = "E:/Downloads";
       // 上传成功或者失败的提示
       String msg = "";

       Book book = new Book();
       book.setCover(localPath+"/"+file.getOriginalFilename());
       book.setBookid(1004);
       if (FileUtils.upload(file, localPath, file.getOriginalFilename())){
    	   bookMapper.coverupdate(book);
           // 上传成功，给出页面提示
           msg = "上传成功！";
       }else {
           msg = "上传失败！";

       }
	return msg;
   }
}
   
