/*
 * Programmer: Jonathan Manzano
 *
 * Date: 10 March 2020
 *
 * Assignment: List, Stacks, and Queues
 *
 * Description: Define a class named Point with two data fields x and y to
 * represent a point's x- and y-coordinates. Implement the Comparable interface
 * for the comparing the points on x-coordinates. If two points have the same
 * x-coordinates, compare their y-coordinates.
 *
 * Define a class named CompareY that implements Comparator<Point>. Implement
 * the compare method to compare two points on their y-coordinates. If two
 * points have the same y-coordinates, compare their x-coordinates.
 *
 * Randomly create 100 points and apply the Arrays.sort method to display the
 * points in increasing order of their x-coordinates, and increasing order of
 * their y-coordinates, respectively.
 *
 */

import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class manzanoJonathanAssignment5 {
  public static void main(final String[] args) {
    // Instantiate ArrayList object with List interface
    final List<Point> coordinates = new ArrayList<>();

    // Instantiate Random object to create random double number
    final Random rand = new Random();

    // Instantiate Comparator object to use in collection sort method
    final CompareY comparator = new CompareY();

    // Create 100 random double points and populate ArrayList
    for (int i = 0; i <= 100; i++) {
      final double random1 = 1 + rand.nextDouble() * 100;
      final double random2 = 1 + rand.nextDouble() * 100;

      coordinates.add(i, new Point(random1, random2));
    }

    // Invoke sort method to sorty by increasing X values
    Collections.sort(coordinates);

    // Instantiate Iterator to iterate through ArrayList
    Iterator<Point> iterator = coordinates.iterator();

    // Iterate and print list
    System.out.println("Coordinate list sorted by increasing X values:\n");
    while (iterator.hasNext()) {
      System.out.println(iterator.next().toString());
    }

    // Sort ArrayList by increasing Y values using comparator
    Collections.sort(coordinates, comparator);
    iterator = coordinates.iterator();

    // Iterate and print list
    System.out.println("\n\nCoordinate list sorted by increasing Y values:\n");
    while (iterator.hasNext()) {
      System.out.println(iterator.next().toString());
    }

  }
}

class Point implements Comparable<Point> {
  // Declare X and Y attributes
  private double x;
  private double y;

  // No-arg constructor
  Point() {
  }

  // two-arg constructor
  Point(final double x, final double y) {
    this.x = x;
    this.y = y;
  }

  // Getter for X
  public double getX() {
    return this.x;
  }

  // Setter for X
  public void setX(final int x) {
    this.x = x;
  }

  // Getter for Y
  public double getY() {
    return this.y;
  }

  // Setter for Y
  public void setY(final int y) {
    this.y = y;
  }

  // Override toString method
  @Override
  public String toString() {
    return "[" + String.format("%.2f", getX()) + ", " + String.format("%.2f", getY()) + "]";
  }

  // Implement Comparable Interface's compareTo method
  @Override
  public int compareTo(final Point point) {
    if (this.getX() < point.getX()) {
      return -1;
    } else if (this.getX() > point.getX()) {
      return 1;
    } else if (this.getY() < point.getY()) {
      return -1;
    } else if (this.getY() > point.getY()) {
      return 1;
    } else {
      return 0;
    }
  }
}

class CompareY implements Comparator<Point> {

  // Implement Comparator Interface compare method
  @Override
  public int compare(final Point point1, final Point point2) {
    if (point1.getY() < point2.getY()) {
      return -1;
    } else if (point1.getY() > point2.getY()) {
      return 1;
    } else if (point1.getX() < point2.getX()) {
      return -1;
    } else if (point1.getX() > point2.getX()) {
      return 1;
    } else {
      return 0;
    }
  }
}