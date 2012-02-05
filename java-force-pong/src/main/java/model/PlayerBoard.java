package model;

public class PlayerBoard extends VisualEntity {
	private PongImage	image;
	
	public PlayerBoard(double xPos, double yPos, PongImage image, Game game) {
		super(xPos, yPos, image, game);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public PongImage getImage() {
		return image;
	}
}
