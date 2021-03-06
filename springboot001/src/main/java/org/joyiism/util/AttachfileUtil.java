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

public class AttachfileUtil {
	private static final String UPLOAD_ROOT = "/attachfile";
	private static final Logger logger = LoggerFactory.getLogger(AttachfileUtil.class);
	
	public static Map<String, String> uploadImageFile(String uploadPath, byte[] fileData, 
			String controller, String originalName) throws Exception {
		Map<String, String> retMap = new HashMap<>();
		
		String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);		
		if(isMediaType(formatName)) {
			UUID uid = UUID.randomUUID();
			
			String savedDir = null;
			String savedName = null;
			String savedPath = null;
			File target = null;
			
			if(!originalName.startsWith(UPLOAD_ROOT)) {
				logger.info("image file upload");
				
				savedName = uid.toString() + "_" + originalName;
				
				retMap.put("frealName", savedName);
				
				savedPath = calcPath(uploadPath);
				target = new File(uploadPath + savedPath, savedName);
				savedDir = UPLOAD_ROOT + savedPath + "/" + savedName;
			} else {
				savedDir = originalName;
				target = new File(uploadPath +
					savedDir.substring(UPLOAD_ROOT.length(), originalName.lastIndexOf("/")),
					savedDir.substring(originalName.lastIndexOf("/") + 1));
			}
			
			FileCopyUtils.copy(fileData, target);
			retMap.put("imagePath", savedDir);
			
			if("board".equals(controller)) {
				retMap.put("thumbnailPath", UPLOAD_ROOT + makeThumbnail(
						uploadPath, savedPath, savedName));
			}
		} else {
			throw new Exception("upload file is not image");
		}
		return retMap;
	}
	
	public static void deleteFile(String savedDir) throws Exception {
		new File(savedDir).delete();
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
		
		String thumbnailName = uploadPath + path + File.separator + "thumb_" + fileName;
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
	
	private static boolean isMediaType(String mediaType) {
		for(MediaUtil mediaUtil : MediaUtil.values()) {
			if(mediaUtil.compareTo(mediaType.toUpperCase())) 
				return true;
		}
		return false;
	}
}
