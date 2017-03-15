package com.codeclan.entities.statics;

import java.awt.Graphics;

import com.codeclan.Handler;
import com.codeclan.gfx.Assets;
import com.codeclan.tilegame.tiles.Tile;

public class Heart extends StaticEntity {
	
	public Heart(Handler handler, float x, float y){
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		bounds.x = 10;
		bounds.y = 10;
//		Used if asset bounding box is <= height of two tiles.
//		bounds.y = (int) (height / 1,5f);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.heart, (int) (x - handler.getGameCamera().getxOffset()), 
				(int) (y - handler.getGameCamera().getyOffset()), null);
		
	}

}