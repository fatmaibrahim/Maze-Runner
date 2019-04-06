package killers;

import javax.swing.ImageIcon;

import mazeElements.Runner;

public class SmallBomb extends Bomb {

	public SmallBomb(){
		this.image= new ImageIcon("resources/B_bomb.png").getImage();
		}
	public void hit(Runner r) {
		if(!isAlreadyHit()){
			markAsHit();	
			r.setLives(r.getLives() - 0.5);
		}
		r.setPreviousWasWater(false);
	}
	public String getElementName(){
		return "a small bomb";
	}
	public char getCharRepresentation(){
		return 'b';
	}
}
