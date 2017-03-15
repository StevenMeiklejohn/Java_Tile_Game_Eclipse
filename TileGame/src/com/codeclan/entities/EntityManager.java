package com.codeclan.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import com.codeclan.Handler;

import com.codeclan.entities.creatures.Player;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	
	public EntityManager(Handler handler, Player player){
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
	}
	
	public void update(){
		for (int i = 0; i < entities.size(); i++){
			Entity e = entities.get(i);
			e.update();
		}
//		Player is something of a special case and is not grouped with the rest of the entities.
		player.update();
	}
	
	
	public void render(Graphics g){
		for(Entity e : entities){
			e.render(g);
		}
		player.render(g);
	}
	
	
	
	public void addEntity(Entity e){
		entities.add(e);
	}
	
//	Getters/Setters

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}
	


	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
	

}
