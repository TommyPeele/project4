package code.cars;

import java.awt.Color;
import java.awt.Graphics2D;

/*
 * This is our Obstacle Car, we have 5 that choose lanes and travel along the highway. If the user collides, he or she loses
 */

public class ObstacleCar extends Car{

	private final static int laneOne = 185;
	private final static int laneTwo = 285;
	private final static int laneThree = 385;
	private final static int speed = 10;
	
	public ObstacleCar(int x, int y){
		super(x, y);
		chooseLane();
	}

		//Chooses which lane the car will spawn in
	protected void chooseLane(){
			//Gets Lane Number
		lane = (int)(Math.random() * 3);
		switch(lane){
		case 0:
<<<<<<< HEAD
			x = 183;
			break;
		case 1:
			x = 283;
			break;
		case 2:
			x = 383;
=======
			x = laneOne;
			break;
		case 1:
			x = laneTwo;
			break;
		case 2:
			x = laneThree;
>>>>>>> 83443b6a102eac8458a8fc735e7050d66a2f69db
			break;
		default:
			break;
		}
	}

		//Moves the Car according to its speed
	public void move(){
		if(y == 500){
			y = -300;
			chooseLane();
		}
		else
			y = y + speed;
	}
	
	@Override
	public void setPaintColor(Graphics2D graphic2D){
		graphic2D.setColor(Color.RED);
	}

}
