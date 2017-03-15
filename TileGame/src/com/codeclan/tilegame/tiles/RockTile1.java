package com.codeclan.tilegame.tiles;

import com.codeclan.gfx.Assets;

public class RockTile1 extends Tile {
	
	
		public RockTile1(int id) {
			super(Assets.rock1, id);

		}
		
		@Override
		public boolean isSolid(){
			return true;
		}

}