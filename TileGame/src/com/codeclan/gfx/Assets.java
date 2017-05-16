package com.codeclan.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Assets {
	
	private static final int width = 64, height = 64;
	
	public static BufferedImage player1, player2, player3, player4, 
	explosion1, explosion2, explosion3, explosion4, explosion5, 
	ex_alt_1, ex_alt_2, ex_alt_3, ex_alt_4, ex_alt_5, ex_alt_6, ex_alt_7, 
	ex2_alt_1, ex2_alt_2, ex2_alt_3, ex2_alt_4, ex2_alt_5, ex2_alt_6, ex2_alt_7, ex2_alt_8,
	space1, space2,edge1,
	rock1, rock2, rock3, rock4,
	bRock1, bRock2, bRock3, bRock4, bRock5, bRock6, bRock7,
	laserA_1, laserA_2, laserA_3, laserA_4, laserA_5, laserA_6, laserA_7, laserA_8, laserA_9, 
	laserA_10, laserA_11, laserA_12, laserA_13, laserA_14, laserA_15, laserA_16, laserA_17, laserA_18, 
	laserA_19, laserA_20, laserA_21, laserA_22, laserA_23, laserA_24, laserA_25, laserA_26, laserA_27, 
	laserA_28, laserA_29, laserA_30,
	laserB_1, laserB_2, laserB_3, laserB_4, laserB_5, laserB_6, laserB_7, laserB_8, laserB_9,
	laserB_10, laserB_11, laserB_12,
	title1, startButton1, startButton2, startButton3,
	lifeBar1,
	backdrop1, backdrop2, backdrop3;

	public static BufferedImage[] player_ani, explosion_ani, rock1_ani, 
	alt_explosion1_ani, alt_explosion2_ani, laser1_ani, laser2_ani,
	start_buttons, titles_array, rock2_ani;
	



	
	public static void init(){
//		player
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/photonShipSpriteSheet.png"));
////		collectable
//		SpriteSheet SheetHeart = new SpriteSheet(ImageLoader.loadImage("/textures/heart.png"));
//		SpriteSheet sheetCoin = new SpriteSheet(ImageLoader.loadImage("/textures/coin.png"));
////		aliens
		SpriteSheet sheetTitle = new SpriteSheet(ImageLoader.loadImage("/textures/spaceBastards.png"));
		SpriteSheet sheetButton = new SpriteSheet(ImageLoader.loadImage("/textures/startButtonCrop.png"));
		SpriteSheet sheetBackdrop1 = new SpriteSheet(ImageLoader.loadImage("/textures/background1.jpg"));
		SpriteSheet sheetBackdrop2 = new SpriteSheet(ImageLoader.loadImage("/textures/background2.png"));
		SpriteSheet sheetBackdrop3 = new SpriteSheet(ImageLoader.loadImage("/textures/background3.jpg"));
		
		SpriteSheet sheetExplosion1 = new SpriteSheet(ImageLoader.loadImage("/textures/explosion_01.png"));
		SpriteSheet sheetExplosion2 = new SpriteSheet(ImageLoader.loadImage("/textures/explosion_02.png"));
		SpriteSheet sheetExplosion3 = new SpriteSheet(ImageLoader.loadImage("/textures/explosion_03.png"));
		SpriteSheet sheetExplosion4 = new SpriteSheet(ImageLoader.loadImage("/textures/explosion_04.png"));
		SpriteSheet sheetExplosion5 = new SpriteSheet(ImageLoader.loadImage("/textures/explosion_05.png"));
		SpriteSheet sheetExplosionAlt1 = new SpriteSheet(ImageLoader.loadImage("/textures/explosion-1.png"));
		SpriteSheet sheetExplosionAlt2 = new SpriteSheet(ImageLoader.loadImage("/textures/explosion-6.png"));
		SpriteSheet sheetLaser1 = new SpriteSheet(ImageLoader.loadImage("/textures/laserSpriteSheet.png"));
		SpriteSheet sheetLaser2 = new SpriteSheet(ImageLoader.loadImage("/textures/giantLaserSpriteSheet.png"));

		SpriteSheet sheetSpace1 = new SpriteSheet(ImageLoader.loadImage("/textures/Space1.png"));
		SpriteSheet sheetSpace2 = new SpriteSheet(ImageLoader.loadImage("/textures/Space2.png"));
		SpriteSheet sheetRocks = new SpriteSheet(ImageLoader.loadImage("/textures/myRockSheet2.png"));
		SpriteSheet sheetRocks2 = new SpriteSheet(ImageLoader.loadImage("/textures/spinning_rock_spriteSheet.png"));
		SpriteSheet sheetEdge1 = new SpriteSheet(ImageLoader.loadImage("/textures/edgeTile.png"));
		SpriteSheet sheetLife1 = new SpriteSheet(ImageLoader.loadImage("/textures/life_orb_trans.png"));
		
		
		start_buttons = new BufferedImage[2];
		startButton1 = sheetButton.crop(0, 0, 115, 64);
		startButton2 = sheetButton.crop(115, 0, 115, 64);
//		startButton3 = sheetButton.crop(230, 0, 344, 64);
		start_buttons[0] = startButton1;
		start_buttons[1] = startButton2;
////		start_buttons[2] = startButton3;
//		
		titles_array = new BufferedImage[1];
		title1 = sheetTitle.crop(0, 0, 538, 189);
		titles_array[0] = title1;
//		titles_array[1] = title1;
//		titles_array[2] = title1;

		player_ani = new BufferedImage[4];

		player1 = sheet.crop(0, 0, width, height);
		player2 = sheet.crop(width, 0, width, height);
		player3 = sheet.crop(width*2, 0, width, height);
		player4 = sheet.crop(width*3, 0, width, height);
		
		
		player_ani[0] = player1;
		player_ani[1] = player2;
		player_ani[2] = player3;
		player_ani[3] = player4;
		
		
		rock1_ani = new BufferedImage[4];
		
		rock1 = sheetRocks.crop(0, 0, width, height);
		rock2 = sheetRocks.crop(64, 0, width, height);
		rock3 = sheetRocks.crop(128, 0, width, height);
		rock4 = sheetRocks.crop(192, 0, width, height);
		
		rock1_ani[0] = rock1;
		rock1_ani[1] = rock2;
		rock1_ani[2] = rock3;
		rock1_ani[3] = rock4;
		
		
		rock2_ani = new BufferedImage[7];
		
		bRock1 = sheetRocks2.crop(0, 0, 98, 117);
		bRock2 = sheetRocks2.crop(98, 0, 94, 117);
		bRock3 = sheetRocks2.crop(192, 0, 82, 117);
		bRock4 = sheetRocks2.crop(369, 0, 98, 117);
		bRock5 = sheetRocks2.crop(468, 0, 96, 117);
		bRock6 = sheetRocks2.crop(564, 0, 82, 117);
		bRock7 = sheetRocks2.crop(646, 0, 94, 117);
		
		rock2_ani[0] = bRock1;
		rock2_ani[1] = bRock2;
		rock2_ani[2] = bRock3;
		rock2_ani[3] = bRock4;
		rock2_ani[4] = bRock5;
		rock2_ani[5] = bRock6;
		rock2_ani[6] = bRock7;
		
		
		alt_explosion1_ani = new BufferedImage[7];
		
		ex_alt_1 = sheetExplosionAlt1.crop(0, 0,32, 32);
		ex_alt_2 = sheetExplosionAlt1.crop(32, 0,32, 32);
		ex_alt_3 = sheetExplosionAlt1.crop(64, 0,32, 32);
		ex_alt_4 = sheetExplosionAlt1.crop(96, 0,32, 32);
		ex_alt_5 = sheetExplosionAlt1.crop(128, 0,32, 32);
		ex_alt_6 = sheetExplosionAlt1.crop(160, 0,32, 32);
		ex_alt_7 = sheetExplosionAlt1.crop(192, 0,32, 32);
		
		alt_explosion1_ani[0] = ex_alt_1;
		alt_explosion1_ani[1] = ex_alt_2;
		alt_explosion1_ani[2] = ex_alt_3;
		alt_explosion1_ani[3] = ex_alt_4;
		alt_explosion1_ani[4] = ex_alt_5;
		alt_explosion1_ani[5] = ex_alt_6;
		alt_explosion1_ani[6] = ex_alt_7;
		
		
		alt_explosion2_ani = new BufferedImage[8];
		
		ex2_alt_1 = sheetExplosionAlt2.crop(0, 0,48, 48);
		ex2_alt_2 = sheetExplosionAlt2.crop(48, 0,48, 48);
		ex2_alt_3 = sheetExplosionAlt2.crop(96, 0,48, 48);
		ex2_alt_4 = sheetExplosionAlt2.crop(144, 0,48, 48);
		ex2_alt_5 = sheetExplosionAlt2.crop(192, 0,48, 48);
		ex2_alt_6 = sheetExplosionAlt2.crop(240, 0,48, 48);
		ex2_alt_7 = sheetExplosionAlt2.crop(288, 0,48, 48);
		ex2_alt_8 = sheetExplosionAlt2.crop(336, 0,48, 48);
		
		alt_explosion2_ani[0] = ex2_alt_1;
		alt_explosion2_ani[1] = ex2_alt_2;
		alt_explosion2_ani[2] = ex2_alt_3;
		alt_explosion2_ani[3] = ex2_alt_4;
		alt_explosion2_ani[4] = ex2_alt_5;
		alt_explosion2_ani[5] = ex2_alt_6;
		alt_explosion2_ani[6] = ex2_alt_7;
		alt_explosion2_ani[7] = ex2_alt_8;
		
		
		explosion_ani = new BufferedImage[5];
		
		explosion1 = sheetExplosion1.crop(0, 0,32, 32);
		explosion2 = sheetExplosion2.crop(0, 0,32, 32);
		explosion3 = sheetExplosion3.crop(0, 0,32, 32);
		explosion4 = sheetExplosion4.crop(0, 0,32, 32);
		explosion5 = sheetExplosion5.crop(0, 0,32, 32);
		
		explosion_ani[0] = explosion1;
		explosion_ani[1] = explosion2;
		explosion_ani[2] = explosion3;
		explosion_ani[3] = explosion4;
		explosion_ani[4] = explosion5;
		
//		heart = SheetHeart.crop(0,  0,  32,  32);
//		coin = sheetCoin.crop(0, 0, 32, 32);
		
		
		laser1_ani = new BufferedImage[30];
		
		laserA_1 = sheetLaser1.crop(0, 0,500, 32);
		laserA_2 = sheetLaser1.crop(500, 0,500, 32);
		laserA_3 = sheetLaser1.crop(1000, 0,500, 32);
		laserA_4 = sheetLaser1.crop(1500, 0,500, 32);
		laserA_5 = sheetLaser1.crop(2000, 0,500, 32);
		laserA_6 = sheetLaser1.crop(2500, 0,500, 32);
		laserA_7 = sheetLaser1.crop(3000, 0,500, 32);
		laserA_8 = sheetLaser1.crop(3500, 0,500, 32);
		laserA_9 = sheetLaser1.crop(4000, 0,500, 32);
		laserA_10 = sheetLaser1.crop(4500, 0,500, 32);
		laserA_11 = sheetLaser1.crop(5000, 0,500, 32);
		laserA_12 = sheetLaser1.crop(5500, 0,500, 32);
		laserA_13 = sheetLaser1.crop(6000, 0,500, 32);
		laserA_14 = sheetLaser1.crop(6500, 0,500, 32);
		laserA_15 = sheetLaser1.crop(7000, 0,500, 32);
		laserA_16 = sheetLaser1.crop(7500, 0,500, 32);
		laserA_17 = sheetLaser1.crop(8000, 0,500, 32);
		laserA_18 = sheetLaser1.crop(8500, 0,500, 32);
		laserA_19 = sheetLaser1.crop(9000, 0,500, 32);
		laserA_20 = sheetLaser1.crop(9500, 0,500, 32);
		laserA_21 = sheetLaser1.crop(10000, 0,500, 32);
		laserA_22 = sheetLaser1.crop(10500, 0,500, 32);
		laserA_23 = sheetLaser1.crop(11000, 0,500, 32);
		laserA_24 = sheetLaser1.crop(11500, 0,500, 32);
		laserA_25 = sheetLaser1.crop(12000, 0,500, 32);
		laserA_26 = sheetLaser1.crop(12500, 0,500, 32);
		laserA_27 = sheetLaser1.crop(13000, 0,500, 32);
		laserA_28 = sheetLaser1.crop(13500, 0,500, 32);
		laserA_29 = sheetLaser1.crop(14000, 0,500, 32);
		laserA_30 = sheetLaser1.crop(14500, 0,500, 32);
		

		
		laser1_ani[0] = laserA_1;
		laser1_ani[1] = laserA_2;
		laser1_ani[2] = laserA_3;
		laser1_ani[3] = laserA_4;
		laser1_ani[4] = laserA_5;
		laser1_ani[5] = laserA_6;
		laser1_ani[6] = laserA_7;
		laser1_ani[7] = laserA_8;
		laser1_ani[8] = laserA_9;
		laser1_ani[9] = laserA_10;
		laser1_ani[10] = laserA_11;
		laser1_ani[11] = laserA_12;
		laser1_ani[12] = laserA_13;
		laser1_ani[13] = laserA_14;
		laser1_ani[14] = laserA_15;
		laser1_ani[15] = laserA_16;
		laser1_ani[16] = laserA_17;
		laser1_ani[17] = laserA_18;
		laser1_ani[18] = laserA_19;
		laser1_ani[19] = laserA_20;
		laser1_ani[20] = laserA_21;
		laser1_ani[21] = laserA_22;
		laser1_ani[22] = laserA_23;
		laser1_ani[23] = laserA_24;
		laser1_ani[24] = laserA_25;
		laser1_ani[25] = laserA_26;
		laser1_ani[26] = laserA_27;
		laser1_ani[27] = laserA_28;
		laser1_ani[28] = laserA_29;
		laser1_ani[29] = laserA_30;
		
		
		
		
		laser2_ani = new BufferedImage[12];
		
		laserB_1 = sheetLaser2.crop(0, 0,318, 145);
		laserB_2 = sheetLaser2.crop(318, 0,318, 145);
		laserB_3 = sheetLaser2.crop(636, 0,318, 145);
		laserB_4 = sheetLaser2.crop(954, 0,318, 145);
		laserB_5 = sheetLaser2.crop(1272, 0,318, 145);
		laserB_6 = sheetLaser2.crop(1590, 0,318, 145);
		laserB_7 = sheetLaser2.crop(1908, 0,318, 145);
		laserB_8 = sheetLaser2.crop(2226, 0,318, 145);
		laserB_9 = sheetLaser2.crop(2544, 0,318, 145);
		laserB_10 = sheetLaser2.crop(2862, 0,318, 145);
		laserB_11 = sheetLaser2.crop(3180, 0,318, 145);
		laserB_12 = sheetLaser2.crop(3470, 0,318, 145);
		
		laser2_ani[0] = laserB_1;
		laser2_ani[1] = laserB_2;
		laser2_ani[2] = laserB_3;
		laser2_ani[3] = laserB_4;
		laser2_ani[4] = laserB_5;
		laser2_ani[5] = laserB_6;
		laser2_ani[6] = laserB_7;
		laser2_ani[7] = laserB_8;
		laser2_ani[8] = laserB_9;
		laser2_ani[9] = laserB_10;
		laser2_ani[10] = laserB_11;
		laser2_ani[11] = laserB_12;


		
	
		
		space1 = sheetSpace1.crop(0, 0, 64, 64);
		space2 = sheetSpace2.crop(0, 0, 64, 64);
		
		edge1 = sheetEdge1.crop(0, 0, 64, 64);
		lifeBar1 = sheetLife1.crop(0,  0,  64,  64);
		
		backdrop1 = sheetBackdrop1.crop(0, 0, 490, 590);
		backdrop2 = sheetBackdrop2.crop(0, 0, 500, 355);
		backdrop3 = sheetBackdrop3.crop(0, 0, 500, 570);
		
		

		






}
	
	

}
