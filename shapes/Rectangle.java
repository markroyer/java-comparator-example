package shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * Representation of a rectangle that may or may not be filled with a color.
 * 
 * @author Mark Royer
 * 
 */
public class Rectangle extends ClosedFigure {

	/**
	 * The underlying representation of the rectangle
	 */
	private Rectangle2D.Float thisRectangle;

	/**
	 * Create a new rectangle with width, height, and location (x,y).
	 * 
	 * @param width
	 *            The horizontal width of the rectangle
	 * @param height
	 *            The vertical height of the rectangle
	 * @param x
	 *            The x position
	 * @param y
	 *            The y position
	 */
	public Rectangle(int width, int height) {
		thisRectangle = new Rectangle2D.Float(0, 0, width, height);
		setX(0);
		setY(0);
		setWidth(width);
		setHeight(height);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see shapes.ClosedFigure#area()
	 */
	public int area() {
		return getWidth() * getHeight();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see shapes.ClosedFigure#perimeter()
	 */
	public int perimeter() {
		return 2 * (getWidth() + getHeight());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see shapes.ClosedFigure#draw(java.awt.Graphics2D)
	 */
	public void draw(Graphics2D g) {

		g.setPaint(Color.BLACK);
		g.draw(thisRectangle);
	}

	/**
	 * @param height
	 *            The vertical height the rectangle will be set to
	 */
	public void setHeight(int height) {
		thisRectangle.height = height;
	}

	/**
	 * @param width
	 *            The horizontal width the rectangle will be set to
	 */
	public void setWidth(int width) {
		thisRectangle.width = width;
	}

	/**
	 * @return The vertical height
	 */
	public int getHeight() {
		return (int) thisRectangle.height;
	}

	/**
	 * @return The horizontal width
	 */
	public int getWidth() {
		return (int) thisRectangle.width;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see shapes.ClosedFigure#getX()
	 */
	public int getX() {
		return (int) thisRectangle.x;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see shapes.ClosedFigure#getY()
	 */
	public int getY() {
		return (int) thisRectangle.y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see shapes.ClosedFigure#setX(int)
	 */
	public void setX(int x) {
		thisRectangle.x = x;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see shapes.ClosedFigure#setY(int)
	 */
	public void setY(int y) {
		thisRectangle.y = y;
	}

	/* (non-Javadoc)
	 * @see shapes.ClosedFigure#getBounds()
	 */
	public java.awt.Rectangle getBounds() {
		return thisRectangle.getBounds();
	}

}
