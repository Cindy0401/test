package test;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import client.Ball;
import client.Brick;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BallDataTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * A basic test for the methods in the Ball class
	 */
	@Test
	public void ballTest() {
		/// Test ball constructor
		Ball testBall = new Ball(0, 0, 4, 4);
		assertEquals(0, testBall.getX());
		assertEquals(0, testBall.getY());
		assertEquals(4, testBall.getXVector());
		assertEquals(4, testBall.getYVector());
		
		/// Test setDiameter and getDiameter
		testBall.setDiameter(17);
		assertEquals(17, testBall.getDiameter());
		testBall.setDiameter(-6);
		assertEquals(-6, testBall.getDiameter());
		
		/// Test setLastHit and getLastHit
		testBall.setLastHit(-1);
		assertEquals(-1, testBall.getLastHit());
		testBall.setLastHit(4);
		assertEquals(4, testBall.getLastHit());
		testBall.setLastHit(10213);
		assertEquals(10213, testBall.getLastHit());
		
		/// Test setX and getX
		testBall.setX(4);
		assertEquals(4, testBall.getX());
		testBall.setX(-17);
		assertEquals(-17, testBall.getX());
		
		/// Test setY and getY
		testBall.setY(32);
		assertEquals(32, testBall.getY());
		testBall.setY(-6);
		assertEquals(-6, testBall.getY());
		
		/// Test setXVector and getXVector
		for (int x = -300; x < 300; x += 3) {
			testBall.setXVector(x);
			assertEquals(x, testBall.getXVector());
		}
		
		/// Test setYVector and getYVector
		for (int x = -300; x < 300; x += 2) {
			testBall.setYVector(x);
			assertEquals(x, testBall.getYVector());
		}
	}
	
	/**
	 * A basic test for the Ball and Brick collisions
	 */
	@Test
	public void brickCollisionTest() {
		Ball testBall = new Ball(0, 0, 4, 4);
		Brick brick = new Brick(240, 240, 100, 100);
		assertEquals(false, testBall.getBounds().intersects(brick.getBounds()));
		
		testBall.setX(240 + 25);
		testBall.setY(240 + 25);
		assertEquals(true, testBall.getBounds().intersects(brick.getBounds()));
		
		testBall.setX(240 - 30);
		testBall.setY(240 + 25);
		assertEquals(false, testBall.getBounds().intersects(brick.getBounds()));
	}
	
}