import java.awt.Color;
import java.awt.Graphics2D;

public class ObstacleCar extends Car{
	
	public ObstacleCar(GameScreen gameScreen, int x, int y){
		super(gameScreen, x, y);
	}

	@Override
	public void paint(Graphics2D graphic2D){
		graphic2D.setColor(Color.RED);
		graphic2D.fillRect(x, y, CAR_WIDTH, CAR_HEIGHT);
	}

}
