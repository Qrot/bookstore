package com.qrot.bookstore.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class UploadUtil {
	
	public static String uploadImg(MultipartFile file, String path, String fileName) {
		String imgPath = path + "/" + fileName;
		File dest = new File(imgPath);
		if(!dest.getParentFile().exists()) {
			dest.getParentFile().mkdir();
		}
		try {
			file.transferTo(dest);
			return imgPath;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
