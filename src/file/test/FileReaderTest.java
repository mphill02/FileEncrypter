package file.test;

import static org.junit.Assert.*;
import file.io.FileEncrypter;
import java.io.File;

import org.junit.Test;

public class FileReaderTest {

	@Test
	/* Create a file in your project. Use the File object to open it. */
	public void testOpenFile() throws Exception {
		assertTrue(FileEncrypter.openSecretFile().isFile());
	}
	@Test
	/* Adjust these asserts to match the text in your secret file. */
	public void testReadFile() throws Exception {
		File file = FileEncrypter.openSecretFile();
		assertEquals("Happy friyday!!", FileEncrypter.readOneLine(file));
		assertEquals("Happy friyday!!other stuff", FileEncrypter.readFileContents(file));
	}
	@Test
	/* Create your own encryption algorithm and adjust the asserts. */
	public void testEncrypt() throws Exception {
		String encryptMe = "lalala";
		assertEquals("ncncnc", FileEncrypter.encrypt(encryptMe));
	}
	
	@Test
	public void testSaveAFile() throws Exception {
		assertTrue(FileEncrypter.saveFile("fileName").isFile());
	}
	
	@Test
	public void testSaveStuffInFile() throws Exception {
		File file = new File("filewithstuff");
		FileEncrypter.saveStuffInAFile("stuff", file);
		assertEquals("stuff", FileEncrypter.readFileContents(file));
	}
	
	@Test
	public void testDecrypt() throws Exception {
		String decryptMe = "ncncnc";
		assertEquals("lalala", FileEncrypter.decrypt(decryptMe));
	}
	
	@Test
	public void testEverythingTogether() throws Exception {
		String secretfileName = "junessecrets";
		File secretFile = new File(secretfileName);
		String stuffToEncrypt = FileEncrypter.readFileContents(secretFile);
		String encryptedStuff = FileEncrypter.encrypt(stuffToEncrypt);
		FileEncrypter.saveStuffInAFile(encryptedStuff, secretFile);

		assertEquals(stuffToEncrypt, FileEncrypter.decrypt(FileEncrypter.readFileContents(secretFile)));
	}

}
