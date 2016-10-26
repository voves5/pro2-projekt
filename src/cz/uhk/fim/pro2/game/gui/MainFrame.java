package cz.uhk.fim.pro2.game.gui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	
	
	protected Screen actualScreen;
	

	public MainFrame(){
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Flappy Bird");
		setResizable(false);//nejde menit velikost okna
		
	}
	
	
	public void setScreen(Screen screen){
	if(actualScreen !=null){
		remove(actualScreen);
	}
		add(screen); //p�id� novou screen
		actualScreen = screen;
		revalidate();   //refres //zmenilo se okno a ono se prekresli
		
		
	}
	
	
	
}
