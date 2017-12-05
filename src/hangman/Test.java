package hangman1;

import java.util.Scanner;

import edu.princeton.cs.introcs.StdIn;
import hangman.Utilities;

public class Test {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
//		String reader = StdIn.readString();
		String word = Utilities.randomWord();
		int right = 0;
		int failure = 0;
		Utilities.initSketch(); //draw the hang
		Utilities.drawBlank(word); //draw the blank
		while (right <= word.length() && failure <= 7) {	
			char guess = reader.next().charAt(0);
//			char guess = reader.charAt(0);
			// int p = word.indexOf(guess);
			int p = Utilities.compare(guess, word);
			if (p < 0) {	
				failure++;
				Utilities.hangman(failure);//draw a hangman
			}
			else {
				//draw a letter on screen
				Utilities.drawLetter(p, String.valueOf(guess));
				right++;	
			}
		}

	}

}
