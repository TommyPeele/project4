import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Car{

	protected int x;
	protected int y;
	protected int lane; //0 is left lane, 1 is center lane, 2 is right lane

	//TESTING NUMBERS, NOT FINAL
	public static final int CAR_WIDTH = 30;
	public static final int CAR_HEIGHT = 60;

	public Car(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

	public Rectangle getBounds(){
		return new Rectangle(x, y, CAR_WIDTH, CAR_HEIGHT);
	}

	public void paint(Graphics2D graphic2D){
		setPaintColor(graphic2D);
		graphic2D.fillRect(x, y, CAR_WIDTH, CAR_HEIGHT);
	}

	protected abstract void setPaintColor(Graphics2D graphic2D);

}
