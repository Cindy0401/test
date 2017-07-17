package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BallDataTest.class, BonusDataTest.class, BrickDataTest.class, PlayerDataTest.class,
		SoundTest.class, UserInterfaceTest.class, GameTest.class })
public class AllTests {
	
	/// Must be ~50+ or UI tests break
	public static final int TEST_DEBUG_PAUSE_TICKS = 100;
	
	public static void humanAppropriatePause() {
		try {
			Thread.sleep(TEST_DEBUG_PAUSE_TICKS);
		} catch (InterruptedException e) {
		}
	}
	
	public static void humanAppropriatePause(boolean gameplayToLoad) {
		try {
			Thread.sleep(gameplayToLoad ? 10000 : TEST_DEBUG_PAUSE_TICKS);
		} catch (InterruptedException e) {
		}
	}

}
