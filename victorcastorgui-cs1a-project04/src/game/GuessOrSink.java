package game;

// imports the Scanner class to use for reading from System.in
import java.util.Scanner;

/**
 * A game in which the goal is for the user to guess a word
 * to save a ship from sinking. 
 * 
 * @author Foothill College, [Victor Castor]
 */
public class GuessOrSink 
{
	/**
	 * Stores a word for the user to guess. Then, prompts the user to enter 
	 * a single letter for their guess. Draws an ASCII representation of a 
	 * ship depending on whether the user guessed correctly.
	 * @param args    not used
	 */
	public static void main(String[] args) 
	{
		String word = "cool";
		char Letter1 = 'c';
		char Letter2 = 'o';
		char Letter3 = 'o';
		char Letter4 = 'l';


		String s1 = "                               <|\n";
		String s2 = "                    __'__     __'__      __'__\n";
		String s3 = "                   /    /    /    /     /    /\n";
		String s4 = "                  /\\____\\    \\____\\     \\____\\\n";
		String s5 = "                 / ___!___   ___!___    ___!___\n";
		String s6 = "               // (      (  (      (   (      (\n";
		String s7 = "             / /   \\______\\  \\______\\   \\______\\\n";
		String s8 = "           /  /   ____!_____ ___!______ ____!_____\n";
		String s9 = "         /   /   /         //         //         /\n";
		String s10 = "      /    /   |  VC     ||         ||         |\n";
		String s11 = "     /_____/     \\         \\\\         \\\\         \\\n";
		String s12 = "           \\      \\_________\\\\_________\\\\_________\\\n";
		String s13 = "            \\         |          |         |\n";
		String s14 = "             \\________!__________!_________!________/\n";
		String s15 = "              \\|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_/|\n";
		String s16 = "               \\    _______________                /\n";
		String fullship = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10 + s11 + s12 + s13 + s14 + s15 + s16;
		String halfship = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10;
		String twothirdship = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10 + s11 + s12 + s13;
		String onethirdship = s1 + s2 + s3 + s4 + s5 + s6;
		String onefourthship = s1 + s2 + s3;
		String w1 = "^^^%%%^%^^^%^%%^\\_\"/_)/_)_/_)__)/_)/)/)_)_\"_'_\"_//)/)/)/)%%%^^^%^^%%%%^\n";
		String w2 = "^!!^^\"!%%!^^^!^^^!!^^^%%%%%!!!!^^^%%^^^!!%%%%^^^!!!!!!%%%^^^^%^^%%%^^^!\n";
		String water = w1 + w2 + w1 + w2 + w1;

		int guessNumber;
		int correctGuessesNeeded = 3;
		int wrong_guess = 0;
		System.out.println("Welcome to Guess or Sink!");
		System.out.println(fullship + water);
		System.out.println("To save the ship from sinking, your job is to guess the 4 letter word: _ _ _ _");
		System.out.println("You have 5 guesses.");
		boolean guessedNumberone = false, guessedNumbertwo = false, guessedNumberthree = false, guessedNumberfour = false;
		// NOTES: used for loop
		for (guessNumber = 0; guessNumber < 5; guessNumber = guessNumber+1)
		{
			System.out.println("Enter your guess #"+ (guessNumber+1)  + ":");
			Scanner keyboard = new Scanner(System.in);
			char guess1 = keyboard.next().charAt(0);
			// NOTES: to able the user to use upper and lower case
			guess1 = Character.toLowerCase(guess1);
			if (guess1 == Letter1 || guess1 == Letter2 || guess1 == Letter3 || guess1 == Letter4)
			{
				System.out.println("Correct!");
				correctGuessesNeeded--;
				if (guess1==Letter1) guessedNumberone = true;
				if (guess1==Letter2) guessedNumbertwo = true;
				if (guess1==Letter3) guessedNumberthree = true;
				if (guess1==Letter4) guessedNumberfour = true;

			}
			else
			{
				wrong_guess++;
				System.out.println("Incorrect guess!");
				if (wrong_guess == 1)
				{
				System.out.println(twothirdship+water);
				}
				if (wrong_guess == 2)
				{
				System.out.println(halfship+water);
				}
				if (wrong_guess == 3)
				{
				System.out.println(onethirdship+water);
				}
				if (wrong_guess == 4)
				{
				System.out.println(onefourthship+water);
				}
				if (wrong_guess == 5)
				{
				System.out.println(water);
				}

			}

			// NOTES: For extra credit show updated word as the user makes correct guesses.
			if (guessedNumberone) System.out.print(Letter1);
			else System.out.print("_");
			if (guessedNumbertwo) System.out.print(Letter2);
			else System.out.print("_");
			if (guessedNumberthree) System.out.print(Letter3);
			else System.out.print("_");
			if (guessedNumberfour) System.out.println(Letter4);
			else System.out.println("_");


			if (guessedNumberone && guessedNumbertwo && guessedNumberthree && guessedNumberfour && correctGuessesNeeded<=0)
			{
				guessNumber = 5;
				System.out.println("You saved the day. " + "The word is: " + word);
				System.out.println(fullship+water);
			}
		}
		System.out.println("The word is: " + word);
		System.out.println("Game Over");
	}
}

