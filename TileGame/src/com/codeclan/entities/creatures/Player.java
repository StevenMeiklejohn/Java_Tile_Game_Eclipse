package com.codeclan.entities.creatures;

import java.awt.Graphics;

import com.codeclan.Handler;
import com.codeclan.gfx.Assets;
import com.codeclan.tilegame.Game;

public class Player extends Creature {
	
	

	public Player(Handler handler, float x, float y) {
//		changing these defaults for numbers allows us to re-size the player object.
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	}

//	Updates all variables
	@Override
	public void update() {
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
//		use casting to convert int variable to float (as defined by entity)
		g.drawImage(Assets.player1, 
				(int) (x - handler.getGameCamera().getxOffset()), 
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}
	
	

}
