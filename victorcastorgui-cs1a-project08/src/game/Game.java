package game;

// imports the Scanner class to use for reading from System.in
import java.util.Scanner;

/**
 * Enables the user to play a console game. Displays the number of wins.
 * 
 * @author Foothill College, [VICTOR CASTOR]
 */
public class Game 
{
	/**
	 * Displays a menu to the user where the user can choose to play a 
	 * console game. 
	 * @param args	not used
	 */
	public static void main(String[] args)
	{
		System.out.println("Welcome to CS1A console game!");
	
		// Stores user input menu selection.
		char selection;	
		
		// Reads from standard in.
		Scanner keyboard = new Scanner(System.in);
		
		// Keeps track of the number of games played.
		int numGamesPlayed = 0;
		
		// Keeps track of how many games the user has won.
		int score = 0;
		
		do 
		{
			printMenu();
			// Game.printMenu();
			
			// Parses the user input.
			String tmpInput = keyboard.next();
			selection = tmpInput.charAt(0);

			if (selection == '1')
			{			
				numGamesPlayed++;

				GuessOrSink shipGame;

				shipGame = new GuessOrSink();

				shipGame.displayIntroduction();

				shipGame.play();

				boolean win = shipGame.getWinStatus();

				shipGame.displayEnding();
				
				// Uses a ternary operator to update the score depending on if the user
				// has won or not. Alternatively you can write an if/else statement.
				score = win ? ++score: score;
				
				// Prints out the current score.
				System.out.println("Your current score is " + score);
			}
		} while (selection != 'q');
		
		System.out.println("Your score is " + score + " out of " + numGamesPlayed);
		System.out.println("Goodbye.");
	} // FUNCTION : main

	private static void printMenu()
	{
		System.out.println("What would you like to do?");
		System.out.println("     1. Play Guess or Sink\n" +
				"\t q. Quit");
		System.out.println("Enter your selection: ");
	}


}
