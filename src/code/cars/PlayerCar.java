package code.cars;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

<<<<<<< HEAD:src/PlayerCar.java
/*
 * This is our Player Car which the user controls, it stems from Car
 */
=======
import code.TextEntry;
>>>>>>> origin/master:src/code/cars/PlayerCar.java

public class PlayerCar extends Car{

	public static int DEFAULT_X = 285; //Player car starts in center lane
	public static int DEFAULT_Y = 310; //Player car stays at bottom of screen as cars drive towards it
	
	private int velocity = 0; //-1 is moving left, 0 is at rest, 1 is moving right
	private int moveCount = 0;

	public PlayerCar(){
		super(DEFAULT_X, DEFAULT_Y);
		lane = 1;
	}

	public PlayerCar(int x, int y){
		super(x, y);
	}

		//Key Pressed Events to Control the Car
	public void keyPressed(KeyEvent event){
		if(event.getKeyCode() == KeyEvent.VK_LEFT)
			if(lane > 0 && velocity == 0)
				velocity = -1;
		if(event.getKeyCode() == KeyEvent.VK_RIGHT)
			if(lane < 2 && velocity == 0)
				velocity = 1;
	}
		
		//Moves the Car right or left depending on its velocity member
	public void move(){
		switch(velocity){
		case -1:
			x = x - 10;
			moveCount++;
			if(moveCount == 10){
				lane--;
				velocity = 0;
				moveCount = 0;
			}
			break;
		case 1:
			x = x + 10;
			moveCount++;
			if(moveCount == 10){
				lane++;
				velocity = 0;
				moveCount = 0;
			}
			break;
		default:
			break;
		}
	}

		//Checks Collision with Obstacle Car
	public boolean checkCollision(ObstacleCar obstacleCar){
		return getBounds().intersects(obstacleCar.getBounds());
	}

		//Checks Detection from Police Car
	public boolean checkPoliceDetection(PoliceCar policeCar, TextEntry textEntry){
		if(y == policeCar.getY() && textEntry.isVisible())
			return true;
		else
			return false;
	}
		
	@Override
	public void setPaintColor(Graphics2D graphic2D){
		graphic2D.setColor(Color.GREEN);
	}

	public int getVelocity(){
		return velocity;
	}

	public void setVelocity(int velocity){
		this.velocity = velocity;
	}

}
