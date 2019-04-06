package mazeElements;

import java.awt.Image;

public class AllElements {
	boolean alreadyHit;
	protected boolean destroyable;
	 protected Image image =null;

	public AllElements() {
		alreadyHit = false;
	}

	public boolean isAlreadyHit() {
		return alreadyHit;
	}

	public void markAsHit() {
		alreadyHit = true;
	}

	public void hit(Runner r) {
	}

	public String getElementName() {
		return null;
	}

	public char getCharRepresentation() {
		return '0';
	}

	public boolean isDestroyable() {
		return destroyable;
	}

	public void setDestroyable(boolean d) {
		this.destroyable = d;
	}
	public Image getimage() {
		// TODO Auto-generated method stub
		return image;
	}

	
	public void setimage(Image image) {
		// TODO Auto-generated method stub
		this.image=image;
	}

}
