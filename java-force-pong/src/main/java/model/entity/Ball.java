package model.entity;

import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;

import model.Game;
import model.physics.force.Force;
import model.physics.force.SimpleForce;
import model.util.ScreenTransform;
import model.util.VectXY;

public class Ball implements PhysicalEntity {
	
	private VectXY		pos, vel;
	private Set<Force>	forceSet;
	private Game		game;
	
	public Ball(VectXY pos, Game game) {
		this(pos, new VectXY(), new HashSet<Force>(), game);
	}
	
	public Ball(VectXY pos, VectXY vel, Set<Force> forceSet, Game game) {
		this.pos = pos;
		this.vel = vel;
		this.forceSet = forceSet;
		this.game = game;
	}
	
	@Override
	public VectXY getPos() {
		return pos;
	}
	
	@Override
	public VectXY getVel() {
		return vel;
	}
	
	@Override
	public Set<Force> getForceSet() {
		return forceSet;
	}
	
	@Override
	public Force getNetForce() {
		Force netForce = new SimpleForce(game);
		for (Force force : forceSet) {
			netForce.add(force);
		}
		return netForce;
	}
	
	@Override
	public Game getGame() {
		return game;
	}
	
	@Override
	public void paint(Graphics g, ScreenTransform sct) {
		// TODO Auto-generated method stub
	}
}
