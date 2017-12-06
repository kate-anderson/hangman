package hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import edu.princeton.cs.introcs.*;

public class Utilities {
	public static String word;
	public static String asterisk;
	
	/**
	 * pick a word from the file at random in order to start the game
	 */
	public static void randomWord() {
		// read in the number of words in the words file
		ArrayList<String> arr = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader("words"))){
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				arr.add(sCurrentLine);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		Random randomGenerator = new Random();
		
		int index = randomGenerator.nextInt(arr.size());
		word = arr.get(index); 
		asterisk = new String(new char[word.length()]).replaceAll("\0", "*");
	}
	
	/**
	 * set up the canvas and draw the stand
	 */
	public static void initSketch() {
		//draw a hang and canvas
		StdDraw.setXscale(-0.5, +3.5);
		StdDraw.setYscale(-0.5, +3.0);
		StdDraw.setPenRadius(0.005);
				
		StdDraw.line(-0.3, -0.3, 0.2, -0.3);
		StdDraw.line(-0.05, -0.3, -0.05, 1.45);
		StdDraw.line(-0.05, 1.45, 0.65, 1.45);
		StdDraw.line(0.65, 1.45, 0.65, 1.35);
	}

	/**
	 * draw the blanks to show the length of the word
	 */
	public static void drawBlank() {
		//draw the blank base on the length of word

		int length = word.length();//length of the letter
		double x0 = -0.2;
		for (int i = 0; i < length; i++) {
			StdDraw.line(x0, 2.0, x0 + 0.2, 2.0);
			x0+=0.3;
		}
	}
	
	/** 
	 * see if the guess is in the word
	 *  if not, call hangman
	 *  if it is, draw the letter in its position
	 *  this also checks to see if the user won the game
	 * @param guess
	 */
	public static void compare(String guess) {
		String newasterisk ="";
		System.out.println("asterisk = " + asterisk);
		
		for(int i=0; i<word.length(); i++) {
			if(word.charAt(i)== guess.charAt(0)) {
				newasterisk += guess.charAt(i);
			}
			else if(asterisk.charAt(i) != '*') {
				newasterisk += asterisk.charAt(i);
			}
			else {
				newasterisk += "*";
			}
		}
		if (asterisk.equals(newasterisk)) {
			Test.count++;
			hangman(Test.count);
		}
		else {
			// draw a letter
			int position = word.indexOf(guess.charAt(0));
			String charGuess = String.valueOf(guess.charAt(0));
			ArrayList<Integer> positions = getAllIndexes(word,charGuess);
			
			drawLetterArr(positions,charGuess);
			asterisk = newasterisk;
		}
		if (asterisk.equals(word)) {
			System.out.println("Correct! You win! The word was " + word);
		}
	}
	
	/**
	 * draw the hangman based on the number of wrong guesses
	 * @param n, number of wrong guesses that the user has made
	 */
	public static void hangman(int n) {
		if (n >= 1) {
			StdDraw.circle(0.65, 1.2875, 0.0625); // draw a head
		 }
		 if (n >= 2) {
			 StdDraw.line(0.65, 1.225, 0.65, 1.1); // draw a neck
		 }
		 if (n >= 3) {
			 StdDraw.line(0.65, 1.1, 0.30, 0.85); // draw an arm
		 }
		 if (n >= 4) {
			 StdDraw.line(0.65, 1.1, 1.0, 0.85); // draw an arm
		 }
		 if (n >= 5) {
			 StdDraw.line(0.65, 1.1, 0.65, 0.65); // draw a body
		 }
		 if (n >= 6) {
			 StdDraw.line(0.65, 0.65, 0.35, 0.125); // draw a leg
		 }
		 if (n >= 7) {
			 StdDraw.line(0.65, 0.65, 1.0, 0.125); // draw a leg
		 }
	}

	/**
	 * get all indexes of character c in string w, for example "summer" and "m"
	 * @param w, the word that the user is supposed to guess
	 * @param c, the letter that the user guessed
	 * @return results, and array of the location(s) of the guess in the word
	 */
	public static ArrayList<Integer> getAllIndexes(String w, String c) {
		ArrayList<Integer> results = new ArrayList<Integer>();
	 	int index = w.indexOf(c); 
	 
	 	while (index >= 0) { 
	 		results.add(index);
	 		index = w.indexOf(c, index + 1);   
	 	}
	 	return results;
	}
	
	/**
	 * draw the letter that has been guessed correctly in its' position(s)
	 * @param posList, the list of position(s) for the guess
	 * @param c, the users' guess
	 */
	public static void drawLetterArr(ArrayList<Integer> posList, String c) {
		//	StdDraw.text(-0.15, 2.1, "V"); // write the letter on the screen
		for (int i = 0; i < posList.size();i++) { 
			StdDraw.text(-0.1 + 0.3 * posList.get(i), 2.1, c);
		}
	}
}
