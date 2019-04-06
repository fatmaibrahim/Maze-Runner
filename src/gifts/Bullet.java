package gifts;
import javax.swing.ImageIcon;

import mazeElements.Runner;

public class Bullet extends Gift {
	public Bullet(){
		this.image= new ImageIcon("resources/Bults.png").getImage();
	}
	
	
	public void hit(Runner r){
		if(!isAlreadyHit()){
			markAsHit();
			r.setBullets(r.getBullets() + 1);
		}
		r.setPreviousWasWater(false);
	}
	public String getElementName(){
		return "a bullet";
	}
	public char getCharRepresentation(){
		return '&';
	}
}
