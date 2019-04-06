package gifts;

import javax.swing.ImageIcon;

import mazeElements.Runner;

public class Live extends Gift {
	public Live(){
		this.image= new ImageIcon("resources/Live.png").getImage();
	}
	
	public void hit(Runner r) {
		if (!isAlreadyHit()) {
			markAsHit();
			r.setLives(r.getLives() + 1);
		}
		r.setPreviousWasWater(false);
	}

	public String getElementName() {
		return "a live";
	}

	public char getCharRepresentation() {
		return 'L';
	}
}
