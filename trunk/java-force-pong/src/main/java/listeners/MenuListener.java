package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import model.Game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import view.OptionsWindow;
import view.Window;

public class MenuListener implements ActionListener {
	private static final Logger	log	= LoggerFactory.getLogger(MenuListener.class);
	
	private Window				window;
	private Game				game;
	
	public MenuListener(Window window, Game game) {
		this.window = window;
		this.game = game;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JMenuItem) {
			JMenuItem source = (JMenuItem) e.getSource();
			log.info("WindowListener - actionPerformed - source: JMenuItem - name: {}", source.getText());
			
			if (source.getText() == "Exit") {
				log.info("Exit program");
				System.exit(0);
			} else if (source.getText() == "Options") {
				log.info("Options");
				game.pause();
				window.setEnabled(false);
				new OptionsWindow(window, game);
			}
		}
	}
}
