package game;

import java.util.Scanner; //To import Scanner

/**
 * Program called GuessOrSink game to submit to GitHub repository.
 * @author Foothill College, [VICTOR CASTOR]
 */
public class GuessOrSink 
{
	/**
	 * Allows user to guess and outputs the word my program is thinking of.
	 * Used method for loop and while loop.
	 * @param args    not used
	 */
	public static void main(String[] args)
	{
		String[] wordsToGuess = {"taken", "broken", "remotes", "november", "fishing"};
		//To store the word the user should guess.
		String word = wordsToGuess[4];
		int letterlength = word.length();

		String mast =    "                 |         |         |\n";
		String sailrow = "              )____)    )____)    )____)\n";
		String connect = "		 ________|_________|_________|_________\n";
		String body =    "         \\|_|VC|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|/\n";
		String water =   "^%^%^^^%^%%^%%^%^^^%^%%^%%^%^VC%^%%^%%^%^^^%^%%^%%^%^^^%^%^\n" +
				"^%^%^^^%^%%^%%^%^^^%^%%^%%^%^^^%^%%^%%^%^^^%^%%^%%^%^^^%^%^\n";
		int numOfSailRows = letterlength-1;
		String[] ship = new String [9];
		ship[0] = mast;
		//To add the number of SailRows depends on the the number of the letter.
		for (int i = 1; i <= numOfSailRows; i++)
		{
			ship[i] = sailrow;
		}
		ship[numOfSailRows + 1] = connect;
		ship[numOfSailRows + 2] = body;
		System.out.println("Welcome to Guess or Sink!");
		int sailcount = numOfSailRows + 2;
		int sinkcount = numOfSailRows + 2;
		for (int i = 0; i <= sailcount; i++)
		{
			System.out.print(ship[i]);
		}
		System.out.println(water);
		char[] lettersGuessed = new char [word.length()];
		//To keep track of the letters that the user has guessed.
		for (int i = 0; i < lettersGuessed.length; i++)
		{
			lettersGuessed[i] = '_';
		}
		System.out.print("To save the ship from sinking, your job is to guess the " + word.length() + " letter word: ");
		for(int i = 0; i < lettersGuessed.length; i++)
		{
			System.out.print(lettersGuessed[i] + " ");
		}
		int userguess = 0;
		boolean same = false;
		int count = letterlength;
		System.out.print('\n');
		boolean guessedLetter = false;
		while(count != 0)
		{
			userguess++;
			System.out.println("Enter your guess #" + (userguess));
			//To read users guesses.
			Scanner keyboard = new Scanner(System.in);
			char guess = keyboard.next().charAt(0);
			//To able the user to use Upper Case Letter
			guess = Character.toLowerCase(guess);
			for(int i = 0; i < lettersGuessed.length; i++)
			{
				if(guess == lettersGuessed[i])
				{
					same = true;
				}
			}
			//To let the user have one more guess
			if(userguess < (letterlength + 1))
			{
				if(same == false)
				{
					for (int i = 0; i < letterlength; i++)
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
					sinkcount--;
					for (int k = 0; k < sinkcount; k++)
					{
						System.out.print(ship[k]);
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
		//To print out saved ship.
		if(count == 0)
		{
			System.out.println("You saved the day! The word is: " + word);
			for (int i = 0; i <= sailcount; i++)
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
	}
}