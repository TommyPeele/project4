import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;


public class PlayerCar extends Car{
	
	//TESTING NUMBERS, NOT FINAL
	public static int DEFAULT_X = 280; //player car starts in center lane
	public static int DEFAULT_Y = 310; //player car stays at bottom of screen as cars drive towards it
	
	private int lane = 1; //0 is left lane, 1 is center lane, 2 is right lane
	private int velocity = 0; //-1 is moving left, 0 is at rest, 1 is moving right
	private int moveCount = 0; //think of a better name
	
	public PlayerCar(GameScreen gameScreen){
		super(gameScreen, DEFAULT_X, DEFAULT_Y);
	}
	
	public PlayerCar(GameScreen gameScreen, int x, int y){
		super(gameScreen, x, y);
	}
	
	public void keyPressed(KeyEvent event){
		if(event.getKeyCode() == KeyEvent.VK_LEFT)
			if(lane > 0 && velocity == 0)
				velocity = -1;
		if(event.getKeyCode() == KeyEvent.VK_RIGHT)
			if(lane < 2 && velocity == 0)
				velocity = 1;
	}
	
	public void move(){
		switch(velocity){
		case -1:
			x = x - 10;
			moveCount++;
			if(moveCount == 10){
				lane--;
				velocity = 0;
				moveCount = 0;
			}
			break;
		case 1:
			x = x + 10;
			moveCount++;
			if(moveCount == 10){
				lane++;
				velocity = 0;
				moveCount = 0;
			}
			break;
		default:
			break;
		}
	}
	
	public boolean checkCollision(ObstacleCar obstacleCar){
		return getBounds().intersects(obstacleCar.getBounds());
	}
	
	public void paint(Graphics2D graphic2D){
		graphic2D.setColor(Color.BLUE);
		graphic2D.fillRect(x, y, CAR_WIDTH, CAR_HEIGHT);
	}
	
}
