package observer.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import model.Game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class PauseGameAction extends AbstractAction {
	private static final Logger	log	= LoggerFactory.getLogger(PauseGameAction.class);
	
	private Game				game;
	
	public PauseGameAction(Game game) {
		super("Pause game");
		
		putValue(SHORT_DESCRIPTION, "Pause game");
		putValue(MNEMONIC_KEY, KeyEvent.VK_P);
		
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		log.info("Game paused");
	}
}
