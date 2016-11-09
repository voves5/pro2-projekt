package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;

public class Heart {
	private float positionX,positionY;

	public Heart(float positionX, float positionY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.red);
		g.fillRect(
				(int)(getPositionX()) -25,
				(int)(getPositionY()) -25,
				50,
				50
				);
	}
	

	public float getPositionX() {
		return positionX;
	}

	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}

	public float getPositionY() {
		return positionY;
	}

	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}
	
	
	
	
	

}
