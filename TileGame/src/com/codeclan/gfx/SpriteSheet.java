package com.codeclan.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet){
		this.sheet = sheet;
		
	}
	
	public BufferedImage crop(int x, int y, int width, int height){
		return sheet.getSubimage(x, y, width, height);
	}
	
	public Graphics getBufferedImage(){
		return sheet.getGraphics();
	}

}
