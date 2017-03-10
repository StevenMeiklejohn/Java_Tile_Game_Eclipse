package com.codeclan.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
//	Static stuff here
	
	public static Tile[] tiles = new Tile[256];
	public static Tile forestTile = new ForestTile(0);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile rockTile = new RockTile(2);
	public static Tile skyTile = new SkyTile(3);
	public static Tile cloudySky = new CloudySkyTile(4);
	
	
	
	
//	CLASS
	
	public static final int TILE_WIDTH = 32, TILE_HEIGHT = 32;
	protected BufferedImage texture;
//	tile id should never change.
	protected final int id;

		public Tile(BufferedImage texture, int id){
			this.texture = texture;
			this.id = id;
//	When constructing the tile we position it in our tiles array at the index position of its unique id.		
			tiles[id] = this;
		}
		
		public void update(){
			
		}
		
		public void render(Graphics g, int x, int y){
			g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
		}
		
		public boolean isSolid(){
			return false;
		}
		
		public int getId(){
			return this.id;
		}
}
