package com.codeclan;

import com.codeclan.tilegame.Game;

public class Launcher {
	
	public static void main(String[] args){
	
//		temporary code to test display constructor is working.
//		new Display("TileGame", 300, 300);
		
		Game game = new Game("Tile Game", 736, 640);
		game.start();
		
	}

}
