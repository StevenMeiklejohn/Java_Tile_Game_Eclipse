package com.codeclan.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 64, height = 64;
	
	public static BufferedImage player1, player2, player3, player4, blobLeft, blobRight, blueOrb, skyBlock,
	forestBlock, grassDirtBox, rock, waterBlock, cloudySky, heart;
	public static BufferedImage[] player_ani;
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/photonShipSpriteSheet.png"));
		SpriteSheet sheetBlobLeft = new SpriteSheet(ImageLoader.loadImage("/textures/blobLeft.png"));
		SpriteSheet sheetBlobRight = new SpriteSheet(ImageLoader.loadImage("/textures/blobRight.png"));
		SpriteSheet sheetBlueOrb = new SpriteSheet(ImageLoader.loadImage("/textures/blueOrb.png"));
		SpriteSheet sheetSkyBlock = new SpriteSheet(ImageLoader.loadImage("/textures/skyBlock.png"));
		SpriteSheet sheetForestBlock = new SpriteSheet(ImageLoader.loadImage("/textures/forestBlock.png"));
		SpriteSheet sheetGrassDirtBlock = new SpriteSheet(ImageLoader.loadImage("/textures/grassDirtBlock.png"));
		SpriteSheet sheetRock = new SpriteSheet(ImageLoader.loadImage("/textures/rock.png"));
		SpriteSheet sheetWaterBlock = new SpriteSheet(ImageLoader.loadImage("/textures/waterBlock.png"));
		SpriteSheet sheetCloudySkyBlock = new SpriteSheet(ImageLoader.loadImage("/textures/clouds_background.png"));
		SpriteSheet SheetHeart = new SpriteSheet(ImageLoader.loadImage("/textures/heart.png"));
		
		player1 = sheet.crop(0, 0, width, height);
		player2 = sheet.crop(width, 0, width, height);
		player3 = sheet.crop(width*2, 0, width, height);
		player4 = sheet.crop(width*3, 0, width, height);

		blobLeft = sheetBlobLeft.crop(0, 0, 32, 32);
		blobRight = sheetBlobRight.crop(0, 0, 32, 32);
		blueOrb = sheetBlueOrb.crop(0, 0, 32, 32);
		skyBlock = sheetSkyBlock.crop(0, 0, 32, 32);
		forestBlock = sheetForestBlock.crop(0, 0, 32, 32);
		grassDirtBox = sheetGrassDirtBlock.crop(0, 0, 32, 32);
		rock = sheetRock.crop(0, 0, 32, 32);
		waterBlock = sheetWaterBlock.crop(0, 0, 32, 32);
		cloudySky = sheetCloudySkyBlock.crop(0, 0, 470, 338);
		heart = SheetHeart.crop(0,  0,  32,  32);
		player_ani = new BufferedImage[4];
		
		player_ani[0] = player1;
		player_ani[1] = player2;
		player_ani[2] = player3;
		player_ani[3] = player4;
}

}
