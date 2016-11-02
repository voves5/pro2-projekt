package cz.uhk.fim.pro2.game.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class HomeScreen extends Screen {
	
	public HomeScreen(MainFrame mainFrame){
		super(mainFrame);
		
		
		 JButton jButtonPlay = new JButton("Play");
		 JButton jButtonScore = new JButton("Score");
		 JButton jButtonSound = new JButton("Sound");
		 JLabel jLableNadpis = new JLabel("FIM BIRD");
		 
		
		 
		 
		 
		 
		 jButtonPlay.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					mainFrame.setScreen(new GameScreen(mainFrame));
					
					
				}
			});
		 
		 
		 jButtonScore.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					mainFrame.setScreen(new ScoreScreen(mainFrame));
					
					
				}
			});
		 
		 
		 //font JLable
		 
		 jLableNadpis.setFont(new Font("Arial",Font.BOLD,40));
		 
		 //nastaveni velikost a pozici
		 	jLableNadpis.setBounds(0,0,280,50);
		 	jButtonPlay.setBounds(100,400,280,50);
		 	jButtonScore.setBounds(100,460,280,50);
		 	jButtonSound.setBounds(100,520,280,50);
		 
		 
		 
		 
		 
		 
		 
		 add(jLableNadpis);
		 add(jButtonPlay);
		 add(jButtonScore);
		 add(jButtonSound);
	
}
	
	
	
	
}
