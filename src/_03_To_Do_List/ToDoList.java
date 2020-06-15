package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton add;
	JButton view;
	JButton remove;
	JButton save;
	JButton load;
	String task;
	int num = 0;
	ArrayList<String> book = new ArrayList<String>();

	public static void main(String[] args) {
		ToDoList todo = new ToDoList();
		todo.build();

	}

	void build() {
		frame = new JFrame();
		frame.setSize(700, 100);
		frame.setVisible(true);
		panel = new JPanel();
		frame.add(panel);
		add = new JButton();
		view = new JButton();
		remove = new JButton();
		save = new JButton();
		load = new JButton();
		panel.add(add);
		add.setLabel("Add Task");
		add.addActionListener(this);
		panel.add(view);
		view.setLabel("View Tasks");
		view.addActionListener(this);
		panel.add(remove);
		remove.setLabel("Remove Task");
		remove.addActionListener(this);
		panel.add(save);
		save.setLabel("Save List");
		save.addActionListener(this);
		panel.add(load);
		load.setLabel("Load List");
		load.addActionListener(this);

	}

	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == add) {
			task = JOptionPane.showInputDialog("Enter in a task");
			book.add(num + " " + task);
			num++;
		}

		if (e.getSource() == view) {
			JOptionPane.showMessageDialog(null, book);
		}

		// load list
		if (e.getSource() == load) {
			String location = JOptionPane.showInputDialog("Enter the location of the file");
			book.clear();
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/" + location));

				String line = br.readLine();
				while (line != null) {
					book.add(line);
					num++;
					line = br.readLine();
				}

				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		// save list
		if (e.getSource() == save) {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/ToDo.txt");
				for (int i = 0; i < book.size(); i++) {
					fw.write(book.get(i) + "\n");
				}

				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		// remover
		if (e.getSource() == remove) {
			String remover = JOptionPane.showInputDialog("Write which task you wish to remove");
			int removerNum = Integer.parseInt(remover);
			if (removerNum < book.size()) {
				for (int i = removerNum + 1; i < book.size(); i++) {
					book.set(i, (Character.getNumericValue(book.get(i).charAt(0)) - 1) + book.get(i).substring(1));
				}
				book.remove(removerNum);
			}

		}
	}
}
