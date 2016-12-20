package cz.uhk.fim.pro2.game;

import cz.uhk.fim.pro2.game.gui.HomeScreen;
import cz.uhk.fim.pro2.game.gui.MainFrame;

import java.io.File;
import java.io.IOException;

public class Game {
	public static final String FILE = "Score.csv";

	public static void main(String[] args) {

		File file = new File(FILE);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	MainFrame mainFrame =  new MainFrame();
	HomeScreen homeScreen = new HomeScreen(mainFrame);
	mainFrame.setScreen(new HomeScreen(mainFrame));
	}
} 
