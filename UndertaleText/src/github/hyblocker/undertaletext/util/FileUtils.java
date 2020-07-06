package github.hyblocker.undertaletext.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class FileUtils {
	
	/*
	 * Checks if a file/directory exists
	 */
	public static boolean Exists(String path) {
		if(new File(path).exists()) {
			return true;
		}
		return false;
	}
	
	/*
	 * Checks if a file/directory exists
	 */
	public static boolean Exists(File file) {
		return Exists(file.getPath());
	}
	
	/*
	 * Creates a new directory at the specified path
	 */
	public static void MakeDir(String path) {
		new File(path).mkdir();
	}
	
	/*
	 * Creates a new file at the specified path
	 */	
	public static void MakeFile(String path) {
		PrintWriter fileWriter;
		try {
			fileWriter = new PrintWriter(path,"UTF-8");
			fileWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Creates a new file at the specified path
	 */	
	public static void MakeFile(File file) {
		PrintWriter fileWriter;
		try {
			fileWriter = new PrintWriter(file.getPath(),"UTF-8");
			fileWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Attempts to write to a file a String array. If the file doesn't exist, it makes it
	 */	
	public static void WriteToFile(File file, String[] contents) {
		try {
			PrintWriter fileWriter = new PrintWriter(file.getPath(),"UTF-8");
			for(String line : contents) {
				fileWriter.println(line);
			}
			fileWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Attempts to write to a file a String array. If the file doesn't exist, it makes it
	 */	
	public static void WriteToFile(String path, String[] contents) {
		try {
			PrintWriter fileWriter = new PrintWriter(path,"UTF-8");
			for(String line : contents) {
				fileWriter.println(line);
			}
			fileWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Returns a String array of the file's contents
	 */
	public static String[] ReadFromFile(File file) {
		return ReadFromFile(file.getPath());
	}
	
	/*
	 * Returns a String array of the file's contents
	 */
	public static String[] ReadFromFile(String path) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
		    ArrayList<String> output = new ArrayList<String>();
		    String line = br.readLine();

		    while (line != null) {
		    	output.add(line);
		        line = br.readLine();
		    }
		    br.close();
		    return output.toArray(new String[0]);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
		}
		return new String[1];
	}
}
