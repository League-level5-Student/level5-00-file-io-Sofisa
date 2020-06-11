package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information in such a way
	 * that only authorized parties can access it and those who are not authorized
	 * cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message down based
	 * on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user. Use the key to
	 * shift each letter in the users input and save the final result to a file.
	 */

	public static void main(String[] args) {
		String message = JOptionPane.showInputDialog("Write a message ");
		// char[] messageChar = message.toCharArray();
		String key = JOptionPane.showInputDialog("Write a key for the message ");
		int keyInt = Integer.parseInt(key);
		System.out.print("Message after shift by key: ");

		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/encryptor.txt", true);
			
			for (int i = 0; i < message.length(); i++) {

				fw.write((char) (message.charAt(i) + keyInt));
			}

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
