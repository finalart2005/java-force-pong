package model.physics.force;

import model.Game;
import model.entity.Entity;
import model.util.VectXY;

public abstract class Force extends VectXY implements Entity {
	private Game	game;
	
	public Force(Game game) {
		this.game = game;
	}
	
	@Override
	public Game getGame() {
		return game;
	}
}
