package com.codeclan.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import com.codeclan.Handler;
import com.codeclan.entities.creatures.AnimatedRock1;
import com.codeclan.entities.creatures.AnimatedRock2;
import com.codeclan.entities.creatures.Player;
import com.codeclan.entities.statics.StaticAnimatedExplosion1;
import com.codeclan.entities.statics.StaticAnimatedLaser1;

public class ExplosionManager {
	


	private StaticAnimatedExplosion1 explosion1;
	private ArrayList<Entity> entities;

	
//	import comparator (and associated methods) to allow us to sort the render order of entity array list.
	private Comparator<Entity> renderSorter = new Comparator<Entity>(){

		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
				return -1;
			return 1;
		}
		
	};
	
	public ExplosionManager(){

		entities = new ArrayList<Entity>();


	}
	
	public void update(){
		for (int i = 0; i < entities.size(); i++){
			Entity e = entities.get(i);
			System.out.println("Number of runs is " + e.getRuns());
			if(e.getRuns() > 30){
				entities.remove(e);
			}
			e.update();
		}
//			e.getTotalLoopTime();
	
		entities.sort(renderSorter);
	}
	
	
	public void render(Graphics g){
		System.out.println("explosion Manager render is triggered");
		for(Entity e : entities){
			e.render(g);
			if(!e.isActive())
				entities.remove(e);
		}
//		player.render(g);
	}
	
	public boolean getIsActive(){
		return this.getIsActive();
	}
	

	
	public void addEntity(Entity e){
		entities.add(e);
	}
	
	public void removeEntity(Entity e){
		entities.remove(e);
	}
	
	

	

}
