package listeners;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.event.MouseInputAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import view.PaintPanel;
import view.Window;

public class PaintPanelListener extends MouseInputAdapter implements ActionListener, ComponentListener {
	private static final Logger	log				= LoggerFactory.getLogger(PaintPanelListener.class);
	
	private PaintPanel			paintPanel;
	private Window				window;
	
	public Point				mouseLocation	= new Point();
	
	public boolean				leftButton;
	public boolean				middleButton;
	public boolean				rightButton;
	
	public PaintPanelListener(PaintPanel paintPanel) {
		this.paintPanel = paintPanel;
		window = paintPanel.window;
		window.getGame().getTimer().addActionListener(this);
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
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		leftButton = e.getButton() == MouseEvent.BUTTON1 ? false : leftButton;
		middleButton = e.getButton() == MouseEvent.BUTTON2 ? false : middleButton;
		rightButton = e.getButton() == MouseEvent.BUTTON3 ? false : rightButton;
		
		log.info("Some button was pressed! Waaaaaa!");
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
	}
	
	public void actionPerformed(ActionEvent e) {
		// paintPanel.phase = (paintPanel.phase + .05) % 1;
		if (e.getSource() == window.getGame().getTimer()) {
			paintPanel.window.getGame().tick();
			paintPanel.repaint();
		}
	}
	
	public void componentHidden(ComponentEvent arg0) {
	}
	
	public void componentMoved(ComponentEvent arg0) {
	}
	
	public void componentResized(ComponentEvent arg0) {
	}
	
	public void componentShown(ComponentEvent arg0) {
	}
}