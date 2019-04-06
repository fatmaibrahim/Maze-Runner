package startgame;

import javax.swing.JFrame;

/**
 * The Class Main.
 */

public class Maingui {


	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	
	
	
	public static void main(String[] args) {
	
		Controller controller = new Controller();
		controller.getView().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controller.getView().setSize(1370, 770);
		controller.getView().setTitle("Game");
		controller.getView().setVisible(true);
		controller.getView().playpanel.setFocusable(true);
		controller.getView().playpanel.requestFocusInWindow();
		

	}

}
