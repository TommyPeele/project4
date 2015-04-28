import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerCarTest{

	PlayerCar playerCar;
	ObstacleCar obstacleCar;
	PoliceCar policeCar;
	
	TextEntry textEntry;
	
	@Before
	public void setUp(){
		playerCar = new PlayerCar();
	}
	
	@Test
	public void checkCollisionTest(){
		obstacleCar = new ObstacleCar(185, 310);
		assertFalse(playerCar.checkCollision(obstacleCar));
		
		obstacleCar.setX(285);
		assertTrue(playerCar.checkCollision(obstacleCar));
		
		policeCar = new PoliceCar(285, 350);
		assertTrue(playerCar.checkCollision(policeCar));
	}

}
