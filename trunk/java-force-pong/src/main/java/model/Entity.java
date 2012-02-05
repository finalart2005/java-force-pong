package model;

public class Entity {
	protected Game	game;
	
	private double	timestep	= 0.5;
	
	public Entity(Game game) {
		this.game = game;
	}
	
	public void tick() {
	}
}
