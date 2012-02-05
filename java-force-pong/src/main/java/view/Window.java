package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import listeners.MenuListener;
import model.Game;

public class Window {
	private Game		game;
	public JFrame		frame;
	private PaintPanel	paintPanel;
	
	public Window(final int width, final int height, Game game) {
		this.game = game;
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(width, height);
			}
		});
	}
	
	private void createAndShowGUI(int width, int height) {
		// Create and set up the window.
		frame = new JFrame("Java Force Pong");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set up the content pane, where the "main GUI" lives.
		Container contentPane = frame.getContentPane();
		JPanel frameContents = new JPanel();
		frameContents.setLayout(new BorderLayout(5, 5));
		
		// Start creating and adding components.
		paintPanel = new PaintPanel(this);
		paintPanel.setPreferredSize(new Dimension(width, height));
		
		// Adding components to JPanel, which is then added to the contentPane
		frameContents.add(BorderLayout.CENTER, paintPanel);
		contentPane.add(frameContents);
		contentPane.validate();
		
		// Set up the menu bar, which appears above the content pane.
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		
		JMenuItem menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(new MenuListener(this));
		menu.add(menuItem);
		
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		
		// Show the window.
		frame.pack();
		frame.setVisible(true);
	}
	
	public void repaint() {
		frame.repaint();
	}
}
