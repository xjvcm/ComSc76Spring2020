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
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class CountOccurences {
  public static void main(String[] args) {
    
    // Check command-line argument length
    if (args.length != 1) {
      System.out.println("Usage: java CountOccurences " +
          "Text File Name");
      System.exit(1);
    }
    
    try {
      // Instantiate file object to hold file passed in argument
      File file = new File(args[0]);

      Scanner input = new Scanner(file);

      TreeMap<String, Integer> treeMap = new TreeMap<>();
      while (input.hasNext()) {
        String line = input.nextLine();
        String[] words = line.split("[\\s\\p{P}]+");
  
        for (int i = 0; i < words.length; i++) {
          if (words[i].length() > 0 && words[i].matches("[\\w]+")) {
            String key = words[i].toLowerCase();
  
            if (treeMap.get(key) != null) {
              int count = treeMap.get(key);
              count++;
              treeMap.put(key, count);
            } else {
              treeMap.put(key, 1);
            }
          }
        }
      }
      Set<Map.Entry<String, Integer>> entrySet = treeMap.entrySet();
  
      // Retrieve an entry set for the tree map
      System.out.println("\nDisplay words and their count in " +
          " ascending order of the word");
  
      // Display words in aplhabetical order
      for (Map.Entry<String, Integer> entry: entrySet) {
        System.out.println(entry.getValue() + "\t" + entry.getKey());
      }
    } catch (FileNotFoundException ex) {
      System.out.println("File does not exist!");
      System.exit(1);
    }

  }
}