import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JLabel;

public class GameScreen extends Screen{

	private int playerScore;
	
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
	
	private boolean running = true;
	
	private boolean firstRend = false;
	
	public GameScreen(Game game){
		super(game);
		setBackground(Color.GREEN.darker());
		
		setFocusable(true);
		
		
		road = new Road(this);
		
		dirtBlocks = new ArrayList<Dirt>();
		dirtBlocks.add(new Dirt(this, 50, 300));
		dirtBlocks.add(new Dirt(this, 20, 240));
		dirtBlocks.add(new Dirt(this, 35, 110));
		dirtBlocks.add(new Dirt(this, 90, 50));
		dirtBlocks.add(new Dirt(this, 75, 0));
		
		dirtBlocks.add(new Dirt(this, 500, 380));
		dirtBlocks.add(new Dirt(this, 530, 240));
		dirtBlocks.add(new Dirt(this, 480, 110));
		dirtBlocks.add(new Dirt(this, 570, 10));
		
		score = new JLabel("Score: 0");
		score.setBounds(550, 10, 40, 20);
		
		playerCar = new PlayerCar(this);
		obstacleCars = new ArrayList<ObstacleCar>();
		
		obstacleCars.add(new ObstacleCar(this, 185, -100));
		obstacleCars.add(new ObstacleCar(this, 285, -400));
		obstacleCars.add(new ObstacleCar(this, 385, -700));
		obstacleCars.add(new ObstacleCar(this, 185, -600));
		obstacleCars.add(new ObstacleCar(this, 285, -200));
		
		policeCar = new PoliceCar(this, 180, -500);
		
		
		add(score);
		
		textEntry = new TextEntry(this);
			//Choose the first message
		textEntry.chooseTextMessage();
		//paintInitialTextEntry(Graphic );
		
		
		notification = new Notification(this);
		
		System.out.println("Before Init");
		
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
				else
					textEntry.keyPressed(event);
			}
		};
		
		System.out.println("Before add");
		addKeyListener(listener);
		requestFocusInWindow();
		setFocusable(true);
	}
	
	public void gameOver(){
		
		running = false;
		
		game.getContentPane().removeAll();
    	game.currentScreen = new GameOverScreen(game);
    	game.getContentPane().add(game.currentScreen);
    	game.getContentPane().validate();
		
		System.out.println("Game Over");
	}
	
	public int getScore(){
		return playerScore;
	}
	
	public void paintInitialTextEntry(Graphics graphic)
	{
		super.paint(graphic);
		Graphics2D graphic2D = (Graphics2D) graphic;
		graphic2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		textEntry.paint(graphic2D);
		textEntry.setVisFalse();
	}
	
	@Override
	public void paint(Graphics graphic){
		
		//score.setText("Score: " + String.valueOf(getScore()));
		super.paint(graphic);
		Graphics2D graphic2D = (Graphics2D) graphic;
		graphic2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		
		if(!textEntry.isVisible() && !firstRend)
		{
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
		
		notification.paint(graphic2D);
		
		//Only paint if the user has opened the texting window
		if(textEntry.isVisible())
			textEntry.paint(graphic2D);
		
		
	}
	
	@Override
	public void run(){

		while(running){
			playerScore++;
			playerCar.move();
			policeCar.move();

			for(Dirt eachDirtBlock : dirtBlocks)
				eachDirtBlock.move();
			
			if(playerCar.checkPoliceCollision(policeCar))
				gameOver();
			
			if(playerCar.checkPoliceDetection(policeCar, textEntry))
				gameOver();
			
			for(ObstacleCar eachObstacleCar : obstacleCars){
				eachObstacleCar.move();
				if(playerCar.checkCollision(eachObstacleCar))
					gameOver();
			}
			repaint();
			
			try{
				Thread.sleep(DELAY);
			} catch(InterruptedException e){
				System.out.println("Interrupted: " + e.getMessage());
			}
		}
	}

}
