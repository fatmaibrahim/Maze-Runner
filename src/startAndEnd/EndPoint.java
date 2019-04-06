package startAndEnd;

import javax.swing.ImageIcon;

import mazeElements.AllElements;
import mazeElements.Runner;

public class EndPoint extends AllElements{
	public EndPoint(){
		this.setDestroyable(false);
		this.image= new ImageIcon("resources/Key.png").getImage();
	}
	public void hit(Runner r){
		r.markAsWinner();
	}
	public String getElementName(){
		return "end point";
	}
	
	public char getCharRepresentation(){
		return '#';
	}
}
