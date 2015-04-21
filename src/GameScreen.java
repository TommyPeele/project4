import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class GameScreen extends Screen{

	private Road road;
	
	private static final long serialVersionUID = 0;
	
	public GameScreen(Game game){
		super(game);
		setBackground(Color.GREEN.darker());
		
		road = new Road(this);
	}
	
	@Override
	public void paint(Graphics graphic){
		super.paint(graphic);
		Graphics2D graphic2D = (Graphics2D) graphic;
		graphic2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		road.paint(graphic2D);
	}

}
