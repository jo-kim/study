
package gui_study;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class WinFrame extends JFrame{
	private JLabel text = new JLabel();
	
	public WinFrame(String winText) {
		
		setLayout(null);
		setTitle("GAME CLEAR!!");
		setBounds(800,400,300,200);
		
		text.setBounds(0,0,300,200);
		text.setText(winText);
		text.setHorizontalAlignment(JLabel.CENTER);
		
		add(text);
		setVisible(true);
		revalidate();
	}
}

class TPanel extends JPanel implements ActionListener{
	
	private JButton map[] = new JButton[9];
	private int mark[] = new int[9];
	private int win;
	private int turn = 1;
	
	public TPanel() {
		setLayout(null);
		setBounds(0,0,Tframe.SIZE,Tframe.SIZE);
		setMap();
	}

	private void setMap() {
		int x = Tframe.SIZE /2 - 100 *3 /2;
		int y = Tframe.SIZE /2- 100 *3 /2;
		for(int i=0; i<this.map.length; i++) {
			this.map[i] = new JButton();
			this.map[i].setBounds(x, y, 100, 100);
			this.map[i].setBackground(new Color(223, 216, 202));
			this.map[i].addActionListener(this);
			add(this.map[i]);
			x += 100 + 3;
			
			if(i%3==2) {
				x=Tframe.SIZE/2- 100 *3 /2;
				y += 100 + 3;
			}
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton target = (JButton) e.getSource();
		
		for(int i=0; i<this.map.length; i++) {
			if(target == this.map[i] && this.mark[i]==0) {
				if(this.turn ==1)
					target.setBackground(new Color(249, 237, 105));
				else 
					target.setBackground(new Color(240, 138, 93));
				this.mark[i] = this.turn;
				
				checkWin();
				
				this.turn = this.turn == 1 ? 2: 1;
			}
		}
		
	}

	private void checkWin() {
		this.win = this.win ==  0 ? checkHori(): this.win;
		this.win = this.win ==  0 ? checkVerti(): this.win;
		this.win = this.win ==  0 ? checkDia(): this.win;
		this.win = this.win ==  0 ? checkReverse(): this.win;
		
		if(this.win !=0) {
			new WinFrame(String.format("p%dÀÇ ½Â",this.win));
		}
	}
	
	/*
	 * 0 1 2
	 * 3 4 5
	 * 6 7 8
	 */
	private int checkHori() {
		for(int i=0; i<this.mark.length; i+=3) {
			int cnt = 0;
			for(int j=0; j<3; j++) {
				if(this.mark[i+j]==this.turn)
					cnt++;
			}
			if(cnt == 3)
				this.win = this.turn;
		}
		return 0;
	}

	private int checkVerti() {
		for(int i=0; i<3; i+=3) {
			int cnt = 0;
			for(int j=0; j<3; j++) {
				if(this.mark[i+j*3] == this.turn)
					cnt++;
			}
			if(cnt == 3) 
				this.win = this.turn;
		}
		return 0;
	}

	private int checkDia() {
		int cnt = 0; 
		for(int i=0; i<3; i++) {
			if(this.mark[i*4]==this.turn)
				cnt++;
			if(cnt ==3)
				this.win = this.turn;
		}
		return 0;
	}

	private int checkReverse() {
		int cnt = 0;
		for(int i=1; i<=3; i++) {
			if(this.mark[i*2] == this.turn)
				cnt++;
			if(cnt == 3)
				this.win = this.turn;
		}
		return 0;
	}
}

class Tframe extends JFrame{
	
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int w = dm.width;
	public static int h = dm.height;
	
	public static final int SIZE = 700;
	
	public Tframe() {
		super("Tic Tac Toe");
		setLayout(null);
		setBounds(w/2-SIZE/2 , h/2-SIZE /2, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new TPanel());
		setVisible(true);
		revalidate();
		
	}
}

public class TTT {

	public static void main(String[] args) {
		
		Tframe game = new Tframe();

	}

}
