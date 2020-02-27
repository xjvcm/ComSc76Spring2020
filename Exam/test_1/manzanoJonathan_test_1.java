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
        int high = str.length();

        return charCount(str, ch, high);
    }

    public static int charCount(String str, char ch, int high) {
        if
        return 0;
    }

    public static void main(String[] args) {
        // System.out.println("Hello world");

        Scanner input = new Scanner(System.in);

        String str;
        char ch;

        System.out.print("Please enter desired string: ");
        str = input.nextLine();
        System.out.println("\nYou inputed: " + str);

        System.out.print("\nPlease enter desired character: ");
        ch = input.next().charAt(0);
        System.out.println("You inputted: " + ch);

        // charCount(str, ch);

        input.close();
    }
}