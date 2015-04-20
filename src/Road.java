import java.awt.Color;
import java.awt.Graphics2D;


public class Road{
	
	private GameScreen gameScreen;
	
	private final static int ROAD_WIDTH = 300;
	private final static int ROAD_HEIGHT = 400;
	
	public Road(GameScreen gameScreen){
		this.gameScreen = gameScreen;
	}
	
	public void paint(Graphics2D graphic2D){
		graphic2D.setColor(Color.BLACK);
		graphic2D.fillRect(150, 0, ROAD_WIDTH, ROAD_HEIGHT);
	}

}
