package model.entity;

import model.Game;
import model.util.Image;
import model.util.VectXY;

public class PhysicsEntity extends VisualEntity implements TickableEntity {
	
	private VectXY	velocity;
	
	public PhysicsEntity(VectXY pos, Image image, Game game) {
		super(pos, image, game);
		// TODO Auto-generated constructor stub
	}
	
	public void tick() {
		getPos().add(VectXY.multiply(velocity, game.TIMESTEP));
	}
}
