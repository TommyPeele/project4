
public abstract class Car{
	
	protected GameScreen gameScreen;
	
	protected int x;
	protected int y;
	
	//TESTING NUMBERS, NOT FINAL
	public static final int CAR_WIDTH = 30;
	public static final int CAR_HEIGHT = 60;
	
	public Car(GameScreen gameScreen, int x, int y){
		this.gameScreen = gameScreen;
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

}
