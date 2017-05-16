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
	private StaticLifeIcon life2;
	private StaticLifeIcon life3;
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
	
	public LifeManager(Handler handler){
		this.handler = handler;
		

		entities = new ArrayList<Entity>();
//		life = new StaticLifeIcon(handler, 20, 20);
//		life2 = new StaticLifeIcon(handler, 50, 20);
//		life3 = new StaticLifeIcon(handler, 80, 20);
//		entities.add(life);
//		entities.add(life2);
//		entities.add(life3);

	}
	
	
	
	public void populate(float n){
		int x = 20;
		int y = 20;
		for( int i=0; i<n; i++){
			entities.add(new StaticLifeIcon(handler,x, y));
			x += 30;
		}
	}
	
	public void update(){
		entities.clear();
		float lives = handler.getWorld().getEntityManager().getPlayer().getLives();
		populate(lives);

		if(lives < 3){
			removeRandomEntity();
		}

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
	
	public void removeRandomEntity(){
		entities.remove(entities.size() - 1);
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



	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	

	
	

}
