import java.awt.Color;
import java.awt.Graphics2D;

public class PoliceCar extends ObstacleCar{

	public PoliceCar(GameScreen gameScreen, int x, int y){
		super(gameScreen, x, y);
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
	public void paint(Graphics2D graphic2D){
		graphic2D.setColor(Color.BLUE.darker());
		graphic2D.fillRect(x, y, CAR_WIDTH, CAR_HEIGHT);
	}

}
