package view;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.Game;
import observer.action.AboutDialogAction;
import observer.action.ExitAction;
import observer.action.OptionsDialogAction;
import observer.action.PauseGameAction;
import observer.action.StartGameAction;
import controller.GameSim;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	private Game		game;
	private GamePanel	gamePanel;
	
	public MainWindow(Game game) {
		super("Java Force Pong");
		this.game = game;
		
		createAndShowGUI();
		
		startGame();
	}
	
	private void startGame() {
		GameSim gameSim = new GameSim(game, gamePanel);
		gameSim.execute();
	}
	
	public Game getGame() {
		return game;
	}
	
	private void createAndShowGUI() {
		// Create and set up the window.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		// Set up the content pane, where the "main GUI" lives.
		JPanel contentPane = new JPanel(new GridBagLayout());
		
		// Start creating and adding components.
		gamePanel = new GamePanel(game);
		
		// Adding components to JPanel, which is then added to the contentPane
		contentPane.add(gamePanel);
		
		add(contentPane);
		
		setJMenuBar(createMenuBar());
		
		// Show the window.
		pack();
	}
	
	private JMenuBar createMenuBar() {
		// Set up the menu bar, which appears above the content pane.
		JMenuBar menuBar = new JMenuBar();
		
		// File menu
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem startMenuItem = new JMenuItem(new StartGameAction(game));
		fileMenu.add(startMenuItem);
		
		JMenuItem pauseMenuItem = new JMenuItem(new PauseGameAction(game));
		fileMenu.add(pauseMenuItem);
		
		fileMenu.addSeparator();
		
		JMenuItem exitMenuItem = new JMenuItem(new ExitAction(this));
		fileMenu.add(exitMenuItem);
		
		menuBar.add(fileMenu);
		
		// Options menu
		JMenu optionsMenu = new JMenu("Options");
		
		JMenuItem optionsMenuItem = new JMenuItem(new OptionsDialogAction());
		optionsMenu.add(optionsMenuItem);
		
		menuBar.add(optionsMenu);
		
		// Help menu
		JMenu helpMenu = new JMenu("Help");
		
		JMenuItem aboutMenuItem = new JMenuItem(new AboutDialogAction());
		helpMenu.add(aboutMenuItem);
		
		menuBar.add(helpMenu);
		
		return menuBar;
	}
}
