package model;

public class PlayerBoard extends VisualEntity {
	private PongImage	image;
	
	public PlayerBoard(VectXY pos, PongImage image, Game game) {
		super(pos, image, game);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public PongImage getImage() {
		return image;
	}
}
