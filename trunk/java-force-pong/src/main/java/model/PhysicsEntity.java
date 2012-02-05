package model;

public class PhysicsEntity extends VisualEntity implements TickableEntity {
	
	private double	xVel, yVel;
	
	public PhysicsEntity(double xPos, double yPos, PongImage image, Game game) {
		super(xPos, yPos, image, game);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void tick() {
		setXPos(getXPos() + game.TIMESTEP * xVel);
		setYPos(getYPos() + game.TIMESTEP * yVel);
	}
}
