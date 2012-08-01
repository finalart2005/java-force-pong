package observer.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import model.Game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class StartAction extends AbstractAction {
	private static final Logger	log	= LoggerFactory.getLogger(StartAction.class);
	
	private Game				game;
	
	public StartAction(Game game) {
		super("Start game");
		
		putValue(SHORT_DESCRIPTION, "Start game");
		putValue(MNEMONIC_KEY, KeyEvent.VK_S);
		
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		log.info("Game started");
	}
}
