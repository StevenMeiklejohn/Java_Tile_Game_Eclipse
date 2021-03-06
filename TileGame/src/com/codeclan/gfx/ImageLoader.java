package com.codeclan.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
//	store images in bufferedImage objects

	public static BufferedImage loadImage(String path){
		try {
//			return buffered image object of loaded image
			return ImageIO.read(ImageLoader.class.getResourceAsStream(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			if image doesn't load, don't run game.
			System.exit(1);
		}
		return null;
	}
}
