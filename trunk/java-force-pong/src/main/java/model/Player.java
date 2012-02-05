package model;

public class Player {
	private String		name;
	private int			lives;
	private PlayArea	playArea;
	
	public Player(String name) {
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
