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
	//Foliage detail
	private ArrayList<Dirt> dirtBlocks;
	
	private static final int DELAY = 100;
	
	private static final long serialVersionUID = 0;
	
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
		
		obstacleCars.add(new ObstacleCar(this, 180, -100));
		obstacleCars.add(new ObstacleCar(this, 280, -200));
		obstacleCars.add(new ObstacleCar(this, 380, -300));
		
		
		add(score);
		
		textEntry = new TextEntry(this);
			//Choose the first message
		textEntry.chooseTextMessage();
		
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
		System.out.println("Game Over");
	}
	
	public int getScore(){
		return playerScore;
	}
	
	@Override
	public void paint(Graphics graphic){
		
		//score.setText("Score: " + String.valueOf(getScore()));
		super.paint(graphic);
		Graphics2D graphic2D = (Graphics2D) graphic;
		graphic2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		
		road.paint(graphic2D);
		
		for(Dirt eachDirtBlock : dirtBlocks)
			eachDirtBlock.paint(graphic2D);
		
		playerCar.paint(graphic2D);
		for(ObstacleCar eachObstacleCar : obstacleCars)
			eachObstacleCar.paint(graphic2D);
		
		notification.paint(graphic2D);
		
		//Only paint if the user has opened the texting window
		if(textEntry.isVisible())
			textEntry.paint(graphic2D);
		
		
	}
	
	@Override
	public void run(){
		while(true){
			playerCar.move();
			playerScore++;
			for(Dirt eachDirtBlock : dirtBlocks)
				eachDirtBlock.move();
			
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
