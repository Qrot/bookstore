package com.qrot.bookstore.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.tomcat.util.codec.binary.Base64;

public class UploadUtil {

	// 接收base64编码，转化为图片存储，返回图片存储路径
	public static String decode(String imgStr, String imgName, String localPath, String servicePath) {
		if (imgStr == null)
			return null;
		
		File file = new File(localPath);
		if(!file.exists() && !file.isDirectory()) {
			file.mkdir();
		}
		// 解码
		// 先处理字符串，去掉base64编码的头，如data:image/png;base64,/gfdgdffgdf
		imgStr = imgStr.replace(imgStr.substring(0, imgStr.indexOf(";base64,")+8), "");
		byte[] data = Base64.decodeBase64(imgStr);

		// 保存路径
		String path = "";
		String prefix = imgName.substring(imgName.lastIndexOf(".")+1);
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			path = md5.digest(imgStr.getBytes()).toString();
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		path = localPath + "/" + path + "." + prefix;
		String newPath = servicePath + "/" + path;
		try {
			OutputStream out = new FileOutputStream(newPath);
			out.write(data);
			out.flush();
			out.close();
			return path;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
