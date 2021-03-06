package com.codeclan.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.codeclan.ui.UIManager;

public class MouseManager implements MouseListener, MouseMotionListener {
	
	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
	private UIManager uiManager;
	
	public MouseManager(){
		
	}
	
//	getters
	
	public void setUIManager(UIManager uiManager){
		this.uiManager = uiManager;
	}
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
	
	public void setRightPressed(boolean rightPressed) {
		this.rightPressed = rightPressed;
	}

	public UIManager getUiManager() {
		return uiManager;
	}

	public void setUiManager(UIManager uiManager) {
		this.uiManager = uiManager;
	}

	public void setLeftPressed(boolean leftPressed) {
		this.leftPressed = leftPressed;
	}

	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}

	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}
	
	public boolean isRightPressed() {
		return rightPressed;
	}
	
//	implemented methods


	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		if(uiManager != null)
			uiManager.onMouseMove(e);
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
			
		if(uiManager != null)
			uiManager.onMouseRelease(e);
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
