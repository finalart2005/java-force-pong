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
public class AboutDialogAction extends AbstractAction {
	private static final Logger	log	= LoggerFactory.getLogger(AboutDialogAction.class);
	
	public AboutDialogAction() {
		super("About");
		
		putValue(SHORT_DESCRIPTION, "About dialog");
		putValue(MNEMONIC_KEY, KeyEvent.VK_A);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Window parent = null;
		if (e.getSource() instanceof Component) {
			parent = SwingUtilities.getWindowAncestor((Component) e.getSource());
		}
		
		log.debug("About dialog shown");
	}
}
