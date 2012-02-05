package model;

import java.util.*;


public class Game {
	
	int numPlayers = getNumPlayers();
	List<Player> playerList = new ArrayList<Player>(numPlayers);
	
	public Game() {
		
	}
	
	public void tick() 
	{
		 for (Item item : itemSet) 
		 {
		   item.tick();
		 }
	}
	
	public int getNumPlayers()
	{
		return numPlayers;
	}
	
	public void addPlayer(Player player) {
		 playerList.add(player);
		}
}
