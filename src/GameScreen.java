import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScreen extends Screen{

	private Road road;
	private PlayerCar playerCar;
	
	private static final int DELAY = 100;
	
	private static final long serialVersionUID = 0;
	
	public GameScreen(Game game){
		super(game);
		setBackground(Color.GREEN.darker());
		
		road = new Road(this);
		playerCar = new PlayerCar(this);
		
		initiateListeners();
	}
	
	public void initiateListeners(){
		KeyListener listener = new KeyListener(){
			@Override
			public void keyTyped(KeyEvent event){
			}
			
			@Override
			public void keyReleased(KeyEvent event){
			}
			
			@Override
			public void keyPressed(KeyEvent event){
				playerCar.keyPressed(event);
			}
		};
		addKeyListener(listener);
		setFocusable(true);
	}
	
	@Override
	public void paint(Graphics graphic){
		super.paint(graphic);
		Graphics2D graphic2D = (Graphics2D) graphic;
		graphic2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		road.paint(graphic2D);
		playerCar.paint(graphic2D);
	}
	
	@Override
	public void run(){
		while(true){
			playerCar.move();
			
			repaint();
			
			try{
				Thread.sleep(DELAY);
			} catch(InterruptedException e){
				System.out.println("Interrupted: " + e.getMessage());
			}
		}
	}

}
