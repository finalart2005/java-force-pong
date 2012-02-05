package model;

public class VisualEntity extends Entity {
	
	private double		xPos, yPos;
	private PongImage	image;
	
	public VisualEntity(double xPos, double yPos, PongImage image, Game game) {
		super(game);
		this.xPos = xPos;
		this.yPos = yPos;
		this.image = image;
	}
	
	public PongImage getImage() {
		return image;
	}
	
	public void setXPos(double xPos) {
		this.xPos = xPos;
	}
	
	public void setYPos(double yPos) {
		this.yPos = yPos;
	}
	
	public double getXPos() {
		return xPos;
	}
	
	public double getYPos() {
		return yPos;
	}
}
