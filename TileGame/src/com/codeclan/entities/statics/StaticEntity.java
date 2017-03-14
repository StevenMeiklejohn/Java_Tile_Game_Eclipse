package com.codeclan.entities.statics;

import com.codeclan.Handler;
import com.codeclan.entities.Entity;

// objects which don't change like trees and rocks.

public abstract class StaticEntity extends Entity {

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y , width, height);
	}

}
