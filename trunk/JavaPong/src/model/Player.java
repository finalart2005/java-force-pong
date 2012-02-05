package model;

public class Player {
	private String	name;
	private int		lives;
	
	
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
		for(this.lives = lives; lives > 0; lives --){
			
		}
		return lives;
	}
}
