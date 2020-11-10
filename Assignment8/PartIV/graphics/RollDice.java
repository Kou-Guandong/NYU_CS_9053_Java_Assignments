package graphics;

import javax.swing.JFrame;
import java.awt.*;

public class RollDice extends JFrame {

	
	public RollDice() {
	}

	public static void main(String[] args) {
		RollDice rollDice = new RollDice();

		ImagePanel panel = new ImagePanel("die.png");
		panel.setVisible(true);
	
	}
}
