package gui_horseRace;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Play extends Util{
	private final int SIZE = 5; 
	private Horse horse[] = new Horse[SIZE];
	private int startX = 50;
	private int startY = 100;
	private int endX = 1200-150-30; 
	private JButton start;
	private JLabel timer;
	private int ms;
	
	private boolean isRun;
	private int rank=1;
	public Play() {
		setLayout(null);
		setBounds(0,0,1200,800);
		
		setStart();
		setTimer();
		setHorse();
		
	}

	private void setHorse() {
		int x = this.startX;
		int y = this.startY;
		for(int i=0; i<SIZE; i++) {
			this.horse[i] = new Horse(i+1,x,y,150,120);
			y+=130;
		}
		
	}
	 @Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i=0; i<SIZE; i++) {
			Horse h = this.horse[i];
			g.drawLine(this.startX, h.getY()+h.getH(), 1200-30, h.getY()+h.getH());
			g.drawImage(h.getImage().getImage(),h.getX(),h.getY(),null);
			
			if(h.getState() == h.GOAL) {
				g.setFont(new Font("",0,15));
				g.drawString(h.getRecord(), 900+50,h.getY()+60 );	
				g.setFont(new Font("",Font.BOLD,25));
				g.drawString(h.getRank()+"등",900,h.getY()+60);
			}
		}
		if(isRun) {
		try {
			play();
			Thread.sleep(50);
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
		repaint();
	}

	private void play() {
		Random rn = new Random();
//		boolean goal = false;   < = 동시도착 예외처리
//		for(int i=0; i<SIZE; i++) {
//			Horse h = this.horse[i];
//			int move = rn.nextInt(10)*3;
//			int xx = h.getX()+move;
//			if(h.getState() == h.RUN) {
//			if(xx>= this.endX && !goal) {
//				xx = this.endX;
//				h.setState(h.GOAL);
//				h.setRank(this.rank);
//				
//				h.setRecord(String.format("%3d.%03d", this.ms/1000, this.ms %1000));
//				this.rank++;
//			}
//			else if(xx>= this.endX && goal) { // 동시 도착한말처리
//				i--;
//				continue;
//			}
//			h.setX(xx);
//		}	
//		}
		
		for(int i=0; i<SIZE; i++) {
		int r = rn.nextInt(10)*3;
		Horse h = this.horse[i];
		if(h.getState() == h.RUN && h.getX()<this.endX) {
			h.setX(h.getX()+r);
		}
		if(h.getX()>=this.endX && h.getState()==h.RUN) {
			h.setX(this.endX);
			h.setState(h.GOAL);
			h.setRank(this.rank);
			this.rank++;
			h.setRecord(String.format("%3d.%03d", this.ms/1000,this.ms%1000));
		}
	}
		
	}

	private void setTimer() {
		timer = new JLabel();
		
		this.timer.setBounds(150,50,100,50);
		this.timer.setText("Ready");
		this.timer.setHorizontalAlignment(JLabel.CENTER);
		add(this.timer);
		
	}

	private void setStart() {
		this.start = new JButton();
		
		this.start.setBounds(50,50,100,50);
		this.start.setText("START");
		this.start.setBackground(Color.white);
		this.start.setFont(new Font("",Font.BOLD,20));
		this.start.addActionListener(this);
		add(this.start);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			if(target == this.start) {
				for(int i=0; i<SIZE; i++) {
					this.horse[i].setState(this.horse[i].RUN);
				}
				isRun = !isRun;
				this.start.setText(this.isRun?"Reset":"Start"); // isRun - reset 
			}
			if(!isRun) {
				resetGame();
			}
		}
	}
	
	private void resetGame() {
		this.ms = 0;
		this.rank = 1;
		this.timer.setText("Ready");
		setHorse();
		
	}

	@Override
	public void run() {
		while(true) {
			if(isRun) {
				this.ms++;
				this.timer.setText(String.format("%3d.%03d", this.ms/1000,this.ms%1000));
			}
			try {
				Thread.sleep(1);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
}
