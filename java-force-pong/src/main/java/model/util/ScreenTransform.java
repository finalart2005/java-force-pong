package model.util;

public class ScreenTransform {
	VectXY	center;
	double	scale;
	
	public ScreenTransform() {
		this(new VectXY(), 1.0);
	}
	
	public ScreenTransform(VectXY center) {
		this(center, 1.0);
	}
	
	public ScreenTransform(double scale) {
		this(new VectXY(), scale);
	}
	
	public ScreenTransform(VectXY center, double scale) {
		this.center = center;
		this.scale = scale;
	}
	
	public VectXY convertToScreen(VectXY worldPos) {
		VectXY screenPos = worldPos.clone();
		screenPos.subtract(center);
		screenPos.divide(scale);
		return screenPos;
	}
	
	public VectXY convertToWorld(VectXY screenPos) {
		VectXY worldPos = screenPos.clone();
		worldPos.multiply(scale);
		worldPos.add(center);
		return worldPos;
	}
}
