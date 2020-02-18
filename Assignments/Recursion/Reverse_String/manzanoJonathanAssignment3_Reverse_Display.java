/*
 * Programmer: Jonathan Manzano
 *
 * Date: 20 February 2020
 *
 * Assignment: Recurrsion Part 1 - Reserve Display
 *
 * Let user input a string. If user input length is less than or equal to
 * one or equals null then print input. If  user's input length is greater
 * than 1 then invoke reverse display method by passing the user input.
 * Reverse display method will invoke a helper method to overload the same
 * method by passing the user input and last character index of the input.
 * The method will print the last character passed then invoke itself by
 * passing a substring of the beginning and second to last character of the
 * value passed.  When the value length is less than zero then print new
 * line and end program.
 *
 */

import java.util.Scanner;

public class manzanoJonathanAssignment3_Reverse_Display {
  public static void main(String[] args) {
    // Instantiate string variable for user input
    String userString;

    // Create a scanner input object
    Scanner input = new Scanner(System.in);

    // User's input has ASCI escape BOLD ON
    System.out.print("Enter your string: \u001b[1m");
    userString = input.nextLine();

    // Turns off BOLD
    System.out.println("\u001b[22m");

    // If user's input lenght is 1 or less then it will return and end
    if (userString.length() <= 1 || userString == null) {
      System.out.println(userString);
    } else {
      // Invoke reserve display method
      reserveDisplay(userString);
    }

    // Print userString value
    // System.out.println(userString);

    input.close();
  }

  // Helper method to overload recursive method
  public static void reserveDisplay(String value) {
    reserveDisplay(value, value.length() - 1);
  }

  public static void reserveDisplay(String value, int high) {
    /* If the index of the last character of the value is less than zero
     * then print new line and end program */
    if (high < 0) {
      System.out.println("");
    } else {
    /* If the index of the last character of the value is zero or greater
     * then print the character at that index.  Use recursion to invoke the
     * method itself and pass a substring of the current value from the
     * index of 0 to second to last character(length - 1). */
      System.out.print(value.charAt(high));
      reserveDisplay(value.substring(0, value.length() - 1));
    }
  }
}