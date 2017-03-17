package com.codeclan.state;

import java.awt.Color;
import java.awt.Graphics;

import com.codeclan.Handler;
import com.codeclan.tilegame.Game;

public class MenuState extends State {
	
	public MenuState(Handler handler){
		super(handler);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(handler.getMouseMnager().isRighPressed())
			State.setState(handler.getGame().gameStates);
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.RED);
		g.fillRect(handler.getMouseMnager().getMouseX(), 
				handler.getMouseMnager().getMouseY(), 8, 8);
		
	}

		
}
