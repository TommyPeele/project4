import java.awt.Color;
import java.awt.Graphics2D;

public class PoliceCar extends Car{
	
	private int lane;
	
	public PoliceCar(GameScreen gameScreen, int x, int y){
		super(gameScreen, x, y);
		chooseLane();
	}
	
	private void chooseLane(){
		lane = (int)(Math.random() * 3);
		switch(lane){
		case 0:
			x = 185;
			break;
		case 1:
			x = 285;
			break;
		case 2:
			x = 385;
			break;
		default:
			break;
		}
	}
	
	public void move(){
		if(y == 500){
			y = -2200;
			chooseLane();
		}
		else
			y = y + 10;
	}

	@Override
	public void paint(Graphics2D graphic2D){
		graphic2D.setColor(Color.BLUE.darker());
		graphic2D.fillRect(x, y, CAR_WIDTH, CAR_HEIGHT);
	}

}