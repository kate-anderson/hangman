package hangman12;

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

	public static String randomWord() {
		// read in the number of words in the words file
		ArrayList<String> arr = new ArrayList<String>();// create an array to contain the words
		try (BufferedReader br = new BufferedReader(new FileReader("words"))) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				arr.add(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Random randomGenerator = new Random();

		int index = randomGenerator.nextInt(arr.size());// pick a random order of the word
		String item = arr.get(index); // read a word from array of words

		return item;

	}

	public static int compare(char guess, String word) {
		// String word = randomWord();
		// find the index of the letter (neg number if it is not in the word)
		int position = word.indexOf(guess);
		return position;
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

	public static void drawBlank(String word) {
		// draw the blank base on the length of word
System.out.println("adb");
		int length = word.length();// length of the letter
		double x0 = -0.2;
		for (int i = 0; i < length; i++) {
			StdDraw.line(x0, 2.0, x0 + 0.2, 2.0);
			x0 += 0.3;
		}
	}

	public static void drawLetter(int p, String c) {
		// StdDraw.text(-0.15, 2.1, "V"); // write the letter on the screen
		StdDraw.text(-0.1 + 0.3 * p, 2.1, c);
		// Font stringFont = new Font( "SansSerif", Font.PLAIN, 44);
		// StdDraw.setFont(SansSerif);
	}
}
