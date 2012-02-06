package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import listeners.OptionsWindowListener;
import model.Game;

public class OptionsWindow extends JFrame {
	private Window					window;
	private Game					game;
	private OptionsWindowListener	listener;
	
	public OptionsWindow(Window window, Game game) {
		super("Options");
		this.window = window;
		this.game = game;
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	public Window getWindow() {
		return window;
	}
	
	private void createAndShowGUI() {
		// Create and set up the window.
		setResizable(false);
		
		listener = new OptionsWindowListener(this);
		addWindowListener(listener);
		System.out.println("blaa");
		
		// Set up the content pane, where the "main GUI" lives.
		Container contentPane = getContentPane();
		JPanel frameContents = new JPanel();
		frameContents.setLayout(new BorderLayout(5, 5));
		
		// Start creating and adding components.
		// TODO add options
		
		// Adding components to JPanel, which is then added to the contentPane
		// frameContents.add(BorderLayout.CENTER, options);
		contentPane.add(frameContents);
		contentPane.validate();
		
		// Show the window.
		pack();
		setVisible(true);
	}
}
