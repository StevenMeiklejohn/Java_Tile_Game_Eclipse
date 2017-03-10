package com.codeclan.state;

import java.awt.Graphics;

import com.codeclan.entities.creatures.Player;
import com.codeclan.gfx.Assets;
import com.codeclan.tilegame.Game;
import com.codeclan.tilegame.tiles.Tile;
import com.codeclan.tilegame.worlds.World;

public class GameState extends State{
	
	private Player player;
	private World world;
	
	public GameState(Game game){
		super(game);
		player = new Player(100, 100, game);
		world = new World("res2/worlds/world1.txt");
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
