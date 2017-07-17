package test;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import client.GameSound;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SoundTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * A basic test for the methods in GameSound
	 * 		- this tests the functions do not give exceptions,
	 * 		- but with human appropriate pauses can be used for manual sound testing
	 */
	@Test
	public void soundTest() {
		GameSound testSound = new GameSound();
		
		/// Test the bonus hit sound
		testSound.bonusHit();
		AllTests.humanAppropriatePause();
		
		/// Test the brick hit sound
		testSound.brickHit();
		AllTests.humanAppropriatePause();
		
		/// Test the player hit sound
		testSound.playerHit();
		AllTests.humanAppropriatePause();
		
		/// Test that the game sounds mutes correctly
		GameSound.gameSoundVolume = 0;
		testSound.playerHit();
		AllTests.humanAppropriatePause();
		
		/// Test the background music
		testSound.playBGM();
		AllTests.humanAppropriatePause();

		/// Test that the background music mutes correctly
		GameSound.gameMusicVolume = 0;
		AllTests.humanAppropriatePause();
	}

}
