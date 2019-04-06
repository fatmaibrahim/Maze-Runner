package gameBoard;

public class Easy extends Board {

	private static Board instance = new Easy(30,30);

	public static Board getInstance() {
		return instance;
	}

	public Easy(int h, int w) {
		super(h, w);
		createFinalMaze(1, 2, 4);

		// TODO Auto-generated constructor stub
	}
}
