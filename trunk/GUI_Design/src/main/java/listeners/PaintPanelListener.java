package listeners;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;

import javax.swing.event.MouseInputAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import view.PaintPanel;
import view.Window;

public class PaintPanelListener extends MouseInputAdapter implements
		ActionListener, ComponentListener {
	private static final Logger	log				= LoggerFactory
														.getLogger(PaintPanelListener.class);
	
	private PaintPanel			paintPanel;
	private Window				window;
	
	public Point				mouseLocation	= new Point();
	public Point				startDragLocation;
	public Point				dragOffset		= new Point();
	
	public boolean				leftButton;
	public boolean				middleButton;
	public boolean				rightButton;
	public boolean				mouseDragged;
	
	public int					scrollLevel		= 20;
	public double				cursorState		= 0;
	
	public PaintPanelListener(PaintPanel paintPanel) {
		this.paintPanel = paintPanel;
		window = paintPanel.window;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		if (paintPanel.contains(e.getPoint())) {
			mouseLocation = e.getPoint();
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (paintPanel.contains(e.getPoint())) {
			mouseLocation = e.getPoint();
			if (startDragLocation == null) {
				startDragLocation = new Point(mouseLocation);
			} else {
				dragOffset.setLocation(mouseLocation.x - startDragLocation.x,
						mouseLocation.y - startDragLocation.y);
			}
			mouseDragged = true;
			
			// log.info("Drag - left: {}, middle: {}, right: {}", new Object[] {
			// leftButton, middleButton, rightButton });
			paintPanel.repaint();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		paintPanel.repaint();
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (paintPanel.contains(e.getPoint())) {
			leftButton = e.getButton() == MouseEvent.BUTTON1 ? true
					: leftButton;
			middleButton = e.getButton() == MouseEvent.BUTTON2 ? true
					: middleButton;
			rightButton = e.getButton() == MouseEvent.BUTTON3 ? true
					: rightButton;
			
			// log.info("Press - left: {}, middle: {}, right: {}", new Object[]
			// { leftButton, middleButton, rightButton });
			paintPanel.repaint();
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		leftButton = e.getButton() == MouseEvent.BUTTON1 ? false : leftButton;
		middleButton = e.getButton() == MouseEvent.BUTTON2 ? false
				: middleButton;
		rightButton = e.getButton() == MouseEvent.BUTTON3 ? false : rightButton;
		
		if (!leftButton && !middleButton && !rightButton) {
			startDragLocation = null;
			paintPanel.gridOffsetX += dragOffset.x;
			paintPanel.gridOffsetY += dragOffset.y;
			dragOffset.setLocation(0, 0);
			mouseDragged = false;
		}
		
		// log.info("Release - left: {}, middle: {}, right: {}", new Object[] {
		// leftButton, middleButton, rightButton });
		paintPanel.repaint();
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (paintPanel.contains(e.getPoint())) {
			scrollLevel -= e.getWheelRotation();
			scrollLevel = scrollLevel < 0 ? 0 : (scrollLevel > 40 ? 40
					: scrollLevel);
			
			// log.info("Mouse Wheel Moved - amount: {}", e.getWheelRotation());
			
			paintPanel.repaint();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		cursorState = (cursorState + .25) % (2 * Math.PI);
		
		paintPanel.repaint();
	}
	
	public void componentHidden(ComponentEvent arg0) {
	}
	
	public void componentMoved(ComponentEvent arg0) {
	}
	
	public void componentResized(ComponentEvent arg0) {
		paintPanel.offScreenImage = new BufferedImage(
				paintPanel.getWidth() > 0 ? paintPanel.getWidth() : 1,
				paintPanel.getHeight() > 0 ? paintPanel.getHeight() : 1,
				BufferedImage.TYPE_INT_ARGB);
		paintPanel.offScreen = paintPanel.offScreenImage.createGraphics();
	}
	
	public void componentShown(ComponentEvent arg0) {
	}
}
