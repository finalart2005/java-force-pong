package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Game;

public class OptionsWindow {
	private Window	window;
	private Game	game;
	public JFrame	frame;
	
	public OptionsWindow(Window window) {
		this.window = window;
		game = window.getGame();
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	private void createAndShowGUI() {
		// Create and set up the window.
		frame = new JFrame("Options");
		frame.setResizable(false);
		
		// Set up the content pane, where the "main GUI" lives.
		Container contentPane = frame.getContentPane();
		JPanel frameContents = new JPanel();
		frameContents.setLayout(new BorderLayout(5, 5));
		
		// Start creating and adding components.
		// TODO add options
		
		// Adding components to JPanel, which is then added to the contentPane
		// frameContents.add(BorderLayout.CENTER, options);
		contentPane.add(frameContents);
		contentPane.validate();
		
		// Show the window.
		frame.pack();
		frame.setVisible(true);
	}
	
	public void repaint() {
		frame.repaint();
	}
}
