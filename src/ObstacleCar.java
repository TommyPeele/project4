import java.awt.Color;
import java.awt.Graphics2D;

public class ObstacleCar extends Car{
	
	private int lane;
	
	public ObstacleCar(GameScreen gameScreen, int x, int y){
		super(gameScreen, x, y);
		chooseLane();
	}
	
	private void chooseLane(){
		lane = (int)(Math.random() * 3);
		switch(lane){
		case 0:
			x = 180;
			break;
		case 1:
			x = 280;
			break;
		case 2:
			x = 380;
			break;
		default:
			break;
		}
	}
	
	public void move(){
		if(y == 500){
			y = -300;
			chooseLane();
		}
		else
			y = y + 10;
	}

	@Override
	public void paint(Graphics2D graphic2D){
		graphic2D.setColor(Color.RED);
		graphic2D.fillRect(x, y, CAR_WIDTH, CAR_HEIGHT);
	}

}
