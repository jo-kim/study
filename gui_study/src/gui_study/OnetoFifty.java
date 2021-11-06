package gui_study;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class WinResult extends JFrame{
	
	private JLabel text = new JLabel(); // �̰����� ����
	
	public WinResult(int ms) {
		super("GAME CLAER");
		setLayout(null);
		setBounds(100,100,300,200);
		
		
		this.text.setText(String.format("���� : %4d.%3d �ҿ�", ms/1000,ms%1000));
		this.text.setBounds(0,0,300,200);
		this.text.setHorizontalAlignment(JLabel.CENTER);
		add(this.text);
		setVisible(true);
	}
}

class OnePanel extends JPanel implements ActionListener,Runnable{
	//��ư �����
	private final int SIZE = 5;
	private JButton map[][] = new JButton[SIZE][SIZE];
	private int front[][] = new int [SIZE][SIZE];
	private int back[][] = new int [SIZE][SIZE];
	private int gameNum = 1;
	private boolean isRun;
	private int ms;
	
	private JLabel title = new JLabel("1 to 50");
	private JButton reset = new JButton("RESET"); // ���� ��ư 
	private JLabel timer = new JLabel("READY");
	
	public OnePanel() { // ��ư�� â
		setLayout(null);
		setBounds(0, 0, OneFrame.SIZE, OneFrame.SIZE); // ��ư ��ü �԰�
		
		setTitle();
		setTimer();
		
		setGame();
		setMap();
		setReset();
	}

	
	private void setTimer() {
		
		this.timer.setBounds(20,0,200,50);
		this.timer.setBackground(Color.red);
		this.timer.setHorizontalAlignment(JLabel.CENTER);
		this.timer.setFont(new Font("OCR A Extended",0,18));
		add(this.timer);
		
	}


	private void setTitle() {
		
		this.title.setBounds(0,0,700,100);
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.title.setFont(new Font("Franklin Gothic Book",Font.PLAIN,28));
		add(this.title);
		
	}
	
	private void setReset() {
		
		this.reset.setBounds(700/2-80/2,620,80,40);
		this.reset.addActionListener(this);
		add(this.reset);
		
	}

	private void setMap() {
		int x = OneFrame.SIZE/2  - 100 *5/2;
		int y = OneFrame.SIZE/2  - 100 *5/2;
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				this.map[i][j] = new JButton(); // �ּ� �Ҵ�
				this.map[i][j].setBounds(x,y,100,100); // ��ư �ϳ��ϳ��� ũ�� �����
				this.map[i][j].setText(this.front[i][j]+""); // ��ư�� ���� �ޱ�
				this.map[i][j].setFont(new Font("",Font.BOLD,23)); // ��ư �ȿ� �ִ� ���� ũ��
				this.map[i][j].setBackground(Color.lightGray);
				this.map[i][j].addActionListener(this);
				add(this.map[i][j]);
				
				x+=100 +3;
			}
			x = OneFrame.SIZE/2 - 100 *5/2;
			y+= 100 +3;
		}
	}
	
	private void setGame() {
		// front �� back�迭�� ��ȣ �ο�
		int n = 1;
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				this.front[i][j] = n;
				this.back[i][j] = n+(SIZE*SIZE);
				n++;
			}
		}
		shuffle();
	}
	private void shuffle() {
		Random rn = new Random();
		
		for(int i=0; i<5000; i++) {
			int r1 = rn.nextInt(SIZE);
			int r2 = rn.nextInt(SIZE);
			
			int temp = this.front[0][0];
			this.front[0][0] = this.front[r1][r2];
			this.front[r1][r2] = temp;
			
			r1 = rn.nextInt(SIZE);
			r2 = rn.nextInt(SIZE);
			
			temp = this.back[0][0];
			this.back[0][0] = this.back[r1][r2];
			this.back[r1][r2] = temp;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			if(target == this.reset) {
				resetGame();
			}
			else {
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					if(target == this.map[i][j] && this.front[i][j] == this.gameNum) {
						
						if(!isRun) isRun = true;
						
						this.front[i][j] = this.back[i][j];
						this.back[i][j] = 0;
						if(this.front[i][j] == 0) {
							this.map[i][j].setBackground(Color.white); // ���� �������� 
						    this.map[i][j].setText("");
						}
						else {
							this.map[i][j].setBackground(Color.pink);  // ���� ��������
							this.map[i][j].setText(this.front[i][j]+""); // ���� ����
						}
						this.gameNum++;
						isRun =winCheck();
						if(!isRun) // �����̳��������
							new WinResult(this.ms);
					}
				}
			}
		}
		}
		
	}

	private void resetGame() { // ���� ��ư�� ��������
		isRun = false;
		this.gameNum = 1;
		setGame();
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				this.map[i][j].setText(this.front[i][j]+"");
				this.map[i][j].setBackground(Color.lightGray);
			}
		}
		
		this.ms = 0;
		this.timer.setText("READY");
	}


	private boolean winCheck() {
		if(this.gameNum > this.SIZE*this.SIZE*2)
			return false;
		else
			return true;
		
	}


	@Override
	public void run() {
		while(true) {
			if(this.isRun) {
			this.ms ++;
			this.timer.setText(String.format("%4d.%3d", this.ms/1000,this.ms%1000));
			}
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	
}

class OneFrame extends JFrame{
	
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int w = dm.width;
	public static int h = dm.height;
	
	public static final int SIZE = 700;
	
	private OnePanel op = new OnePanel();
	
	public OneFrame() {  // 1. â�����
		super("1 to 50");
		setLayout(null);
		setBounds(w/2-SIZE/2,h/2-SIZE/2,SIZE,SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(op);
		
		setVisible(true);
		revalidate();
		
		op.run();
	}
}

public class OnetoFifty {

	public static void main(String[] args) {
		// Frame
		// Panel
		// title
		// timer
		// reset
		// GAMECLEAR â
		
		OneFrame game = new OneFrame();

	}

}
