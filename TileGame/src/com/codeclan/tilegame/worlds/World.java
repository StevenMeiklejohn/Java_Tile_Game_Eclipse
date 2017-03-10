package com.codeclan.tilegame.worlds;

import java.awt.Graphics;

import com.codeclan.tilegame.tiles.Tile;
import com.codeclan.utils.Utils;

public class World {
	
	private int width;
	private int height;
	private int spawnX;
	private int spawnY;
	private int[][] tiles;
	
	public World(String path){
		loadWorld(path);
	
	}
	
	public void update(){
		
	}
	
	public void render(Graphics g){
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				getTile(x, y).render(g, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
			}
		}
		
	}
	
	public Tile getTile(int x, int y){
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.dirtTile;
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
		width = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
			for (int y = 0; y < height; y++){
				for(int x = 0; x < width; x++){
					tiles[x][y]= Utils.parseInt(tokens[(x + y * width) + 4]);
				}
			}
			
	}
}
