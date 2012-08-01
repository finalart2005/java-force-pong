package model.entity;

import java.awt.Graphics;

import model.Game;
import model.util.ScreenTransform;
import model.util.VectXY;

public class Bonus implements VisualEntity {
	
	private VectXY	pos;
	private Game	game;
	
	public Bonus(VectXY pos, Game game) {
		this.pos = pos;
		this.game = game;
	}
	
	@Override
	public Game getGame() {
		return game;
	}
	
	@Override
	public VectXY getPos() {
		return pos.clone();
	}
	
	@Override
	public void paint(Graphics g, ScreenTransform sct) {
		// TODO Auto-generated method stub
	}
}
