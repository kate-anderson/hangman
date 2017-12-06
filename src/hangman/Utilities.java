package hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.awt.Font;

import edu.princeton.cs.introcs.*;

public class Utilities {
	public static String word;
	public static String asterisk; 
	
	//get all indedcies off chracter c in string w, for example "summer" and "m"
	public static ArrayList<Integer> getAllIndexes(String w, String c) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		int index = w.indexOf(c); 

		while (index >= 0) { 

		    results.add(index);
		    index = w.indexOf(c, index + 1);
		    
		}
		return results;
	}
	public static void randomWord() {
		// read in the number of words in the words file
		ArrayList<String> arr = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader("words"))) { 
			String sCurrentLine; 
			while ((sCurrentLine = br.readLine()) != null) {
				arr.add(sCurrentLine); 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Random randomGenerator = new Random();

		int index = randomGenerator.nextInt(arr.size());
		word = arr.get(index); 
		asterisk = new String(new char[word.length()]).replaceAll("\0", "*"); 

	}

	// see if the guess is in the word
	public static void compare(String guess) {

		String newasterisk = "";
		System.out.println("asterisk = " + asterisk);
		
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess.charAt(0)) {
				newasterisk += guess.charAt(0);
			} else if (asterisk.charAt(i) != '*') {
				newasterisk += asterisk.charAt(i);
			} else {
				newasterisk += "*";
			}
		}
		if (asterisk.equals(newasterisk)) {
			Test.count++;
			hangman(Test.count);
		} else {
			// draw a letter
			int position = word.indexOf(guess.charAt(0));
			String charGuess = String.valueOf(guess.charAt(0));
			ArrayList<Integer> positions = getAllIndexes(word,charGuess);
			
//			drawLetter(position, charGuess );
			drawLetterArr(positions,charGuess);
			asterisk = newasterisk;
		}
		if (asterisk.equals(word)) {
			System.out.println("Correct! You win! The word was " + word);
		}
	}

	public static void initSketch() {
		// draw a hang and canvas
		StdDraw.setXscale(-0.5, +3.5);
		StdDraw.setYscale(-0.5, +3.0);
		StdDraw.setPenRadius(0.005);

		StdDraw.line(-0.3, -0.3, 0.2, -0.3);
		StdDraw.line(-0.05, -0.3, -0.05, 1.45);
		StdDraw.line(-0.05, 1.45, 0.65, 1.45);
		StdDraw.line(0.65, 1.45, 0.65, 1.35);
	}

	public static void hangman(int n) {
		if (n >= 1) {
			StdDraw.circle(0.65, 1.2875, 0.0625); // draw a head
		}
		if (n >= 2) {
			StdDraw.line(0.65, 1.225, 0.65, 1.1); // draw a kneck
		}
		if (n >= 3) {
			StdDraw.line(0.65, 1.1, 0.30, 0.85); // draw a hang
		}
		if (n >= 4) {
			StdDraw.line(0.65, 1.1, 1.0, 0.85); // draw a hang
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

	public static void drawBlank() {
		// draw the blank base on the length of word

		int length = word.length();// length of the letter
		double x0 = -0.2;
		for (int i = 0; i < length; i++) {
			StdDraw.line(x0, 2.0, x0 + 0.2, 2.0);
			x0 += 0.3;
		}
	}

	public static void drawLetterArr(ArrayList<Integer> posList, String c) {
		// StdDraw.text(-0.15, 2.1, "V"); // write the letter on the screen
		for (int i = 0; i < posList.size();i++) {
			StdDraw.text(-0.1 + 0.3 * posList.get(i), 2.1, c);
		}
		
	}
	

}
