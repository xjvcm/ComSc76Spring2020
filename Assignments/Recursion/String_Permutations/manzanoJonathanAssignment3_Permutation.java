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
    System.out.println(userString);

		input.close();
  }

  public static void displayPermutation(String s) {
    return;
  }

  public static void displayPermutation(String s1, String s2) {
    return;
  }
}
