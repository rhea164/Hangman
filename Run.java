package hangman;

import java.awt.GridLayout;

import javax.swing.SwingUtilities;

public class Run {

	public static void main(String[] args) {
		MainWindow main=new MainWindow();
		main.setTitle("Hangman");
		main.setSize(800,600);
		main.setLayout(new GridLayout(3,1));
		main.setVisible(true);
	}
}


