import java.awt.*;
import javax.swing.*;


public class Canvas extends JFrame {
	
	public Canvas(Game game){
		
		JPanel panel = new JPanel(new BorderLayout());
		
		JTextField test = new JTextField();
		test.setText("Test");
		panel.add(test, BorderLayout.NORTH);

		add(panel);
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Reygate de la mort!");
		setSize(800,600);
		setVisible(true);
	}

}
