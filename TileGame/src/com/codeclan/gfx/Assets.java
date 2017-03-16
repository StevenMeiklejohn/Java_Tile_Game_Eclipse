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
	alien1, alien2, alien3, alien4, alien5, alien6, alien7, battleship,
	coin, heart, game_won, planet1, planet2, planet3, ship1, ship2, ship3, ship4, ship5,
	shotBlue, shotGreen, shotRed, space1, space2, rock1, rock2, rock3, rock4;
	public static BufferedImage[] player_ani, explosion_ani, rock1_ani, alt_explosion1_ani, alt_explosion2_ani;
	



	
	public static void init(){
//		player
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/photonShipSpriteSheet.png"));
////		collectable
//		SpriteSheet SheetHeart = new SpriteSheet(ImageLoader.loadImage("/textures/heart.png"));
//		SpriteSheet sheetCoin = new SpriteSheet(ImageLoader.loadImage("/textures/coin.png"));
////		aliens
//		SpriteSheet sheetAlien1 = new SpriteSheet(ImageLoader.loadImage("/textures/Alien1.png"));
//		SpriteSheet sheetAlien2 = new SpriteSheet(ImageLoader.loadImage("/textures/Alien2.png"));
//		SpriteSheet sheetAlien3 = new SpriteSheet(ImageLoader.loadImage("/textures/Alien3.png"));
//		SpriteSheet sheetAlien4 = new SpriteSheet(ImageLoader.loadImage("/textures/Alien4.png"));
//		SpriteSheet sheetAlien5 = new SpriteSheet(ImageLoader.loadImage("/textures/Alien5.png"));
//		SpriteSheet sheetAlien6 = new SpriteSheet(ImageLoader.loadImage("/textures/Alien6.png"));
//		SpriteSheet sheetAlien7 = new SpriteSheet(ImageLoader.loadImage("/textures/Alien7.png"));
////		battleship
//		SpriteSheet sheetBattleship = new SpriteSheet(ImageLoader.loadImage("/textures/Battleship.png"));
////		explosion
		SpriteSheet sheetExplosion1 = new SpriteSheet(ImageLoader.loadImage("/textures/explosion_01.png"));
		SpriteSheet sheetExplosion2 = new SpriteSheet(ImageLoader.loadImage("/textures/explosion_02.png"));
		SpriteSheet sheetExplosion3 = new SpriteSheet(ImageLoader.loadImage("/textures/explosion_03.png"));
		SpriteSheet sheetExplosion4 = new SpriteSheet(ImageLoader.loadImage("/textures/explosion_04.png"));
		SpriteSheet sheetExplosion5 = new SpriteSheet(ImageLoader.loadImage("/textures/explosion_05.png"));
		SpriteSheet sheetExplosionAlt1 = new SpriteSheet(ImageLoader.loadImage("/textures/explosion-1.png"));
		SpriteSheet sheetExplosionAlt2 = new SpriteSheet(ImageLoader.loadImage("/textures/explosion-6.png"));
////		game won
//		SpriteSheet sheetGameWon = new SpriteSheet(ImageLoader.loadImage("/textures/game_won_illustration.png"));
////		planets
		SpriteSheet sheetPlanet1 = new SpriteSheet(ImageLoader.loadImage("/textures/Planet1.png"));
//		SpriteSheet sheetPlanet2 = new SpriteSheet(ImageLoader.loadImage("/textures/Planet2.png"));
//		SpriteSheet sheetPlanet3 = new SpriteSheet(ImageLoader.loadImage("/textures/Planet3.png"));
////		ships
//		SpriteSheet sheetShip1 = new SpriteSheet(ImageLoader.loadImage("/textures/Ship1.png"));
//		SpriteSheet sheetShip2 = new SpriteSheet(ImageLoader.loadImage("/textures/Ship2.png"));
//		SpriteSheet sheetShip3 = new SpriteSheet(ImageLoader.loadImage("/textures/Ship3.png"));
//		SpriteSheet sheetShip4 = new SpriteSheet(ImageLoader.loadImage("/textures/Ship4.png"));
//		SpriteSheet sheetShip5 = new SpriteSheet(ImageLoader.loadImage("/textures/Ship5.png"));
////		bullets
//		SpriteSheet sheetShotBlue = new SpriteSheet(ImageLoader.loadImage("/textures/ShotBlue.png"));
//		SpriteSheet sheetShotGreen = new SpriteSheet(ImageLoader.loadImage("/textures/ShotGreen.png"));
//		SpriteSheet sheetShotRed = new SpriteSheet(ImageLoader.loadImage("/textures/ShotRed.png"));
//		backgrounds
		SpriteSheet sheetSpace1 = new SpriteSheet(ImageLoader.loadImage("/textures/Space1.png"));
		SpriteSheet sheetSpace2 = new SpriteSheet(ImageLoader.loadImage("/textures/Space2.png"));
		SpriteSheet sheetRocks = new SpriteSheet(ImageLoader.loadImage("/textures/myRockSheet2.png"));

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
		
		

		
//		

//		alien2 = sheetAlien2.crop(0, 0, 64, 64);
//		alien3 = sheetAlien3.crop(0, 0, 64, 64);
//		alien4 = sheetAlien4.crop(0, 0, 64, 64);
//		alien5 = sheetAlien5.crop(0, 0, 64, 64);
//		alien6 = sheetAlien6.crop(0, 0, 64, 64);
//		alien7 = sheetAlien7.crop(0, 0, 64, 64);
//		
//		battleship = sheetBattleship.crop(0, 0, 480, 240);
//		
//		planet1 = sheetPlanet1.crop(0, 0, 64, 64);
//		planet2 = sheetPlanet2.crop(0, 0, 256, 256);
//		planet3 = sheetPlanet3.crop(0, 0, 256, 256);
//		
//		game_won = sheetGameWon.crop(0,  0,  480,  480);
//		ship1 = sheetShip1.crop(0, 0, 64, 64);
//		ship2 = sheetShip2.crop(0, 0, 64, 64);
//		ship3 = sheetShip3.crop(0, 0, 64, 64);
//		ship4 = sheetShip4.crop(0, 0, 64, 64);
//		ship5 = sheetShip5.crop(0, 0, 64, 64);
//		
//		
//		shotBlue = sheetShotBlue.crop(0, 0, 32, 32);
//		shotGreen = sheetShotGreen.crop(0, 0, 32, 32);
//		shotRed = sheetShotRed.crop(0, 0, 32, 32);
		
		space1 = sheetSpace1.crop(0, 0, 64, 64);
		space2 = sheetSpace2.crop(0, 0, 64, 64);
		
		

		






}
	
	

}
