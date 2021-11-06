package gui_study;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

// painComponent() 메소드를 활용한 사각형 그리기
class Nemo{
	// draw에 필요한 객체를 준비  
	private int x, y, width, height;
	private Color c; 
	// 패널에 add할 수 있게 클래스 따로 만들어줌 
	
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
		
		// 버튼에 액션리스너를 달았던것과 같이
		// 패널에 혹은 특정하는 컴포넌트에  - > 마우스 리스너를 달 수 있음
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
	protected void paintComponent(Graphics g) { // 화면상의 그래픽을 그려주는 역할 / 스레드를 돌고 있음 ( 계속 그림을 그리는 중)
		// TODO Auto-generated method stub
		super.paintComponent(g);  // 그래픽의 g -> 지워주는 역할 ( 갱신 ) 그리고 다시 그리고 ..
		
//		g.setColor(Color.red);  // 그래픽의 색깔 바꿔줌
//		g.drawRect(100, 100, 100, 100);
//		g.fillRect(100, 100, 100, 100);
		// 도형은 그냥 그림일뿐 어떤 역할도 하지 않음 ..  객체화를 하기 위해 서는 Nemo 객체를 만들어야함 따로 클래스
		
		// 차이점 
		// 포스트잇을 붙인것과 같이 수정할 수 있음 
		
//		g.setColor(this.nemo.getC());
//		g.drawRect(this.nemo.getX(), this.nemo.getY(), this.nemo.getWidth(), this.nemo.getHeight());
		
		// draw map
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				Nemo temp = this.map[i][j];
				g.setColor(temp.getC());
//				g.drawRect(temp.getX(),temp.getY(),temp.getWidth(),temp.getHeight()); -> 네모
				g.fillRoundRect(temp.getX(),temp.getY(),temp.getWidth(),temp.getHeight(),temp.getWidth(),temp.getHeight());
				// curve값은 width과 height 값과 동일하게
			}
		}
		
		repaint();
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("클릭");
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("클 -");
		
		// 클릭이 발생한 지점의 좌표 값을 얻어오는
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
		System.out.println("- 릭");
		
	}



	@Override
	public void mouseEntered(MouseEvent e) { // 마우스리스너가 작동되는 영역안에 마우스가 들어오면 
		System.out.println("hello");
		
	}



	@Override
	public void mouseExited(MouseEvent e) { // 마우스리스너가 작동되는 영역밖으로 마우스가 나가면 
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
