package com.codeclan.entities.statics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.codeclan.Handler;
import com.codeclan.gfx.Animation;
import com.codeclan.gfx.Assets;
import com.codeclan.tilegame.tiles.Tile;

public class StaticAnimatedExplosion3 extends StaticEntity {
	
//	Animation
	private Animation anim;
	
	public StaticAnimatedExplosion3(Handler handler, float x, float y){
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
// 		setup bounding box.	
//		bounding box co-ords relative to entity 0, 0.
		bounds.x = 0;
		bounds.y = 0;
//		size of bounding box inside player tile.
		bounds.width = 0;
		bounds.height = 0;
		anim = new Animation(100, Assets.alt_explosion2_ani);
		
	}

	@Override
	public void update() {
//		Animation
		anim.update();
	}
	
	@Override
	public void die() {
		System.out.println("StaticAnimatedExplosion3 destroyed");
	}

	@Override
	public void render(Graphics g) {
//		use casting to convert int variable to float (as defined by entity)
		g.drawImage(getCurrentAnimationFrame(), 
				(int) (x - handler.getGameCamera().getxOffset()), 
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
//		g.setColor(Color.red);
//		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
//				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
//				bounds.width, bounds.height);
	}
	
	
	public BufferedImage getCurrentAnimationFrame(){
		return anim.getCurrentFrame();
	}

}
