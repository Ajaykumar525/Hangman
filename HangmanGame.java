import java.util.Random;
import java.util.Scanner;
public class HangmanGame {
	private static final String randomWord = generateRandomWord(10);
	private static String lettersLine = new String(new char[randomWord.length()]).replace("\0", "-");
	private static int count = 0;
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (count < 7 && lettersLine.contains("-")) {
			message("Guess any letter in the word");
			message(lettersLine);
			String guessWord = s.next();
			hangCharachter(guessWord);
		}
		s.close();
	}
	public static void hangCharachter(String guessWord) {
		String newLettersLine = "";
		for (int i = 0; i < randomWord.length(); i++) {
			if (randomWord.charAt(i) == guessWord.charAt(0)) {
				newLettersLine += guessWord.charAt(0);
			} else if (lettersLine.charAt(i) != '*') {
				newLettersLine += randomWord.charAt(i);
			} else {
				newLettersLine += "*";
			}
		}
		if (lettersLine.equals(newLettersLine)) {
			count++;
			hangmanLife();
		} else {
			lettersLine = newLettersLine;
		}
		if (lettersLine.equals(randomWord)) {
			message("Congratulations! you guessed the right word. You win! The word was " + randomWord);
		}
	}
	public static void hangmanLife() {
		if (count == 1) {
			message("Wrong guess, try again");
			message("Player Life Remaining: 10");
		}
		if (count == 2) {
			message("Wrong guess, try again");
			message("Player Life Remaining: 8");
		}
		if (count == 3) {
			message("Wrong guess, try again");
			message("Player Life Remaining: 6");
		}
		if (count == 4) {
			message("Wrong guess, try again");
			message("Player Life Remaining: 4");
		}
		if (count == 5) {
			message("Wrong guess, try again");
			message("Player Life Remaining: 2");
		}
		if (count == 6) {
			message("Wrong guess, try again");
			message("Player Life Remaining: 1");
		}
		if (count == 7) {
			message("Game Over!");
			message("Player Hanged");
		}
	}
        public static String generateRandomWord(int wordLength) {
                Random r = new Random();
                StringBuilder sb = new StringBuilder(wordLength);
                for(int i = 0; i < wordLength; i++) { 
                    char tmp = (char) ('a' + r.nextInt('z' - 'a'));
                    sb.append(tmp); 
                }
                return sb.toString();
        }
        public static void message(String inputMessage)
        {
            System.out.println(inputMessage);
        }
