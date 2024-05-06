package hangman;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class ButtonPanel extends JPanel implements ActionListener{
	private JButton buttons[];
	private WordPanel wordPanel;
	private MainWindow main;
	
	public ButtonPanel(WordPanel wordPanel, MainWindow main){
		this.main=main;
		this.wordPanel=wordPanel;

		buttons=new JButton[26];
		setLayout(new GridLayout(4,7));
		
		char c='A';
		for(int i=0;i<26;i++) {
			buttons[i]=new JButton(String.valueOf((char)(c+i)));
			buttons[i].addActionListener(this);
			buttons[i].setPreferredSize(new Dimension(60,50));
			add(buttons[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button=(JButton)e.getSource();
		String letter=button.getText();
		main.makeGuess(letter);
		
		/*if(wordPanel.guess(letter)) {
			button.setEnabled(false);
		}
		
		if(wordPanel.isWordGuessed()) {
			System.out.println("Congratulations!You guessed the word");
		}
		
		else {
			System.out.println("Incorrect guess");
		}*/
		
		
	}
	
	public void updateButtons(String letter) {
		for(JButton button:buttons) {
			if(button.getText().equalsIgnoreCase(letter)) {
				button.setVisible(false);
				break;
			}
		}
		
	}
	

}
