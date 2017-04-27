package com.codeclan.tilegame.tiles;

import com.codeclan.gfx.Assets;

public class EdgeTileSolid extends Tile {
	
	public EdgeTileSolid(int id) {
		super(Assets.edge1, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
