package game;

import java.util.*;

/**
 * Program called GuessOrSink game to submit to GitHub repository.
 * Program is build on top of Programming Assignment #5.
 *
 * @author Foothill College, [VICTOR CASTOR]
 */
public class GuessOrSink
{
	/**
	 * Generating random words from the Array to let user guess the correct letter.
	 * Enabling user to continue game or stop the game.
	 *
	 * @param args not used
	 */

	public static void main(String[] args)
	{
		// To repeat the game if the user does not quit.
		boolean playNewGame = true;
		boolean[] usedWords = new boolean[5];
		//To end the game after all words are guessed.
		int noMore = 0;
		while (playNewGame)
		{
			noMore+=1;
			if (noMore==5) playNewGame=false;
			String[] wordsToGuess = {"taken", "broken", "remotes", "november", "fishing"};

			//To store the word the user should guess.
			Random randomWord = new Random();
			int randomIndex = randomWord.nextInt(5);
			while (usedWords[randomIndex] == true)
			{
				randomIndex = randomWord.nextInt(5);
			}
			usedWords[randomIndex] = true;
			String word = wordsToGuess[randomIndex];
			int letterLength = word.length();

			String mast = "                 |         |         |\n";
			String sailRow = "              )____)    )____)    )____)\n";
			String connect = "		 ________|_________|_________|_________\n";
			String body = "         \\|_|VC|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|/\n";
			String water = "^%^%^^^%^%%^%%^%^^^%^%%^%%^%^VC%^%%^%%^%^^^%^%%^%%^%^^^%^%^\n" +
					"^%^%^^^%^%%^%%^%^^^%^%%^%%^%^^^%^%%^%%^%^^^%^%%^%%^%^^^%^%^\n";
			int numOfSailRows = letterLength;
			String[] ship = new String[1000];
			ship[0] = mast;
			//To add the number of SailRows depends on the the number of the letter.
			for (int i = 1; i <= numOfSailRows; i++)
			{
				ship[i] = sailRow;
			}
			ship[numOfSailRows + 1] = connect;
			ship[numOfSailRows + 2] = body;
			System.out.println("Welcome to Guess or Sink!");
			int sailCount = numOfSailRows + 2;
			int sinkCount = numOfSailRows + 2;
			for (int i = 0; i <= sailCount; i++)
			{
				System.out.print(ship[i]);
			}
			System.out.println(water);
			//To keep track of the letters that the user has guessed.
			char[] lettersGuessed = new char[word.length()];
			for (int i = 0; i < lettersGuessed.length; i++)
			{
				lettersGuessed[i] = '_';
			}

			System.out.print("To save the ship from sinking, your job is to guess the " + word.length() + " letter word: ");
			for (int i = 0; i < lettersGuessed.length; i++)
			{
				System.out.print(lettersGuessed[i] + " ");
			}
			int userGuess = 0;
			boolean same = false;
			int count = letterLength;
			System.out.print('\n');
			boolean guessedLetter = false;
			while (count != 0)
			{
				userGuess++;
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
				if (userGuess <= (letterLength + 1))
				{
					if (same == false)
					{
						for (int i = 0; i < letterLength; i++)
						{
							if (guess == word.charAt(i))
							{
								lettersGuessed[i] = guess;
								guessedLetter = true;
								count--;
							}
						}
					}
					if (guessedLetter == true)
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
						sinkCount--;
						for (int m = 0; m < sinkCount; m++)
						{
							System.out.print(ship[m]);
						}
						System.out.println(water);
						}
					guessedLetter = false;
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
			//To print out saved ship.
			if (gameWon)
			{
				System.out.println("You saved the day! The word is: " + word);
				for (int i = 0; i <= sailCount; i++)
				{
					System.out.print(ship[i]);
				}
				System.out.println(water);
			}
			//To print sunk ship.
			else
			{
				System.out.println("The ship has sunk! The word is: " + word);
				System.out.println(water);
			}
			System.out.println("Game Over");

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
			// Extra Credit
			if (playNewGame==false)
			{
				System.out.println("There are no more words to guess.");
				System.out.println("Thank you for playing!");
			}
		}
	}
}