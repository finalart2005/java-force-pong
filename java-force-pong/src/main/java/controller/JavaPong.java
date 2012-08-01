package controller;

import javax.swing.SwingUtilities;

import model.Game;
import view.MainWindow;

public class JavaPong implements Runnable {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new JavaPong());
	}
	
	@Override
	public void run() {
		MainWindow mainWindow = new MainWindow(512, 512, new Game());
		
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setVisible(true);
	}
}
