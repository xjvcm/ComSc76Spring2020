/**
 * (Count the occurrences of words in a text file) 
 * 
 * Rewrite Listing 21.9 to read
 * the text from a text file. The text file is passed as a command-line
 * argument. Words are delimited by whitespace characters, punctuation marks
 * (, ; . : ?), quotation marks (' "), and parentheses. Count the words in a
 * case-sensitive fashion (e.g., consider Good and good to be the same word).
 * The words must start with a letter. Display the output of words in
 * alphabetical order, with each word preceded by the number of times it occurs.
 */

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class manzanoJonathanAssignment6SAM {
  public static void main(String[] args) {
    // Check command-line argument length
    if (args.length != 1) {
      System.out.println("Usage: java Exercise_21_08 textFileName");
      System.exit(1);
    }

    // Instantiate file object to hold file passed in argument
    File file = new File(args[0]);

    Map<String, Integer> map = new TreeMap<>();

    try {
      Scanner input = new Scanner(file);
    } catch (IOException e) {
      
    }
  }
}