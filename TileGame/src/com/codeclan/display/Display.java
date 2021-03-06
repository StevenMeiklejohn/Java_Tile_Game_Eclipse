package com.codeclan.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	
//create a window to the screen.
	private JFrame frame;
//	JFrame requires width, height and title
	private String title;
	private int height;
	private int width;
	
//	create a canvas to go in the jframe and display graphics
	private Canvas canvas;
	
//	Display constructor
	public Display(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
//		Actual display is initialized in its own function.
		createDisplay();
		}
	
	public Canvas getCanvas(){
		return canvas;
	}
	
	public JFrame getJFrame(){
		return frame;
	}
	
	public void createDisplay(){
		frame = new JFrame(title);
		frame.setSize(width, height);
//		This line ensures that pressing the x on the window closes it.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		User cannot re-size the windoe by dragging.
		frame.setResizable(false);
//		When the window is created, it will appear in the middle of the screen instead of to the side.
		frame.setLocationRelativeTo(null);
//		By default, Jframes are set to invisible, we need to change this setting in order to see it.
		frame.setVisible(true);
		
//		create a new canvas
		canvas = new Canvas();
//		the canvas preferred size method takes a new Dimension object which in turn has the width and height
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
//		Makes the Jframe the only thing we 'focus' on. Allows us to use key listener.
		canvas.setFocusable(false);
		
//		add the canvas to the Jframe
		frame.add(canvas);
//		resize the jframe to allow us to see the canvas fully.
		frame.pack();
	}
}
