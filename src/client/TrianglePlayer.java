package client;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

public class TrianglePlayer extends Player {
	double angle = 0;
	int i = 0 ;
	private ImageIcon paddle = new ImageIcon(getClass().getResource("/client/resource/paddle.png"));
	
	//In order to check goals of every player, I'd like to specify where are they located on the map when we call function createPlayer
	//The location so far will be North and South. I will make it more flexible when we'll get to more players
	public TrianglePlayer(int playerSpeed, String location, int x, int y) {
		super(x, y, playerSpeed, location);
		if (location == "S") {
			angle = Math.toRadians(15);
		} else if (location == "NW") {
			angle = Math.toRadians(135);
		} else if (location == "NE") {
			angle = Math.toRadians(75);
		}
	}
	
	// This needs some work.
	public Shape getBounds() {
		AffineTransform transform = new AffineTransform();
		transform.rotate(angle, getX(), getY());
		Rectangle2D rect = new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight());
		Shape rotatedRect = transform.createTransformedShape(rect);
		return rotatedRect;
	}

	//depending on location, thats how the update() is worked
	@Override
	public void update() {
		//these are hard coded and not flexible AT ALL
		//setting the unchanging vector to move along the line, using the angle that it needs to travel along
		if (getLocation() == "S") {
			setX(getX() + getVector());
			setY((int) ((MainPage.HEIGHT-(MainPage.HEIGHT*Math.tan(angle))) +(getX() * Math.tan(angle))) - 68);
		} else if (getLocation() == "NW") {
			setY(getY() + getVector());
			setX((int) (MainPage.HEIGHT/4 +((MainPage.HEIGHT-(MainPage.HEIGHT*Math.tan(Math.toRadians(15)))) - (getY() * Math.tan(Math.toRadians(45)))) + 30));
		} else if (getLocation() == "NE") {
			setY(getY() + getVector());
			setX((int) ((MainPage.HEIGHT/4 +(MainPage.HEIGHT-(MainPage.HEIGHT*Math.tan(Math.toRadians(15)))) + (getY() * Math.tan(Math.toRadians(15))))));
		}
	}
	

	// draw
	@Override
	public void draw(Graphics2D g) {
		Image PlayerImage = paddle.getImage();
		AffineTransform transform = new AffineTransform();
		transform.rotate(angle, getX(), getY());
		g.setTransform(transform);
		g.drawImage(PlayerImage, getX(), getY(), getWidth(), getHeight(), null);
		// reset transformation after use, prevents bugs from graphics re-use
		transform.rotate(-angle, getX(), getY());
		g.setTransform(transform);
	}
		
}

