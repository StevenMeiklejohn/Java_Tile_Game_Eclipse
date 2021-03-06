package com.codeclan.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.codeclan.Handler;
import com.codeclan.entities.statics.StaticAnimatedExplosion1;
import com.codeclan.gfx.Animation;
import com.codeclan.gfx.AnimationOnce;
import com.codeclan.gfx.Assets;
import com.codeclan.tilegame.Game;
import com.codeclan.tilegame.tiles.Tile;

public class AnimatedLaser1 extends Creature {
//	Animation
	private int runs;
	protected long loopTime;
	private AnimationOnce anim;
	StaticAnimatedExplosion1 exp;
	
	

	public AnimatedLaser1(Handler handler, float x, float y) {
//		changing these defaults for numbers allows us to re-size the player object.
		super(handler, x, y, Tile.TILE_WIDTH * 18, Tile.TILE_HEIGHT);
// 		setup bounding box.	
//		bounding box co-ords relative to entity 0, 0.
		bounds.x = 0;
		bounds.y = 0;
//		size of bounding box inside laser tile.
		bounds.width = 640;
		bounds.height = 19;
		anim = new AnimationOnce(50, Assets.laser1_ani);
		loopTime = 0;
		runs = 0;
		health = 10;
	}

	@Override
	public void update() {
//		Animation
			anim.update();
			runs += 1;
	}
	
	public StaticAnimatedExplosion1 generateExplosion(float x, float y){
		 exp = new StaticAnimatedExplosion1(handler, x, y);
			return exp;
		}
	
	@Override
	public void die(){
		System.out.println("AnimatedLaser1 collision detected. die() called.");
//		handler.getWorld().getExplosionManager().addEntity(generateExplosion(this.x, this.y));
//		handler.getWorld().getRockManager().removeCreature(this);
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
	
	
//	this method would be modified (perhaps with if statements)
//	if our player used different animations for different input
//	i.e. direction of travel or firing.
	public BufferedImage getCurrentAnimationFrame(){
		return anim.getCurrentFrame();
		
//		if(cMove < 0){
//			return animLeft.getCurrentAnimationFrame();
//		}else if{
//			(xMove > 0){
//				return animRight.getCurrentAnimationFrame();
//			}else if{
//				(yMove < 0){
//					return animUp.getCurrentAnimationFrame();
//				}else if{
//					yMove > 0){
//						animDown.getCurrentAnimationFrame();
//					}
//				}
//			}
//		}
	}
	
	public int getRuns(){
		return runs;
	}
	

	
	

}
