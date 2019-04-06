package walls;

import javax.swing.ImageIcon;

public class Tree extends Wall {
	public Tree(){
		this.setDestroyable(true);
		this.image= new ImageIcon("resources/Tree.png").getImage();
	}
	public String getElementName(){
		return "a tree";
	}
	public char getCharRepresentation(){
		return 'T';
	}
}

