import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class numguess extends JFrame implements ActionListener {
    private final JLabel promptLabel;
    private final JTextField guessField;
    private final JButton guessButton;
    private final JTextArea outputArea;
    private int num;
    private int numberOfTurns;

    public numguess() {
        super("Number Guessing Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        Random rand = new Random();
        num = rand.nextInt(100) + 1;
        numberOfTurns = 8;

        promptLabel = new JLabel("Guess a number between 1 and 100:");
        guessField = new JTextField(10);
        guessButton = new JButton("Guess!");
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        guessButton.addActionListener(this);

        add(promptLabel);
        add(guessField);
        add(guessButton);
        add(outputArea);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == guessButton) {
            int guess = Integer.parseInt(guessField.getText());
            if (guess < 1 || guess > 100) {
                outputArea.append("\nPlease enter a number between 1 and 100");
                guessField.setText("");
            }

            else if (guess == num) {
                outputArea.setText("Congrats! You got it in " + (8-numberOfTurns) + " guesses");
                guessButton.setEnabled(false);
            } else if (guess < num) {
                outputArea.append("\nYour guess is too low");
                numberOfTurns--;
                outputArea.append("\nYou have " + numberOfTurns + " guesses left");
            } else if (guess > num) {
                outputArea.append("\nYour guess is too high");
                numberOfTurns--;
                outputArea.append("\nYou have " + numberOfTurns + " guesses left");
            }

            if (numberOfTurns == 0 && guess != num) {
                outputArea.append("\n\nYou ran out of guesses... Better Luck Next Time!!!");
                outputArea.append("\nThe Number Is " + num);
                guessButton.setEnabled(false);
            }

            guessField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                numguess game = new numguess();
                game.setVisible(true);
            }
        });
    }
}
