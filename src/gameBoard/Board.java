package gameBoard;

import gifts.GiftFactory;

import java.awt.*;
import java.util.Random;

import startAndEnd.EndPoint;
import startAndEnd.StartPoint;

import killers.BombFactory;

import walls.WallFactory;
import water.Water;

import mazeElements.AllElements;
import mazeElements.EmptyCell;
import mazeElements.Runner;

public class Board implements IBoard {
	protected AllElements[][] maze;
	Runner r;
	boolean[][] mazeInBoolean;
	boolean[][] visited;
	int height, width, empty;
	static Point startPoint, endPoint;
	int killers, gifts;

	public Board(int h, int w) {
		setHeight(h);
		setWidth(w);
		createBooleanMaze();
	}

	@Override
	public void setHeight(int h) {
		// TODO Auto-generated method stub
		h = h / 2 * 2;
		height = h;
	}

	public void setRunner(Runner r) {
		this.r = r;
	}

	public Runner getRunner() {
		return r;
	}
	
	public void setKillers(int killers){
		this.killers = killers;
	}
	
	public void setGifts(int gifts){
		this.gifts = gifts;
	}
	
	public void setEmpty(int empty){
		this.empty = empty;
	}
	@Override
	public void setWidth(int w) {
		// TODO Auto-generated method stub
		w = w / 2 * 2;
		width = w;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public void setStartPoint(Point start) {
		// TODO Auto-generated method stub
		startPoint = start;
	}

	@Override
	public void setEndPoint(Point end) {
		// TODO Auto-generated method stub
		endPoint = end;
	}

	@Override
	public Point getStartPoint() {
		// TODO Auto-generated method stub
		return startPoint;
	}

	@Override
	public Point getEndPoint() {
		// TODO Auto-generated method stub
		return endPoint;
	}

	@Override
	public AllElements getItem(int yIndex, int xIndex) {
		// TODO Auto-generated method stub
		return maze[yIndex][xIndex];
	}

	public void setItem(int yIndex, int xIndex, AllElements item) {
		maze[yIndex][xIndex] = item;
	}

	public void createBooleanMaze() {
		Point p1 = new Point(0, 0);
		Point p2 = new Point(width - 1, height - 1);
		mazeInBoolean = new boolean[height][width];
		visited = new boolean[height][width];
		generateMaze(mazeInBoolean, p1, p2);
	}

	public void createFinalMaze(int killers, int gifts, int empty) {
		maze = new AllElements[mazeInBoolean.length][mazeInBoolean[0].length];
		for (int i = 0; i < mazeInBoolean.length; i++) {
			for (int j = 0; j < mazeInBoolean[i].length; j++) {
				if (mazeInBoolean[i][j]) {
					WallFactory wf = new WallFactory();
					Random rand = new Random();
					int n = rand.nextInt(3);
					if (n == 0) {
						maze[i][j] = wf.createWall("tree");
					} else if (n == 1) {
						maze[i][j] = wf.createWall("stone");
					} else {
						maze[i][j] = new Water();
					}
				} else {
					Random rand = new Random();
					BombFactory bf = new BombFactory();
					GiftFactory gf = new GiftFactory();
					int n = rand.nextInt(killers+gifts+empty) + 1;
					if (n <= killers) {
						// put a killer
						String[] bombTypes = new String[] { "small", "big" };
						int type = rand.nextInt(2);
						maze[i][j] = bf.create(bombTypes[type]);
					} else if (n <= killers+gifts) {
						// put a gift
						String[] giftTypes = new String[]{"bullet", "coin", "live", "raft"};
						int type = rand.nextInt(2);
						maze[i][j] = gf.create(giftTypes[type]);

					} else {
						maze[i][j] = new EmptyCell();
					}
				}

			}
		}
		Random rand = new Random();
		int startX = rand.nextInt(mazeInBoolean[0].length / 3);
		startX = startX / 2 * 2;
		int startY = rand.nextInt(mazeInBoolean.length / 3);
		startY = startY / 2 * 2;
		int endX = rand.nextInt(mazeInBoolean[0].length
				- mazeInBoolean[0].length * 2 / 3)
				+ mazeInBoolean[0].length * 2 / 3;
		int endY = rand
				.nextInt(mazeInBoolean.length - mazeInBoolean.length / 2)
				+ mazeInBoolean.length / 2;
		endX = endX / 2 * 2;
		endY = endY / 2 * 2;
		maze[startY][startX] = new StartPoint();
		Point s = new Point(startX, startY);
		setStartPoint(s);
		maze[endY][endX] = new EndPoint();
		Point e = new Point(endX, endY);
		setEndPoint(e);
	}

	public boolean[][] generateMaze(boolean arr[][], Point topLeft,
			Point bottomRight) {
		int left = (int) topLeft.getX();
		int right = (int) bottomRight.getX();
		int bottom = (int) bottomRight.getY();
		int top = (int) topLeft.getY();
		Random rand = new Random();
		int n;
		int n2 = 1;
		if (bottom - top == right - left)
			n2 = rand.nextInt(2);
		if ((bottom - top) > (right - left) || n2 == 0) { // split horizontally
			n = rand.nextInt(bottom - top + 1) + top;
			n = (n / 2) * 2 + 1;
			putHorizontalWall(arr, n, left, right);
			Point p2 = new Point(right, n - 1);
			Point p3 = new Point(left, n + 1);
			if (n - 1 - top >= 1 && right - left >= 1) {
				generateMaze(arr, topLeft, p2);
			}
			if (bottom - n + 1 >= 1 && right - left >= 1) {
				generateMaze(arr, p3, bottomRight);
			}
		} else { // split vertically
			n = rand.nextInt(right - left + 1) + left;
			n = (n / 2) * 2 + 1;
			putVerticalWall(arr, n, top, bottom);
			Point p2 = new Point(n - 1, bottom);
			Point p3 = new Point(n + 1, top);
			if (bottom - top >= 1 && n - 1 - left >= 1) {
				generateMaze(arr, topLeft, p2);
			}
			if (right - n - 1 >= 1 && bottom - top >= 1) {
				generateMaze(arr, p3, bottomRight);
			}
		}
		return null;
	}

	public boolean[][] putHorizontalWall(boolean arr[][], int rowNum,
			int beginIndex, int endIndex) {
		if (rowNum < arr.length) {
			for (int i = beginIndex; i <= endIndex; i++) {
				if (!visited[rowNum][i]) {
					arr[rowNum][i] = true;
					visited[rowNum][i] = true;
				} else {
					return arr;
				}
			}
		}
		Random rand = new Random();
		int n = rand.nextInt(endIndex - beginIndex + 1) + beginIndex;
		n = (n / 2) * 2;
		arr[rowNum][n] = false;
		return arr;
	}

	public boolean[][] putVerticalWall(boolean arr[][], int colNum,
			int beginIndex, int endIndex) {
		if (colNum < arr[0].length) {
			for (int i = beginIndex; i <= endIndex; i++) {
				if (!visited[i][colNum]) {
					arr[i][colNum] = true;
					visited[i][colNum] = true;
				} else {
					return arr;
				}
			}
		}
		Random rand = new Random();

		try {
			int n = rand.nextInt(endIndex - beginIndex + 1) + beginIndex;
			n = (n / 2) * 2;
			arr[n][colNum] = false;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return arr;
	}

	public void destroy(int yIndex, int xIndex) {
		setItem(yIndex, xIndex, new EmptyCell());
	}

	public void printBoard() {
		Runner r = getRunner();
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				if (i == r.getPosition().getY() && j == r.getPosition().getX()) {
					System.out.print("æ" + "  ");
				} else {
					System.out.print(getItem(i, j).getCharRepresentation()
							+ "  ");
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Bullets: " + r.getBullets());
		System.out.println("Score: " + r.getScore());
		System.out.println("Lives: " + r.getLives());
		System.out.println("Rafts: " + r.getRafts());

	}

}
