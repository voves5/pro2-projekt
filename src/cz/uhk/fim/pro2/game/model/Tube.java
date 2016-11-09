package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;

import cz.uhk.fim.pro2.game.gui.MainFrame;

public class Tube {
	private float positionX;
	private float height;
	private Color  color;
	
	private static final int GAP = 200;
	public Tube(float positionX, float height, Color color) {
		super();			//od niciho nededi,vol� se konstuktor Objectu
		this.positionX = positionX;
		this.height = height;
		this.color = color;
	}
	
	
	public void paint(Graphics g){
		g.setColor(Color.green);
		g.fillRect(
				(int)(getPositionX()) - 25,
				(int)height,
				50,
				(int)((MainFrame.HEIGHT) - height)
				);
	
	
		g.fillRect(
				(int)(getPositionX()) - 25,
				0,
				50,
				(int)(height - GAP)
				);
	
		
		
	}
	
	
	
	public float getPositionX() {
		return positionX;
	}
	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	
	
	
	
	
	
}
