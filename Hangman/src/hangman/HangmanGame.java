package hangman;

import java.util.Scanner; //Import scanner class to take input from user
import hangman.ConsoleColors; //Import ConsoleColors from hangman package to make output colourful

public class HangmanGame {
        
        //list of words for player to guess
	private static String[] words = {
                                         "train", "chocolate", "algorithm", "canada", "awesome", "water", 
                                         "mango", "wafer", "joker", "grandfather", "darwin", "america",
                                         "light", "laptop", "computer", "amazing", "adelaide", "river",
                                         "ocean", "car", "noodles", "bread", "pizza", "burger"};
	private static String word = words[(int) (Math.random() * words.length)]; //get length of the word to be guessed
	private static String lettersLine = new String(new char[word.length()]).replace("\0", "_"); //this variable hides the word with blankspaces and reveals as the game progresses
	private static int count = 0; //declared a counter to count the wrong guesses of player

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
                
                message("Hello, welcome to the Hangman Game. Let's play...");
                message("\nThe number of letters in this word are "+word.length());
                message(ConsoleColors.ANSI_RED + "You have 6 player lives to attempt a wrong guess.");

		while (count < 6 && lettersLine.contains("_")) {
			message("\nPlease guess a character of the word");
			message(ConsoleColors.ANSI_BLUE + lettersLine); //print the word either hidden or reveals gradually as the game progresses
			String guessWord = sc.next(); //take guessed character from the user
			checkCharacter(guessWord); //pass the guessed character as an argument to validate it
		}
		sc.close(); //scanner object closed
	}

        //method to check whether the guessed character is right or wrong
	public static void checkCharacter(String guessWord) {
		String newlettersLine = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guessWord.charAt(0)) {
				newlettersLine += guessWord.charAt(0); //reveals characters if guessed character is true
			} else if (lettersLine.charAt(i) != '_') {
				newlettersLine += word.charAt(i);
			} else {
				newlettersLine += "_";
			}
		}

		if (lettersLine.equals(newlettersLine)) {
			count++; //increase counter if wrong guessed
			deductLife(); //call the method to deduct life when wrong guessed
		} else {
			lettersLine = newlettersLine; //updates the lettersLine
		}
                //when guessed the whole word correctly, print the following message
		if (lettersLine.equals(word)) {
			message(ConsoleColors.ANSI_BLUE + "Woohoo..! You guessed the word correctly. You won! The word was \"" + word+"\"");
		}
	}

        //function containing if else conditions to print relevant messages according to the life remainging
	public static void deductLife() {
		if (count == 1) {
			message(ConsoleColors.ANSI_RED + "Oops...! You have made a wrong guess, please try another letter");
			message(ConsoleColors.ANSI_RED + "Player Life Remaining: 5");
		}
		if (count == 2) {
			message(ConsoleColors.ANSI_RED + "Oops...! You have made a wrong guess, please try another letter");
			message(ConsoleColors.ANSI_RED + "Player Life Remaining: 4");
		}
		if (count == 3) {
			message(ConsoleColors.ANSI_RED + "Oops...! You have made a wrong guess, please try another letter");
			message(ConsoleColors.ANSI_RED + "Player Life Remaining: 3");
		}
		if (count == 4) {
			message(ConsoleColors.ANSI_RED + "Oops...! You have made a wrong guess, please try another letter");
			message(ConsoleColors.ANSI_RED + "Player Life Remaining: 2");
		}
		if (count == 5) {
			message(ConsoleColors.ANSI_RED + "Oops...! You have made a wrong guess, please try another letter");
			message(ConsoleColors.ANSI_RED + "Player Life Remaining: 1");
		}
		if (count == 6) {
			message(ConsoleColors.ANSI_RED + "The game is over!");
			message(ConsoleColors.ANSI_RED + "Oh no...! Unfortunately you have lost the game. The word was \"" + word + "\". Better luck next time");
		}
	}

        //method to avoid repeated usage of System.out.println
    public static void message(String inputMessage)
        {
            System.out.println(inputMessage);
        }
}