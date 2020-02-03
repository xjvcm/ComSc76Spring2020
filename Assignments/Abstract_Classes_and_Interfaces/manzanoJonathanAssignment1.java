/**
 * Programmer: Manzano, Jonathan
 * Course: ComSc 76
 * Instructor: Estrada
 * Assignment: Abstract Classes and Interfaces
 * Due date: Feb. 4th, 2020
 *
 * Description:  A Triangle class is created and extends GeometricObject
 * class.  Abstact methods are inhearted from the super class.  The user is
 * presented with a menu to select a desired shape(Circle, rectangle, and
 * triangle).  Program will prompt user to input specific data for each
 * shape.  Circle requirs a radius, rectangle requires width and length,
 * and triangle requires three side lengths.  The program will validate
 * the users inputted side lengths for the triangle object if it creates a
 * valid triangle.  After input required data, the program will then prompt
 * after to ask what color is the shape and if it is filled.  After all
 * data is inputted, program will then print on the console the area,
 * perimeter, color and boolean value if it is filled.
 */
import java.util.Scanner;

public class manzanoJonathanAssignment1 {
  public static void main(String[] args) {
    // Instaniate & initalized scanner object;
    Scanner input = new Scanner(System.in);

    // Program variables
    boolean quit = true;

    // Declare geomentric object variables
    String color;
    boolean filled;
    char selection;

    // Declare circle variables
    double radius = 0.0;

    // Declare rectangle variables
    double width, height;

    // Declare triangle variables
    double side1 = 0.0;
    double side2 = 0.0;
    double side3 = 0.0;
    boolean valid = false;

    System.out.println("Welcome to the Geometric Object Creator!");

    // Do-while loop to keep prompt the user to create geometric objects
    // until user quits.
    do {
      // Prompt user to input data
      System.out.println("Please select a shape to create:");
      System.out.println("(C) - Circle");
      System.out.println("(R) - Rectangle");
      System.out.println("(T) - Triangle");
      System.out.println("(Q) - QUIT");
      System.out.print("Input the following letter for desired shape: ");
      selection = input.next().charAt(0);

      switch(selection) {
        case 'c':
        case 'C':

          // Validate radius length greater than zero
          while(!valid) {
            System.out.print("Radius length: ");
            radius = input.nextDouble();
            // Validate user's input
            if (radius > 0) {
              valid = true;
            } else {
              System.out.println("Radius cannot be negative!\n");
            }
          }

          System.out.print("Color: ");
          color = input.next();
          System.out.print("Filled? ('true' or 'false'): ");
          filled = input.nextBoolean();

          System.out.println("\nCircle Specifications:");

          Circle circle = new Circle(radius, color, filled);

          System.out.println("\n" + circle.toString() + "\n");
          break;
        case 'r':
        case 'R':
          System.out.print("Width length: ");
          width = input.nextDouble();
          System.out.print("Height length: ");
          height = input.nextDouble();
          System.out.print("Color: ");
          color = input.next();
          System.out.print("Filled? ('true' or 'false'): ");
          filled = input.nextBoolean();

          System.out.println("\nRectangle Specifications:");

          Rectangle rectangle = new Rectangle(width, height, color, filled);
          System.out.println("\n" + rectangle.toString() + "\n");
          break;
        case 't':
        case 'T':
          while(!valid) {
            System.out.print("Side 1 length: ");
            side1 = input.nextDouble();
            System.out.print("Side 2 length: ");
            side2 = input.nextDouble();
            System.out.print("Side 3 length: ");
            side3 = input.nextDouble();

            // Validate user's input
            if (side1 + side2 > side3 && side1 + side3 > side2
                && side2 + side3 > side1) {
              valid = true;
            } else {
              System.out.println("Invalid side lengths!\n");
            }
          }

          Triangle triangle = new Triangle(side1, side2, side3);

          // Prompt user to continue inputting data
          System.out.print("Color: ");
          color = input.next();
          System.out.print("Filled? ('true' or 'false'): ");
          filled = input.nextBoolean();

          System.out.println("\nTriangle Specifications:");
          System.out.println("\n" + triangle.toString() + "\n");
          break;
        default:
          quit = false;
          break;
      }
    } while(quit);
    input.close();
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

class Triangle extends GeometricObject {
  private double side1;
  private double side2;
  private double side3;

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

  @Override
  public double getPerimeter() {
    return side1 + side2 + side3;
  }

  @Override
  public double getArea() {
    double perimeter = getPerimeter();

    return Math.sqrt(perimeter * (perimeter - side1) * (perimeter - side2)
    * (perimeter - side3));
  }

  @Override
  public String toString() {
    return "\tArea: " + getArea() + "\n\tPerimeter: " + getPerimeter()
        + "\n\tColor: " + getColor() + "\n\tFilled: " + isFilled();
  }
}

class Circle extends GeometricObject {
  private double radius;

  public Circle() {
  }

  public Circle(double radius) {
    this.radius = radius;
  }

  public Circle(double radius, String color, boolean filled) {
    this.radius = radius;
    setColor(color);
    setFilled(filled);
  }

  /** Return radius */
  public double getRadius() {
    return radius;
  }

  /** Set a new radius */
  public void setRadius(double radius) {
    this.radius = radius;
  }

  /** Return area */
  public double getArea() {
    return radius * radius * Math.PI;
  }

  /** Return diameter */
  public double getDiameter() {
    return 2 * radius;
  }

  /** Return perimeter */
  public double getPerimeter() {
    return 2 * radius * Math.PI;
  }

  /** Print the circle info */
  public void printCircle() {
    System.out.println("The circle is created " + getDateCreated()
        + " and the radius is " + radius);
  }

  @Override
  public String toString() {
    return "\tArea: " + getArea() + "\n\tPerimeter: " + getPerimeter()
    + "\n\tColor: " + getColor() + "\n\tFilled: " + isFilled();
  }
}

class Rectangle extends GeometricObject {
  private double width;
  private double height;

  public Rectangle() {
  }

  public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  public Rectangle(double width, double height, String color,
      boolean filled) {
    this.width = width;
    this.height = height;
    setColor(color);
    setFilled(filled);
  }

  /** Return width */
  public double getWidth() {
    return width;
  }

  /** Set a new width */
  public void setWidth(double width) {
    this.width = width;
  }

  /** Return height */
  public double getHeight() {
    return height;
  }
  /** Set a new height */
  public void setHeight(double height) {
    this.height = height;
  }
  /** Return area */
  public double getArea() {
    return width * height;
  }

  /** Return perimeter */
  public double getPerimeter() {
    return 2 * (width + height);
  }

  /** Modifed toString method */
  @Override
  public String toString() {
    return "\tArea: " + getArea() + "\n\tPerimeter: " + getPerimeter()
    + "\n\tColor: " + getColor() + "\n\tFilled: " + isFilled();
  }
}

