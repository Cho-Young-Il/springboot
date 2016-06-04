package org.joyiism.util;

public enum MediaUtil {
	JPEG("JPEG"), JPG("JPG"), PNG("PNG"), GIF("GIF");
	
	private String mediaType;
	
	MediaUtil(String mediaType) {
		this.mediaType = mediaType;
	}
	
	public boolean compareTo(String mediaType) {
		if(this.mediaType.equals(mediaType)) 
			return true;
		return false;
	}
}
