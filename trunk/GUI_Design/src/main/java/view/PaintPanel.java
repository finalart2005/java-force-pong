package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

import listeners.PaintPanelListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class PaintPanel extends JPanel {
	private static final Logger	log			= LoggerFactory.getLogger(PaintPanel.class);

	public Window				window;

	private PaintPanelListener	listener;
	private Timer				timer;

	public BufferedImage		offScreenImage;
	public Graphics2D			offScreen;

	public int					gridOffsetX	= 0;
	public int					gridOffsetY	= 0;

	public PaintPanel(Window window) {
		this.window = window;

		buildListener();
		timer = new Timer(20, listener);
		timer.start();

		setBackground(new Color(0, 0, 32));

		offScreenImage = new BufferedImage(640, 480, BufferedImage.TYPE_INT_ARGB);
		offScreen = offScreenImage.createGraphics();
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
		offScreen.setColor(getBackground());
		offScreen.fillRect(0, 0, getWidth(), getHeight());

		// draw grid
		int spacing = listener.scrollLevel > 0 ? listener.scrollLevel : 1;
		offScreen.setColor(new Color(32, 32, 64));
		for (int x = (gridOffsetX + listener.dragOffset.x) % spacing; x < getWidth(); x += spacing) {
			offScreen.drawLine(x, 0, x, getHeight());
		}
		for (int y = (gridOffsetY + listener.dragOffset.y) % spacing; y < getHeight(); y += spacing) {
			offScreen.drawLine(0, y, getWidth(), y);
		}

		// draw origin
		offScreen.setColor(new Color(255,255,64));
		offScreen.drawOval(gridOffsetX + listener.dragOffset.x-4, gridOffsetY + listener.dragOffset.y-4, 8, 8);
		
		// left mousebutton
		if (listener.leftButton) {
			offScreen.setColor(Color.RED);
			offScreen.fillRect(10, 10, 10, 10);
		}
		offScreen.setColor(Color.WHITE);
		offScreen.drawRect(10, 10, 10, 10);

		// middle mousebutton
		if (listener.middleButton) {
			offScreen.setColor(Color.YELLOW);
			offScreen.fillRect(25, 10, 10, 10);
		}
		offScreen.setColor(Color.WHITE);
		offScreen.drawRect(25, 10, 10, 10);

		// right mousebutton
		if (listener.rightButton) {
			offScreen.setColor(Color.GREEN);
			offScreen.fillRect(40, 10, 10, 10);
		}
		offScreen.setColor(Color.WHITE);
		offScreen.drawRect(40, 10, 10, 10);

		// mousedrag
		if (listener.mouseDragged) {
			offScreen.setColor(Color.BLUE);
			offScreen.fillRect(10, 25, 40, 10);
		}
		offScreen.setColor(Color.WHITE);
		offScreen.drawRect(10, 25, 40, 10);

		// scroll level
		offScreen.setColor(Color.WHITE);
		offScreen.drawLine(10 + listener.scrollLevel, 40, 10 + listener.scrollLevel, 50);

		// drag line
		if (listener.mouseDragged) {
			offScreen.setColor(Color.GRAY);
			offScreen.drawLine(listener.startDragLocation.x, listener.startDragLocation.y, listener.mouseLocation.x, listener.mouseLocation.y);
		}

		// cursor
		offScreen.setColor(Color.WHITE);
		int dx = (int) (Math.cos(listener.cursorState) * 10);
		int dy = (int) (Math.sin(listener.cursorState) * 10);

		offScreen.drawLine(listener.mouseLocation.x + dx / 2, listener.mouseLocation.y + dy / 2, listener.mouseLocation.x + dx, listener.mouseLocation.y + dy);
		offScreen.drawLine(listener.mouseLocation.x + dy / 2, listener.mouseLocation.y - dx / 2, listener.mouseLocation.x + dy, listener.mouseLocation.y - dx);
		offScreen.drawLine(listener.mouseLocation.x - dx / 2, listener.mouseLocation.y - dy / 2, listener.mouseLocation.x - dx, listener.mouseLocation.y - dy);
		offScreen.drawLine(listener.mouseLocation.x - dy / 2, listener.mouseLocation.y + dx / 2, listener.mouseLocation.x - dy, listener.mouseLocation.y + dx);

		g.drawImage(offScreenImage, 0, 0, this);
	}
}
