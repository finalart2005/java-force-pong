package model;

public class Player extends Entity {
	private String		name;
	private int			lives;
	private PlayerArea	playerArea;
	private PlayerBoard	playerBoard;
	
	public Player(String name, Game game) {
		super(game);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLives() {
		return lives;
	}
	
	public int lowerLives() {
		for (int i = 5; i > 0; i--) {
			lives--;
		}
		return lives;
	}
}
