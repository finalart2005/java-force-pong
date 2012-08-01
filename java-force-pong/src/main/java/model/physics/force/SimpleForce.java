package model.physics.force;

import model.Game;
import model.util.VectXY;

public class SimpleForce extends Force {
	public SimpleForce(Game game, VectXY forceVector) {
		super(game);
		set(forceVector);
	}
	
	public SimpleForce(Game game) {
		super(game);
	}
}
