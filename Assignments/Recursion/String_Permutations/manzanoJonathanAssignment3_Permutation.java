/*
 * Programmer: Jonathan Manzano
 *
 * Date: 08 October 2019
 *
 * Assignment: Recursion Part II - String Permutation
 *
 * ~ Description goes here ~
 *
 */

import java.util.Scanner;

public class manzanoJonathanAssignment3_Permutation {

	public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Instantiate user input variable
    String userString;

    // User's input has ASCI escape BOLD ON
    System.out.print("Enter your string: \u001b[1m");
    userString = input.nextLine();

    // Turns off BOLD
    System.out.println("\u001b[22m");

    // Print user input
    // System.out.println(userString);

    displayPermutation(userString);

		input.close();
  }

  public static void displayPermutation(String s) {
    displayPermutation(s, "");
  }

  public static void displayPermutation(String s1, String s2) {
    // If string is empty
    if (s1.length() == 0) {
      System.out.println(s2 + " ");
    }

    for (int i = 0; i < s1.length(); i++) {

      // ith character of s1
      char ch = s1.charAt(i);

      // Rest of the string after excluding the 8th character
      String ros = s1.substring(0, i) + s1.substring(i + 1);

      // recursive call
      displayPermutation(ros, s2 + ch);
    }
  }
}
