package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import model.Game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	private static final Logger	log	= LoggerFactory.getLogger(GamePanel.class);
	
	private Game				game;
	private GamePanelListener	gamePanelListener;
	private long				lastTime;
	
	// Timer timer = new Timer(20, new ActionListener() {
	// @Override
	// public void actionPerformed(ActionEvent e) {
	// repaint();
	// }
	// });
	
	public double				phase;
	
	public GamePanel(Game game) {
		setPreferredSize(new Dimension(512, 512));
		
		this.game = game;
		
		buildListener();
		
		// Create a new blank cursor.
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "blank cursor");
		setCursor(blankCursor);
		
		// setBackground(new Color(0, 0, 32));
		
		// setDoubleBuffered(true); // eliminates the need to implement double
		// buffering by yourself using an off screen
		// image
		
		// timer.start();
	}
	
	public void buildListener() {
		gamePanelListener = new GamePanelListener();
		addMouseListener(gamePanelListener);
		addMouseMotionListener(gamePanelListener);
		addMouseWheelListener(gamePanelListener);
		addComponentListener(gamePanelListener);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		// draw background
		g.setColor(new Color(0, 0, 32));
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(new Color(192, 192, 255));
		if (gamePanelListener.inPanel) {
			g.fillOval(game.newMouseLocation.x - 4, game.newMouseLocation.y - 4, 8, 8);
		}
		
		g.drawString(game.newMouseLocation.x + ", " + game.newMouseLocation.y, 10, 502);
		
		long now = System.nanoTime();
		long timePassed = now - lastTime;
		lastTime = now;
		double fps = ((double) 1000000000 / timePassed);
		g.drawString("fps: " + fps, 10, 482);
		
		g.setColor(Color.RED);
		g.fillRect(10, gamePanelListener.leftButton ? 10 : 20, 20, 8);
		g.setColor(Color.YELLOW);
		g.fillRect(35, gamePanelListener.middleButton ? 10 : 20, 12, 8);
		g.setColor(Color.GREEN);
		g.fillRect(52, gamePanelListener.rightButton ? 10 : 20, 20, 8);
	}
	
	private class GamePanelListener extends MouseInputAdapter implements ActionListener, ComponentListener {
		public Point	mouseLocation	= new Point();
		
		public boolean	leftButton;
		public boolean	middleButton;
		public boolean	rightButton;
		public boolean	inPanel;
		
		@Override
		public void mouseMoved(MouseEvent e) {
			if (contains(e.getPoint())) {
				mouseLocation = e.getPoint();
				game.mouseLocation = mouseLocation;
			}
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			if (contains(e.getPoint())) {
				mouseLocation = e.getPoint();
				game.mouseLocation = mouseLocation;
			}
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			inPanel = true;
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			inPanel = false;
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			leftButton = e.getButton() == MouseEvent.BUTTON1 ? true : leftButton;
			middleButton = e.getButton() == MouseEvent.BUTTON2 ? true : middleButton;
			rightButton = e.getButton() == MouseEvent.BUTTON3 ? true : rightButton;
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			leftButton = e.getButton() == MouseEvent.BUTTON1 ? false : leftButton;
			middleButton = e.getButton() == MouseEvent.BUTTON2 ? false : middleButton;
			rightButton = e.getButton() == MouseEvent.BUTTON3 ? false : rightButton;
		}
		
		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {}
		
		@Override
		public void actionPerformed(ActionEvent e) {}
		
		@Override
		public void componentHidden(ComponentEvent arg0) {}
		
		@Override
		public void componentMoved(ComponentEvent arg0) {}
		
		@Override
		public void componentResized(ComponentEvent arg0) {}
		
		@Override
		public void componentShown(ComponentEvent arg0) {}
	}
}
