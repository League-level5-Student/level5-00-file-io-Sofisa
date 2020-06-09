package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Write anything ");

		try {

			FileWriter fw = new FileWriter("src/_01_File_Recorder/test3.txt", true);

			fw.write("\nThis is me writing a message " + input);

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
