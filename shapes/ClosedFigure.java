package shapes;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * A representation of figures that have a well defined area and perimeter.
 * Java2D can draw this figure in some way.
 * 
 * @author Mark Royer
 * 
 */
public abstract class ClosedFigure {

	/**
	 * @param x
	 *            The x position of the closed figure
	 */
	public abstract void setX(int x);

	/**
	 * @param y
	 *            The y position of the closed figure
	 */
	public abstract void setY(int y);

	/**
	 * @return The x position of the closed figure
	 */
	public abstract int getX();

	/**
	 * @return The y position of the closed figure
	 */
	public abstract int getY();

	/**
	 * @return A string representation of the closed figure's location in the
	 *         form (x,y)
	 */
	public String location() {
		return "(" + getX() + "," + getY() + ")";
	}

	/**
	 * @return The mathematical perimeter of the closed figure
	 */
	public abstract int perimeter();

	/**
	 * @return The mathematical area of the closed figure
	 */
	public abstract int area();

	/**
	 * Draw the closed figure in the given graphics context.
	 * 
	 * @param g
	 *            The graphics context
	 */
	public abstract void draw(Graphics2D g);

	/**
	 * @return A rectangle that surrounds this closed figure.
	 */
	public abstract Rectangle getBounds();

}