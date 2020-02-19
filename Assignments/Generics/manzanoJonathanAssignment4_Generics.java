/*
 * Programmer: Jonathan Manzano
 *
 * Date: 24 February 2020
 *
 * Assignment: Generics
 *
 * Description: This program is to test a sort method for ArrayList object
 * using generics
 *
 */

import java.util.ArrayList;

public class manzanoJonathanAssignment4_Generics {
  public static void main(String[] args) {
    // Create an ArrayLIst for Integer, Double, and String
    ArrayList<Integer> intArray = new ArrayList<>();
    ArrayList<Double> doubleArray = new ArrayList<>();
    ArrayList<String> stringArray = new ArrayList<>();

    // Add items to arraylist objects
    intArray.add(2);
    intArray.add(4);
    intArray.add(3);

    doubleArray.add(3.4);
    doubleArray.add(1.2);
    doubleArray.add(-12.3);

    stringArray.add("Bob");
    stringArray.add("Alice");
    stringArray.add("Ted");
    stringArray.add("Carol");

    // Sort the arrays
    sort(intArray);
    sort(doubleArray);
    sort(stringArray);

    // Display the sorted arrays
    System.out.print("Sorted Integer objects: ");
    printList(intArray);
    System.out.print("Sorted Double objects: ");
    printList(doubleArray);
    System.out.print("Sorted String objects: ");
    printList(stringArray);
  }

  public static<E extends Comparable<E>> void sort(ArrayList<E> list) {
    E currentMin;
    int currentMinIndex;

    for (int i = 0; i < list.size() - 1; i++) {
      // Find the minimum in the list[i+1..list.length−2]
      currentMin = list.get(i);
      currentMinIndex = i;

      for (int j = i + 1; j < list.size(); j++) {
        if (currentMin.compareTo(list.get(j)) > 0) {
          currentMin = list.get(j);
          currentMinIndex = j;
        }
      }

      // Swap list[i] with list[currentMinIndex] if necessary;
      if (currentMinIndex != i) {
        list.set(currentMinIndex, list.get(i));
        list.set(i, currentMin);
      }
    }
  }

  /** Print an array of objects */
  public static <E> void printList(ArrayList<E> list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + " ");
    }
    System.out.println();
  }
}