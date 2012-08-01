package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.entity.Entity;
import model.player.Player;

public class Game {
	private List<Player>	playerList	= new ArrayList<Player>();
	private List<Entity>	entityList	= new LinkedList<Entity>();
	
	public Game() {
		start();
	}
	
	private void start() {
		// TODO Auto-generated method stub
	}
	
	public List<Player> getPlayerList() {
		return playerList;
	}
	
	public List<Entity> getEntityList() {
		return entityList;
	}
	
	public void addPlayer(Player player) {
		playerList.add(player);
	}
}
