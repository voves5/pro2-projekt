package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;

public class Bird {
	private String name;
	private float positionX, positionY;
	private float speed;
	private int lives;
	private static final int GRAVITY = 400;
	private static final int JUMP = 650;

	// kostuktor a gettery a settery
	public Bird(String name, float positionX, float positionY) {
		super();
		this.name = name;
		this.positionX = positionX;
		this.positionY = positionY;
		speed = 0;
		lives = 3;

	}

	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		Rectangle rectangle = getRectangle();

		g.fillRect((int) rectangle.getX(), (int) rectangle.getY(), (int) rectangle.getWidth(),
				(int) rectangle.getHeight());
	}

	// vraáti souøadnice ke kolizím
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

		if (rectangle.getMinX() < 0 || rectangle.getMinY() < 0) {
			return true;
		}

		if (rectangle.getMaxX() > MainFrame.WIDTH || rectangle.getMaxY() > MainFrame.HEIGHT) {
			return true;
		} else {
			return false;
		}

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

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}

	public void goUp() {

	}

	public void catchHeart() {

	}

	public void die() {

	}

	public void addLive() {

	}

	public void removeLive() {

	}

}
