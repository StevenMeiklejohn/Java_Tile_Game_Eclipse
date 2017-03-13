package com.codeclan.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.codeclan.Handler;
import com.codeclan.tilegame.Game;

public abstract class Entity {
	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;
	
	public Entity(Handler handler, float x, float y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.handler = handler;
//	Every entity initialised with a bounding (collision detection box) the same size as the entity.
		bounds = new Rectangle(0, 0, width, height);
	}
	
	
	public float getX() {
		return x;
	}


	public void setX(float x) {
		this.x = x;
	}


	public float getY() {
		return y;
	}


	public void setY(float y) {
		this.y = y;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public abstract void update();
	public abstract void render(Graphics g);
}
