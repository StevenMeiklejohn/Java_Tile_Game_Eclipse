package com.codeclan.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	
	private boolean[] keys;
	public boolean up, down, left ,right;
	public boolean fire, fire2, bomb, rock;
	
	public KeyManager(){
		keys = new boolean[256];
	}
	
	public void update(){
		up = keys[KeyEvent.VK_Q];
		down = keys[KeyEvent.VK_A];
		left = keys[KeyEvent.VK_O];
		right = keys[KeyEvent.VK_P];
		
		fire = keys[KeyEvent.VK_SPACE];
		fire2 = keys[KeyEvent.VK_M];
		bomb = keys[KeyEvent.VK_B];
//		rock = keys[KeyEvent.VK_R];
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
//		when key is pressed we populate the array with a true at the index
//		which corresponds to the id of the keyboard key (in this case 123).
//		keys[123] = true;
		keys[e.getKeyCode()] = true;
		System.out.println("Pressed:" + e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

}
