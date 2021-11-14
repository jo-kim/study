package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class SnakePanel extends MyUtil{
	private final int SIZE = 10;
	private Rect map[][] = new Rect[SIZE][SIZE];
	private ArrayList<ArrayList<Integer>> yx = new ArrayList<ArrayList<Integer>>();
	
	private JLabel title = new JLabel();
	private JButton reset = new JButton();
	private JButton key[] = new JButton[4];
	
	public SnakePanel() {
		setLayout(null);
		setBounds(0,0,800,700);
		setTitle();
		setKey();
		setReset();
		setMap();
		
		setFocusable(true);
		addKeyListener(this);
	}
	
	private void setMap() {
		int y = 150;
		for(int i=0; i<SIZE; i++) {
			int x = 50;
			for(int j=0; j<SIZE; j++) {
				this.map[i][j] = new Rect(x,y,50,50,Color.black);
				x+=50;
			}
			y+=50;
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// map
		for(int i=0;i<this.SIZE;i++) {
			for(int j=0; j<this.SIZE; j++) {
				Rect r = this.map[i][j];
				g.setColor(r.getC());
				g.drawRect(r.getX(), r.getY(), r.getW(), r.getH());
			}
		}
		repaint();
	}
	private void setTitle() {
		this.title.setBounds(30,50,250,100);
		this.title.setText("SNAKE GAME");
		this.title.setFont(new Font("",Font.BOLD,30));
		this.title.setHorizontalAlignment(JLabel.CENTER);
		add(this.title);
		
	}

	private void setReset() {
		this.reset.setBounds(600,600,150,50);
		this.reset.setText("RESET");
		this.reset.setFont(new Font("",Font.BOLD,20));
		this.reset.setHorizontalAlignment(JLabel.CENTER);
		this.reset.addActionListener(this);
		add(this.reset);
		
	}
	private void setKey() {
		String text[] = {"ก็","ก้","กๆ","ก่"};
		int x = 600;
		int y = 550;
		for(int i=0; i<this.key.length; i++) {
			this.key[i] = new JButton();
			this.key[i].setBounds(x,y,50,50);
			this.key[i].setText(text[i]);
			this.key[i].addActionListener(this);
			add(this.key[i]);
			x+=50;
			if(i==this.key.length-1-1) {
				x-=100;
				y-=50;
			}
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_LEFT) {
			System.out.println("4");
		}
		else if(e.getKeyCode() == e.VK_DOWN) {}
		else if(e.getKeyCode() == e.VK_RIGHT) {}
		else if(e.getKeyCode() == e.VK_UP) {}
		super.keyPressed(e);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			if(target == this.reset) {
				System.out.println("3");
				// resetGame();
			}
		}
		super.actionPerformed(e);
	}
	
}

public class Snake extends JFrame{
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int w = dm.width;
	public static int h = dm.height;
	
	public Snake() {
		super("Snake Game");
		setLayout(null);
		setBounds(w/2-800/2,h/2-800/2,800,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new SnakePanel());
		
		setVisible(true);
		revalidate();
	}
	public static void main(String[] args) {
		
		Snake game = new Snake();
		
		
	}

}
