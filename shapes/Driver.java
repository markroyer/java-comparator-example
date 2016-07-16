package shapes;

import java.awt.Color;

import javax.swing.JFrame;

/**
 * A simple driver program to show how to use Comparator.
 */
public class Driver {

	public static void main(String[] args) {

		initWindow();
	}

	/**
	 * Initialize a window frame that we can paint in.
	 * 
	 */
	public static void initWindow() {

		ShapesExample panel = new ShapesExample();
		JFrame frame = new JFrame("Shapes Example");
		frame.setBackground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}