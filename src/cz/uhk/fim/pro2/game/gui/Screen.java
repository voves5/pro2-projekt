package cz.uhk.fim.pro2.game.gui;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class Screen extends JPanel {
	
	protected MainFrame mainFrame;
	
	public Screen(MainFrame mainFrame){
		this.mainFrame = mainFrame;
		setLayout(null);
		
	}
	
	
	
	
}
