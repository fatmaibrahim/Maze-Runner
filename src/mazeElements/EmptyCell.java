package mazeElements;

import javax.swing.ImageIcon;

public class EmptyCell extends AllElements {

	public EmptyCell(){
		this.setDestroyable(false);
		this.image= new ImageIcon("resources/Spase.png").getImage();
	}
	public void hit(Runner r){
		r.setPreviousWasWater(false);
	}
	public String getElementName(){
		return "an empty cell";
	}
	
	public char getCharRepresentation(){
		return '-';
	}
	
}
