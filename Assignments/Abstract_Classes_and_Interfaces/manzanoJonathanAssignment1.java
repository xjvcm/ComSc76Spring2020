/**
 * Programmer: Manzano, Jonathan
 * Course: ComSc 76
 * Instructor: Estrada
 * Assignment: Abstract Classes and Interfaces
 *
 * Description:  A Triangle class is created and extends GeometricObject
 * class
 */
import java.util.Scanner;

public class manzanoJonathanAssignment1 {
  public static void main(String[] args) {
    // Instaniate & initalized scanner object;
    Scanner input = new Scanner(System.in);

    // Declare sides variables
    double side1, side2, side3;

    System.out.println("Welcome to Triangle creator!");
    System.out.println("Please eneter the length for the 3 sides to " +
        "create a triangle");
    System.out.print("Side 1: ");
    side1 = input.nextDouble();
    System.out.print("Side 2: ");
    side2 = input.nextDouble();
    System.out.print("Side 3: ");
    side3 = input.nextDouble();

    Triangle test = new Triangle(side1, side2, side3);

  }
}
class Triangle extends GeometricObject {
  private double side1;
  private double side2;
  private double side3;
  private double perimeter;
  private double area;

  public Triangle() {
  }

  public Triangle(double side1, double side2, double side3) {
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
  }

  public Triangle(
        double side1, double side2, double side3, String color,
            boolean filled) {
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
    setColor(color);
    setFilled(filled);
  }

  // Method to check if all 3 sides create a valid triangle
  public boolean isValid() {
    if (side1 + side2 <= side3 || side1 + side3 <= side2
        || side2 + side3 <= side1)
        return false;
    else
        return true;
  }

  @Override
  public double getPerimeter() {
    perimeter = side1 + side2 + side3;
    return perimeter;
  }

  @Override
  public double getArea() {
    area = Math.sqrt(perimeter * (perimeter - side1) * (perimeter - side2)
        * (perimeter - side3));
    return area;
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
  * the getter method is named isFilled */
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

  @Override
  public String toString() {
  return "created on " + dateCreated + "\ncolor: " + color +
  " and filled: " + filled;
  }

  /** Abstract method getArea */
  public abstract double getArea();

  /** Abstract method getPerimeter */
  public abstract double getPerimeter();
}