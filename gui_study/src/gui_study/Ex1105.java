package gui_study;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

// painComponent() �޼ҵ带 Ȱ���� �簢�� �׸���
class Nemo{
	// draw�� �ʿ��� ��ü�� �غ�  
	private int x, y, width, height;
	private Color c; 
	// �гο� add�� �� �ְ� Ŭ���� ���� ������� 
	
	public Nemo(int x, int y, int width, int height, Color c) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.c = c;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}

}

class MyPanel extends JPanel implements MouseListener{
	
//	private Nemo nemo = new Nemo();
	
	private Nemo map[][] = new Nemo[3][3];
	
	public MyPanel() {
		setLayout(null);
		setBounds(0,0,500,400);
		setBackground(Color.pink);
		
//		nemo.setX(100);
//		nemo.setY(100);
//		nemo.setWidth(200);
//		nemo.setHeight(200);
//		nemo.setC(Color.blue);
		
		
		setMap();
		
		// ��ư�� �׼Ǹ����ʸ� �޾Ҵ��Ͱ� ����
		// �гο� Ȥ�� Ư���ϴ� ������Ʈ��  - > ���콺 �����ʸ� �� �� ����
		addMouseListener(this);
		
		
	}
	
	
	
	private void setMap() {
		int x = 50;
		int y = 50;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				this.map[i][j] = new Nemo(x,y,50,50, Color.red);
				x+=50;
			}
			x= 50;
			y+= 50;
		}
		
	}



	@Override
	protected void paintComponent(Graphics g) { // ȭ����� �׷����� �׷��ִ� ���� / �����带 ���� ���� ( ��� �׸��� �׸��� ��)
		// TODO Auto-generated method stub
		super.paintComponent(g);  // �׷����� g -> �����ִ� ���� ( ���� ) �׸��� �ٽ� �׸��� ..
		
//		g.setColor(Color.red);  // �׷����� ���� �ٲ���
//		g.drawRect(100, 100, 100, 100);
//		g.fillRect(100, 100, 100, 100);
		// ������ �׳� �׸��ϻ� � ���ҵ� ���� ���� ..  ��üȭ�� �ϱ� ���� ���� Nemo ��ü�� �������� ���� Ŭ����
		
		// ������ 
		// ����Ʈ���� ���ΰͰ� ���� ������ �� ���� 
		
//		g.setColor(this.nemo.getC());
//		g.drawRect(this.nemo.getX(), this.nemo.getY(), this.nemo.getWidth(), this.nemo.getHeight());
		
		// draw map
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				Nemo temp = this.map[i][j];
				g.setColor(temp.getC());
//				g.drawRect(temp.getX(),temp.getY(),temp.getWidth(),temp.getHeight()); -> �׸�
				g.fillRoundRect(temp.getX(),temp.getY(),temp.getWidth(),temp.getHeight(),temp.getWidth(),temp.getHeight());
				// curve���� width�� height ���� �����ϰ�
			}
		}
		
		repaint();
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Ŭ��");
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Ŭ -");
		
		// Ŭ���� �߻��� ������ ��ǥ ���� ������
		int x = e.getX();
		int y = e.getY();
		
		System.out.println(x +"/ " + y);
		
//		if(x>= this.nemo.getX() && x<this.nemo.getX() + this.nemo.getWidth() 
//		&& y>= this.nemo.getY() && y <this.nemo.getY() + this.nemo.getHeight()) {
//			this.nemo.setC(Color.red);
//		}
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("- ��");
		
	}



	@Override
	public void mouseEntered(MouseEvent e) { // ���콺�����ʰ� �۵��Ǵ� �����ȿ� ���콺�� ������ 
		System.out.println("hello");
		
	}



	@Override
	public void mouseExited(MouseEvent e) { // ���콺�����ʰ� �۵��Ǵ� ���������� ���콺�� ������ 
		System.out.println("bye");
		
	}
}

class MyFrame extends JFrame{
	public MyFrame() {
		setLayout(null);
		setTitle("My Frame");
		setBounds(50,50,500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new MyPanel());
		
		setVisible(true);
		revalidate();
	}
}

public class Ex1105 {

	public static void main(String[] args) {
		MyFrame game = new MyFrame();

	}

}
