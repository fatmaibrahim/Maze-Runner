package tryPacMan;
import java.util.Date;
import java.util.Scanner;

import gameBoard.Board;
import gameBoard.LevelFactory;
import mazeElements.*;
public class TryBoard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		LevelFactory lf = new LevelFactory();
		Board b = lf.create("medium");
		System.out.println();
		Runner r = new Runner();
		r.setPosition(b.getStartPoint());
		b.setRunner(r);
		b.printBoard();
		String query;
		Date st = new Date();
		Date end = new Date();
		long time = end.getTime() - st.getTime();
		System.out.println("time passed:" + time);
		
		while (r.isAlive() && !r.isWinner()) {
			System.out.println("enter direction");
			query = input.nextLine();
			switch (query) {
			case "down":
				r.moveDown();
				break;
			case "up":
				r.moveUp();
				break;
			case "left":
				r.moveLeft();
				break;
			case "right":
				r.moveRight();
				break;
			case "shoot":
				r.shoot(b);
				break;
			default:
				break;
			}
			b.getItem((int) r.getPosition().getY(), (int) r.getPosition().getX())
					.hit(r);
			if(!r.wasPreviousWater())
			b.destroy((int) r.getPosition().getY(), (int) r.getPosition().getX());
			b.printBoard();
			end = new Date();
			time = end.getTime() - st.getTime();
			System.out.println("time passed:" + time/60000 +"m," +(time/1000) % 60 +"s");
		}
		if (r.isAlive()) {
			System.out.println("You win");
		} else {
			System.out.println("You ran out of lives :(");
		}
		input.close();

	}
	
	public static void printBoard(Board b, Runner r) {
		for (int i = 0; i < b.getHeight(); i++) {
			for (int j = 0; j < b.getWidth(); j++) {
				if (i == r.getPosition().getY() && j == r.getPosition().getX()) {
					System.out.print("$" + "   ");
				} else {
					System.out.print(b.getItem(i, j).getCharRepresentation() + "  ");
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Bullets: " + r.getBullets());
		System.out.println("Score: " + r.getScore());
		System.out.println("Lives: " + r.getLives());

	}
}
