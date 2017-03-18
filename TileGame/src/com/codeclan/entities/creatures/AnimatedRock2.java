package com.codeclan.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.codeclan.Handler;
import com.codeclan.gfx.Animation;
import com.codeclan.gfx.Assets;
import com.codeclan.tilegame.Game;

public class AnimatedRock2 extends Creature {
//	Animation
	private Animation anim;
	
	

	public AnimatedRock2(Handler handler, float x, float y) {
//		changing these defaults for numbers allows us to re-size the player object.
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
// 		setup bounding box.	
//		bounding box co-ords relative to entity 0, 0.
		bounds.x = 2;
		bounds.y = 5;
//		size of bounding box inside player tile.
		bounds.width = 58;
		bounds.height = 58;
		anim = new Animation(150, Assets.rock2_ani);
	}

//	Updates all variables
	@Override
	public void update() {
//		Animation
		anim.update();
//		Move
//		getInput();
		move();
//		handler.getGameCamera().centerOnEntity(this);
	}
	
//	private void getInput(){
//		xMove = 0;
//		yMove = 0;
//		if(handler.getKeyManager().up)
//			yMove = -speed;
//		if(handler.getKeyManager().down)
//			yMove = speed;
//		if(handler.getKeyManager().left)
//			xMove = -speed;
//		if(handler.getKeyManager().right)
//			xMove = speed;
//	}
	


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
	

	
	

}