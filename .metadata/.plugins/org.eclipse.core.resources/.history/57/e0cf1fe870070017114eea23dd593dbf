package com.codeclan.entities.creatures;

import com.codeclan.entities.Entity;
import com.codeclan.tilegame.Game;

public abstract class Creature extends Entity {
	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;
	
	protected int health;
	protected float speed;
	protected float xMove;
	protected float yMove;

	public Creature(Game game, Float x, Float y, int width, int height) {
		super(game, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		
	}
	
	public void move(){
		x += xMove;
		y += yMove;
	}
	
	
	
//	GETTERS/SETTERS

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
