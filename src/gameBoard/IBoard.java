package gameBoard;

import java.awt.Point;

import mazeElements.AllElements;
import mazeElements.Runner;

public interface IBoard {
	public void setHeight(int h);
	public void setWidth(int w);
	public int getHeight();
	public int getWidth();
	public void setStartPoint(Point start);
	public void setEndPoint(Point end);
	public Point getStartPoint();
	public Point getEndPoint();
	public AllElements getItem(int yIndex, int xIndex);
	public void setRunner(Runner runner);
}
