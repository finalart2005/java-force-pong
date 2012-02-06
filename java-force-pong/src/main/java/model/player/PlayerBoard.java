package model.player;

import model.Game;
import model.entity.VisualEntity;
import model.util.Image;
import model.util.VectXY;

public class PlayerBoard extends VisualEntity {
	private Image	image;
	
	public PlayerBoard(VectXY pos, Image image, Game game) {
		super(pos, image, game);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Image getImage() {
		return image;
	}
}
