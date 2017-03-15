package com.codeclan.entities.statics;

import java.awt.Graphics;

import com.codeclan.Handler;
import com.codeclan.gfx.Assets;
import com.codeclan.tilegame.tiles.Tile;

public class Rock1 extends StaticEntity {
	
	public Rock1(Handler handler, float x, float y){
//		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		super(handler, x, y, 32, 32);
		bounds.x = 0;
		bounds.y = 0;
//		Used if asset bounding box is <= height of two tiles.
//		bounds.y = (int) (height / 1,5f);
		bounds.width = 100;
		bounds.height = 100;
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.rock1, (int) (x - handler.getGameCamera().getxOffset()), 
				(int) (y - handler.getGameCamera().getyOffset()), null);
		
	}

}
