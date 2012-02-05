package model;

public class VisualEntity extends Entity {
	
	private VectXY		pos;
	private PongImage	image;
	
	public VisualEntity(VectXY pos, PongImage image, Game game) {
		super(game);
		this.pos = pos.clone();
		this.image = image;
	}
	
	public PongImage getImage() {
		return image;
	}
	
	public void setPos(VectXY pos) {
		this.pos = pos.clone();
	}
	
	public VectXY getPos() {
		return pos;
	}
}
