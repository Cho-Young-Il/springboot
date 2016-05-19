package org.joyiism.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncoder {
	public static String encode(CharSequence mpwd) {
		return new BCryptPasswordEncoder().encode(mpwd);
	}
	
	public static boolean matches(CharSequence mpwd, String encodedPass) {
		return new BCryptPasswordEncoder().matches(mpwd, encodedPass);
	}
}
