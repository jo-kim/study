package gui_horseRace;

import javax.swing.JFrame;

public class Frame extends JFrame{
	private Play play = new Play();
	public Frame() {
		super("Horse Race");
		setLayout(null);
		setBounds(400,200,1200,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(play);
		
		setVisible(true);
		revalidate();
		play.run();
	}
}
