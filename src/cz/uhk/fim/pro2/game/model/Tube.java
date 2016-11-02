package cz.uhk.fim.pro2.game.model;

import java.awt.Color;

public class Tube {
	private float positionX;
	private float height;
	private Color  color;
	
	
	public Tube(float positionX, float height, Color color) {
		super();			//od niciho nededi,vol� se konstuktor Objectu
		this.positionX = positionX;
		this.height = height;
		this.color = color;
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
