package cz.uhk.fim.pro2.game.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.awt.Frame;
import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

public class GameCanvas extends Canvas {
	public static final int UP_BOUND=50;
	public static final int DOWN_BOUND=85;
	private World world;

	public GameCanvas(World world){
		this.world = world;
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Bird bird = world.getBird();
		g.setColor(Color.cyan);
		g.fillRect(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);
		g.setColor(Color.black);
		g.fillRect(0, UP_BOUND, MainFrame.WIDTH, 1);

				bird.paint(g);

		List<Heart> hearts = world.getHearts();
		
		for(Heart heart: hearts){
			heart.paint(g);
		}
		
		List<Tube> tubes = world.getTubes();
		for(Tube tube : world.getTubes()){
			tube.paint(g);
		}
		
		
		
	}

}
