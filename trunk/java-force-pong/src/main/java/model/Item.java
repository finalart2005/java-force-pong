package model;

public class Item {
	private PongImage	image;
	private double		xPos, yPos;
	private double		xVel, yVel;
	private double		timestep = 0.5;
	
	public Item(PongImage image) {
		this.image = image;
	}
	
	public PongImage getImage() {
		return image;
	}
	
	public void tick() {
		 setxPos(getxPos() + timestep * xVel);
		 setyPos(getyPos() + timestep * yVel);
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
	}

	public double getxPos() {
		return xPos;
	}
	
	public double getyPos() {
		return yPos;
	}
}
