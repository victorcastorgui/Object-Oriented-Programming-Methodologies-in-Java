package game;

// imports the Scanner class to use for reading from System.in
import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.sound.sampled.Line;
import java.util.Scanner;

/**
 * A game in which the goal is for the user to guess a the two letter
 * abbreviation of the fifty states. If the user guesses correctly the
 * application will show the ASCII representation of a ship. Otherwise,
 * it will show a sunken ship.
 * 
 * @author Foothill College, [VICTOR CASTOR]
 */
public class GuessOrSink 
{
	/**
	 * Stores a 2-letter word for the user to guess. Then, prompts the user to enter 
	 * a single letter for their guess. Draws an ASCII representation of a 
	 * ship depending on whether the user guessed correctly.
	 * @param args    not used
	 */
	public static void
		main(String[] args) {

		String word = "LA";

		boolean guessedFirstletter = false;
		boolean guessedSecondletter = false;
// Adopt ASCII Ship
		String s1 = "                               <|\n";
		String s2 = "                    __'__     __'__      __'__\n";
		String s3 = "                   /    /    /    /     /    /\n";
		String s4 = "                  /\\____\\    \\____\\     \\____\\\n";
		String s5 = "                 / ___!___   ___!___    ___!___\n";
		String s6 = "               // (      (  (      (   (      (\n";
		String s7 = "             / /   \\______\\  \\______\\   \\______\\\n";
		String s8 = "           /  /   ____!_____ ___!______ ____!_____\n";
		String s9 = "         /   /   /         //         //         /\n";
		String s10 = "      /    /   |         ||         ||         |\n";
		String s11 = "     /_____/     \\         \\\\         \\\\         \\\n";
		String s12 = "           \\      \\_________\\\\_________\\\\_________\\\n";
		String s13 = "            \\         |          |         |\n";
		String s14 = "             \\________!__________!_________!________/\n";
		String s15 = "              \\|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_/|\n";
		String s16 = "               \\    _______________                /\n";
		String fullship = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10 + s11 + s12 + s13 + s14 + s15 + s16;
		String halfship = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10;
		String w1 = "^^^%%%^%^^^%^%%^\\_\"/_)/_)_/_)__)/_)/)/)_)_\"_'_\"_//)/)/)/)%%%^^^%^^%%%%^\n";
		String w2 = "^!!^^\"!%%!^^^!^^^!!^^^%%%%%!!!!^^^%%^^^!!%%%%^^^!!!!!!%%%^^^^%^^%%%^^^!\n";
		String water = w1 + w2 + w1 + w2 + w1;

		char Letter1 = 'L';
		char Letter2 = 'A';

        System.out.println("Welcome to Guess or Sink!\n");
        System.out.println(fullship + water);

        System.out.println("To save the ship from sinking, your job is to guess the 2 letter word.");
        System.out.println("I'm thinking of my favorite state. What are the initials of the state? _ _ ");
        System.out.println("You have 2 guesses for each Letter.");

        System.out.println("Can you guess the first initial? Enter your first guess:");

        Scanner keyboard = new Scanner(System.in);

        char guess1 = keyboard.next().charAt(0);
// Enable Lower Case and Upper Case Letters
        if (Character.toLowerCase(guess1) == Character.toLowerCase(Letter1)) guessedFirstletter = true;
        if (guessedFirstletter==true)
        {
            System.out.println("Correct!");
            System.out.println("The first initial is: L_");
            System.out.println("Can you guess the second initial? Enter your first guess:");

            char guess3 = keyboard.next().charAt(0);
// Enable Lower Case and Upper Case Letters
            if (Character.toLowerCase(guess3) == Character.toLowerCase(Letter2)) guessedSecondletter = true;
            if (guessedSecondletter == true)
            {
                System.out.println("Correct!");
                System.out.println("The second initial is: _A");
                System.out.println("You saved the day.");
                System.out.println(fullship + water);
                System.out.println("The state is: " + word);
                System.out.println("Game over");
            }
            else
                System.out.println("Incorrect guess! Enter your second guess:");

            char guess4 = keyboard.next().charAt(0);
// Enable Lower Case and Upper Case Letters
            if (Character.toLowerCase(guess4) == Character.toLowerCase(Letter2)) guessedSecondletter = true;
            if (guessedSecondletter == true)
            {
                System.out.println("Correct!");
                System.out.println("The second initial is: _A");
                System.out.println("You saved the day");
                System.out.println(fullship + water);
                System.out.println("The state is: " + word);
                System.out.println("Game over");
            }
            else
                {
                System.out.println("Incorrect guess!");
                System.out.println("Oh no! You only save half of the ship");
                System.out.println(halfship + water);
                System.out.println("The state is: " + word);
                System.out.println("Game over");
            }
        }
        else
            {
            System.out.println("Incorrect guess! Enter your second guess:");

            char guess2 = keyboard.next().charAt(0);
// Enable Lower Case and Upper Case Letters
            if (Character.toLowerCase(guess2)==Character.toLowerCase(Letter1)) guessedFirstletter = true;
            if (guessedFirstletter==true)
            {
            System.out.println("Correct!");
            System.out.println("The first initial is: L_");
            System.out.println("Can you guess the second initial? Enter your first guess:");
            }
            else
            {
                System.out.println("Incorrect guess! Oh no the ship is sinking!");
            System.out.println(halfship + water);
            }
            System.out.println("Can you guess the second initial? Enter your first guess:");
            char guess3 = keyboard.next().charAt(0);
// Enable Lower Case and Upper Case Letters
            if (Character.toLowerCase(guess3)==Character.toLowerCase(Letter2)) guessedSecondletter = true;
            if (guessedSecondletter==true)
            {
            System.out.println("Correct!");
            System.out.println("The second initial is: _A");
            System.out.println("You saved the day.");
            System.out.println(fullship + water);
            System.out.println("The state is: " + word);
            System.out.println("Game over");
            }
            else
            System.out.println("Incorrect guess! Enter your second guess:");

            char guess4 = keyboard.next().charAt(0);
// Enable Lower Case and Upper Case Letters
            if (Character.toLowerCase(guess4)==Character.toLowerCase(Letter2)) guessedSecondletter = true;
            if (guessedSecondletter==true)
            {
            System.out.println("Correct!");
            System.out.println("The second initial is: _A");
            System.out.println("You saved the day but only half ship is saved.");
            System.out.println(halfship + water);
            System.out.println("The state is: " + word);
            System.out.println("Game over");
            }
            else
                {
            System.out.println("Incorrect guess!");
            System.out.println(water);
            System.out.println("The state is: " + word);
            System.out.println("Game over");
                }
            }
    }
}
