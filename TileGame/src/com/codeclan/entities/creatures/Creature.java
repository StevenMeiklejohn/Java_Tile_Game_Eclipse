package com.codeclan.entities.creatures;

import com.codeclan.Handler;
import com.codeclan.entities.Entity;
import com.codeclan.tilegame.Game;
import com.codeclan.tilegame.tiles.Tile;

public abstract class Creature extends Entity {
	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;
	
	protected int health;
	protected float speed; 
	protected float xMove;
	protected float yMove;

	public Creature(Handler handler, Float x, Float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		
	}
	
	public void move(){
		if(!checkEntityCollisions(xMove, 0f))
		moveX();
		if(!checkEntityCollisions(0f, yMove))
		moveY();
	}
	
//	######################################
//	######################################
//	collision detection
//	######################################
//	######################################
	
	public void moveX(){
//		moving right
		if(xMove > 0){
//			get the position of tile we are trying to move into.
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
//			collision.
//			if no solid tile at x position and upper right of bounding box.
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) && 
//			if no solid tile at x position and lower right of bounding box.					
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)){
				x += xMove;
			}else{
				x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
			}
			
//		moving left			
		}else if(xMove < 0){
//			get the position of tile we are trying to move into.
			int tx = (int) (x - xMove - bounds.x) / Tile.TILE_WIDTH;
//			collision.
//			if no solid tile at x position and upper left of bounding box.
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) && 
//			if no solid tile at x position and upper right of bounding box.					
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)){
			
			x += xMove;
			}else{
				x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
			}
		}
	}
	
	
	
	public void moveY(){
//		move up
		if(yMove < 0){
//			get the position of tile we are trying to move into.
			int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;
//			collision.
//			if no solid tile at x position and right hand side top
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) && 
					!collisionWithTile((int) (x + bounds.x + bounds.height) / Tile.TILE_HEIGHT, ty)){
				y += yMove;	
			}else{
				y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y;
			}
			
//		move down
		}else if(yMove > 0){
//			get the position of tile we are trying to move into.
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_WIDTH;
//			collision.
//			if no solid tile at x position and left hand side top corner
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) && 
					!collisionWithTile((int) (x + bounds.x + bounds.height) / Tile.TILE_HEIGHT, ty)){
				y += yMove;
			}else{
				y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1;
			}
			
		}
		}
			
	protected Boolean collisionWithTile(int x, int y){
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	
	
//	GETTERS/SETTERS
//	###################
//	###################

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public static int getDefaultHealth() {
		return DEFAULT_HEALTH;
	}

	public static float getDefaultSpeed() {
		return DEFAULT_SPEED;
	}
	
//	update and render methods are not defined here since this is an abstract class.
	
	

}
