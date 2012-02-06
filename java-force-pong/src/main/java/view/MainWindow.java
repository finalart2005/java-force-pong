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

public class MainWindow extends JFrame {
	private Game			game;
	private PaintPanel		paintPanel;
	private MenuListener	menuListener;
	
	private boolean			setPause	= false;
	
	public MainWindow(final int width, final int height, Game game) {
		super("Java Force Pong");
		this.game = game;
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(width, height);
			}
		});
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
		menuListener = new MenuListener(this, game);
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem optionsMenuItem = new JMenuItem("Options");
		optionsMenuItem.addActionListener(menuListener);
		JMenu helpMenu = new JMenu("Help");
		
		JMenuItem startMenuItem = new JMenuItem("Start");
		startMenuItem.addActionListener(menuListener);
		fileMenu.add(startMenuItem);
		
		JMenuItem pauseMenuItem = new JMenuItem("Pause");
		pauseMenuItem.addActionListener(menuListener);
		fileMenu.add(pauseMenuItem);
		
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(menuListener);
		fileMenu.add(exitMenuItem);
		
		JMenuItem aboutMenuItem = new JMenuItem("About");
		aboutMenuItem.addActionListener(menuListener);
		helpMenu.add(aboutMenuItem);
		
		menuBar.add(fileMenu);
		menuBar.add(optionsMenuItem);
		menuBar.add(helpMenu);
		setJMenuBar(menuBar);
		
		// Show the window.
		pack();
		setVisible(true);
	}
}
