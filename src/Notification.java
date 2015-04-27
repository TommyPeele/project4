import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

public class Notification{
	
		private GameScreen gameScreen;
		private boolean availableMessage;
		
		private int tick = 0;
	
		public Notification(GameScreen gameScreen){
			this.gameScreen = gameScreen;
		}
		
		public void paint(Graphics2D graphic2D){
			//System.out.println(tick);
			
			if(tick < 10 && tick < 20)
			{
				graphic2D.setColor(Color.WHITE);
				graphic2D.fillOval(12, 4, 50, 50);
				graphic2D.setColor(Color.RED);
				graphic2D.fillOval(17, 9, 40, 40);
				tick++;
			}
			else if(tick >= 10 && tick < 20)
			{
				tick++;
			}
			else if(tick >= 20)
				tick = 0;
		}
		
		public void blink(){
			
		}
		
}
