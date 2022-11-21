package com.Webapp.miniproject;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.SecureRandom;
import java.util.Random;

public class MovieUtil {

	/** Characters allowed to create UUID. */
	private static final String UUID_STR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	/** Length of each part of the UUID. */
	private static final int UUID_LEN = 6;
	
	
	public static String generateUUID(Integer uuidLength) {

		if (uuidLength == null || uuidLength == 0) {
			uuidLength = UUID_LEN;
		}
		Random random = new SecureRandom();
		StringBuilder uuid = new StringBuilder();

		for (int i = 0; i < uuidLength; i++) {
			uuid.append(UUID_STR.charAt(random.nextInt(UUID_STR.length())));
		}

		return uuid.toString();
	}
	
	public static synchronized String getErrorMessage(final Exception e) {

		final StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		return errors.toString();
	}


}
