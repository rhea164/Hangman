package hangman;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class WordPanel extends JPanel {
	private JLabel wordLabel;
	String word;
	StringBuilder guessedWord;
	
	WordPanel(String word){
		this.word=word;
		guessedWord=new StringBuilder(word.replaceAll("\\w", "_ "));
		EmptyBorder margin=new EmptyBorder(50,0,10,0);
		wordLabel=new JLabel(guessedWord.toString());
		wordLabel.setFont(new Font("Arial",Font.BOLD,20));
		wordLabel.setBorder(margin);
		add(wordLabel,JLabel.CENTER);

	}
	
	public boolean guess(String letter) {
		boolean success=false;
		//char guessChar=Character.toUpperCase(letter.charAt(0));
		for(int i=0; i<word.length();i++) {
			if(Character.toUpperCase(word.charAt(i))==letter.charAt(0)) {
				guessedWord.setCharAt(i * 2, letter.charAt(0));
				success=true;
			}
		}
		wordLabel.setText(guessedWord.toString());
		return success;
	}
	
	public boolean isWordGuessed() {
		return !guessedWord.toString().contains("_ ");
	}
	
	
	

}
