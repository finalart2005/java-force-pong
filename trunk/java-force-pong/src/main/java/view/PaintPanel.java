package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import listeners.PaintPanelListener;

public class PaintPanel extends JPanel {
	public Window				window;
	
	private PaintPanelListener	listener;
	private Timer				timer;
	
	public double				phase;
	
	public PaintPanel(Window window) {
		this.window = window;
		
		buildListener();
		timer = new Timer(20, listener);
		timer.start();
		
		setBackground(new Color(0, 0, 32));
		
		setDoubleBuffered(true); // eliminates the need to implement double
									// buffering by yourself using an off screen
									// image
	}
	
	public void buildListener() {
		listener = new PaintPanelListener(this);
		addMouseListener(listener);
		addMouseMotionListener(listener);
		addMouseWheelListener(listener);
		addComponentListener(listener);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		// draw background
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		
		Random random = new Random();
		
		// for (int i = 0; i < 1000; i++) {
		// int x = random.nextInt(getWidth());
		// int y = random.nextInt(getHeight());
		// int width = random.nextInt(30) + 20;
		// int height = random.nextInt(30) + 20;
		// g.setColor(new Color(random.nextInt(1 << 23)));
		// g.fillOval(x, y, width, height);
		// }
		
		g.setColor(Color.RED);
		int width = (int) (Math.cos(Math.PI * 2 * phase) * 60 + 100);
		int height = (int) (Math.sin(Math.PI * 2 * phase) * 60 + 100);
		g.fillOval(listener.mouseLocation.x - width / 2, listener.mouseLocation.y - height / 2, width, height);
	}
	
}
