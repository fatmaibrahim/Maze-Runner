package startgame;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.Timer;

import gameBoard.LevelFactory;
import mazeElements.Runner;
public class Controller implements ActionListener ,KeyEventDispatcher{

	private Date starttime;
	private View view;
	private  gameBoard.Board Board;
	Timer timer;
	private Runner runner;
	ImageIcon imgrunner = null, imgtree = null, imgbult = null, imgraft = null, imglive = null 
			,imgstart = null, imgend = null, imgsmallbomb = null, imgwater = null
			,imgstone = null, imgbigbom = null, imgempty = null;
	public Controller(){
		view=new View();	
		timer=new Timer(10000,this);
		timer.start();
	view.getBtneasy().addActionListener(this);
   view.getBtnhard().addActionListener(this);
   view.getBtnnormal().addActionListener(this);
   view.getBtnstart().addActionListener(this);
   view.getBtnexit().addActionListener(this);
   view.getBtnexits().addActionListener(this);  
   view.getBtnload().addActionListener(this);
   view.getBtnplayagain().addActionListener(this);
   view.getPlaypanel().setFocusable(true);
   KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
   manager.addKeyEventDispatcher(new MyDispatcher());
 	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		view.repaint();	 
		String buttonPressed = e.getActionCommand();
		if(buttonPressed.equals("Start Game")||buttonPressed.equals("Exit")){
			if(buttonPressed.equals("Start Game")){
				view.getCard().show(view.getContentPane(),"cardlevelpanel");		
			}else{
				System.exit(0);
			}
			buttonPressed=null;
		}else if(buttonPressed.equals("Hard")||buttonPressed.equals("Normal")||buttonPressed.equals("Easy")){
			view.setLevelname(buttonPressed);
			if(buttonPressed.equals("Easy")){
				Board=new LevelFactory().create("easy");
			}else if(buttonPressed.equals("Normal")){
				Board=new LevelFactory().create("medium");
			}else{
				Board=new LevelFactory().create("hard");
			}
			buttonPressed=null;
			view.getCard().show(view.getContentPane(),"cardgamepanel");	
 		   starttime=new Date();
			runner=new Runner();
			runner.setPosition(Board.getStartPoint());
			Board.setRunner(runner);
			view.Setboard(Board);
			view.setRunner(runner);
	    }else if(buttonPressed.equals("play again")){
			view.getCard().show(view.getContentPane(),"cardlevelpanel");		
			buttonPressed=null;
	    }else if(buttonPressed.equals("Load Image")){
			view.setIsloadedimage(true);
			try {
				Loadimage();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			buttonPressed=null;
	    }
	}	

	public void Loadimage() throws ClassNotFoundException{
		
		String path = System.getProperty("user.home") + "/Desktop".replace("\\", "/");
		JFileChooser fileChooser = new JFileChooser(path);
		int returnVal = fileChooser.showOpenDialog(view);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
		try {
			LoadClass load=new LoadClass();
			
			imgend = new ImageIcon(ImageIO.read(ResourceLoader.load(load.excute(fileChooser.getSelectedFile().getAbsolutePath(),"runner.png"))));
			runner.setImage(imgend.getImage());
			//			imgbigbom = new ImageIcon(ImageIO.read(ResourceLoader.load(load.excute(fileChooser.getSelectedFile().getAbsolutePath(),"bigbomb.png"))));
//			imgbult = new ImageIcon(ImageIO.read(ResourceLoader.load(load.excute(fileChooser.getSelectedFile().getAbsolutePath(),"bult.png"))));		
//			imgempty = new ImageIcon(ImageIO.read(ResourceLoader.load(load.excute(fileChooser.getSelectedFile().getAbsolutePath(),"empty.png"))));
//			imgwater = new ImageIcon(ImageIO.read(ResourceLoader.load(load.excute(fileChooser.getSelectedFile().getAbsolutePath(),"water.png"))));
//			imgtree = new ImageIcon(ImageIO.read(ResourceLoader.load(load.excute(fileChooser.getSelectedFile().getAbsolutePath(),"tree.png"))));
//			imgstone = new ImageIcon(ImageIO.read(ResourceLoader.load(load.excute(fileChooser.getSelectedFile().getAbsolutePath(),"stone.png"))));
//			imgraft = new ImageIcon(ImageIO.read(ResourceLoader.load(load.excute(fileChooser.getSelectedFile().getAbsolutePath(),"start.png"))));
//			imgstart = new ImageIcon(ImageIO.read(ResourceLoader.load(load.excute(fileChooser.getSelectedFile().getAbsolutePath(),"raft.png"))));
//			imgsmallbomb = new ImageIcon(ImageIO.read(ResourceLoader.load(load.excute(fileChooser.getSelectedFile().getAbsolutePath(),"smalbomb.png"))));
//			imgrunner = new ImageIcon(ImageIO.read(ResourceLoader.load(load.excute(fileChooser.getSelectedFile().getAbsolutePath(),"runner.png"))));
//			imglive = new ImageIcon(ImageIO.read(ResourceLoader.load(load.excute(fileChooser.getSelectedFile().getAbsolutePath(),"live.png"))));

		} catch (IOException e) {

		}
	}
	}
	public View getView() {
		// TODO Auto-generated method stub
		return this.view;
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		return false;
	}


	public class MyDispatcher implements KeyEventDispatcher {
		
		@Override
		public boolean dispatchKeyEvent(KeyEvent e) {
			int keycode=e.getKeyCode();			
			if(keycode!=0){
			if(runner.isAlive() && !runner.isWinner()){
			if(keycode==KeyEvent.VK_W){
				runner.moveUp();
			}
	        if(keycode==KeyEvent.VK_S){
	        	runner.moveDown();
			}
			if(keycode==KeyEvent.VK_A){
				runner.moveLeft();		
					}
			if(keycode==KeyEvent.VK_D){
				runner.moveRight();
			}
			if(keycode==KeyEvent.VK_SPACE){
				runner.shoot(Board);
			}
			Board.getItem((int) runner.getPosition().getY(), (int) runner.getPosition().getX())
			.hit(runner);
			if(!runner.wasPreviousWater())
				Board.destroy((int) runner.getPosition().getY(), (int) runner.getPosition().getX());
				Board.printBoard();
				 Date endtime = new Date();
				long time = endtime.getTime() - starttime.getTime();
				Integer x=runner.getBullets();
				view.setBulltes(x.toString());
				x=runner.getRafts();
				view.setRaft(x.toString());
				x=(int) runner.getLives();
				view.setLives(x.toString());
	            String s="";
				x=(int) (time/60000);
	            s+=x.toString();
	            s+=":";
	            x=(int) (time/1000);
				s+=x;
	            view.setTimes(s);
	            view.Setboard(Board);
				view.setRunner(runner);
				view.repaint();
			}
			if (runner.isWinner()||!runner.isAlive()) {
			    view.setBooleanwin(true);
				view.getCard().show(view.getContentPane(),"cardendpanel");	
			} else if(!runner.isWinner()&&!runner.isAlive()){
				view.setBooleanwin(false);
				view.getCard().show(view.getContentPane(),"cardendpanel");	
			}	
			}
			return false;
	  }	
	}
}
