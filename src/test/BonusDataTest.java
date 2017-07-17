package test;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import client.Bonus;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BonusDataTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * A basic test for the methods in the Ball class
	 */
	@Test
	public void bonusTest() {
		Bonus testBonus = new Bonus(120, 120, 3, -3, Bonus.WIDTHBONUS);
		assertEquals(120, testBonus.getX());
		assertEquals(120, testBonus.getY());
		assertEquals(3, testBonus.getXVector());
		assertEquals(-3, testBonus.getYVector());
		assertEquals(Bonus.WIDTHBONUS, testBonus.getBonusType());
		
		/// Test getX and setX
		testBonus.setX(342);
		assertEquals(342, testBonus.getX());
		
		/// Test getY and setY
		testBonus.setY(446);
		assertEquals(446, testBonus.getY());
		
		/// Test getXVector and setXVector
		testBonus.setXVector(testBonus.getXVector() * -1);
		assertEquals(-3, testBonus.getXVector());
		
		/// Test getYVector and setYVector
		testBonus.setYVector(testBonus.getYVector() * -1);
		assertEquals(3, testBonus.getYVector());
		
		/// Test getDiameter
		testBonus.setDiameter(12310);
		assertEquals(12310, testBonus.getDiameter());
		testBonus.setDiameter(0);
		assertEquals(0, testBonus.getDiameter());
	}
}