import java.util.Random;
import javax.swing.*;

public class GuessingGame {

    public static void main(String[] args) {

        // Create GUI window
        JFrame frame = new JFrame("Guessing Game");
        frame.setUndecorated(true);
        frame.setType(JFrame.Type.UTILITY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Generate random number
        Random rand = new Random();
        int number = rand.nextInt(100) + 1;


        // Initialize variables
        int guess = 0;
        int attempts = 0;

        // Loop until user guesses correctly
        while(guess != number) {

            // Get user input
            String input = JOptionPane.showInputDialog(frame, "Enter a number between 1 and 100", "Guessing Game", JOptionPane.QUESTION_MESSAGE);

            // Check if Cancel was clicked
            if (input == null || input.equals("cancel")) {
                System.exit(0);
            }

            try {
                guess = Integer.parseInt(input);
                if(guess < 1 || guess > 100) {
                    JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 100");
                    continue;
                }
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number between 1 and 100");
                continue;
            }

            // Check if guess is correct
            if(guess > number) {
                JOptionPane.showMessageDialog(null, "Lower!");
            } else if(guess < number) {
                JOptionPane.showMessageDialog(null, "Higher!");
            }

            // Increment attempt count
            attempts++;
        }
        // Show result
        JOptionPane.showMessageDialog(null, "You guessed it in " + attempts + " attempts!","Developed by Midhilesh", JOptionPane.INFORMATION_MESSAGE);
    }
}
