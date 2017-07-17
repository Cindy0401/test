package test;

import static org.junit.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.InputEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import client.Credits;
import client.Game;
import client.Guide;
import client.Guide;
import client.LocalMultiplay;
import client.MainPage;
import client.OnlineMultiplay;
import client.Policy;
import client.Settings;
import client.Support;
import client.Terms;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserInterfaceTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	public JFrame mockedMain() {
		JFrame frame = new JFrame("BrickBreak");
		frame.setBounds(100, 100, MainPage.WIDTH, MainPage.HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainPage mainPage = new MainPage();
		frame.setContentPane(mainPage);
		ImageIcon background = new ImageIcon(MainPage.class.getResource("/client/resource/background.jpg"));
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		JPanel imagePanel = (JPanel) frame.getContentPane();
		imagePanel.setOpaque(false);
		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		frame.setVisible(true);
		frame.toFront();
		return frame;
	}

	/**
	 * UI tests for the LocalMultiplay class.
	 */
	@Test
	public void localMultiplayTests() {
		try {
			final Robot robot = new Robot();
			final JFrame frame = mockedMain();
			AllTests.humanAppropriatePause();

			pressLocalGameButton(robot, frame);

			// Does clicking the back button return to the main page?
			robot.mouseMove((int) (frame.getWidth() * 0.10), frame.getHeight() + 60);
			click(robot, frame);
			assertEquals(MainPage.class, frame.getContentPane().getClass());

			pressLocalGameButton(robot, frame);

			/// Does clicking OK successfully load the LocalMultiplay page?
			robot.mouseMove((int) (frame.getWidth() * 0.98), frame.getHeight() + 60);
			click(robot, frame);
			assertEquals(LocalMultiplay.class, frame.getContentPane().getClass());

			// Does clicking the back button return to the main page?
			robot.mouseMove((int) (frame.getWidth() * 0.10), frame.getHeight() + 60);
			click(robot, frame);
			assertEquals(MainPage.class, frame.getContentPane().getClass());
			
			pressLocalGameButton(robot, frame);

			/// Does clicking OK successfully load the LocalMultiplay page?
			robot.mouseMove((int) (frame.getWidth() * 0.98), frame.getHeight() + 60);
			click(robot, frame);
			assertEquals(LocalMultiplay.class, frame.getContentPane().getClass());
			
			/// Does clicking Play successfully load the 2-player easy game?
			robot.mouseMove((int) (frame.getWidth() * 1.04), frame.getHeight() + 60);
			click(robot, frame);
			AllTests.humanAppropriatePause(true);
			assertEquals(Game.class, frame.getContentPane().getClass());
			/// 20 seconds of gameplay
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * UI tests for the OnlineMultiplay class.
	 */
	@Test
	public void onlineGameTests() {
		try {
			final Robot robot = new Robot();
			final JFrame frame = mockedMain();
			AllTests.humanAppropriatePause();

			pressOnlineGameButton(robot, frame);

			// Does clicking the back button return to the main page?
			robot.mouseMove((int) (frame.getWidth() * 0.18), frame.getHeight() + 20);
			click(robot, frame);
			assertEquals(MainPage.class, frame.getContentPane().getClass());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * UI tests for toggling background music on and off
	 */
	@Test
	public void musicToggleTest() {
		try {
			final Robot robot = new Robot();
			final JFrame frame = mockedMain();

			// Does clicking the music label button enable the game music?
			testToggleMusic(robot, frame);
			assertEquals(true, ((JRadioButton) frame.getContentPane().getComponent(1)).isSelected());

			// Does clicking the music label again disable the game music?
			testToggleMusic(robot, frame);
			assertEquals(false, ((JRadioButton) frame.getContentPane().getComponent(1)).isSelected());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * UI tests for the Settings class.
	 */
	@Test
	public void settingsTests() {
		try {
			final Robot robot = new Robot();
			final JFrame frame = mockedMain();
			AllTests.humanAppropriatePause();

			pressSettingsButton(robot, frame);

			// Does clicking the credits button successfully change pages?
			robot.mouseMove((int) (frame.getWidth() * 0.6), (int) (frame.getHeight() * 0.8));
			click(robot, frame);
			assertEquals(Credits.class, frame.getContentPane().getClass());

			// Does clicking the back button return to the settings page?
			robot.mouseMove((int) (frame.getWidth() * 0.18), frame.getHeight() + 20);
			click(robot, frame);
			assertEquals(Settings.class, frame.getContentPane().getClass());

			// Does clicking the back button return to the main page?
			robot.mouseMove((int) (frame.getWidth() * 0.6), (int) (frame.getHeight() * 0.9));
			click(robot, frame);
			assertEquals(MainPage.class, frame.getContentPane().getClass());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * UI tests for the Support class.
	 */
	@Test
	public void supportTests() {
		try {
			final Robot robot = new Robot();
			final JFrame frame = mockedMain();
			AllTests.humanAppropriatePause();

			pressSupportButton(robot, frame);

			// Does clicking the guide button successfully change pages?
			robot.mouseMove((int) (frame.getWidth() * 0.6), (int) (frame.getHeight() * 0.5));
			click(robot, frame);
			assertEquals(Guide.class, frame.getContentPane().getClass());

			// Does clicking the back button return to the support page?
			robot.mouseMove((int) (frame.getWidth() * 0.10), frame.getHeight() + 60);
			click(robot, frame);
			assertEquals(Support.class, frame.getContentPane().getClass());

			// Does clicking the terms of use button successfully change pages?
			robot.mouseMove((int) (frame.getWidth() * 0.6), (int) (frame.getHeight() * 0.6));
			click(robot, frame);
			assertEquals(Terms.class, frame.getContentPane().getClass());

			// Does clicking the back button return to the support page?
			robot.mouseMove((int) (frame.getWidth() * 0.10), frame.getHeight() + 60);
			click(robot, frame);
			assertEquals(Support.class, frame.getContentPane().getClass());

			// Does clicking the privacy policy button successfully change
			// pages?
			robot.mouseMove((int) (frame.getWidth() * 0.6), (int) (frame.getHeight() * 0.72));
			click(robot, frame);
			assertEquals(Policy.class, frame.getContentPane().getClass());

			// Does clicking the back button return to the support page?
			robot.mouseMove((int) (frame.getWidth() * 0.10), frame.getHeight() + 60);
			click(robot, frame);
			assertEquals(Support.class, frame.getContentPane().getClass());

			// Does clicking the back button return to the main page?
			robot.mouseMove((int) (frame.getWidth() * 0.20), frame.getHeight() + 10);
			click(robot, frame);
			assertEquals(MainPage.class, frame.getContentPane().getClass());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pressLocalGameButton(Robot robot, JFrame frame) {
		// Does clicking the local game button successfully change pages?
		robot.mouseMove((int) (frame.getWidth() * 0.6), (int) (frame.getHeight() * 0.6));
		click(robot, frame);
		assertEquals(Guide.class, frame.getContentPane().getClass());
	}

	public void pressOnlineGameButton(Robot robot, JFrame frame) {
		// Does clicking the online game button successfully change pages?
		robot.mouseMove((int) (frame.getWidth() * 0.6), (int) (frame.getHeight() * 0.7));
		click(robot, frame);
		assertEquals(OnlineMultiplay.class, frame.getContentPane().getClass());
	}

	public void pressSupportButton(Robot robot, JFrame frame) {
		// Does clicking the support button successfully change pages?
		robot.mouseMove((int) (frame.getWidth() * 1.04), frame.getHeight() + 60);
		click(robot, frame);
		assertEquals(Support.class, frame.getContentPane().getClass());
	}

	public void pressSettingsButton(Robot robot, JFrame frame) {
		// Does clicking the settings button successfully change pages?
		robot.mouseMove((int) (frame.getWidth() * 0.14), frame.getHeight() + 60);
		click(robot, frame);
		assertEquals(Settings.class, frame.getContentPane().getClass());
	}

	public void testToggleMusic(Robot robot, JFrame frame) throws InterruptedException {
		robot.mouseMove((int) (frame.getWidth() * 1), (int) (frame.getHeight() * 0.2));
		click(robot, frame);
	}

	public void click(Robot robot, JFrame frame) {
		frame.toFront();
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		AllTests.humanAppropriatePause();
	}

}