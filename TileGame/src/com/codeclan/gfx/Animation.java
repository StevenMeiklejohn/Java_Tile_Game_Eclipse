package com.codeclan.gfx;

import java.awt.image.BufferedImage;

public class Animation {
	
	private int speed;
	private int index;
	private int timer;
	private int count;



	private BufferedImage[] frames;
	long lastTime;
	long loopTime1;
	long loopTime2;
	long totalLoopTime;
	int currentIndex;

	
	
	
	
	
	public Animation(int speed, BufferedImage[] frames){
		this.frames = frames;
		this.speed = speed;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
		loopTime1 = System.currentTimeMillis();
		totalLoopTime = 0;
		currentIndex = 0;
	}

	
	public void update(){
		count = 0;
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		loopTime1 = System.currentTimeMillis();
		
		
		if(timer > speed){
			index++;
			currentIndex++;
			currentIndex += 1;
			timer = 0;
			if(index >= frames.length){
				index = 0;
			}
		}
	}
	
	
	
	public BufferedImage getCurrentFrame(){
		return frames[index];
	}
	
	public long getTotalLoopTime(){
		return 00000000;
	}
	
	public int getCurrentIndex(){
		return currentIndex;
	}
	



}
