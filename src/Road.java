import java.awt.Color;
import java.awt.Graphics2D;

public class Road{
	
	private GameScreen gameScreen;
	
	private final static int ROAD_WIDTH = 300;
	private final static int ROAD_HEIGHT = 400;
	
	private int stripY = -300;
	
	public Road(GameScreen gameScreen){
		this.gameScreen = gameScreen;
	}
	
	public void moveStrips(){
			if(stripY >= 0)
				stripY = -300;
			else
				stripY = stripY + 20;
	}
	
	public void paint(Graphics2D graphic2D){
		graphic2D.setColor(Color.BLACK);
		graphic2D.fillRect(150, 0, ROAD_WIDTH, ROAD_HEIGHT);
		
		//Create lane marks - needs to be fixed so that it generates with spaces in between marks rather than as a single line
		graphic2D.setColor(Color.YELLOW);
		graphic2D.fillRect(245, 0, 5, ROAD_HEIGHT); //should make these into constants at some point
		graphic2D.fillRect(345, 0, 5, ROAD_HEIGHT);
		
		graphic2D.setColor(Color.BLACK);
		graphic2D.fillRect(245, stripY, 5, 40);
		graphic2D.fillRect(345, stripY, 5, 40);
		graphic2D.fillRect(245, stripY + 80, 5, 40);
		graphic2D.fillRect(345, stripY + 80, 5, 40);
		graphic2D.fillRect(245, stripY + 160, 5, 40);
		graphic2D.fillRect(345, stripY + 160, 5, 40);
		graphic2D.fillRect(245, stripY + 240, 5, 40);
		graphic2D.fillRect(345, stripY + 240, 5, 40);
		graphic2D.fillRect(245, stripY + 320, 5, 40);
		graphic2D.fillRect(345, stripY + 320, 5, 40);
		graphic2D.fillRect(245, stripY + 400, 5, 40);
		graphic2D.fillRect(345, stripY + 400, 5, 40);
		graphic2D.fillRect(245, stripY + 480, 5, 40);
		graphic2D.fillRect(345, stripY + 480, 5, 40);
		graphic2D.fillRect(245, stripY + 560, 5, 40);
		graphic2D.fillRect(345, stripY + 560, 5, 40);
		graphic2D.fillRect(245, stripY + 640, 5, 40);
		graphic2D.fillRect(345, stripY + 640, 5, 40);
		graphic2D.fillRect(245, stripY + 720, 5, 40);
		graphic2D.fillRect(345, stripY + 720, 5, 40);
		
		graphic2D.setColor(Color.GRAY.darker());
		graphic2D.fillRect(135, 0, 15, ROAD_HEIGHT);
		graphic2D.fillRect(450, 0, 15, ROAD_HEIGHT);
		
		moveStrips();
		
	}

}
