package gameBoard;

public class Medium extends Board {
	private static Board instance = new Medium(50,50);
	
	public static Board getInstance(){
		return instance;
	}
	private Medium(int h, int w) {
		super(h, w);
		createFinalMaze(1, 1, 2);
		// TODO Auto-generated constructor stub
	}

}
