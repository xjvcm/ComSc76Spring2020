/**
 * Programmer: Manzano, Jonathan
 * Course: ComSc-076-201
 * Instructor: Estrada
 * Assignment: Test 1
 * Due date: Feb. 26, 2020
 *
 * Description:  This program will count the number of occurence of a specific
 * character defined by the user.  The user will inputl the desired string
 * followed by the character.
 */

import java.util.Scanner;

public class manzanoJonathan_test_1 {

  public static int charCount(String str, char ch) {
    // System.out.println("Helper Method");
    int high = str.length() - 1;
    // System.out.println("the ch is " + ch);
    // System.out.println("the length of the string is " + high);

    return charCount(str, ch, high);
  }

  public static int charCount(String str, char ch, int high) {
    // System.out.println("Recursive");
    int count = 0;

    // System.out.println(str.charAt(high));
    // System.out.println(ch);
    // System.out.println(high);
    // System.out.println(str.charAt(high));

    // for (int x = 0; x < str.length(); x++) {
    //   if (high == 0){
    //     return count;
    //   } else if (str.charAt(high) == ch) {
    //     System.out.println("This is hit");
    //     count++;
    //     high--;
    //     return count + charCount(str.substring(0, high) + str.substring(high + 1), ch, high);
    //   } else {
    //     high--;
    //     return count + charCount(str.substring(0, high) + str.substring(high + 1), ch, high);
    //   }
    // }
    
    if (high <= 0) {
      return 0;
    }

    count = str.charAt(high) == ch ? 1 : 0;
    return count + charCount(str, ch, high - 1);
  }

  public static void main(String[] args) {
    // System.out.println("Hello world");

    Scanner input = new Scanner(System.in);

    String str;
    char ch;
    int occurence = 0;


    System.out.print("Please enter desired string: ");
    str = input.nextLine();
    // System.out.println("\nYou inputed: " + str);

    /* Call the replaceAll() method to remove whitespace 
    and to use lowercase */
    str = str.replaceAll("\\s", "").toLowerCase();
    // System.out.println(str.charAt(str.length() - 1));

    System.out.print("\nPlease enter desired character: ");
    ch = input.next().charAt(0);
    // System.out.println("You inputted: " + ch);

    occurence = charCount(str, ch);
    System.out.println("\nThe number of occure of \"" + ch + 
        "\" in the string is " + occurence);

    input.close();
  }
}