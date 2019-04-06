package mazeElements;

import gameBoard.Board;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class Runner {
	double score;
	double lives;
	int bullets, rafts = 3;
	Point position = new Point();
	Point previousPosition = new Point();
	boolean winner;
	private boolean previousWasWater = false;
	String direction;
	private Image image;
	public Runner(){
		this.setImage(new ImageIcon("resources/Runner.gif").getImage());
		
		score = 6;
		lives = 3;
		bullets = 6;
		winner = false;
		setPreviousWasWater(false);
	}

	public void moveUp() {
		this.setImage(new ImageIcon("resources/Runner.gif").getImage());
		setDirection("up");
		setPreviousPosition(position);
		if(position.getY() > 0)
		setPosition(new Point((int) position.getX(),(int) (position.getY() - 1.0)));
	}

	public void moveDown() {
		this.setImage(new ImageIcon("resources/Runner.gif").getImage());
		setDirection("down");
		setPreviousPosition(position);
		setPosition(new Point((int) position.getX(),(int) (position.getY() + 1.0)));
	}

	public void moveRight() {
		this.setImage(new ImageIcon("resources/Runner.gif").getImage());
		setDirection("right");
		setPreviousPosition(position);
		setPosition(new Point((int)( position.getX() + 1.0),(int) position.getY()));

	}

	public void moveLeft() {
		this.setImage(new ImageIcon("resources/Runner.gif").getImage());
		setDirection("left");
		setPreviousPosition(position);
		if(position.getX() > 0)
		setPosition(new Point((int)( position.getX() - 1.0),(int) position.getY()));

	}

	public Point getPreviousPosition() {
		return previousPosition;
	}
	
	public void setPreviousPosition(Point previousPosition){
		this.previousPosition = previousPosition;
	}
	public Point getPosition() {
		return position;
	}


	public void setPosition(Point position) {
		this.position = position;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getLives() {
		return lives;
	}

	public void setLives(double lives) {
		this.lives = lives;
	}

	public int getBullets() {
		return bullets;
	}

	public void setBullets(int bullets) {
		this.bullets = bullets;
	}
	public boolean isAlive(){
		return(lives > 0);
	}
	public boolean isWinner(){
		return winner;
	}
	public void markAsWinner(){
		winner = true;
	}
	public void setDirection(String direction){
		this.direction = direction;
	}
	public String getDirection(){
		return direction;
	}
	public boolean wasPreviousWater(){
		return previousWasWater;
	}
	public void setPreviousWasWater(boolean b){
		previousWasWater = b;
	}
	public int getRafts(){
		return rafts;
	}
	
	public void setRafts(int rafts){
		this.rafts = rafts;
	}
	public void shoot(Board b) {
		String direction = this.getDirection();
		int runnerX = (int) this.getPosition().getX();
		int runnerY = (int) this.getPosition().getY();
		if (direction != null && this.getBullets() > 0) {
			switch (direction) {
			case "up":
				for (int row = runnerY; row >= 0; row--) {
					if (b.getItem(row, runnerX).getCharRepresentation() == 'S') {
						break;
					}
					if (b.getItem(row, runnerX).isDestroyable()) {
						b.destroy(row, runnerX);
						break;
					}
				}
				break;
			case "down":
				for (int row = runnerY; row < b.getHeight(); row++) {
					if (b.getItem(row, runnerX).getCharRepresentation() == 'S') {
						break;
					}
					if (b.getItem(row, runnerX).isDestroyable()) {
						b.destroy(row, runnerX);
						break;
					}
				}
				break;

			case "right":
				for (int col = runnerX; col < b.getWidth(); col++) {
					if (b.getItem(runnerY, col).getCharRepresentation() == 'S') {
						break;
					}
					if (b.getItem(runnerY, col).isDestroyable()) {
						b.destroy(runnerY, col);
						break;
					}
				}
				break;

			case "left":
				for (int col = runnerX; col >= 0; col--) {
					if (b.getItem(runnerY, col).getCharRepresentation() == 'S') {
						break;
					}
					if (b.getItem(runnerY, col).isDestroyable()) {
						b.destroy(runnerY, col);
						break;
					}
				}
				break;

			default:
				break;
			}
			this.setBullets(this.getBullets() - 1);
		}
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
}

