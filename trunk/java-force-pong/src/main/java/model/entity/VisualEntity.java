package model.entity;

import java.awt.Graphics;

import model.util.ScreenTransform;
import model.util.VectXY;

public interface VisualEntity extends Entity {
	public VectXY getPos();
	
	public void paint(Graphics g, ScreenTransform sct);
}
