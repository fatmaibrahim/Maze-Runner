package startAndEnd;

import javax.swing.ImageIcon;

import mazeElements.AllElements;
import mazeElements.Runner;

public class StartPoint extends AllElements {
	public StartPoint(){
		this.setDestroyable(false);
		this.image= new ImageIcon("resources/Start.png").getImage();
	}
	public String getElementName(){
		return "start point";
	}
	public void hit(Runner r){
		r.setPreviousWasWater(false);
	}
	
	public char getCharRepresentation(){
		return '*';
	}
}
