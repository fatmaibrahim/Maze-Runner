package walls;

import javax.swing.ImageIcon;

public class Stone extends Wall {
	public Stone(){
		this.setDestroyable(false);
		this.image= new ImageIcon("resources/Stone.png").getImage();
	}
	public String getElementName(){
		return "a stone";
	}
	public char getCharRepresentation(){
		return 'S';
	}
}

