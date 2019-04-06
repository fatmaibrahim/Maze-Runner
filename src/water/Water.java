package water;

import javax.swing.ImageIcon;

import mazeElements.AllElements;
import mazeElements.Runner;

public class Water extends AllElements{
	public Water(){
		this.image= new ImageIcon("resources/Water.png").getImage();	
	}
	
	public void hit(Runner r){
		System.out.println("previous was water:" + r.wasPreviousWater());
		if(!r.wasPreviousWater() && r.getRafts() > 0){
			r.setRafts(r.getRafts() - 1);
			r.setPreviousWasWater(true);
		}else if (r.getRafts() <= 0 && !r.wasPreviousWater()){
			r.setLives(r.getLives()- 1.0);
			r.setPosition(r.getPreviousPosition());
			r.setPreviousWasWater(false);
		}
		
	}
	public String getElementName() {
		return "water";
	}

	public char getCharRepresentation() {
		return 'W';
	}

}
