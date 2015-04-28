import java.awt.Color;
import java.awt.Graphics2D;

public class Dirt{

	private GameScreen gameScreen;

	private int x;
	private int y;

	public Dirt(GameScreen gameScreen, int x, int y){
		this.gameScreen = gameScreen;
		this.x = x;
		this.y = y;
	}

	public void paint(Graphics2D graphic2D){
		graphic2D.setColor(new Color(156, 93, 82));
		graphic2D.fillRect(x, y, 5, 40);
	}

	public void move(){
		if(y >= 400)
			y = -10;
		else
			y = y + 60;
	}

}
