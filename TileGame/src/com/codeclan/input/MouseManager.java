package com.codeclan.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {
	
	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
	
	public MouseManager(){
		
	}
	
//	getters
	public boolean isLeftPressed(){
		return leftPressed;
	}
	
	public boolean isRighPressed(){
		return rightPressed;
	}
	
	public int getMouseX(){
		return mouseX;
	}
	
	public int getMouseY(){
		return mouseY;
	}
	
//	implemented methods


	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
//		left mouse click
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = true;
//		right mouse click
		else if(e.getButton() == MouseEvent.BUTTON3)
			rightPressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		left mouse release
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = false;
//		right mouse release
		else if(e.getButton() == MouseEvent.BUTTON3)
			rightPressed = false;
	}
	
	
//	Methods below here are not currently required.
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
// 		TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
		
	}

}
