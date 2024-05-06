package hangman;

import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame{

	private HealthPanel healthPanel;
	private WordPanel wordPanel;
	private ButtonPanel buttonPanel;
	private String word;
	private boolean gameOver;
	String message;
	String randomWord;
	public MainWindow() {
		
		resetGame();

	}
	
	public void makeGuess(String letter) {
		if(!gameOver) {
			boolean correctGuess=wordPanel.guess(letter);
			if(!correctGuess) {
				gameOver=healthPanel.removeLife();
			}
			else {
				gameOver=wordPanel.isWordGuessed();
			}
			
			buttonPanel.updateButtons(letter);
		
			if(gameOver) {
			handleGameOver();
		}
		}
		
	}
	
	public void handleGameOver() {
		if(wordPanel.isWordGuessed()) {
			 message="Congratulations! You found the mystery word!\n\n Would you like to play another game?";
			int choice=JOptionPane.showConfirmDialog(this, message, "Victory", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
			if(choice==JOptionPane.YES_OPTION) 
				resetGame();
			else
				System.exit(0);
		}
		else {
			message="Unfortunately, you failed to find the mystery word!\n\n"
					+ "The mystery word was: "+word.toUpperCase()+ "\n\nDo you want to play another game?";
			int choice=JOptionPane.showConfirmDialog(this, message,"Defeat",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
			if(choice==JOptionPane.YES_OPTION) 
				resetGame();
			else
				System.exit(0);
			
		}
	}
	
	public void resetGame() {
		
		getContentPane().removeAll();
		randomWord=WordLoader.getRandomWord();
		word= randomWord;
		wordPanel=new WordPanel(word);
		healthPanel=new HealthPanel();
		buttonPanel=new ButtonPanel(wordPanel,this);
		gameOver=false;
		
		 add(healthPanel);
		 add(buttonPanel);
	     add(wordPanel);
	     
	     revalidate();
	     repaint();
		
	}
	

}
