package game;

import java.util.Random;
import java.util.Scanner;

public class GuessOrSink
{
    // Stores the words the user should guess
    private static final String[] WORDS_TO_GUESS = {"words", "letter", "friends", "elephant", "buzzkills", "blackjacks",
                                                    "crackerjack", "infrastructure", "i need sleep", "hello world"};
    private String wordInPlay;
    private char[] lettersGuessed;
    private Ship theShip;
    private boolean winStatus;
    private boolean gameInProgress;
    private int letters;
    public GuessOrSink()
    {
        // To generate random word
        Random randomWord = new Random();
        int randomIndex = randomWord.nextInt(WORDS_TO_GUESS.length);
        wordInPlay = WORDS_TO_GUESS[randomIndex];

        // To show guessed letters
        lettersGuessed = new char[wordInPlay.length()];
        for (int i = 0; i < lettersGuessed.length; i++)
        {
            if (wordInPlay.charAt(i)==' ')
            {
                lettersGuessed[i] = ' ';
            }
            else
            {
                lettersGuessed[i] = '_';
                letters++;
            }
        }
        winStatus = false;
        gameInProgress = true;

        // To call the ship from ship.java
        theShip = new Ship (wordInPlay.length()+2);
    }
    public void displayIntroduction()
    {
        if(gameInProgress == false)
        {
            displayEnding();
            return;
        }
        System.out.println("Let's play Guess or Sink!");
        System.out.print(theShip.toString());
        System.out.print("To save the ship from sinking, your job is to guess the " + letters + " letter word: ");
        for (int i = 0; i < lettersGuessed.length; i++)
        {
            System.out.print(lettersGuessed[i] + " ");
        }
        System.out.println();
    }

    public void play()
    {
        int userGuess = 0;
        boolean same;
        int count = letters;
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
            if (theShip.getIsAlive()==true)
            {
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
                    theShip.addHits();
                    System.out.println(theShip.toString());
                    if (theShip.getIsAlive()==false)
                        break;
                    for (int j = 0; j < lettersGuessed.length; j++)
                    {
                        System.out.print(lettersGuessed[j] + " ");
                    }
                    System.out.println("\n");
                }
            }
            else
            {
                break;
            }
        }

        // Keeps track of whether the user has won the current game.
        if (count == 0)
            winStatus = true;
        gameInProgress = false;
    }

    public boolean getWinStatus()
    {
        return winStatus;
    }

    public void displayEnding()
    {
        if (gameInProgress==true)
        {
            System.out.println("The game is still playing");
            return;
        }
        if (getWinStatus())
        {
            System.out.println("You saved the day! The word is: " + wordInPlay);
            System.out.println(theShip.toString());
        }
        System.out.println("Game Over");
    }
}
