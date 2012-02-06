package model.physics;

import model.util.VectXY;

public class Deflector {
	VectXY	posMin, posMax;
	
	public Deflector(VectXY posMin, VectXY posMax) {
		this.posMin = posMin;
		this.posMax = posMax;
	}
}
