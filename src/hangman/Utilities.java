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

}
