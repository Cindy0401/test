package test;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import client.Ball;
import client.Bonus;
import client.Player;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlayerDataTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * A basic test for the methods in the Player class
	 */
	@Test
	public void playerTest() {
		/// Test player constructor
		Player testPlayer = new Player(50, 50, 3, "W");
		assertEquals(50, testPlayer.getX());
		assertEquals(50, testPlayer.getY());
		assertEquals(2, testPlayer.getSpeed()); /// FIXME wtf
		assertEquals("W", testPlayer.getLocation());
		assertEquals(18, testPlayer.getWidth());
		assertEquals(100, testPlayer.getHeight());

		testPlayer.setAI(false);
		assertEquals(false, testPlayer.isAI());
		assertEquals(50, testPlayer.getX());
		assertEquals("W", testPlayer.getLocation());
		assertEquals(18, testPlayer.getWidth());
		assertEquals(100, testPlayer.getHeight());
		assertEquals(0, testPlayer.getBonus());
		testPlayer.applyBonus(Player.WIDTHBONUS);
		testPlayer.removeBonus();
		assertEquals(0, testPlayer.getBonus());
		
		/// Test getX and setX
		testPlayer.setX(45);
		assertEquals(45, testPlayer.getX());

		/// Test getY and setY
		testPlayer.setY(342);
		assertEquals(342, testPlayer.getY());
		
		/// Test getWidth and setWidth
		testPlayer.setWidth(-234);
		assertEquals(-234, testPlayer.getWidth());
		
		/// Test getHeight and setHeight
		testPlayer.setHeight(543);
		assertEquals(543, testPlayer.getHeight());
		
		/// Test getBonus and setBonus
		testPlayer.setBonus(Player.WIDTHBONUS);
		assertEquals(Player.WIDTHBONUS, testPlayer.getBonus());
		
		/// Test getBonusTime and setBonusTime
		testPlayer.setBonusTime(7000);
		assertEquals(7000, testPlayer.getBonusTime());
		 
		/// Test getSpeed and setSpeed
		testPlayer.setSpeed(10);
		assertEquals(10, testPlayer.getSpeed());
		
		/// Test getNewX
		assertEquals(testPlayer.getX() + testPlayer.getVector(), testPlayer.getNewX());
		
		/// Test getNewY
		assertEquals(testPlayer.getY() + testPlayer.getVector(), testPlayer.getNewY());
		
		/// Test getLocation and setLocation
		testPlayer.setLocation("E");
		assertEquals("E", testPlayer.getLocation());
		
		/// Test isAI and setAI
		testPlayer.setAI(true);
		assertEquals(true, testPlayer.isAI());
	}
	
	/**
	 * A basic test for the methods in the Player class, when AI is enabled.
	 */
	@Test
	public void aiPlayerTest() {
		Player testPlayer = new Player(250, 5, 3, "W");
		testPlayer.setAI(true);
		assertEquals(true, testPlayer.isAI());
		assertEquals(250, testPlayer.getX());
		assertEquals("W", testPlayer.getLocation());
		assertEquals(18, testPlayer.getWidth());
		assertEquals(100, testPlayer.getHeight());
		assertEquals(0, testPlayer.getBonus());
		testPlayer.applyBonus(Player.WIDTHBONUS);
		testPlayer.removeBonus();
		assertEquals(0, testPlayer.getBonus());
	}
	
	/**
	 * A basic test for ball player collisions
	 */
	@Test
	public void ballCollisionTest() {
		Player testPlayer = new Player(66, 66, 3, "W");
		Ball testBall = new Ball(66, 66, 4, 4);
		
		/// Test the ball moving from inside to outside the player's boundary box correctly registers
		
		assertEquals(true, testPlayer.getBounds().intersects(testBall.getBounds()));
		for (int x = 0; x < 10; x++) testBall.update();
		assertEquals(false, testPlayer.getBounds().intersects(testBall.getBounds()));
	}
	
	/**
	 * A basic test for bonus player collisions
	 */
	@Test
	public void bonusCollisionTest() {
		Player testPlayer = new Player(66, 66, 3, "W");
		Bonus testBonus = new Bonus(76, 76, 3, -3, Bonus.WIDTHBONUS);
		
		/// Test the ball moving from inside to outside the player's boundary box correctly registers
		
		assertEquals(true, testPlayer.getBounds().intersects(testBonus.getBounds()));
		for (int x = 0; x < 20; x++) testBonus.update();
		assertEquals(false, testPlayer.getBounds().intersects(testBonus.getBounds()));
	}
	
}