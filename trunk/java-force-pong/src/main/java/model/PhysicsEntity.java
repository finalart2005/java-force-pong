package model;

public class PhysicsEntity extends VisualEntity implements TickableEntity {
	
	private VectXY	velocity;
	
	public PhysicsEntity(VectXY pos, PongImage image, Game game) {
		super(pos, image, game);
		// TODO Auto-generated constructor stub
	}
	
	public void tick() {
		getPos().add(VectXY.multiply(velocity, game.TIMESTEP));
	}
}
