package code;
import java.awt.Color;
import java.awt.Graphics2D;

public class PoliceCar extends ObstacleCar{

	public PoliceCar(int x, int y){
		super(x, y);
	}

	@Override
	public void move(){
		if(y == 500){
			y = -2200;
			chooseLane();
		}
		else
			y = y + 10;
	}
	
	@Override
	public void setPaintColor(Graphics2D graphic2D){
		graphic2D.setColor(Color.BLUE.darker());
	}

}
