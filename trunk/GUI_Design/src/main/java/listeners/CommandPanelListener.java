package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import view.CommandPanel;
import view.Window;

public class CommandPanelListener implements ActionListener, ItemListener,
		ChangeListener {
	private static final Logger	log	= LoggerFactory
											.getLogger(CommandPanelListener.class);
	
	private CommandPanel		commandPanel;
	private Window				window;
	
	public CommandPanelListener(CommandPanel commandPanel) {
		this.commandPanel = commandPanel;
		window = commandPanel.window;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton source = (JButton) e.getSource();
			log.info(
					"CommandPanelListener - actionPerformed - source: JButton - name: {}",
					source.getText());
			if (source.getText() == "Button") {
				log.info("Button pressed");
				window.repaint();
			}
		}
	}
	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() instanceof JCheckBox) {
			JCheckBox source = (JCheckBox) e.getSource();
			log.info(
					"CommandPanelListener - itemStateChanged - source: JCheckBox - name: {}",
					source.getText());
		}
	}
	
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() instanceof JSpinner) {
			@SuppressWarnings("unused")
			JSpinner source = (JSpinner) e.getSource();
			log.info("CommandPanelListener - stateChanged - source: JSpinner");
		}
	}
}
