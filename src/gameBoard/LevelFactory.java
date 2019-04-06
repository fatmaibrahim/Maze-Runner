package gameBoard;

public class LevelFactory {
	public Board create(String difficulty){
		switch (difficulty.toLowerCase()) {
		case "easy":
			return Easy.getInstance();
		
		case "medium":
			return Medium.getInstance();
		default:
			return Difficult.getInstance();
		}
	}
}
