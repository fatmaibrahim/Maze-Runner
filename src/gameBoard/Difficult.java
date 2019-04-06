package gameBoard;

public class Difficult extends Board {
	
	private Difficult(int h, int w) {
		super(h, w);
		createFinalMaze(1, 1, 1);
		// TODO Auto-generated constructor stub
	}

	private static Board instance = new Difficult(70,70);
	
	public static Board getInstance(){
		return instance;
	}
}
