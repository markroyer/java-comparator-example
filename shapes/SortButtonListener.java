package shapes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;

/**
 * Listen for a mouse click and notify shape example that the figures should be
 * sorted using the comparator that this listener knows about.
 * 
 * @author Mark Royer
 * 
 */
public class SortButtonListener implements ActionListener {

	/**
	 * The comparator that will be used for sorting.
	 */
	private Comparator<ClosedFigure> c;

	/**
	 * The panel that contains the items to be sorted.
	 */
	private ShapesPanel s;

	/**
	 * Create an object that will listen for button clicks. When the button
	 * click occurs, the figures in the given panel will be sorted using the
	 * given comparator.
	 * 
	 * @param s
	 *            The panel containing the figures that will be sorted
	 * @param c
	 *            The comparator to use for sorting
	 */
	public SortButtonListener(ShapesPanel s, Comparator<ClosedFigure> c) {
		this.s = s;
		this.c = c;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		s.sort(c);
	}

}