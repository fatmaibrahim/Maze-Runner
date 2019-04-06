package gifts;

import javax.swing.ImageIcon;

import mazeElements.Runner;

public class Coin extends Gift {
	
	public Coin(){
		this.image= new ImageIcon("resources/Coin (2).png").getImage();
	}
	
	public void hit(Runner r) {
		if(!isAlreadyHit()){
			markAsHit();
			r.setScore(r.getScore() + 1.0); // this is not the final formula
		}
		r.setPreviousWasWater(false);
	}
	public String getElementName(){
		return "a coin" ;
	}
	public char getCharRepresentation(){
		return '$';
	}
}
