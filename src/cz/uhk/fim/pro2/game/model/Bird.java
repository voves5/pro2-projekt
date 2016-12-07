package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import cz.uhk.fim.pro2.game.gui.*;



public class Bird {
	private String name;
	private float positionX, positionY;
	private float speed;
	private int lifes;
	private int score;
	private static final int GRAVITY = 500;
	public static final int JUMP = 950;
	public static final int DEFAULT_SCORE =0;
	public static final int DEFAULT_LIFES =3;

	// kostuktor a gettery a settery
	public Bird(String name, float positionX, float positionY) {
		super();
		this.name = name;
		this.positionX = positionX;
		this.positionY = positionY;
		speed = JUMP/2;
		lifes =DEFAULT_LIFES;
		score = DEFAULT_SCORE;

	}

	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		Rectangle rectangle = getRectangle();

		g.fillRect((int) rectangle.getX(), (int) rectangle.getY(), (int) rectangle.getWidth(),
				(int) rectangle.getHeight());
	}

	// vra�ti sou�adnice ke koliz�m
	public Rectangle getRectangle() {
		return new Rectangle((int) (getPositionX() - 25), (int) getPositionY() - 25, 50, 50);
	}

	// rozpohybuj ptaka
	public void update(float deltaTime) {
		positionY -= speed * deltaTime;
		positionY += GRAVITY * deltaTime;
		speed -= speed * deltaTime;
	}

	// naraz do trubky
	public Boolean collideWith(Tube tube) {
		Rectangle rectangle = getRectangle();

		return rectangle.intersects(tube.getBottomRectangle()) || rectangle.intersects(tube.getTopRectangle());
	}

	// kolize se srdce
	public Boolean collideWith(Heart heart) {
		return getRectangle().intersects(heart.getRectangle());
	}

	// naraz do zeme
	public Boolean isOutOf() {
		Rectangle rectangle = getRectangle();

		int upLimit = GameCanvas.UP_BOUND;
		int downLimit = MainFrame.HEIGHT - GameCanvas.DOWN_BOUND;
		return rectangle.getMinY() <upLimit || rectangle.getMaxY()>downLimit;

	}

	public String getName() {
		return name;
	}

	public float getPositionX() {
		return positionX;
	}

	public float getPositionY() {
		return positionY;
	}

	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getLifes() {
		return lifes;
	}

	public void setLifes(int lives) {
		this.lifes = lifes;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}

	public void goUp() {

	}

	public boolean isAlive(){
		return lifes>0;
		}


	public void addPoint(){
		score++;
	}
	public int getScore(){
		return score;
	}
	public void setScore(int score){
		this.score = score;
	}
	public void catchHeart(){
		lifes++;
	}
	public void die(){

	}
	public void addLive(){

	}
	public void removeLive(){
		lifes--;
	}


}
