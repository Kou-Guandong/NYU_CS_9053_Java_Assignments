package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RollDice extends JFrame {

	private static final long serialVersionUID = 9158824910956861673L;
	private ImagePanel img1JPanel;
	private ImagePanel img2JPanel;
	private JLabel resultJLabel;
	private JPanel dicesPanel;
	private JPanel resultPanel;
	private JPanel buttonPanel;
	private JPanel wrapperPanel;
	private int dice1 = 1;
	private int dice2 = 1;
	private int result = 2;

	public static int getRollNumber() {
		return (int) (Math.random() * 6) + 1;
	}

	public void initView() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.LIGHT_GRAY);
		wrapperPanel = new JPanel(new BorderLayout());
		dicesPanel = new JPanel(new GridLayout(1, 2));

		resultPanel = new JPanel();
		resultJLabel = new JLabel();
		resultPanel.add(resultJLabel);

		this.repaint();

		buttonPanel = new JPanel();
		JButton rollButton = new JButton("Roll Dice");
		rollButton.addActionListener((e) -> {
			this.rollNthDice(1);
			this.rollNthDice(2);
			this.repaint();
		});
		buttonPanel.add(rollButton);
		wrapperPanel.add(dicesPanel, BorderLayout.NORTH);
		wrapperPanel.add(resultPanel, BorderLayout.CENTER);
		wrapperPanel.add(buttonPanel, BorderLayout.SOUTH);

		this.add(wrapperPanel);
		this.setSize(600, 400);
		this.setVisible(true);
	}

	private void rollNthDice(int diceIndex) {
		if (diceIndex == 1) {
			this.dice1 = getRollNumber();
		} else if (diceIndex == 2) {
			this.dice2 = getRollNumber();
		}
	}

	public ImagePanel getDiceImage(int number, int diceIndex) {
		ImagePanel img = new ImagePanel("PartIV/die" + number + ".png");
		img.addMouseListener(new DiceListener(diceIndex));
		return img;
	}

	public void repaint() {
		this.result = dice1 + dice2;
		resultJLabel.setText("Result: " + this.result);
		dicesPanel.removeAll();
		img1JPanel = getDiceImage(dice1, 1);
		img2JPanel = getDiceImage(dice2, 2);
		dicesPanel.add(img1JPanel);
		dicesPanel.add(img2JPanel);
	}

	class DiceListener extends MouseAdapter {
		private int diceIndex;

		public DiceListener() {
			super();
		}

		public DiceListener(int dice) {
			super();
			diceIndex = dice;
		}

		@Override
		public void mouseClicked(MouseEvent event) {
			rollNthDice(diceIndex);
			RollDice.this.repaint();
		}
	}

	public RollDice() {
		this.initView();
	}

	public static void main(String[] args) {
		RollDice rollDice = new RollDice();

	}
}
