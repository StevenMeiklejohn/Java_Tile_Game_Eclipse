package com.codeclan.state;

import java.awt.Graphics;

import com.codeclan.Handler;
import com.codeclan.entities.creatures.Player;
import com.codeclan.entities.statics.Heart;
import com.codeclan.gfx.Assets;
import com.codeclan.gfx.GameCamera;
import com.codeclan.tilegame.Game;
import com.codeclan.tilegame.tiles.Tile;
import com.codeclan.tilegame.worlds.World;

public class GameState extends State{
	
	private Player player;
	private World world;
	private Heart heart;
	private GameCamera gameCamera;
	private Handler handler;

	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res2/worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler, 100, 100);
		heart = new Heart(handler, 120, 120);
		gameCamera = handler.getGameCamera();
		
	}

	@Override
	public void update() {
		world.update();
		player.update();
		heart.update();
	}

	@Override
	public void render(Graphics g) {
//		g.drawImage(Assets.player1, 0, 0, null);
		world.render(g);
		player.render(g);
		heart.render(g);

	}
}
