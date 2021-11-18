package gui_horseRace;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Horse {
	private int x,y,w,h;
	
	private String fileName;
	private ImageIcon image;
	private int num;
	
	private int state; 
	public final int RUN = 0;
	public final int GOAL = 1;
	
	private int rank;
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	private String record;
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public String getFileName() {
		return fileName;
	}

	public ImageIcon getImage() {
		return image;
	}

	public int getNum() {
		return num;
	}

	public int getState() {
		return state;
	}

	public String getRecord() {
		return record;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setW(int w) {
		this.w = w;
	}

	public void setH(int h) {
		this.h = h;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public Horse(int num, int x, int y, int w, int h) {
		this.num = num;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.fileName = String.format("images/horse%d.png", this.num);
		this.image = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
				
	}
	
}
