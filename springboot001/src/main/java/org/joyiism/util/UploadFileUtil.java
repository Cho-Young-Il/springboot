package org.joyiism.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtil {
	private static final String ROOT = "/attachfile";
	private static final Logger logger = 
			LoggerFactory.getLogger(UploadFileUtil.class);
	
	public static Map<String, String> uploadImageFile(String uploadPath, byte[] fileData, 
			String controller, String originalName) throws Exception {
		Map<String, String> retMap = new HashMap<>();
		
		String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);		
		if(MediaUtil.getMediaType(formatName) != null) {
			UUID uid = UUID.randomUUID();
			
			String savedDir = null;
			String savedName = null;
			String savedPath = null;
			File target = null;
			
			if(!originalName.startsWith(ROOT)) {
				logger.info("image file upload");
				
				savedName = uid.toString() + "_" + originalName;
				savedPath = calcPath(uploadPath);
				target = new File(uploadPath + savedPath, savedName);
				savedDir = ROOT + savedPath + "/" + savedName;
			} else {
				savedDir = originalName;
				target = new File(uploadPath +
					savedDir.substring(ROOT.length(), originalName.lastIndexOf("/")),
					savedDir.substring(originalName.lastIndexOf("/") + 1));
			}
			
			FileCopyUtils.copy(fileData, target);
			retMap.put("imagePath", savedDir);
			
			if(controller == "board") {
				retMap.put("thumbnailPath", makeThumbnail(
						uploadPath, savedPath, savedName));
			}
		} else {
			throw new Exception("upload file is not image");
		}
		return retMap;
	}
	
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		makeDir(uploadPath, yearPath, monthPath, datePath);
		logger.info(datePath);
		return datePath;
	}
	
	private static void makeDir(String uploadPath, String...paths) {
		if(new File(paths[paths.length - 1]).exists()){
			return;
		}
		
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			if(!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}
	
	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception {
		
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
		
		String thumbnailName = uploadPath + path + File.separator + fileName + "_thumb";
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
}
