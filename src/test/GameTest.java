package test;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import client.Game;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GameTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * A basic test for the methods in the Ball class
	 */
	@Test
	public void gameTest() {
		Game testGame = new Game(false, 0, 0);
		testGame.createPlayers();
		testGame.addBricks();
		testGame.setAILocation();
	}

}
