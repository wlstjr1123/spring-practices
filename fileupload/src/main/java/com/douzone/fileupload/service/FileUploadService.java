package com.douzone.fileupload.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	public String restore(MultipartFile multipartFile) {
		String url = null;
		
		if (multipartFile.isEmpty()) {
			return url;
		}
		
		String originFileName = multipartFile.getOriginalFilename();
		String extName = originFileName.substring(originFileName.lastIndexOf('.') + 1);
		String saveFileName = generateSaveFileName(extName);
		long fileSize = multipartFile.getSize();
		
		System.out.println("#################" + originFileName);
		System.out.println("#################" + fileSize);
		System.out.println("#################" + saveFileName);
		
		return url;
	}

}
