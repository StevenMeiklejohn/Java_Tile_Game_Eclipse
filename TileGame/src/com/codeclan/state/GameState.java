package com.codeclan.state;

import java.awt.Graphics;

import com.codeclan.entities.creatures.Player;
import com.codeclan.gfx.Assets;
import com.codeclan.gfx.GameCamera;
import com.codeclan.tilegame.Game;
import com.codeclan.tilegame.tiles.Tile;
import com.codeclan.tilegame.worlds.World;

public class GameState extends State{
	
	private Player player;
	private World world;
	private GameCamera gameCamera;

	
	public GameState(Game game){
		super(game);
		player = new Player(game, 100, 100);
		world = new World(game, "res2/worlds/world1.txt");
		gameCamera = game.getGameCamera();
		
	}

	@Override
	public void update() {
		world.update();
		player.update();
	}

	@Override
	public void render(Graphics g) {
//		g.drawImage(Assets.player1, 0, 0, null);
		world.render(g);
		player.render(g);

	}
}
