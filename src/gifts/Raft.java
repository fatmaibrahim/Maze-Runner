package gifts;

import javax.swing.ImageIcon;

import mazeElements.Runner;

public class Raft extends Gift{
	public Raft(){
		this.image= new ImageIcon("resources/Raft(2).png").getImage();
	}
	
	public void hit(Runner r){
		r.setRafts(r.getRafts() + 1);
		r.setPreviousWasWater(false);
	}
	public String getElementName() {
		return "a raft";
	}

	public char getCharRepresentation() {
		return 'R';
	}
}
