package com.codeclan.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UITitleScreen extends UIObject {
	
	private BufferedImage images;


	public UITitleScreen(float x, float y, int width, int height, BufferedImage images) {
		super(x, y, width, height);
		this.images = images;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(images, (int) x,(int) y, width, height, null);

	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		
	}



}
