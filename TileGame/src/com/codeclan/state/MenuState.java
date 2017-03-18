package com.codeclan.state;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.codeclan.Handler;
import com.codeclan.gfx.Assets;
import com.codeclan.tilegame.Game;
import com.codeclan.ui.ClickListener;
import com.codeclan.ui.UIImageButton;
import com.codeclan.ui.UIManager;
import com.codeclan.ui.UITitleScreen;

public class MenuState extends State {
	
	private UIManager uiManager;
	
	public MenuState(final Handler handler){
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseMnager().setUIManager(uiManager);
		uiManager.addObject(new UITitleScreen(0, 0, 640, 640, Assets.backdrop3));
		uiManager.addObject(new UITitleScreen(50, 100, 538, 139, Assets.title1));
		uiManager.addObject(new UIImageButton(270, 350, 115, 64, Assets.start_buttons, new ClickListener(){

//			Create a ClickListener class on the fly(from interface).
			@Override
			public void onClick() {
				handler.getMouseMnager().setUIManager(null);
				State.setState(handler.getGame().gameStates);
			}}));
	}

	@Override
	public void update() {
		uiManager.update();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

		
}
