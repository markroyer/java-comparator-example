package shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

/**
 * 
 * Representation of a circle that may or may not be filled with a color.
 * 
 * @author Mark Royer
 * 
 */
public class Circle extends ClosedFigure {

	/**
	 * Underlying shape
	 */
	protected Ellipse2D.Float thisCircle;

	/**
	 * Create a circle with a radius equal to the given size.
	 * 
	 * @param radius
	 *            The size of the circle's radius
	 */
	public Circle(int radius) {
		thisCircle = new Ellipse2D.Float(0, 0, radius * 2, radius * 2);
		setX(0);
		setY(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Circle)
			return this.radius() == ((Circle) obj).radius();
		else
			return false;
	}

	/**
	 * @return The circle's radius
	 */
	public int radius() {
		return (int) thisCircle.width / 2;
	}

	/**
	 * @param r
	 *            The size the circle's radius will be set to
	 */
	public void setRadius(int r) {
		thisCircle.width = r * 2;
		thisCircle.height = thisCircle.width;
	}

	/* (non-Javadoc)
	 * @see shapes.ClosedFigure#area()
	 */
	public int area() {
		return (int) (Math.PI * Math.pow(radius(), 2));
	}

	/* (non-Javadoc)
	 * @see shapes.ClosedFigure#perimeter()
	 */
	public int perimeter() {
		return (int) (2 * Math.PI * radius());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "{Circle:" + location() + ", area=" + area() + "}";
	}

	/* (non-Javadoc)
	 * @see shapes.ClosedFigure#setX(int)
	 */
	public void setX(int x) {
		thisCircle.x = x;
	}

	/* (non-Javadoc)
	 * @see shapes.ClosedFigure#setY(int)
	 */
	public void setY(int y) {
		thisCircle.y = y;
	}

	/* (non-Javadoc)
	 * @see shapes.ClosedFigure#getX()
	 */
	public int getX() {
		return (int) thisCircle.x;
	}

	/* (non-Javadoc)
	 * @see shapes.ClosedFigure#getY()
	 */
	public int getY() {
		return (int) thisCircle.y;
	}

	/* (non-Javadoc)
	 * @see shapes.ClosedFigure#draw(java.awt.Graphics2D)
	 */
	public void draw(Graphics2D g) {

		g.setPaint(Color.black);
		g.draw(thisCircle);

	}

	/* (non-Javadoc)
	 * @see shapes.ClosedFigure#getBounds()
	 */
	public Rectangle getBounds() {
		return thisCircle.getBounds();
	}

}
