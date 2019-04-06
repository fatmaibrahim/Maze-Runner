package startgame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gameBoard.IBoard;
import mazeElements.Runner;
public class View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void setPlaypanel(JPanel playpanel) {
		this.playpanel = playpanel;
	}

	private JButton btnstart, btnexit, btneasy, btnnormal, btnhard,btnplayagain,btnexits;
	private JPanel gamepanel, scorepanel, startpanel, levelpanel, endpanel;
	private IBoard Board;
	private Runner runner;
    public JPanel playpanel;
	
	private CardLayout card = new CardLayout();
	private ImageIcon image;
	private Image backgroundlevel,background, win, lose;
	private boolean booleanwin;
    private boolean isloadedimage=false;
	private JButton btnload;
	private String bulltes="00",lives="00",times="00.00",levelname,coin="0000",raft="00";
	public void setBulltes(String bulltes) {
		this.bulltes = bulltes;
	}

	public void setLives(String lives) {
		this.lives = lives;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}

	public void setCoin(String coin) {
		this.coin = coin;
	}

	public void setRaft(String raft) {
		this.raft = raft;
	}

	public JButton getBtnload() {
		return btnload;
	}

	public void setIsloadedimage(boolean isloadedimage) {
		this.isloadedimage = isloadedimage;
	}

	public View() {
		image = new ImageIcon("resources/background.png");
		background = image.getImage();
		image = new ImageIcon("resources/background.png");
		backgroundlevel = image.getImage();
		image = new ImageIcon("resources/lose.png");
		win = image.getImage();
		image = new ImageIcon("resources/lose.png");
		lose = image.getImage();

		/**
		 * start panel
		 */

		startpanel = new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				int iWidth21 = background.getWidth(this) / 2;
				int iHeight21 = background.getHeight(this) / 2;
				if (background != null) {
					int x = this.getParent().getWidth() / 2 - iWidth21;
					int y = this.getParent().getHeight() / 2 - iHeight21;
					g.drawImage(background, x, y, null);
				}
			}
		};
		
		
		startpanel.setBackground(Color.white);
		startpanel.setLayout(null);
		
		btnstart = new JButton("Start Game");
		btnstart.setBackground(Color.WHITE);
		btnstart.setFont(new Font("Plantagenet Cherokee", Font.BOLD | Font.ITALIC, 13));
		btnstart.setBounds(800, 244, 204, 87);
		startpanel.add(btnstart);

		btnexit = new JButton("Exit");
		btnexit.setBackground(Color.WHITE);
		btnexit.setFont(new Font("Plantagenet Cherokee", Font.BOLD | Font.ITALIC, 13));
		btnexit.setBounds(800, 342, 204, 73);
		startpanel.add(btnexit);

		/**
		 * level panel
		 */

	
		levelpanel = new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				int iWidth21 = backgroundlevel.getWidth(this) / 2;
				int iHeight21 = backgroundlevel.getHeight(this) / 2;
				if (backgroundlevel != null) {
					int x = this.getParent().getWidth() / 2 - iWidth21;
					int y = this.getParent().getHeight() / 2 - iHeight21;
					g.drawImage(backgroundlevel, x, y, null);
				}
			}
		};
		levelpanel.setBackground(Color.WHITE);
		levelpanel.setLayout(null);

		btneasy = new JButton("Easy");
		btneasy.setBounds(800, 185, 141, 53);
		btneasy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btneasy.setBackground(Color.WHITE);
		levelpanel.add(btneasy);

		btnnormal = new JButton("Normal");
		btnnormal.setBounds(800, 264, 141, 53);
		btnnormal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnnormal.setBackground(Color.WHITE);
		levelpanel.add(btnnormal);

		btnhard = new JButton("Hard");
		btnhard.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnhard.setBounds(800, 345, 141, 53);
		btnhard.setBackground(Color.WHITE);
		levelpanel.add(btnhard);
		
		btnload = new JButton("Load Image");
		btnload.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnload.setBounds(800, 425, 141, 53);
		btnload.setBackground(Color.WHITE);
		levelpanel.add(btnload);

		/**
		 * play panel
		 */

		playpanel = new JPanel() {
			/**
				 * 
				 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics graphics) {
				Graphics2D g = (Graphics2D) graphics;
				super.paintComponent(g);
				for (int i = 0; i < Board.getHeight(); i++) {
					for (int j = 0; j < Board.getWidth(); j++) {
						if (i == runner.getPosition().x && j == runner.getPosition().y) {
							g.drawImage(runner.getImage(), i * 100, j * 100, null);	
						}else{
							g.drawImage(Board.getItem(i, j).getimage(), i * 100, j * 100,null);

								
						}
						}
					}
					
				}
				
			
		};
		playpanel.setBackground(Color.white);
		playpanel.setLayout(new FlowLayout());

		/**
		 * score panel
		 */

		scorepanel = new JPanel();
		scorepanel.setBackground(Color.WHITE);
		scorepanel.setLayout(new FlowLayout());

		


		JLabel coins = new JLabel("");
		coins.setIcon(new ImageIcon("resources/coin.png"));
		scorepanel.add(coins);

		JLabel coin_counter = new JLabel(coin);
		coin_counter.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scorepanel.add(coin_counter);

		JLabel bullets = new JLabel("");
		bullets.setIcon(new ImageIcon("resources/bullet.png"));
		scorepanel.add(bullets);
		
		JLabel bullet_counter = new JLabel(bulltes);
		bullet_counter.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scorepanel.add(bullet_counter);

		JLabel half_hearts = new JLabel("");
		half_hearts.setIcon(new ImageIcon("resources/half heart.png"));
		scorepanel.add(half_hearts);
		

		JLabel Level_name = new JLabel(levelname);
		scorepanel.add(Level_name);
		Level_name.setFont(new Font("Tahoma", Font.BOLD, 25));

		JLabel full_hearts = new JLabel("");
		full_hearts.setIcon(new ImageIcon("resources/full heart.png"));
		scorepanel.add(full_hearts);

		JLabel live_counter = new JLabel(lives);
		live_counter.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scorepanel.add(live_counter);		

		JLabel rafts = new JLabel("");
		rafts.setIcon(new ImageIcon("resources/raft.png"));
		scorepanel.add(rafts);

		JLabel raft_counter = new JLabel(raft);
		raft_counter.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scorepanel.add(raft_counter);

		JLabel time = new JLabel("");
		time.setIcon(new ImageIcon("resources/clock.png"));
		scorepanel.add(time);

		JLabel time_counter = new JLabel(times);
		time_counter.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scorepanel.add(time_counter);
	
		
		
		gamepanel = new JPanel();
		gamepanel.setLayout(new BorderLayout());
		gamepanel.setBackground(Color.orange);
		gamepanel.add(playpanel, BorderLayout.CENTER);
		gamepanel.add(scorepanel, BorderLayout.NORTH);

		/**
		 * end panel
		 */

		
		endpanel = new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				int iWidth3 = win.getWidth(this) / 2;
				int iHeight3 = win.getHeight(this) / 2;
				int iWidth31 = lose.getWidth(this) / 2;
				int iHeight31 = lose.getHeight(this) / 2;
				
				if (win != null && lose != null) {
					if (booleanwin) {
						int x = this.getParent().getWidth() / 2 - iWidth3;
						int y = this.getParent().getHeight() / 2 - iHeight3;
						g.drawImage(win, x, y, null);
					} else {
						int x = this.getParent().getWidth() / 2 - iWidth31;
						int y = this.getParent().getHeight() / 2 - iHeight31;
						g.drawImage(lose, x, y, null);
					}
				}
			}
		};

		endpanel.setBackground(Color.GREEN);
		endpanel.setLayout(null);

		btnplayagain = new JButton("play again");
		btnplayagain.setBounds(600, 244, 204, 87);
		endpanel.add(btnplayagain);

		btnexits = new JButton("Exit");
		btnexits.setBounds(600, 342, 204, 73);
		endpanel.add(btnexits);

		
		this.getContentPane().setLayout(card);
		this.getContentPane().add(gamepanel, "cardgamepanel");
		this.getContentPane().add(levelpanel, "cardlevelpanel");
		this.getContentPane().add(startpanel, "cardstartpanel");
		this.getContentPane().add(endpanel, "cardendpanel");	
		
		card.show(this.getContentPane(), "cardstartpanel");

	}

	public void setBooleanwin(boolean booleanwin) {
		this.booleanwin = booleanwin;
	}

	public JButton getBtnstart() {
		return btnstart;
	}

	public JButton getBtnplayagain() {
		return btnplayagain;
	}

	public JButton getBtnexits() {
		return btnexits;
	}

	public JPanel getGamepanel() {
		return gamepanel;
	}

	public JPanel getEndpanel() {
		return endpanel;
	}

	public Image getWin() {
		return win;
	}

	public Image getLose() {
		return lose;
	}

	public boolean isBooleanwin() {
		return booleanwin;
	}

	public JButton getBtnexit() {
		return btnexit;
	}

	public JButton getBtneasy() {
		return btneasy;
	}

	public JButton getBtnnormal() {
		return btnnormal;
	}

	public JButton getBtnhard() {
		return btnhard;
	}

	public JPanel getScorepanel() {
		return scorepanel;
	}

	public JPanel getStartpanel() {
		return startpanel;
	}

	public JPanel getLevelpanel() {
		return levelpanel;
	}

	public JPanel getPlaypanel() {
		return playpanel;
	}

	public void Setboard(IBoard Board) {
		this.Board = Board;
	}

	public void setRunner(Runner runner) {
		this.runner = runner;
	}

	public CardLayout getCard() {
		return card;
	}

	

}
