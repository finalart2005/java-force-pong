package model.player;

import model.Game;
import model.entity.Entity;

public abstract class Player implements Entity {
	private String		name;
	private int			lives;
	private PlayerBoard	playerBoard;
	private Game		game;
	
	public Player(String name, int lives, Game game) {
		this.name = name;
		this.lives = lives;
		
		this.game = game;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLives() {
		return lives;
	}
	
	public void increaseLives() {
		lives++;
	}
	
	public void decreaseLives() {
		lives--;
	}
	
	public PlayerBoard getPlayerBoard() {
		return playerBoard;
	}
	
	@Override
	public Game getGame() {
		return game;
	}
}
