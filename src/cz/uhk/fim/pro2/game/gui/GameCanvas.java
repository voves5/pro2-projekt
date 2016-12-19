package cz.uhk.fim.pro2.game.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.awt.Frame;
import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

import javax.imageio.ImageIO;

public class GameCanvas extends Canvas {
	private BufferedImage imgBird, imgHeart, imgTube,imgBg;
	public static final int UP_BOUND=50;
	public static final int DOWN_BOUND=85;
	private World world;

	public GameCanvas(World world) throws IOException {
		this.world = world;
		imgBird = ImageIO.read(new File("picture/bird.png"));
					   imgHeart = ImageIO.read(new File("picture/heart.png"));
					   imgBg = ImageIO.read(new File("picture/bg.png"));
					   imgTube = ImageIO.read(new File("picture/tube.png"));
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Bird bird = world.getBird();
		//g.setColor(Color.cyan);
		g.drawImage(imgBg, 0, 0, MainFrame.WIDTH, MainFrame.HEIGHT, null);
		g.setColor(Color.black);
		g.fillRect(0, UP_BOUND, MainFrame.WIDTH, 1);
		bird.paint(g,imgBird);

		List<Heart> hearts = world.getHearts();
		
		for(Heart heart: hearts){
			heart.paint(g, imgHeart);
		}
		List<Tube> tubes = world.getTubes();
		for(Tube tube : world.getTubes()){
			tube.paint(g, imgTube);
		}
	}
}
