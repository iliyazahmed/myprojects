package com.example.crudoperations.controllerlayer;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

	@PostMapping(value="/file", 
		      consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> fileUpload(@RequestParam("uploadFile") MultipartFile multipartFile){
		File fileConverter = new File("C:\\Users\\iliyaz\\Documents\\workspace-spring-tool-suite-4-4.13.1.RELEASE\\MyFirstTask "+multipartFile.getOriginalFilename());
		FileOutputStream fileOutputStream=null;
		try {
			fileConverter.createNewFile();
			fileOutputStream = new FileOutputStream(fileConverter);
			fileOutputStream.write(multipartFile.getBytes());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fileOutputStream.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new ResponseEntity<>("File Uploaded Successfully",HttpStatus.OK);
	}
}
