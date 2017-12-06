package hangman;

import java.util.Scanner;
import edu.princeton.cs.introcs.StdIn;
import hangman.Utilities;

public class Test {
	public static int count=0;

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		Utilities.randomWord(); //pick a word
		
		
		Utilities.initSketch(); //draw the hang
		//Utilities.drawBlank(word); //draw the blank
		
		while (count<7 && Utilities.asterisk.contains("*")) {
			System.out.println("Guess a letter:");
			System.out.println(Utilities.asterisk);
			String guess = reader.next();
			Utilities.compare(guess);
		}
		reader.close();
	}

}
