package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Game;

public class GameListener implements ActionListener {
	private Game	game;
	
	public GameListener(Game game) {
		this.game = game;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == game.getTimer()) {
			game.tick();
		}
		
	}
}
