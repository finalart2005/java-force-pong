package view;

import javax.swing.JFrame;

public class Window extends JFrame {
	private Game game;
	private PaintPanel paintPanel;
	
	public Window(int width, int height, Game game){
		this.game = game;
	}
}
