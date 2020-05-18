/**
 * Programmer: Manzano, Jonathan
 * Course: ComSc-076-201
 * Instructor: Estrada
 * Assignment: Efficient Algorithm
 * Due date: March 28, 2020
 *
 * Description:  (Closest pair of points) Section 22.8 introduced the following
 * algorithm for finding the closest pair of points using a divide-and-conquer
 * approach:
 * 
 * Step 1: Sort the points in increasing order of x-coordinates. For the points
 * with the same x-coordinates, sort on y-coordinates. The result should be a
 * sorted collection of points denoted by S.
 * 
 * Step 2: Divide S into two subsets, S1 and S2, of equal size about the
 * midpoint of the sorted list S. Include the midpoint in S1. Recursively find
 * the closest pair in S1 and S2. Let d1 and d2 denote the distance of closest
 * pairs in the two subsets, respectively.
 * 
 * Step 3: Find the closest pair between a point in S1 and a point in S2 and
 * denote the distance between them as d3. The closest pair is the one with
 * distance equal to the minimum of {d1, d2, d3}.
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;


class Point implements Comparable<Point> {
  // Declare X and Y attributes
  private double x;
  private double y;

  // Constructors
  Point() {                  // Explicit default constructors
    this(0,0);
  }

  // two-arg constructor
  Point(double x, double y) {
    super();
    this.x = x;
    this.y = y;
  }

  // Getter for X
  public double getX() {
    return x;
  }

  // Setter for X
  public void setX(double x) {
    this.x = x;
  }

  // Getter for Y
  public double getY() {
    return y;
  }

  // Setter for Y
  public void setY(double y) {
    this.y = y;
  }

  // Override toString method
  @Override
  public String toString() {
    return "[" + String.format("%.2f", getX()) + ", " + String.format("%.2f",
        getY()) + "]";
  }

  // Implement Comparable Interface's compareTo method
  @Override
  public int compareTo(Point point) {
    if (x < point.x) {
      return -1;
    } else if (x > point.x) {
      return 1;
    } else {
       if (y < point.y) {
          return -1;
        } else if (y > point.y) {
          return 1;
        } else {
          return 0;
        }
    }
  }
}

class CompareY implements Comparator<Point> {
  @Override
  public int compare(Point p1, Point p2) {
    if (p1.getY() > p2.getY()) {
      return 1;
    } else if (p1.getY() < p2.getY()) {
      return -1;
    } else {
      if (p1.getX() > p2.getX()) {
        return 1;
      } else if (p1.getX() < p2.getX()) {
        return -1;
      } else {
        return 0;
      }
    }
  }
}

class Pair {
  private Point p1;
  private Point p2;

  public Point getP1() {
    return p1;
  }

  public void setP1(Point p1) {
    this.p1 = p1;
  }

  public Point getP2() {
    return p2;
  }

  public void setP2(Point p2) {
    this.p2 = p2;
  }

  public Pair(Point p1, Point p2) {
    super();
    this.p1 = p1;
    this.p2 = p2;
  }

  public double getDistance()  {
    return distance(p1, p2);
  }
  
  /** Compute the distance btween two points p1 and p2 */
  public static double distance(Point p1, Point p2) {
    return distance(p1.getX(), p1.getY(), p2.getX(), p2.getY());
  }

  /** Compute th distance btween points (x1, y1) nad (x2, y2) */
  public static double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
  }

  public static Pair distance(Point[] pointsOrderedOnX, int low, int high,
      Point[] pointsOrderedOnY) {
    
    if (low >= high) {
      return null;
    } else if (low + 1 == high) {
      return new Pair(pointsOrderedOnX[low], pointsOrderedOnX[high]);
    }

    int halfSize = (low + high) / 2;
    Pair p1 = distance(pointsOrderedOnX, low, halfSize, pointsOrderedOnY);
    Pair p2 = distance(pointsOrderedOnX, halfSize + 1, high, pointsOrderedOnY);

    double distance = 0;
    Pair p = null;

    if (p1 == null && p2 == null) {
      distance = Double.MAX_VALUE;
    } else if (p1 == null) {
      distance = p2.getDistance();
      p = p2;
    } else if (p2 == null) {
      distance = p1.getDistance();
      p = p1;
    } else {
      distance = Math.min(p1.getDistance(), p2.getDistance());
      p = ((p1.getDistance() <= p2.getDistance()) ? p1 : p2);
    }

    ArrayList<Point> stripL = new ArrayList<Point>();
    ArrayList<Point> stripR = new ArrayList<Point>();

    for (int i = 0; i < pointsOrderedOnY.length; i++) {
      if ((pointsOrderedOnY[i].getX() <= pointsOrderedOnX[halfSize].getX()) &&
          (pointsOrderedOnY[i].getX() >= pointsOrderedOnX[halfSize].getX() -
              distance)) {
        stripL.add(pointsOrderedOnY[i]);
      } else {
        stripR.add(pointsOrderedOnY[i]);
      }
    }

    
    double d3 = distance;
    int r = 0;

    for (int i = 0; i < stripL.size(); i++) {
      while (r < stripR.size() && stripL.get(i).getY() > stripR.get(r).getY() +
          distance) {
        r++;
      }

      int r1 = r;

      while (r1 < stripR.size() && stripR.get(r1).getY() <= stripL.get(i).getY()
          + distance) {
        if (d3 > distance(stripL.get(i), stripR.get(r1))) {
          d3 = distance(stripL.get(i), stripR.get(r1));
          p.p1 = stripL.get(i);
          p.p2 = stripR.get(r1);
        }
        r1++;
      }
    }

    return p;
  }
  
  /** Return the distance of the closest pair of points */
  public static Pair getClosestPair(Point[] points) {
    Arrays.sort(points);
    Point[] pointsOrderedOnY = points.clone();
    Arrays.sort(pointsOrderedOnY, new CompareY());
    return distance(points, 0, points.length - 1, pointsOrderedOnY);
  }
  
  /** Return the distance of the closest pair of points */
  public static Pair getClosestPair(double[][] points) {
    Point[] points2 = new Point[points.length];
    for (int i = 0; i < points.length; i++) {
      points2[i] = new Point(points[i][0], points[i][1]);
    }
    return getClosestPair(points2);
  }
}

public class Jonathan_Manzano_EfficientAlgorithms {
  public static void main(String[] args) {
    Point[] points = new Point[500];
    for (int i = 0; i < points.length; i++) {
      points[i] = new Point((int)(Math.random() * 1000000),
          (int)(Math.random() * 1000000));
    }

    Pair pair = Pair.getClosestPair(points);
    System.out.println(pair.getP1());
    System.out.println(pair.getP1());
    System.out.println(pair.getDistance());
  }
}