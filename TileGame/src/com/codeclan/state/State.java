package com.codeclan.state;

import java.awt.Graphics;

import com.codeclan.tilegame.Game;

//Creating a simple game state manager.

public abstract class State {
	
	private static State currentState = null;
	
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
	
	
//	CLASS
	
	protected Game game;
	
	public State(Game game){
		game = this.game;
	}
	
	public abstract void update();
	
//	paint brush.
	public abstract void render(Graphics g);
	
	

}
