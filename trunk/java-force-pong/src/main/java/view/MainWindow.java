package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.Game;
import observer.action.AboutDialogAction;
import observer.action.ExitAction;
import observer.action.PauseGameAction;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	private Game		game;
	private PaintPanel	paintPanel;
	
	public MainWindow(int width, int height, Game game) {
		super("Java Force Pong");
		this.game = game;
		
		createAndShowGUI(width, height);
	}
	
	public Game getGame() {
		return game;
	}
	
	private void createAndShowGUI(int width, int height) {
		// Create and set up the window.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set up the content pane, where the "main GUI" lives.
		Container contentPane = getContentPane();
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
		
		// File menu
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem startMenuItem = new JMenuItem(new StartGameAction(game));
		fileMenu.add(startMenuItem);
		
		JMenuItem pauseMenuItem = new JMenuItem(new PauseGameAction(game));
		fileMenu.add(pauseMenuItem);
		
		JMenuItem exitMenuItem = new JMenuItem(new ExitAction(this));
		fileMenu.add(exitMenuItem);
		
		menuBar.add(fileMenu);
		
		// Options menu
		JMenuItem optionsMenuItem = new JMenuItem(new OptionsDialogAction());
		
		menuBar.add(optionsMenuItem);
		
		// Help menu
		JMenu helpMenu = new JMenu("Help");
		
		JMenuItem aboutMenuItem = new JMenuItem(new AboutDialogAction());
		helpMenu.add(aboutMenuItem);
		
		menuBar.add(helpMenu);
		
		setJMenuBar(menuBar);
		
		// Show the window.
		pack();
		setVisible(true);
	}
}
