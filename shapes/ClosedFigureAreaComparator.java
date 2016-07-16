package shapes;

import java.util.Comparator;

/**
 * Compares two figures based on area where the result will be ascending order.
 * 
 * @author Mark Royer
 * 
 */
public class ClosedFigureAreaComparator implements Comparator<ClosedFigure> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(ClosedFigure first, ClosedFigure second) {

		int x1 = first.area();
		int x2 = second.area();

		if (x1 < x2) {
			return -1;
		} else if (x1 > x2) {
			return 1;
		} else {
			return 0;
		}
	}
}