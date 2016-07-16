package shapes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 * A panel for displaying shapes.
 * 
 * @author Mark Royer
 * 
 */
public class ShapesPanel extends JPanel {

	/**
	 * For serializable.
	 */
	private static final long serialVersionUID = -3022064336837761943L;

	/**
	 * All of the figures in the panel
	 */
	private List<ClosedFigure> figures;

	/**
	 * Largest figure width.
	 */
	private int maxFigureWidth;

	/**
	 * Largest figure height.
	 */
	private int maxFigureHeight;

	/**
	 * The amount of horizontal padding between shapes.
	 */
	private int hPadding;

	/**
	 * The amount of vertical padding between shapes.
	 */
	private int vPadding;

	/**
	 * We use a swing worker to perform the sorting and the animation.
	 */
	private SwingWorker<List<ClosedFigure>, Void> activeDrawingThread;

	/**
	 * Create a panel for displaying shapes
	 * 
	 * @param hPadding
	 *            The horizontal padding between shapes.
	 * @param vPadding
	 *            The vertical padding between the shapes and the panel's
	 *            border.
	 */
	public ShapesPanel(int hPadding, int vPadding) {
		figures = new ArrayList<ClosedFigure>();
		this.hPadding = hPadding;
		this.vPadding = vPadding;
	}

	/**
	 * Add a shape to be displayed in the panel.
	 * 
	 * @param shape
	 *            The shape to be added to the panel. (Not null)
	 */
	public void addShape(ClosedFigure shape) {
		figures.add(shape);

		shape.setY(vPadding);

		Rectangle r = shape.getBounds();

		if (r.width > maxFigureWidth) {
			maxFigureWidth = r.width;
		}
		if (r.height > maxFigureHeight) {
			maxFigureHeight = r.height;
		}

		setPreferredSize(new Dimension(figures.size() * maxFigureWidth
				+ (figures.size() + 1) * hPadding, maxFigureHeight + vPadding
				* 2));

	}

	/**
	 * Sort the figures using the given comparator
	 * 
	 * @param c
	 *            The comparator that will be used by the sorting algorithm the
	 *            figures
	 */
	public void sort(final Comparator<ClosedFigure> c) {
		// If the previous action is still going let it finish and don't do
		// anything.
		if (activeDrawingThread != null && !activeDrawingThread.isDone()) {
			return;
		}

		activeDrawingThread = new SwingWorker<List<ClosedFigure>, Void>() {

			@Override
			protected List<ClosedFigure> doInBackground() throws Exception {

				Collections.sort(figures, c);

				boolean done = false;
				// Continue to adjust the position of the figures while they are
				// not in
				// there proper spot.
				while (!done) {
					done = adjustFigures();
					sleep();
					repaint();
				}

				return figures;
			}

		};

		activeDrawingThread.execute();

	}

	/**
	 * Rest the program for .03 seconds
	 */
	private void sleep() {
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * Returns true iff figures were moved
	 * 
	 * @return true iff all the figures are in their final positions
	 */
	private boolean adjustFigures() {
		boolean done = true;
		ClosedFigure f;
		int curX;
		int amntToMove = 5;

		// look at each figure and move it to its proper position if it's not in
		// it.
		for (int i = 0; i < figures.size(); i++) {
			f = figures.get(i);

			// Location the figure should end at
			int loc = i * maxFigureWidth + (i + 1) * hPadding;

			curX = f.getX();
			if (curX > loc) {
				f.setX(curX - amntToMove);
				done = false;
			} else if (curX < loc) {
				f.setX(curX + amntToMove);
				done = false;
			}
		}
		return done;
	}

	/**
	 * Draw all the figures
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		Graphics2D g2d = (Graphics2D) g;

		for (ClosedFigure f : figures) {
			f.draw(g2d);
		}

	}

	/**
	 * @return The number of figures that are in the panel
	 */
	public int numberOfFigures() {
		return figures.size();
	}

	/**
	 * Spread out the shapes in a 'nice' way using their current order.
	 */
	public void layoutShapes() {
		for (int i = 0; i < figures.size(); i++) {
			figures.get(i).setX(i * maxFigureWidth + (i + 1) * hPadding);
		}
	}
}
