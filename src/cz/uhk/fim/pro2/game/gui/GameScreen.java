package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GameScreen extends Screen {

	public GameScreen(MainFrame mainFrame) {
		super(mainFrame);
		// TODO Auto-generated constructor stub
		
		
		JButton jButtonBack = new JButton("Back");
		JButton jButtonPause = new JButton("Pause");
		
		 jButtonBack.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					mainFrame.setScreen(new HomeScreen(mainFrame));
					
					
				}
			});
		 
		 
		 
		 //nastavení velikosti a pozice tlacitek
		 
		 	jButtonBack.setBounds(20,20,60,60);
		 	jButtonBack.setFont(new Font("Arial",Font.PLAIN,11));
		 	jButtonBack.setForeground(Color.red);
		 	jButtonPause.setBounds(400,20,60,60);
		
		add(jButtonBack);
		add(jButtonPause);
		
	}

}
