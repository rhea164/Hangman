package hangman;

import java.awt.*;
import javax.swing.*;


public class HealthPanel extends JPanel{

	private int numberOfLabels=7;
	private int remGuess=7;
	private JLabel[] lifeLabels;
	
	public HealthPanel(){
		setLayout(new GridLayout(1,numberOfLabels,10,10));
		lifeLabels=new JLabel[numberOfLabels];
		
		for(int i=0;i<numberOfLabels;i++) {
			lifeLabels[i]=new JLabel(String.valueOf(i+1));
			lifeLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			lifeLabels[i].setBackground(Color.GREEN);
			lifeLabels[i].setOpaque(true);
			lifeLabels[i].setPreferredSize(new Dimension(50, 200));
			add(lifeLabels[i]);
		}
		
		
		
	}
	
	public boolean removeLife() {
		for(int i=6;i>=0;i--) {
			if (lifeLabels[i].getBackground()==Color.GREEN) {
				lifeLabels[i].setBackground(Color.RED);
				return i== 0;
			}	
		}
		return true; //all lives are already lost
	}
}
