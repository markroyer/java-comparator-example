package shapes;

import static java.awt.Color.BLUE;
import static java.awt.Color.RED;

import java.awt.BorderLayout;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * A visual representation of a collection of figures. Can we add some
 * additional buttons that will sort the figures using comparators?
 * 
 * @author Mark Royer
 * 
 */
public class ShapesExample extends JPanel {

	/**
	 * For serializability
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Panel for the buttons.
	 */
	private JPanel buttonPanel;
	
	/**
	 * Panel to draw the shapes in.
	 */
	private ShapesPanel shapesPanel;
	
	/**
	 * Create a new panel with figures.
	 */
	public ShapesExample() {
		initialize();
		
		addButtons();

		createFigures();
		
		buttonPanel.setPreferredSize(shapesPanel.getPreferredSize());
		
	}


	/**
	 * Create a bunch of figures and add them to a list.
	 */
	private void createFigures() {

		shapesPanel.addShape(new ColoredCircle(30, RED));
		shapesPanel.addShape(new ColoredCircle(20, BLUE));
		shapesPanel.addShape(new Circle(40));
		shapesPanel.addShape(new Rectangle(50, 70));
		shapesPanel.addShape(new Rectangle(30, 30));

		// TODO add additional figures?
		
		shapesPanel.layoutShapes();
	}

	/**
	 * Add all the buttons to the panel.
	 */
	private void addButtons() {

		addButton("Sort ascending by Area", new ClosedFigureAreaComparator());
		addButton("Sort descending by Area",
				new ClosedFigureAreaComparatorDesc());
		
		// TODO add additional buttons here!
	}

	/**
	 * Create necessary back-end for the panel.
	 */
	private void initialize() {
		this.setLayout(new BorderLayout());

		buttonPanel = new JPanel();
		this.add(buttonPanel, BorderLayout.NORTH);
		
		shapesPanel = new ShapesPanel(20, 20);
		this.add(shapesPanel, BorderLayout.CENTER);
		
	}
	
	/**
	 * Add a button with the given label to the window. When the button is
	 * clicked, the button will sort the figures according to the given
	 * comparator.
	 * 
	 * @param label
	 *            The button's text
	 * @param c
	 *            The comparator that will be used when the button is pressed
	 */
	private void addButton(String label, Comparator<ClosedFigure> c) {
		JButton b = new JButton(label);
		b.addActionListener(new SortButtonListener(shapesPanel, c));
		buttonPanel.add(b);
	}


	/**
	 * @return The number of shapes to be displayed.
	 */
	public int shapesCount() {
		return shapesPanel.numberOfFigures();
	}



}
