package controller;

import model.Game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import view.MainWindow;

public class JavaPong {
	private static final Logger	log	= LoggerFactory.getLogger(JavaPong.class);
	
	private final Game			game;
	
	private JavaPong() {
		game = new Game();
		new MainWindow(512, 512, game);
	}
	
	public static void main(String[] args) {
		System.out.println("Rick is still a fucking idiot!");
		
		new JavaPong();
	}
}
