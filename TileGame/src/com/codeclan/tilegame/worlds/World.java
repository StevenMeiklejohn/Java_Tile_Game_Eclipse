package com.codeclan.tilegame.worlds;

import java.awt.Graphics;

import com.codeclan.gfx.GameCamera;
import com.codeclan.tilegame.Game;
import com.codeclan.tilegame.tiles.Tile;
import com.codeclan.utils.Utils;

public class World {
	private Game game;
	private int width;
	private int height;
	private int spawnX;
	private int spawnY;
	private int[][] tiles;
//	private GameCamera gameCamera;
	
	public World(Game game, String path){
		this.game = game;
		loadWorld(path);
	}
	
	public void update(){
		
	}
	
	public void render(Graphics g){
//		make the render more efficient by limiting the computer to only render tiles within the current camera view.
//		Ensure xStart is greater than 0 by using Math.max. So if the game.getGameCamera.getOffset number is greater than 0, it will be selected.
//		To demonstrate in action add +1 to the end of TILE_WIDTH
		int xStart = (int) Math.max(0, game.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width, (game.getGameCamera().getxOffset() + game.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, game.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(height, (game.getGameCamera().getyOffset() + game.getHeight()) / Tile.TILE_HEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y++){
			for(int x = xStart;  x < xEnd; x++){
				getTile(x, y).render(g, 
						(int) (x * Tile.TILE_WIDTH - game.getGameCamera().getxOffset()), 
						(int) (y * Tile.TILE_HEIGHT - game.getGameCamera().getyOffset()));
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
}
