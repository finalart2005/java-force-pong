package model.entity;

public interface ChangingEntity extends Entity {
	public void update(double timeStep);
	
	public double getRelTime();
}
