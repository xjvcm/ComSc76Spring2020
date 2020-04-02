/**
 * Programmer: Manzano, Jonathan
 * Course: ComSc-076-201
 * Instructor: Estrada
 * Assignment: Test 2
 * Due date: April 02, 2020
 *
 * Description: Write the following two generic methods using merge sort.
 * The first sorts theelements using the Comparable interface, and the second
 * uses the Comparator interface. Find the source code you need to complete
 * this program at Canvas\Files\Source Code.
 */

import java.io.Serializable;
import java.util.Comparator;
import java.util.Arrays;

public class Jonathan_Manzano_Test2 {
  public static void main(String[] args) {
    Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    mergeSort(list);

    System.out.println("Array of Integers sorted with Merge Sort:");
    System.out.print("[");
    for (int i = 0; i < list.length; i++){
      System.out.print(list[i] + (i == list.length - 1 ? "" : ", "));
    }
    System.out.println("]");

    System.out.print("\n\n");

    System.out.println("Array of Circles sorted by area with Merge Sort:");
    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
        new Circle(5), new Circle(6), new Circle(1), new Circle(2),
        new Circle(3), new Circle(14), new Circle(12)};
    
    mergeSort(list1, new CircleComparator());
    
    System.out.println("[");
    for (int i = 0; i < list1.length; i++) {
      System.out.printf("\tCircle %d Area: %.2f%s%n", i + 1, list1[i].getArea(),
          (i == list.length - 1 ? "" : ","));
    }
    System.out.println("]");
  }

  /* Generic merge sort using Comparable */
  public static <E extends Comparable<E>> void mergeSort(E[] list) {
    if (list.length > 1) {
      // Merge sort the first half
      @SuppressWarnings("unchecked")
      E[] firstHalf = (E[])new Comparable[list.length / 2];
      System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
      mergeSort(firstHalf);
      // Merge sort the second half
      int secondHalfLength = list.length - list.length / 2;
      @SuppressWarnings("unchecked")
      E[] secondHalf = (E[])new Comparable[secondHalfLength];
      System.arraycopy(list, list.length / 2,
        secondHalf, 0, secondHalfLength);
      mergeSort(secondHalf);
      // Merge firstHalf with secondHalf into list
      merge(firstHalf, secondHalf, list);
    }
  }
  /** Merge two sorted lists */
  public static <E extends Comparable<E>> void merge(E[] list1, E[] list2,
      E[] temp) {
    int current1 = 0; // Current index in list1
    int current2 = 0; // Current index in list2
    int current3 = 0; // Current index in temp
    while (current1 < list1.length && current2 < list2.length) {
      if (list1[current1].compareTo(list2[current2]) < 0)
        temp[current3++] = list1[current1++];
      else
        temp[current3++] = list2[current2++];
    }
    while (current1 < list1.length)
      temp[current3++] = list1[current1++];
    while (current2 < list2.length)
      temp[current3++] = list2[current2++];
  }

  /* Generic Merge Sort using Comparator Interface */
  public static <E> void mergeSort(E[] list, Comparator<? super E> comparator) {
    if (list.length > 1) {
      // Merge sort the first half
      E[] firstHalf = Arrays.copyOf(list, list.length / 2);
      mergeSort(firstHalf, comparator);

      // Merge sort the second half
      E[] secondHalf = Arrays.copyOfRange(list, list.length / 2, list.length);
      mergeSort(secondHalf, comparator);
      // Merge firstHalf with secondHalf into list
      merge(firstHalf, secondHalf, list, comparator);
    }
  }
  /** Merge two sorted lists */
  public static <E> void merge(E[] list1, E[] list2, E[] temp,
      Comparator<? super E> comparator) {
    int current1 = 0; // Current index in list1
    int current2 = 0; // Current index in list2
    int current3 = 0; // Current index in temp
    while (current1 < list1.length && current2 < list2.length) {
      if (comparator.compare(list1[current1], list2[current2]) < 0)
        temp[current3++] = list1[current1++];
      else
        temp[current3++] = list2[current2++];
    }
    while (current1 < list1.length)
      temp[current3++] = list1[current1++];
    while (current2 < list2.length)
      temp[current3++] = list2[current2++];
  }
}

abstract class GeometricObject {
  private String color = "white";
  private boolean filled;
  private java.util.Date dateCreated;
  /** Construct a default geometric object */
  protected GeometricObject() {
    dateCreated = new java.util.Date();
  }
  /** Construct a geometric object with color and filled value */
  protected GeometricObject(String color, boolean filled) {
    dateCreated = new java.util.Date();
    this.color = color;
    this.filled = filled;
  }
  /** Return color */
  public String getColor() {
    return color;
  }
  /** Set a new color */
  public void setColor(String color) {
    this.color = color;
  }
  /** Return filled. Since filled is boolean,
   *  the get method is named isFilled */
  public boolean isFilled() {
    return filled;
  }
  /** Set a new filled */
  public void setFilled(boolean filled) {
    this.filled = filled;
  }
  /** Get dateCreated */
  public java.util.Date getDateCreated() {
    return dateCreated;
  }
  /** Return a string representation of this object */
  public String toString() {
    return "created on " + dateCreated + "\ncolor: " + color +
      " and filled: " + filled;
  }
  /** Abstract method getArea */
  public abstract double getArea();
  /** Abstract method getPerimeter */
  public abstract double getPerimeter();
}

class Circle extends GeometricObject {
  private double radius;
  public Circle() {
  }
  public Circle(double radius) {
    this.radius = radius;
  }
  /** Return radius */
  public double getRadius() {
    return radius;
  }
  /** Set a new radius */
  public void setRadius(double radius) {
    this.radius = radius;
  }
  @Override /** Return area */
  public double getArea() {
    return radius * radius * Math.PI;
  }
  /** Return diameter */
  public double getDiameter() {
    return 2 * radius;
  }
  @Override /** Return perimeter */
  public double getPerimeter() {
    return 2 * radius * Math.PI;
  }
  /* Print the circle info */
  public void printCircle() {
    System.out.println("The circle is created " + getDateCreated() +
      " and the radius is " + radius);
  }
}

class CircleComparator implements Comparator<Circle>, Serializable {
  private static final long serialVersionUID = 1L;

  // Implementing comparator compare method
  @Override
  public int compare(Circle c1, Circle c2) {
    double area1 = c1.getArea();
    double area2 = c2.getArea();
    
    // Compare areas
    if (area1 < area2) {
      return -1;
    } else if (area1 == area2) {
      return 0;
    } else {
      return 1;
    }
  }
}