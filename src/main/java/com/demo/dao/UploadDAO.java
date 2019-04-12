//package com.demo.dao;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.nio.file.Paths;
//
//import javax.annotation.Resource;
//
//import org.springframework.core.io.UrlResource;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.google.common.io.Files;
//
//import io.swagger.models.Path;
//
//public class UploadDAO {
//	private final String UPLOAD_AVATAR = System.getProperty("user.dir")+"/imagesAvatar";
//	// UPLOAD FILE
//	public String upLoadFileAvatar(MultipartFile file) throws IOException{
//		File file2 = new File(UPLOAD_AVATAR);
//		file2.mkdirs();
//		if (file.isEmpty()) {
//			return"Empty";
//			
//		}else {
//			String uploadFilePath = UPLOAD_AVATAR + "/" + file.getOriginalFilename();
//			byte[] bytes = file.getBytes();
//			Path path = (Path) Paths.get(uploadFilePath);
//			Files.write(path, bytes);
//			return file.getOriginalFilename();
//		}
//	}
//	
//	public Resource getImage(String filename) throws MalformedURLException {
//		File file = new File(UPLOAD_AVATAR + "/" + filename);
//		return (Resource) new UrlResource(file.toURI());
//	}
//}
