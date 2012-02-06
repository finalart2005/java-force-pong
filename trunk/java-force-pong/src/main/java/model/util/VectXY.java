package model.util;

public class VectXY {
	public double	x, y;
	
	public VectXY() {
		this(0.0, 0.0);
	}
	
	public VectXY(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public VectXY clone() {
		return new VectXY(x, y);
	}
	
	// these functions change the VectXY instance itself
	
	public void add(VectXY v) {
		x += v.x;
		y += v.y;
	}
	
	public void subtract(VectXY v) {
		x -= v.x;
		y -= v.y;
	}
	
	public void multiply(VectXY v) {
		x *= v.x;
		y *= v.y;
	}
	
	public void divide(VectXY v) {
		x /= v.x;
		y /= v.y;
	}
	
	public void multiply(double scalar) {
		x *= scalar;
		y *= scalar;
	}
	
	public void divide(double scalar) {
		x /= scalar;
		y /= scalar;
	}
	
	public double norm() {
		return Math.sqrt(x * x + y * y);
	}
	
	public void normalize() {
		divide(norm());
	}
	
	// these functions preserve the data and return a new instance of VectXY;
	
	public static VectXY add(VectXY v1, VectXY v2) {
		return new VectXY(v1.x + v2.x, v1.y + v2.y);
	}
	
	public static VectXY subtract(VectXY v1, VectXY v2) {
		return new VectXY(v1.x - v2.x, v1.y - v2.y);
	}
	
	public static VectXY multiply(VectXY v1, VectXY v2) {
		return new VectXY(v1.x * v2.x, v1.y * v2.y);
	}
	
	public static VectXY divide(VectXY v1, VectXY v2) {
		return new VectXY(v1.x / v2.x, v1.y / v2.y);
	}
	
	public static VectXY multiply(VectXY v, double scalar) {
		return new VectXY(v.x * scalar, v.y * scalar);
	}
	
	public static VectXY divide(VectXY v, double scalar) {
		return new VectXY(v.x / scalar, v.y / scalar);
	}
	
	public static double norm(VectXY v) {
		return Math.sqrt(v.x * v.x + v.y * v.y);
	}
	
	public static VectXY normalize(VectXY v) {
		return divide(v, norm(v));
	}
}
