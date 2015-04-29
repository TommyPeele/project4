package code.screens;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;

import code.Dirt;
import code.Game;
import code.Notification;
import code.Road;
import code.TextEntry;
import code.cars.ObstacleCar;
import code.cars.PlayerCar;
import code.cars.PoliceCar;

public class GameScreen extends Screen{

	private int playerScore = 0;
	private int timerValue = 500;
	private int notificationDelay;
	Random random = new Random();
	private Road road;
	private PlayerCar playerCar;
	private ArrayList<ObstacleCar> obstacleCars;
	private TextEntry textEntry;
	private Notification notification;

	private JLabel score;
	private PoliceCar policeCar;

	private ArrayList<Dirt> dirtBlocks;

	private static final int DELAY = 100;

	private static final long serialVersionUID = 0;

	private static final int gameOverCollision = 0;
	private static final int gameOverDetection = 1;
	private static final int gameOverTimer = 2;
	private boolean running = true;

	private boolean firstRend = false;
	private boolean printNotification = true;

	public GameScreen(Game game){
		super(game);
		setBackground(Color.GREEN.darker());
		setFocusable(true);

		road = new Road();

		dirtBlocks = new ArrayList<Dirt>();
		dirtBlocks.add(new Dirt(50, 300));
		dirtBlocks.add(new Dirt(20, 240));
		dirtBlocks.add(new Dirt(35, 110));
		dirtBlocks.add(new Dirt(90, 50));
		dirtBlocks.add(new Dirt(75, 0));

		dirtBlocks.add(new Dirt(500, 380));
		dirtBlocks.add(new Dirt(530, 240));
		dirtBlocks.add(new Dirt(480, 110));
		dirtBlocks.add(new Dirt(570, 10));

		playerCar = new PlayerCar();
		obstacleCars = new ArrayList<ObstacleCar>();

		obstacleCars.add(new ObstacleCar(185, -400));
		obstacleCars.add(new ObstacleCar(285, -700));
		obstacleCars.add(new ObstacleCar(385, -1000));
		obstacleCars.add(new ObstacleCar(185, -900));
		obstacleCars.add(new ObstacleCar(285, -500));

		policeCar = new PoliceCar(180, -800);

		textEntry = new TextEntry(this);
		textEntry.chooseTextMessage(); //Choose the first message
		
		notification = new Notification(this);

		initiateListeners();
	}

	public void initiateListeners(){
		KeyListener listener = new KeyListener(){

			@Override
			public void keyTyped(KeyEvent event){
				textEntry.keyTyped(event);
			}

			@Override
			public void keyReleased(KeyEvent event){}

			@Override
			public void keyPressed(KeyEvent event){
				if(event.getKeyCode() == KeyEvent.VK_LEFT || event.getKeyCode() == KeyEvent.VK_RIGHT)
					playerCar.keyPressed(event);
				else if (printNotification)
					textEntry.keyPressed(event);
			}
		};

		addKeyListener(listener);
		requestFocusInWindow();
		setFocusable(true);
	}

	public void gameOver(int state){
		running = false;

		game.getContentPane().removeAll();
		game.setCurrentScreen(new GameOverScreen(game, state, playerScore));
		game.getContentPane().add(game.getCurrentScreen());
		game.getContentPane().validate();

		System.out.println("Game Over");
	}

	public int getScore(){
		return playerScore;
	}

	public void paintInitialTextEntry(Graphics graphic){
		super.paint(graphic);
		Graphics2D graphic2D = (Graphics2D) graphic;
		graphic2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		textEntry.paint(graphic2D);
		textEntry.setVisible(false);
	}

	@Override
	public void paint(Graphics graphic){
		super.paint(graphic);
		Graphics2D graphic2D = (Graphics2D) graphic;
		graphic2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if(!textEntry.isVisible() && !firstRend){
			textEntry.paint(graphic2D);
			firstRend = true;
		}

		road.paint(graphic2D);

		for(Dirt eachDirtBlock : dirtBlocks)
			eachDirtBlock.paint(graphic2D);

		playerCar.paint(graphic2D);
		policeCar.paint(graphic2D);
		for(ObstacleCar eachObstacleCar : obstacleCars)
			eachObstacleCar.paint(graphic2D);
		
		if (printNotification)
			notification.paint(graphic2D);
		else if (notificationDelay == 0)
			printNotification = true;
		else
			notificationDelay--;
			

		graphic.setFont(new Font("Serif", Font.BOLD, 20));
		graphic.drawString("Score: "+ String.valueOf(getScore()), 500, 40); 

		graphic.drawString("Timer: "+ String.valueOf(timerValue), 25, 375);

		//Only paint if the user has opened the texting window
		if(textEntry.isVisible())
			textEntry.paint(graphic2D);
	}

	public void timerIncrease(){
		timerValue += 100;
	}

	@Override
	public void run(){
		while(running){
			playerScore++;
			timerValue--;
			playerCar.move();
			policeCar.move();

			for(Dirt eachDirtBlock : dirtBlocks)
				eachDirtBlock.move();

			if(playerCar.checkCollision(policeCar))
				gameOver(gameOverCollision);

			if(playerCar.checkPoliceDetection(policeCar, textEntry))
				gameOver(gameOverDetection);

			if(timerValue == 0)
				gameOver(gameOverTimer);

			for(ObstacleCar eachObstacleCar : obstacleCars){
				eachObstacleCar.move();
				if(playerCar.checkCollision(eachObstacleCar))
					gameOver(gameOverCollision);
			}
			repaint();

			try{
				Thread.sleep(DELAY);
			} catch(InterruptedException e){
				System.out.println("Interrupted: " + e.getMessage());
			}
		}
	}

	public void newMessageDelay() {
		printNotification = false;
		notificationDelay = (random.nextInt(40) + 20);
	}

}

