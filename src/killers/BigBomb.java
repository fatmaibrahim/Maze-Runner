package killers;

import javax.swing.ImageIcon;

import mazeElements.Runner;

public class BigBomb extends Bomb {
	
	public BigBomb(){
		this.image= new ImageIcon("resources/S_bomb.png").getImage();
	}
	public void hit(Runner r) {
		if(!isAlreadyHit()){
			markAsHit();
			r.setLives(r.getLives() - 1);
		}
		r.setPreviousWasWater(false);
	}
	public String getElementName(){
		return "a big bomb";
	}
	public char getCharRepresentation(){
		return 'B';
	}
}
