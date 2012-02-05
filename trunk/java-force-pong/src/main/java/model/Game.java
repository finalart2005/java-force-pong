package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game {
	List<Player>				playerList	= new ArrayList<Player>();
	List<Entity>				entityList	= new LinkedList<Entity>();
	
	public static final int		FPS			= 25;
	public static final double	TIMESTEP	= 1.0 / FPS;
	
	public Game() {
		
	}
	
	public void tick() {
		for (Entity entity : entityList) {
			entity.tick();
		}
	}
	
	public int getNumPlayers() {
		return playerList.size();
	}
	
	public void addPlayer(Player player) {
		playerList.add(player);
	}
}
