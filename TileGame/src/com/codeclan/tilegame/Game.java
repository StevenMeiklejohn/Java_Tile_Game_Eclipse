package com.codeclan.tilegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.codeclan.display.Display;
import com.codeclan.gfx.Assets;
import com.codeclan.input.KeyManager;
import com.codeclan.state.GameState;
import com.codeclan.state.MenuState;
import com.codeclan.state.SettingsState;
import com.codeclan.state.State;

//notes. A thread is effectively a mini program within a program.
//We use the main program to create the window, canvas, etc and the thread
//handles our game inside its own mini programme. We can run a class seperately from the main programme.
//implements runnable, allows the class to run on a thread.

public class Game implements Runnable {
	
	
//	#####################################
//	#####################################
//	DECLARATIONS
//	#####################################
//	#####################################
	
	
	private Display display;
	public String title;
	public int width;
	public int height;
	
	private Thread thread;
	
	private boolean running = false;
	
//	BufferStrategy tells the computer how to draw things to the screen.
//	Using memory buffers prevents the game flickering as it would if we were to draw directly to the screen.
	private BufferStrategy bs;
	private Graphics g;
	
//	private BufferedImage testImage;
//	
//	private SpriteSheet sheet;
	
//	states
	private State gameStates;
	private State menuState;
	private State settingsState;
	
	
	
	
//	inputs
	private KeyManager keyManager;
	
	
//	#####################################	
//	#####################################
//	CONSTRUCTOR
//	#####################################
//	#####################################
	
	
	public Game(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
		
	}
	
//	#####################################	
//	#####################################
//	INIT
//	#####################################
//	#####################################
	
//	The run method runs init once.
//	It sets up the graphics and other assets of our game.
	private void init(){
		display = new Display(title, width, height);
//		Get the Jframe associated with the display and implement a key listener
		display.getJFrame().addKeyListener(keyManager);
		Assets.init();
//		testImage = ImageLoader.loadImage("/textures/photonShipSpriteSheet.png");
//		sheet = new SpriteSheet(testImage);
		
		
//		because GameState extends State, we can declare gameStates as a State then initialize it as a GameState(below)
		gameStates = new GameState(this);
		menuState = new MenuState(this);
		settingsState = new SettingsState(this);
		State.setState(gameStates);
		
	}
	
//	#####################################	
//	#####################################
//	UPDATE
//	#####################################
//	#####################################
	
	
//	int x = 0;
	
//	Create update method for game loop.
	private void update(){
//		get updates from the key manager.
		keyManager.update();
//		check and update state
		if(State.getState() != null)
			State.getState().update();
		
//		x += 1;
	}
	
	
//	#####################################	
//	#####################################
//	RENDER
//	#####################################
//	#####################################
	
	

//	Game loop notes. Finding the frames per second is necessary to accommodate different speeds
//	of computer so that the game plays in the same way on any computer.
	
//	Create render method for game loop.
	private void render(){
//		get how many buffers our strategy is going to use.
		bs = display.getCanvas().getBufferStrategy();
//		Check buffer strategy exists, and if not create one.
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
//		create paintbrush.
		g = bs.getDrawGraphics();
//		clear the screen
		g.clearRect(0, 0, width, height);
//		draw here
//		g.fillRect(0, 0, width, height);
//		end drawing
//		g.drawRect(10, 50, 50, 70);
//		g.setColor(Color.red);
//		g.fillRect(10, 50, 50, 70);
//		g.setColor(Color.green);
//		g.fillRect(0, 0, 10, 10);
		
//		Image observer is null.
//		g.drawImage(sheet.crop(64, 0, 64, 64), 5, 5, null);
		
		if(State.getState() != null)
			State.getState().render(g);
		
//		g.drawImage(Assets.player1, x, 0, null);
//		g.drawImage(Assets.player2, 100, 0, null);
//		g.drawImage(Assets.player3, 200, 0, null);
//		g.drawImage(Assets.player4, 300, 0, null);
		
//		draw to the canvas
		bs.show();
//		properly dispose of paint brush.
		g.dispose();
		
	}
	
	
	
	
	
//	#####################################	
//	#####################################
//	RUN
//	#####################################
//	#####################################
	
	
//	All classes which implement runnable must implement a run() method.
//	thread.start() initiates this method.
	public void run(){
		
		init();
		
//		We want to measure time in the computer as nanoseconds. There are a billion in a second.
//		Hence the timePerUpdate equation which calculates the maximum time
//		for an update so that we can achieve our targeted 60 fps.
		int fps = 60;
		double timePerUpdate = 1000000000 / fps;
		double delta = 0;
		long now;
//		get current time from computer
		long lastTime = System.nanoTime();
		long timer = 0;
		int updates = 0;
		
		
//		Create the game loop. Update variables, positions of objects, states.
//		Render/redraw to the screen. Repeat.
		
		while(running){
			now = System.nanoTime();
//			delta essentially represents how much time we have before we need to call
//			update and render again.
			delta += (now - lastTime) / timePerUpdate;
			timer += now - lastTime;
			lastTime = now;
			
//			If delta has accumulated to >= 1, we run render/update then subtract 1 from the delta.
			if(delta >= 1){
			update();
			render();
			delta --;
			updates ++;
			}
			if(timer >= 1000000000){
				System.out.println("Updates and frames: " + updates);
				updates = 0;
				timer = 0;
			}
			}
		stop();
		}
		
	
	
//	synchronized is used when starting or stopping a thread to ensure nothing gets messed up.
	

	
//	#####################################	
//	#####################################
//	GET KEY MANAGER
//	#####################################
//	Allows player access to keymanager
//	#####################################
	
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
//	#####################################	
//	#####################################
//	START
//	#####################################
//	#####################################
	
	public synchronized void start(){
//		Ensure game is not already running.
		if(running){
			return;
		}
//		Set running boolean to true
		running = true;
//		run thread by passing in Game class (which implements runnable)
		thread = new Thread(this);
//		kicks off run method.
		thread.start();
	}
	
	
	
	
	
//	#####################################	
//	#####################################
//	STOP
//	#####################################
//	#####################################	
	
	
//	Properly close down the thread.
	public synchronized void stop(){
//		Ensure game is not already stopped.
		if(!running){
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
