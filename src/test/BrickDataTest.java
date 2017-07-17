package test;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import client.Brick;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BrickDataTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * A basic test for the methods in the Brick class.
	 */
	@Test
	public void brickTest() {
		/// Test brick constructor
		Brick brick = new Brick(240, 240, 100, 100);
		assertEquals(240, brick.getX());
		assertEquals(240, brick.getY());
		assertEquals(100, brick.getWidth());
		assertEquals(100, brick.getHeight());
		
		/// Test getX and setX
		brick.setX(67);
		assertEquals(67, brick.getX());
	
		/// Test getY and setY
		brick.setY(653);
		assertEquals(653, brick.getY());
		
		/// Test getWidth and setWidth
		brick.setWidth(4000);
		assertEquals(4000, brick.getWidth());
		
		/// Test getHeight and setHeight
		brick.setHeight(2000);
		assertEquals(2000, brick.getHeight());
		
		/// Test getHealth and setHealth
		brick.setHealth(300);
		assertEquals(300, brick.getHealth());
		
		/// Test getUpperYCoord
		assertEquals(brick.getY(), brick.getUpperYCoord());
		
		/// Test getBottomYCoord
		assertEquals(brick.getY() + (brick.getHeight() / 2), brick.getBottomYCoord());
		
		/// Test getEastCoord
		assertEquals(brick.getX() + brick.getWidth(), brick.getEastCoord());
		
		/// Test getWestCoord
		assertEquals(brick.getX(), brick.getWestCoord());
		
		/// Test hit and isAlive
		assertEquals(true, brick.isAlive());
		brick.setHealth(1);
		assertEquals(true, brick.isAlive());
		brick.hit();
		assertEquals(false, brick.isAlive());
	}
	
}