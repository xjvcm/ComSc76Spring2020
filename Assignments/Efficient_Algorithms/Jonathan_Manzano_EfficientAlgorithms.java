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

