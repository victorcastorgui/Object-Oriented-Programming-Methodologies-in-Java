package game;

//To import Scanner and Random
import java.util.*;

/**
 * A game in which the goal is for the user to guess a word
 * to save a ship from sinking. 
 * 
 * @author Foothill College, [VICTOR CASTOR]
 */
public class GuessOrSink
{
	private static final String[] wordsToGuess = {"great", "awesome", "computer", "bottle"};
	private static boolean[] wordsUsed = new boolean[wordsToGuess.length];
	private String wordInPlay;
	private char[] lettersGuessed;
	private int incorrectGuesses;
	private static final String asciiMast = "                 |         |         |\n";
	private static final String asciiSail = "              )____)    )____)    )____)\n";
	private static final String asciiConnect = "		 ________|_________|_________|_________\n";
	private static final String asciiBody = "         \\|_|VC|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|/\n";
	private static final String asciiWater = "^%^%^^^%^%%^%%^%^^^%^%%^%%^%^VC%^%%^%%^%^^^%^%%^%%^%^^^%^%^\n" +
			"^%^%^^^%^%%^%%^%^^^%^%%^%%^%^^^%^%%^%%^%^^^%^%%^%%^%^^^%^%^\n";

	public GuessOrSink()
	{
		// To generate random words from wordsToGuess
		Random randomWord = new Random();
		int randomIndex = randomWord.nextInt(wordsToGuess.length);
		while (wordsUsed[randomIndex])
		{
			randomIndex = randomWord.nextInt(wordsToGuess.length);
		}
		wordsUsed[randomIndex] = true;
		wordInPlay = wordsToGuess[randomIndex];
		// To show guessed letters
		lettersGuessed = new char[wordInPlay.length()];
		for (int i = 0; i < lettersGuessed.length; i++)
		{
			lettersGuessed[i] = '_';
		}
		incorrectGuesses = 0;
	}
	// To draw the ship
	public void drawShip(int incorrectGuesses)
	{
		int numOfSailRows = wordInPlay.length() - 2;
		String[] ship = new String[numOfSailRows + 10];
		ship[0] = asciiMast;
		for (int i = 1; i <= numOfSailRows; i++)
		{
			ship[i] = asciiSail;
		}
		ship[numOfSailRows + 1] = asciiConnect;
		ship[numOfSailRows + 2] = asciiBody;
		for (int i = 0; i <= numOfSailRows + 2 - incorrectGuesses; i++)
		{
			System.out.print(ship[i]);
		}
		System.out.print(asciiWater);
	}
	// Introduction of the game
	public void displayIntroduction()
	{
		System.out.println("Welcome to Guess or Sink!");
		drawShip(0);
		System.out.print("To save the ship from sinking, your job is to guess the" + " " + wordInPlay.length() + " " + "letter word: ");
		for (char p : lettersGuessed) System.out.print(p + " ");
		System.out.println();
		System.out.println("number incorrect = " + incorrectGuesses + " " + "word length = " + wordInPlay.length());
	}
	// To check the user has win or lose
	public void displayEnding(boolean winOrLose)
	{
		if (winOrLose)
		{
			System.out.println("You saved the day! The word is: " + wordInPlay);
			drawShip(0);
			System.out.println("Game Over");
		}
		else
		{
			System.out.println(asciiWater);
			System.out.println("The ship has sunk! The word is: " + wordInPlay);
			System.out.println("Game Over");
		}
	}

	public boolean playGame()
	{
		int userGuess = 0;
		boolean same;
		int count = wordInPlay.length();
		System.out.print('\n');
		boolean guesses;
		while (count !=0 && userGuess < wordInPlay.length() + 1)
		{
			userGuess++;
			guesses = false;
			same = false;
			System.out.println("Enter your guess #" + (userGuess));
			//To read users guesses.
			Scanner keyboard = new Scanner(System.in);
			char guess = keyboard.next().charAt(0);
			//To able the user to use Upper Case Letter
			guess = Character.toLowerCase(guess);
			for (int i = 0; i < lettersGuessed.length; i++)
			{
				if (guess == lettersGuessed[i])
				{
					same = true;
				}
			}
			//To let the user have one more guess
			if (userGuess <= (wordInPlay.length() + 1))
			{
				// EXTRA CREDIT
				if (same)
				{
					userGuess -=1;
					System.out.println("This letter has been guessed, please guess again: ");
					continue;
				}
				if (same == false)
				{
					for (int i = 0; i < wordInPlay.length(); i++)
					{
						if (guess == wordInPlay.charAt(i))
						{
							lettersGuessed[i] = guess;
							guesses = true;
							count--;
						}
					}
				}
				if (guesses == true)
				{
					System.out.println("Correct!");
					for (int j = 0; j < lettersGuessed.length; j++)
					{
						System.out.print(lettersGuessed[j] + " ");
					}
					System.out.println("\n");
				}
				else
				{
					//To print sinking ship.
					System.out.println("Incorrect guess!");
					incorrectGuesses++;
					drawShip(incorrectGuesses);
				}
				guesses = false;
				same = false;
			}
			else
			{
				break;
			}
		}

		// Keeps track of whether the user has won the current game.
		boolean gameWon = false;
		if (count == 0) gameWon = true;
		if (gameWon)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static void main(String[] args)
	{
		boolean playNewGame = true;
		while (playNewGame)
		{
			GuessOrSink game = new GuessOrSink();
			game.displayIntroduction();
			boolean temp = game.playGame();
			game.displayEnding(temp);
			boolean allGuessed = true;
			for (int i = 0; i < wordsToGuess.length; i++)
			{
				if (!wordsUsed[i]) allGuessed = false;
			}
			if (allGuessed) playNewGame = false;
			// To allow user to quit.
			System.out.println("Do you want to quit (enter q/quit) or play again (enter anything else)?");
			Scanner keyboard = new Scanner(System.in);
			String enter = keyboard.next();
			if (enter.equals("quit") || enter.equals("q"))
			{
				playNewGame = false;
				System.out.println("Thank you for playing!");
			}
			else
				// To show if there are no more words to guess.
				if (!playNewGame)
				{
					System.out.println("There are no more words to guess.");
					System.out.println("Thank you for playing!");
				}
		}
	}
}