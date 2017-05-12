package com.codeclan.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import com.codeclan.Handler;
import com.codeclan.entities.creatures.AnimatedRock1;
import com.codeclan.entities.creatures.AnimatedRock2;
import com.codeclan.entities.creatures.Creature;
import com.codeclan.entities.creatures.Player;
import com.codeclan.entities.statics.StaticAnimatedLaser1;
import com.codeclan.entities.statics.StaticLifeIcon;

public class LifeManager {
	
	private Handler handler;
	private ArrayList<Entity> entities;
	private Player player;
	private StaticLifeIcon life;
	private int count;
	
//	import comparator (and associated methods) to allow us to sort the render oredr of entity array list.
	private Comparator<Entity> renderSorter = new Comparator<Entity>(){

		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
				return -1;
			return 1;
		}
		
	};
	
	public LifeManager(Handler handler, Player player, StaticLifeIcon life){
		this.handler = handler;
		this.player = player;
		this.life = life;
		entities = new ArrayList<Entity>();
		entities.add(life);
	}
	
	public void update(){
		for (int i = 0; i < entities.size(); i++){
			Entity e = entities.get(i);
			System.out.println("Number of lives is " + entities.size());

			e.update();
		}
		entities.sort(renderSorter);
	}
	
	
	public void render(Graphics g){
		for(Entity e : entities){
			e.render(g);
			if(!e.isActive())
				entities.remove(e);
		}
//		player.render(g);
	}
	

	
	public void addEntity(Entity e){
		entities.add(e);
	}
	
	public void removeEntity(Entity e){
		entities.remove(e);
	}
	
	
	public void addCreature(Creature c){
		entities.add(c);
	}
	
	public void removeCreature(Creature c){
		entities.remove(c);
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
	
//	public AnimatedRock1 getAnimatedRock1(){
//		return animatedRock1;
//	}
//	
//	public AnimatedRock2 getAnimatedRock2(){
//		return animatedRock2;
//	}
//	
//	public StaticAnimatedLaser1 getAnimatedLaser(){
//		return laser;
//	}
	

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
