package com.codeclan;

import com.codeclan.gfx.GameCamera;
import com.codeclan.input.KeyManager;
import com.codeclan.tilegame.Game;
import com.codeclan.tilegame.worlds.World;

// Handler will allow us to pass around one object. An object which has access to the game, world, camera, key manager etc.

public class Handler {
	
	private Game game;
	private World world;
	
	public Handler(Game game){
		this.game = game;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}

}
