package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Timer;

import listeners.GameListener;
import model.entity.Entity;
import model.entity.TickableEntity;
import model.player.Player;

public class Game {
	List<Player>				playerList		= new ArrayList<Player>();
	List<Entity>				entityList		= new LinkedList<Entity>();
	
	public static final int		FPS				= 50;						// TODO think of a way to maximize this without hurting performance!
	public static final int		TIMESTEP_MILLIS	= 1000 / FPS;
	public static final double	TIMESTEP		= TIMESTEP_MILLIS / 1000.0;
	
	private GameListener		gameListener;
	private Timer				timer;
	
	public Game() {
		gameListener = new GameListener(this);
		timer = new Timer(TIMESTEP_MILLIS, gameListener);
		start();
	}
	
	public void tick() {
		for (Entity entity : entityList) {
			if (entity instanceof TickableEntity) {
				((TickableEntity) (entity)).tick();
			}
		}
	}
	
	public int getNumPlayers() {
		return playerList.size();
	}
	
	public void addPlayer(Player player) {
		playerList.add(player);
	}
	
	public void pause(int seconds) {
		pause();
		Timer pauseTimer = new Timer(TIMESTEP_MILLIS, gameListener);
		pauseTimer.start();
	}
	
	public void pause() {
		timer.stop();
	}
	
	public void start() {
		timer.start();
	}
	
	public Timer getTimer() {
		return timer;
	}
}
