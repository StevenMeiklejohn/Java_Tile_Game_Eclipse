package com.codeclan.gfx;

import java.awt.image.BufferedImage;

public class Animation {
	
	private int speed;
	private int index;
	private int timer;


	private BufferedImage[] frames;
	long lastTime;
	long loopTime1;
	long loopTime2;
	
	
	
	
	public Animation(int speed, BufferedImage[] frames){
		this.frames = frames;
		this.speed = speed;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
		loopTime1 = System.currentTimeMillis();
	}

	
	public void update(){
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		loopTime1 = System.currentTimeMillis();
		
		if(timer > speed){
			index++;
			timer = 0;
			if(index >= frames.length){
				index = 0;
				loopTime2 = System.currentTimeMillis();
			}
		}
	}
	
	
	
	public BufferedImage getCurrentFrame(){
		return frames[index];
	}
	
	public int getLoopTime(){
		return (int)loopTime2 - (int)loopTime1 / 1000000;
	}
	



}
