package com.codeclan.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import com.codeclan.Handler;
import com.codeclan.entities.creatures.AnimatedRock1;
import com.codeclan.entities.creatures.AnimatedRock2;
import com.codeclan.entities.creatures.Creature;
import com.codeclan.entities.creatures.Player;
import com.codeclan.entities.statics.StaticAnimatedExplosion1;
import com.codeclan.entities.statics.StaticAnimatedExplosion2;
import com.codeclan.entities.statics.StaticAnimatedExplosion3;
import com.codeclan.entities.statics.StaticAnimatedLaser1;

public class RockManager {
	

	private AnimatedRock1 rock1;
	private AnimatedRock2 rock2;
	
	
	private ArrayList<Creature> creatures;

	
//	import comparator (and associated methods) to allow us to sort the render oredr of entity array list.
	private Comparator<Creature> renderSorter = new Comparator<Creature>(){

		@Override
		public int compare(Creature a, Creature b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
				return -1;
			return 1;
		}
		
	};
	
	public RockManager(){

		creatures = new ArrayList<Creature>();


	}
	
	public void update(){
		for (int i = 0; i < creatures.size(); i++){
			Creature c = creatures.get(i);
//			System.out.println("Number of runs is " + e.getRuns());
//			if(e.getRuns() > 30){
//				entities.remove(e);
//			}
			c.update();
		}
		creatures.sort(renderSorter);
	}
	
	
	public void render(Graphics g){
		System.out.println("Rock Manager render is triggered");
		for(Creature c : creatures){
			c.render(g);
//			if(c.x < 0 || c.x > 660 || c.y < 0 || c.y > 660)
//				c.die();
		}
	}
	
	
	
	public boolean getIsActive(){
		return this.getIsActive();
	}
	

	
	public void addCreature(Creature c){

		creatures.add(c);

	}
	
	public void removeCreature(Creature c){
		creatures.remove(c);
	}
	
	public ArrayList<Creature> getCreatures() {
		return creatures;
	}

	public int size() {
		// TODO Auto-generated method stub
		return creatures.size();
	}
	

	
	

	

}
