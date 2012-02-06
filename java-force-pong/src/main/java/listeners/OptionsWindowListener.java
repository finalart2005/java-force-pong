package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import view.OptionsWindow;

public class OptionsWindowListener implements ActionListener, WindowListener {
	
	private OptionsWindow	optionsWindow;
	
	public OptionsWindowListener(OptionsWindow optionsWindow) {
		this.optionsWindow = optionsWindow;
	}
	
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void windowClosing(WindowEvent e) {
		optionsWindow.getWindow().setEnabled(true);
		optionsWindow.getWindow().getGame().start();
	}
	
	public void windowClosed(WindowEvent e) {
	}
	
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
