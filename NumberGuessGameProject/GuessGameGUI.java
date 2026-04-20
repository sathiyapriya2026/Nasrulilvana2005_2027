import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GuessGameGUI {

    static int number = new Random().nextInt(100) + 1;
    static int attempts = 0;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Number Guess Game");
        frame.setSize(400,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel title = new JLabel("Number Guess Game");
        JTextField textField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        JButton restartButton = new JButton("Restart");

        JLabel result = new JLabel("Enter number between 1 - 100");
        JLabel attemptLabel = new JLabel("Attempts: 0");

        frame.add(title);
        frame.add(textField);
        frame.add(guessButton);
        frame.add(restartButton);
        frame.add(result);
        frame.add(attemptLabel);

        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int guess = Integer.parseInt(textField.getText());
                attempts++;

                if (guess < number) {
                    result.setText("Too Low!");
                }
                else if (guess > number) {
                    result.setText("Too High!");
                }
                else {
                    result.setText("Correct! You Win!");
                }

                attemptLabel.setText("Attempts: " + attempts);
            }
        });

        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                number = new Random().nextInt(100) + 1;
                attempts = 0;

                textField.setText("");
                result.setText("Game Restarted!");
                attemptLabel.setText("Attempts: 0");
            }
        });

        frame.setVisible(true);
    }
}