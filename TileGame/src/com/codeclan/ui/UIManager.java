package com.codeclan.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.codeclan.Handler;

public class UIManager {
	
	private Handler handler;
	private ArrayList<UIObject> objects;
	
	public UIManager(Handler handler){
		this.handler = handler;
		objects = new ArrayList<UIObject>();
	}
	
	public void update(){
		for(UIObject object : objects)
			object.update();
	}
	
	public void render(Graphics g){
		for(UIObject object : objects)
			object.render(g);
	}
	
	public void onMouseMove(MouseEvent e){
		for(UIObject object : objects)
			object.onMouseMove(e);
	}
	
	public void onMouseRelease(MouseEvent e){
		for(UIObject object : objects)
			object.onMouseRelease(e);
	}
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<UIObject> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<UIObject> objects) {
		this.objects = objects;
	}

	public void addObject(UIObject object){
		objects.add(object);
	}
	
	public void removeObject(UIObject object){
		objects.remove(object);
	}

}
