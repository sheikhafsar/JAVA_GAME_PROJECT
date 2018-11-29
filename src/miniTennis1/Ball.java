package miniTennis1;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import Audio.Sound;

public class Ball {
	
	private static final int DIAMETER = 30;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private Game game;
	
	public Ball (Game game) {
		this.game=game;
	}
	
	void move() {
		
		boolean changeDirection = true;
		
		if (x + xa < 0) {
			//xa = 1;
			xa = game.speed;
		}
			
		else if (x + xa > game.getWidth() - DIAMETER)
			xa = -1;
		else if (y + ya < 0)
			ya = 1;
		else if (y + ya > game.getHeight() - DIAMETER)
			game.gameOver();
		else if (collision()){
			//ya = -1;
			ya = -game.speed;
			y = game.racquet.getTopY() - DIAMETER;
			game.speed++;
		}
		else 
			changeDirection = false;
		
		if (changeDirection) 
			Sound.BALL.play();
		
		x = x + xa;
		y = y + ya;
	}

	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}

}
