package model.entity;

import java.util.Set;

import model.physics.force.Force;
import model.util.VectXY;

public interface PhysicalEntity extends VisualEntity {
	public VectXY getVel();
	
	public Set<Force> getForceSet();
	
	public Force getNetForce();
}