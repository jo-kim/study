package gui_study;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ResultFrame3 extends JFrame{
	
	private JLabel text = new JLabel();
	
	public ResultFrame3(String str) {
		setLayout(null);
		setBounds(OmokFrame.w/2 -150, OmokFrame.h/2 -150,300,200);
		setTitle("GAME OVER");
		
		this.text.setText(str);
		this.text.setBounds(0,0,300,200);
		this.text.setFont(new Font("HY헤드라인M",Font.PLAIN,22));
		this.text.setHorizontalAlignment(JLabel.CENTER);
		add(this.text);
		
		setVisible(true);
		revalidate();
	}
}

class OmokPanel3 extends JPanel implements ActionListener{
	
	private JLabel title = new JLabel();
	
	private final int SIZE = 10;
	private JButton map[][] = new JButton[SIZE][SIZE];
	private int mark[][] = new int [SIZE][SIZE];
	private int turn = 1;
	private int win;
	
	private JButton reset = new JButton();
	
	public OmokPanel3() {
		setLayout(null);
		setBounds(0,0,OmokFrame.SIZE, OmokFrame.SIZE);
		setBackground(Color.LIGHT_GRAY);
		
		setTitle();
		setReset();
		setMap();
		
		setVisible(true);
		revalidate();
	}
	

	private void setReset() {
		this.reset.setText("RESET");
		this.reset.setFont(new Font("",Font.BOLD,16));
		this.reset.setBounds(0,0,90,70);
		this.reset.setBackground(Color.DARK_GRAY);
		this.reset.setForeground(Color.white);
		this.reset.addActionListener(this);
		add(this.reset);
	}


	private void setTitle() {
		this.title.setText(" [ 오 목 게 임 ] ");
		this.title.setFont(new Font("맑은 고딕",Font.BOLD,35));
		this.title.setForeground(Color.white);
		this.title.setBounds(270,-10,300,200);
		add(this.title);
		
	}
	
	private void setMap() {
		int x = 150;
		int y = 150;
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				this.map[i][j] = new JButton();
				this.map[i][j].setBounds(x,y,50,50);
				this.map[i][j].setBackground(Color.white);
				add(this.map[i][j]);
				this.map[i][j].addActionListener(this);
				x+= 50;
			}
			y+=50;
			x = 150;
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton ) {
		JButton target = (JButton)e.getSource();
		if(target == this.reset) {
			resetButton();
		}else {
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(target == this.map[i][j] && this.mark[i][j] ==0) {
					if(this.turn == 1) {
						this.mark[i][j] = this.turn;
						target.setText("X");
						target.setFont(new Font("",Font.BOLD,24));
						target.setForeground(Color.pink);
						
					}
					else {
						this.mark[i][j] = this.turn;
						target.setText("O");
						target.setFont(new Font("",Font.BOLD,20));
						target.setForeground(Color.blue);
					}
					
					winCheck();
					this.turn = this.turn == 1 ? 2 : 1;
				}
			}
		}
		}
		}
		
	}


	private void resetButton() {
		this.win = 0;
		this.turn = 1;
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				this.mark[i][j] = 0;
				this.map[i][j].setText("");
			}
		}
	}


	private void winCheck() {
		this.win = this.win == 0 ? checkHori() : this.win;
		this.win = this.win == 0 ? checkVerti() : this.win;
		this.win = this.win == 0 ? checkDia() : this.win;
		this.win = this.win == 0 ? checkReverse() : this.win;
		
		if(this.win !=0) {
			new ResultFrame3(String.format(" Congrats!! P%d WIN  ", this.win));
		}
		
		/*
		 *  00 01 02 03 04 05 06 07 08 09
		 *  10 11 12 13 14 15 16 17 18 19
		 *  20 21 22 23 24 25 26 27 28 29
		 *  30 31 32 33 34 35 36 37 38 39
		 *  40 41 42 43 44 45 46 47 48 49
		 *  50 51 52 53 54 55 56 57 58 59
		 */
		
	}
	

	private int checkHori() {
		// 00, 01, 02, 03, 04 /  i는 그대로 j++
		// 2 5 6 7 8 9 / j = 4간격 
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE -4; j++) {
				if(this.mark[i][j] == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.mark[i][j+k] == this.turn)
							cnt ++;
					}
					if(cnt == 5)
						return this.turn;
				}
			}
		}
		return 0;
	}


	private int checkVerti() {
		// 00 10 20 30 40 / i++ j그대로
		// 41 51 61 71 81 / i 4간격
		
		for(int i=0; i<SIZE -4; i++) {
			for(int j=0; j<SIZE; j++) {
				if(this.mark[i][j] == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.mark[i+k][j] == this.turn)
							cnt++;
					}
					if(cnt == 5)
						return this.turn;
				}
			}
		}
		return 0;
	}


	private int checkDia() {
		// 05 16 27 38 49 / i++ k++
		for(int i=0; i<SIZE-4; i++) {
			for(int j=0; j<SIZE-4; j++) {
				if(this.mark[i][j] == this.turn) {
					int cnt =0;
					for(int k=0; k<5; k++) {
						if(this.mark[i+k][j+k] == this.turn)
							cnt++;
					}
					if(cnt == 5)
						return this.turn;
				}
			}
		}
		return 0;
	}


	private int checkReverse() {
		// 04 13 22 31 40 
		for(int i = 4; i<SIZE; i++) {
			for(int j=0; j<SIZE-4; j++) {
				if(this.mark[i][j] == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.mark[i-k][j+k] == this.turn)
							cnt++;
					}
					if(cnt == 5)
						return this.turn;
				}
			}
		}
		return 0;
	}
	
}

class OmokFrame extends JFrame{
	
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int w = dm.width;
	public static int h = dm.height;
	public static final int SIZE = 800;
	
	private OmokPanel3 op = new OmokPanel3();
	
	public OmokFrame() {
		setLayout(null);
		setTitle("Omok");
		setBounds(w/2 -SIZE/2, h/2-SIZE/2, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(op);
		
		setVisible(true);
		revalidate();
	}
}

public class Omok {

	public static void main(String[] args) {
		/*
		 * frame
		 * omok panel 
		 * map 10X10
		 * mark 
		 * title
		 * reset button
		 * 승자 출력 frame 창
		 */
		
		OmokFrame game = new OmokFrame();
	}

}
