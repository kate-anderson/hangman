package hangman;

import edu.princeton.cs.introcs.*;

public class Utilities {

	public static String randomWord(String[] args) {
		// read in the number of words in the words file
		int numWords = StdIn.readInt();
		
		// pick a random word out of the file
		int r = (int)(Math.random()*(numWords-1));
		String word = Files.readAllLines(Paths.get("words.txt")).get(r);
			// pick a random number 0 to numWords-1
			// get that word from the file
		return word;
	}
	
	public static void compare(char guess) {
		String word = randomWord();
		//find the index of the letter (neg number if it is not in the word)
		int position = word.indexOf(guess);
		if(position<0) {
			// draw part of the man
		}
	}
	public static void hangman(String[] args) {
		StdDraw.setXscale(-0.5, +2.5);
	StdDraw.setYscale(-0.5, +2.5);
	StdDraw.setPenRadius(0.005);
	
	StdDraw.line(-0.3, -0.3, 0.2, -0.3);
	StdDraw.line(-0.05, -0.3, -0.05, 1.45);
	StdDraw.line(-0.05, 1.45, 0.65, 1.45);
	StdDraw.line(0.65, 1.45, 0.65,1.35);
// draw a hangman
	StdDraw.circle(0.65, 1.2875, 0.0625);
	StdDraw.line(0.65, 1.225, 0.65, 1.1);
	StdDraw.line(0.65, 1.1, 0.30, 0.85);
	StdDraw.line(0.65, 1.1, 1.0, 0.85);
	StdDraw.line(0.65, 1.1, 0.65, 0.65);
	StdDraw.line(0.65, 0.65, 0.35, 0.125);
	StdDraw.line(0.65, 0.65, 1.0, 0.125);
	// draw a line to fill out the letters: for example vacation
	StdDraw.line(-0.3, 2.0, 0.0, 2.0);
	StdDraw.line(0.2, 2.0, 0.5, 2.0);
	StdDraw.line(0.7, 2.0, 1.0, 2.0);
	StdDraw.line(1.2, 2.0, 1.5, 2.0);
	StdDraw.line(1.7, 2.0, 2.0, 2.0);
	StdDraw.line(0.2, 1.55, 0.5, 1.55);
	StdDraw.line(0.7, 1.55, 1.0, 1.55);
	StdDraw.line(1.2, 1.55, 1.5, 1.55);
	}


}
