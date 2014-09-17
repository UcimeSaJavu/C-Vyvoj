package com.edu4java.minitennis8;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	private static final int DIAMETER = 30;
	
	double  x = 0;
	double  y = 0;
	double  xa = 1;
	double  ya = 1;
	private Game game;

	public Ball(Game game) {
		this.game = game;
	}

	void move() {
		
		if (x + xa < 0)
			xa = game.rychlost;
		else if (x + xa > game.getWidth() - DIAMETER)
			xa = -game.rychlost;
		else if (y + ya < 0)
			ya = game.rychlost;
		else if (y + ya > game.getHeight() - DIAMETER)
			game.gameOver();
		else if (collision()){
			ya = -game.rychlost;
			y = game.racquet.getTopY() - DIAMETER;
			++game.rychlost;
			
		
		}
		x = x + xa;
		y = y + ya;
	
			}
	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.f( x,  y, DIAMETER, DIAMETER);
	}

	public Rectangle getBounds() {
		return new Rectangle( x, y, DIAMETER,DIAMETER);
	}
}