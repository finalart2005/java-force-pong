package observer.action;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class OptionsDialogAction extends AbstractAction {
	private static final Logger	log	= LoggerFactory.getLogger(OptionsDialogAction.class);
	
	public OptionsDialogAction() {
		super("Options");
		
		putValue(SHORT_DESCRIPTION, "Options dialog");
		putValue(MNEMONIC_KEY, KeyEvent.VK_O);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Window parent = null;
		if (e.getSource() instanceof Component) {
			parent = SwingUtilities.getWindowAncestor((Component) e.getSource());
		}
		
		log.debug("Options dialog shown");
	}
}
