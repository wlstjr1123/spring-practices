package com.douzone.fileupload.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static String SAVE_PATH = "/upload-images";
	private static String URL_BASE = "/images";

	public String restore(MultipartFile multipartFile) {
		String url = null;

		try {
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

			byte[] data = multipartFile.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
			os.write(data);
			os.close();
			
			url = URL_BASE + "/" + saveFileName;
		} catch (IOException ex) {
			throw new RuntimeException("file upload error:" + ex);
		}
		return url;
	}

	private String generateSaveFileName(String extName) {
		String filename = "";

		Calendar clendar = Calendar.getInstance();

		filename += clendar.get(Calendar.YEAR);
		filename += clendar.get(Calendar.MONTH);
		filename += clendar.get(Calendar.DATE);
		filename += clendar.get(Calendar.HOUR);
		filename += clendar.get(Calendar.MINUTE);
		filename += clendar.get(Calendar.SECOND);
		filename += clendar.get(Calendar.MILLISECOND);
		filename += ("." + extName);

		clendar.get(Calendar.YEAR);
		return filename;
	}

}
