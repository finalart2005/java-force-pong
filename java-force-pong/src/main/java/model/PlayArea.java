package model;

import java.util.HashSet;
import java.util.Set;

public class PlayArea {
	private Set<Deflector>	deflectorSet	= new HashSet<Deflector>();
	
	public PlayArea() {
		
	}
	
	public Set<Deflector> getDeflectorSet() {
		return deflectorSet;
	}
}
