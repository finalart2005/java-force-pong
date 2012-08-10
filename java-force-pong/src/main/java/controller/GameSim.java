package controller;

import java.awt.Point;
import java.util.List;

import javax.swing.SwingWorker;

import model.Game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import view.GamePanel;

public class GameSim extends SwingWorker<Point, Point> {
	private static final Logger	log	= LoggerFactory.getLogger(GameSim.class);
	
	private Game				game;
	private GamePanel			gamePanel;
	
	public GameSim(Game game, GamePanel gamePanel) {
		this.game = game;
		this.gamePanel = gamePanel;
		
	}
	
	@Override
	protected Point doInBackground() throws Exception {
		while (true) {
			publish((Point) game.mouseLocation.clone());
		}
	}
	
	@Override
	protected void process(List<Point> pointList) {
		game.newMouseLocation = pointList.get(pointList.size() - 1);
		if (gamePanel != null) {
			// log.debug("x: {}, y: {}", game.newMouseLocation.x, game.newMouseLocation.y);
			gamePanel.repaint();
		}
	}
}
