package code.cars;
import java.awt.Color;
import java.awt.Graphics2D;

public class ObstacleCar extends Car{

	public ObstacleCar(int x, int y){
		super(x, y);
		chooseLane();
	}

	protected void chooseLane(){
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
			y = -300;
			chooseLane();
		}
		else
			y = y + 10;
	}
	
	@Override
	public void setPaintColor(Graphics2D graphic2D){
		graphic2D.setColor(Color.RED);
	}

}
