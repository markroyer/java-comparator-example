package shapes;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Representation of a circle that is filled with a color.
 * 
 * @author Mark Royer
 * 
 */
public class ColoredCircle extends Circle {

	/**
	 * The color of the interior of this circle.
	 */
	private Color c;

	/**
	 * Create a new circle with the given radius that is filled with the given
	 * color.
	 * 
	 * @param radius
	 *            The size of this circle's radius
	 * @param color
	 *            The interior color of the circle
	 */
	public ColoredCircle(int radius, Color color) {
		super(radius);
		c = color;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see shapes.Circle#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (obj instanceof ColoredCircle)
			return super.equals(obj) && c == ((ColoredCircle) obj).c;
		else
			return false;
	}

	/**
	 * @return The interior color of this circle
	 */
	public Color color() {
		return c;
	}

	/* (non-Javadoc)
	 * @see shapes.Circle#toString()
	 */
	public String toString() {
		return "{ColoredCircle:" + location() + ", " + c + ", area=" + area()
				+ "}";
	}

	/* (non-Javadoc)
	 * @see shapes.Circle#draw(java.awt.Graphics2D)
	 */
	@Override
	public void draw(Graphics2D g) {
		g.setPaint(c);
		g.fill(thisCircle);
	}

}
