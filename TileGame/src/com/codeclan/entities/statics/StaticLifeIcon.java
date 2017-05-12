package com.codeclan.entities.statics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.codeclan.Handler;
import com.codeclan.gfx.Animation;
import com.codeclan.gfx.AnimationOnce;
import com.codeclan.gfx.Assets;
import com.codeclan.tilegame.tiles.Tile;

public class StaticLifeIcon extends StaticEntity {
	
public BufferedImage life;

	
	public StaticLifeIcon(Handler handler, float x, float y){
		super(handler, x, y, Tile.TILE_WIDTH * 18, Tile.TILE_HEIGHT);
// 		setup bounding box.	
//		bounding box co-ords relative to entity 0, 0.
		bounds.x = 0;
		bounds.y = 0;
//		size of bounding box inside player tile.
		bounds.width = 0;
		bounds.height = 0;
		life = Assets.lifeBar1;


		
	}


	
	
	
	@Override
	public void die(){
		System.out.println("explosion die method is triggered");
		handler.getWorld().getLifeManager().removeEntity(this);
	}
	
	



	@Override
	public void render(Graphics g) {
//		use casting to convert int variable to float (as defined by entity)
		g.drawImage(life, 
				(int) x, 
				(int) y, 32, 32, null);
//		g.setColor(Color.red);
//		g.fillRect((int) ((x +20) - handler.getGameCamera().getxOffset()), 
//				(int) ((y + 22) - handler.getGameCamera().getyOffset()),
//				bounds.width, bounds.height + 3);
	}
	
	
	public BufferedImage getCurrentAnimationFrame(){
		return anim.getCurrentFrame();
	}
	
	public BufferedImage getBufferedImage(){
		return this.life;
	}





	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
//	public int getRuns(){
//		return runs;
//	}

}

