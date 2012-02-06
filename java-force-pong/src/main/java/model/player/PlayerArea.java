package model.player;

import java.util.HashSet;
import java.util.Set;

import model.physics.Deflector;

public class PlayerArea {
	private Set<Deflector>	deflectorSet	= new HashSet<Deflector>();
	
	public PlayerArea() {
		
	}
	
	public Set<Deflector> getDeflectorSet() {
		return deflectorSet;
	}
}
