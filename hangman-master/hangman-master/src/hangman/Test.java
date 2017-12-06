package hangman;

import java.util.Scanner;
import edu.princeton.cs.introcs.StdIn;
import hangman.Utilities;

public class Test {
	public static int count = 0;

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		/**
		 * pick a word from the file at random in order to start the game
		 * 
		 * This method picks the word that the user will be guessing from the
		 * words file and saves it to an instance variable. It also creates
		 * a string of * the same length of the word and saves it to the
		 * asterisk instance variable.
		 */
		Utilities.randomWord(); //pick a word
		/**
		 * set up the canvas and draw the stand
		 * 
		 * This method initializes the drawing canvas so that the hanman can
		 * be drawn when the user guesses wrong. It also draws the stand.
		 */
		Utilities.initSketch(); //draw the hang
		/**
		 * draw the blanks to show the length of the word
		 * 
		 * Here the blanks are drawn over the hangman to show the length of the
		 * word. This makes it easier for users to see how they are doing.
		 */
		Utilities.drawBlank(); //draw the blank
		
		while (count < 7 && Utilities.asterisk.contains("*")) {
			System.out.println("Guess a letter:");
			System.out.println(Utilities.asterisk);
			String guess = reader.next();
			/** 
			 * see if the guess is in the word
			 *  if not, call hangman (a method that draws the hangman to show a 
			 *  wrong guess)
			 *  if it is, draw the letter in its position (call getAllIndexes to
			 *  find the position(s) of the letter that was guessed then call 
			 *  drawLetterArr to draw the letter in that position on the canvas)
			 *  
			 *  this also checks to see if the user won the game
			 * @param guess
			 */
			Utilities.compare(guess);
		}
		reader.close();
	}

}
