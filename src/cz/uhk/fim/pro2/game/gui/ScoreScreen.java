package cz.uhk.fim.pro2.game.gui;

import cz.uhk.fim.pro2.game.ScoreManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ScoreScreen extends Screen {

	public ScoreScreen(MainFrame mainFrame) {
		super(mainFrame);

		for (int i = 0; i < ScoreManager.getItemNumber(); i++) {
			int score = ScoreManager.getItemIndex(i);
			Scoreithemm scoreItem = new Scoreithemm(i+1,score);
			scoreItem.setBounds(50,200+i*50,300,50);

			add(scoreItem);

		}
				ScoreManager.getList();
				JButton jButtonBack = new JButton("Back");
				 jButtonBack.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					mainFrame.setScreen(new HomeScreen(mainFrame));
				}
			});
	add(jButtonBack);	
	}
}
