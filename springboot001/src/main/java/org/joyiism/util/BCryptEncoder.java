package org.joyiism.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncoder {
	public static String encode(CharSequence mpwd) {
		return new BCryptPasswordEncoder().encode(mpwd);
	}
}
