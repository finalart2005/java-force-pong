package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game {
	
	List<Player>	playerList	= new ArrayList<Player>();
	List<Item>		itemList	= new LinkedList<Item>();
	
	public Game() {
		
	}
	
	public void tick() {
		for (Item item : itemList) {
			item.tick();
		}
	}
	
	public int getNumPlayers() {
		return playerList.size();
	}
	
	public void addPlayer(Player player) {
		playerList.add(player);
	}
}
