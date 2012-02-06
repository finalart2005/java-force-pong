package model.entity;

import model.Game;
import model.util.Image;
import model.util.VectXY;

public class VisualEntity extends Entity {
	
	private VectXY		pos;
	private Image	image;
	
	public VisualEntity(VectXY pos, Image image, Game game) {
		super(game);
		this.pos = pos.clone();
		this.image = image;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setPos(VectXY pos) {
		this.pos = pos.clone();
	}
	
	public VectXY getPos() {
		return pos;
	}
}
