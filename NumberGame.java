package AWT.learning;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NumberGame extends Frame {

	static int num = (int) (Math.random() * 100) + 1;
	static int attempt = 0, guess_num, limit = 10;
	static double iqScore;

	Label header, result, Attempt, IQscore;
	TextField input;
	Button submit;

	public NumberGame() {
		// TODO Auto-generated constructor stub
		header = new Label("Enter the number you guess");
		input = new TextField();
		submit = new Button("Submit");
		result = new Label("result");
		Attempt = new Label(" ");
		IQscore = new Label(" ");

		header.setBounds(50, 50, 200, 30);
		input.setBounds(80, 100, 50, 20);
		submit.setBounds(80, 150, 50, 20);
		result.setBounds(20, 200, 400, 30);
		Attempt.setBounds(50, 250, 400, 30);
		IQscore.setBounds(50, 300, 400, 30);

		add(header);
		add(input);
		add(submit);
		add(result);
		add(Attempt);
		add(IQscore);

		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		submit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				guess_num = Integer.parseInt(input.getText());

				if (num == guess_num && attempt <= 10) {
					result.setText("Wow, you've guessed the correct number, you've won the match!");
					Attempt.setText("Attempt: " + String.valueOf(attempt));
					iqScore = 10 * (10 - attempt);
					IQscore.setText("IQscore: " + String.valueOf(iqScore) + "%");

				} else if (guess_num > num && attempt < 10) {
					result.setText("guess number is high ");
					attempt++;

				} else if (guess_num < num && attempt < 10) {
					result.setText("guess number is low ");
					attempt++;

				} else {
					result.setText("You reached the limit of attempt");

				}
			}
		});

		setLayout(null);
		setSize(400, 400);
		setVisible(true);
		setTitle("Number Game");

	}

	public static void main(String[] args) {
		new NumberGame();
	}
}
