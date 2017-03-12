package com.codeclan.entities.creatures;

import java.awt.Graphics;

import com.codeclan.gfx.Assets;
import com.codeclan.tilegame.Game;

public class Player extends Creature {
	
	

	public Player(Game game, float x, float y) {
//		changing these defaults for numbers allows us to re-size the player object.
		super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	}

//	Updates all variables
	@Override
	public void update() {
		getInput();
		move();
		game.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		if(game.getKeyManager().up)
			yMove = -speed;
		if(game.getKeyManager().down)
			yMove = speed;
		if(game.getKeyManager().left)
			xMove = -speed;
		if(game.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
//		use casting to convert int variable to float (as defined by entity)
		g.drawImage(Assets.player1, 
				(int) (x - game.getGameCamera().getxOffset()), 
				(int) (y - game.getGameCamera().getyOffset()), width, height, null);
		
	}
	
	

}
