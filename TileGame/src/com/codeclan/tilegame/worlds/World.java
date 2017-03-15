package com.codeclan.tilegame.worlds;

import java.awt.Graphics;

import com.codeclan.Handler;
import com.codeclan.entities.EntityManager;
import com.codeclan.entities.creatures.AnimatedRock1;
import com.codeclan.entities.creatures.Player;
import com.codeclan.entities.statics.StaticAnimatedExplosion1;
//import com.codeclan.entities.statics.Heart;
//import com.codeclan.entities.statics.Rock1;
//import com.codeclan.gfx.GameCamera;
//import com.codeclan.tilegame.Game;
import com.codeclan.tilegame.tiles.Tile;
import com.codeclan.utils.Utils;

public class World {
	private Handler handler;
	private int width;
	private int height;
	private int spawnX;
	private int spawnY;
	private int[][] tiles;
//	private GameCamera gameCamera;
	
//	Entities
	private EntityManager entityManager;
	
	public World(Handler handler, String path){
		this.handler = handler;
		Player player = new Player(handler, 100, 100);
		AnimatedRock1 animatedRock1 = new AnimatedRock1(handler, 300, 300);


		entityManager = new EntityManager(handler, player, animatedRock1);

//		entity manager should be above loadWorld
		loadWorld(path);
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setX(spawnY);
//		static entities(non moving elements, like trees/rock) are instantiated here.
		entityManager.getAnimatedRock1().setX(300);
		entityManager.getAnimatedRock1().setY(300);
		entityManager.addEntity(new StaticAnimatedExplosion1(handler, 250, 250));

	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void update(){
		entityManager.update();
	}
	
	public void render(Graphics g){
//		make the render more efficient by limiting the computer to only render tiles within the current camera view.
//		Ensure xStart is greater than 0 by using Math.max. So if the game.getGameCamera.getOffset number is greater than 0, it will be selected.
//		To demonstrate in action add +1 to the end of TILE_WIDTH
		int xStart = (int) Math.max(0,handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y++){
			for(int x = xStart;  x < xEnd; x++){
				getTile(x, y).render(g, 
						(int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), 
						(int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
//		Render entities
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y){
//		prevent crash if player is outside the map boundary by applying a forest tile.
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.space1;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.space2;
		else
		return t;
	}
	
	private void loadWorld(String path){
//		width = 5;
//		height = 5;
//		tiles = new int[width][height];
//		
//		for(int x = 0; x < width; x++){
//			for(int y = 0; y < height; y++){
//				tiles[x][y] = 0;
//			}
//		}
		
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
			for (int y = 0; y < height; y++){
				for(int x = 0; x < width; x++){
					tiles[x][y]= Utils.parseInt(tokens[(x + y * width) + 4]);
				}
			}
			
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public int getHeight(){
		return this.height;
	}
}
