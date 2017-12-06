package hangman;

import java.util.Scanner;
import edu.princeton.cs.introcs.StdIn;
import hangman.Utilities;

public class Test2 {
	public static int count=0;

	public static void main(String[] args) {
		String word = "hello";
		String str = new String(new char[word.length()]).replace("\0", "*");
//		String asterisk = new String(new char[word.length()]).replaceAll("/0", "*");
		System.out.println("test " + str);
	}
}
