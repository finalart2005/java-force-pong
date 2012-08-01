package model.physics.force;

import model.Game;
import model.util.VectXY;

public class Gravity extends SimpleForce {
	public Gravity(double strength, Game game) {
		super(game, new VectXY(0, -strength));
	}
}
