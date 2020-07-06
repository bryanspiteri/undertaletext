package github.hyblocker.undertaletext.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;

public class Calc {
	public static String randomAlphanumeric(int length) {
		final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		SecureRandom rnd = new SecureRandom();
		
		StringBuilder sb = new StringBuilder( length );
		for( int i = 0; i < length; i++ ) {
			sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		}
		return sb.toString();
	}

	public static void copyInputStreamToFile(InputStream fontStream, File fontFile) {
		try {
			OutputStream outStream = new FileOutputStream(fontFile);
	        byte[] buffer = new byte[1024];
	        int len = fontStream.read(buffer);
	        while (len != -1) {
	        	outStream.write(buffer, 0, len);
	            len = fontStream.read(buffer);
	            if (Thread.interrupted()) {
	    	        outStream.close();
	                throw new InterruptedException();
	            }
	        }
	        outStream.close();
	        fontStream.close();
		} catch (Exception ex) {
			ex.printStackTrace();
	    }
	}
	
	/*
	 * Clamps 'value' between the specified 'min' and 'max' parameters
	 */
	public static float Clamp(float value, float min, float max) {
		return Math.max(min, Math.min(max, value));
	}

	/*
	 * Clamps 'value' between the specified 'min' and 'max' parameters
	 */
	public static int Clamp(int value, int min, int max) {
		return Math.max(min, Math.min(max, value));
	}
}
