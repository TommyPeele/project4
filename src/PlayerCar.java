import java.awt.Color;
import java.awt.Graphics2D;

public class PlayerCar extends Car{
	
	//TESTING NUMBERS, NOT FINAL
	public static final int DEFAULT_X = 280; //player car starts in center lane
	public static final int DEFAULT_Y = 310; //player car stays at bottom of screen as cars drive towards it
	
	public PlayerCar(GameScreen gameScreen){
		super(gameScreen, DEFAULT_X, DEFAULT_Y);
	}
	
	public PlayerCar(GameScreen gameScreen, int x, int y){
		super(gameScreen, x, y);
	}
	
	public void paint(Graphics2D graphic2D){
		graphic2D.setColor(Color.BLUE);
		graphic2D.fillRect(x, y, CAR_WIDTH, CAR_HEIGHT);
	}

}
