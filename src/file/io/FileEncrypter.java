package file.io;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;

public class FileEncrypter {
	static String filePath = "files/testfile.txt";

	public FileEncrypter() {
		// TODO Auto-generated constructor stub
	}

	public static void foo() {
		
	}
	
	public static File openSecretFile() throws Exception {
		File file = new File(filePath);
		System.out.println("File path: " + file.getCanonicalPath());
		return file;
	}
	
	public static String readOneLine(File file) throws Exception {
		String line = "";
		BufferedReader in = new BufferedReader(new FileReader(file));
		line = in.readLine();
		in.close();
		
		return line;
	}
	
	public static String readFileContents(File file) throws Exception {
		String line = "";
		String currentLine = "";
		BufferedReader in = new BufferedReader(new FileReader(file));
		while ((currentLine = in.readLine()) != null) {
			line = line + currentLine;
		}
		in.close();
		
		return line;
	}
	
	public static String encrypt(String key) {
		String returnKey = "";
		for (int i = 0; i < key.length(); i++) {
			if (key.charAt(i)=='l') {
				returnKey = returnKey + "n";
			} else {
				returnKey = returnKey + "c";
			}
		}
		return returnKey;
	}
	
	public static File saveFile(String fileName) throws Exception {
		File file =  new File(fileName);
		FileWriter fw = new FileWriter(file);
		fw.write("stuf");
		fw.close();
		return file;
	}

	public static String saveStuffInAFile(String line, File file) throws Exception {
		FileWriter fw = new FileWriter(file);
		fw.write(line);
		fw.close();
		String stuff = readFileContents(file);
		return stuff;
	}
	
	public static String decrypt(String key) {
		String returnKey = "";
		for (int i = 0; i < key.length(); i++) {
			if (key.charAt(i)=='n') {
				returnKey = returnKey + "l";
			} else {
				returnKey = returnKey + "a";
			}
		}
		return returnKey;
	}
}
