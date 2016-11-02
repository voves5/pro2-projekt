package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

public class GameScreen extends Screen {

	public GameScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		
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
		
		
		
		
		
		
		//WORLD
		Bird bird = new Bird("Jakub",240,400);
		World world = new World(bird);
		world.addTubes(new Tube(400,400,Color.green));
		world.addTubes(new Tube(600,300,Color.green));
		world.addTubes(new Tube(800,500,Color.green));
		
		world.addHeart(new Heart(500, 450));
		world.addHeart(new Heart(700, 600));
		
		
		
		GameCanvas gameCanvas = new GameCanvas(world);
		gameCanvas.setBounds(0,0,MainFrame.WIDTH,MainFrame.HEIGHT);
		add(gameCanvas);
		
		
		
			
		}
	
	
}
