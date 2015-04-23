import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class GameScreen extends Screen{

	private Road road;
	private PlayerCar playerCar;
	
	// The Game Screen Requires a Text Entry Obj
	private TextEntry textEntry;
	private boolean visTextEntry = false;
	
	private Key key;
	
	
	
	
	private static final long serialVersionUID = 0;
	
	public GameScreen(Game game){
		super(game);
		setBackground(Color.GREEN.darker());
		
		//SetFocusable
		setFocusable(true);
		
		//Key Listeners
		key = new Key();
		addKeyListener(key);
		
		road = new Road(this);
		playerCar = new PlayerCar(this);
		
			//Create TextEntry Obj
		textEntry = new TextEntry(this);
	}
	
	@Override
	public void paint(Graphics graphic){
		super.paint(graphic);
		Graphics2D graphic2D = (Graphics2D) graphic;
		graphic2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		
		road.paint(graphic2D);
		playerCar.paint(graphic2D);
		
			//If the user has pressed the Show TV
		if(visTextEntry)
			textEntry.paint(graphic2D);
	}
	
	@Override
	public void run(){
		while(true){
			repaint();
		}
	}
	
	private class Key implements KeyListener{
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			//A very janky way to capture keyboard input, will look into better method later!
			//Else if statements 4 dayz
			
			if(key == KeyEvent.VK_DOWN && visTextEntry == false)
			{
				System.out.println("Display TextEntry");
				visTextEntry = true;
				//Set TextEntry Bool equal to True, Display it
			}
			else if(key == KeyEvent.VK_DOWN && visTextEntry == true)
			{
				System.out.println("Collapse TextEntry");
				visTextEntry = false;
			}
			else if(key == KeyEvent.VK_A && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "a";
			}
			else if(key == KeyEvent.VK_B && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "b";
			}
			else if(key == KeyEvent.VK_C && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "c";
			}
			else if(key == KeyEvent.VK_D && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "d";
			}
			else if(key == KeyEvent.VK_E && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "e";
			}
			else if(key == KeyEvent.VK_F && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "f";
			}
			else if(key == KeyEvent.VK_G && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "g";
			}
			else if(key == KeyEvent.VK_H && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "h";
			}
			else if(key == KeyEvent.VK_I && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "i";
			}
			else if(key == KeyEvent.VK_J && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "j";
			}
			else if(key == KeyEvent.VK_K && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "k";
			}
			else if(key == KeyEvent.VK_L && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "l";
			}
			else if(key == KeyEvent.VK_M && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "m";
			}
			else if(key == KeyEvent.VK_N && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "n";
			}
			else if(key == KeyEvent.VK_O && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "o";
			}
			else if(key == KeyEvent.VK_P && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "p";
			}
			else if(key == KeyEvent.VK_Q && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "q";
			}
			else if(key == KeyEvent.VK_R && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "r";
			}
			else if(key == KeyEvent.VK_S && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "s";
			}
			else if(key == KeyEvent.VK_T && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "t";
			}
			else if(key == KeyEvent.VK_U && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "u";
			}
			else if(key == KeyEvent.VK_V && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "v";
			}
			else if(key == KeyEvent.VK_W && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "w";
			}
			else if(key == KeyEvent.VK_X && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "x";
			}
			else if(key == KeyEvent.VK_Y && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "y";
			}
			else if(key == KeyEvent.VK_Z && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + "z";
			}
			else if(key == KeyEvent.VK_BACK_SPACE && visTextEntry == true)
			{
				if(textEntry.userMessage.length() != 0)
					textEntry.userMessage = textEntry.userMessage.substring(0, textEntry.userMessage.length() - 1);
			}
			else if(key == KeyEvent.VK_SPACE && visTextEntry == true)
			{
				textEntry.userMessage = textEntry.userMessage + " ";
			}
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
