/**
 * Programmer: Manzano, Jonathan
 * Course: ComSc 76
 * Instructor: Estrada
 * Assignment: File I/O
 * Due date: Feb. 11th, 2020
 *
 * Description:
 */

import java.io.*;

public class manzanoJonathanAssignment2 {
  public static void main(String[] args) throws Exception {
    System.out.println("Hello world!");
  }
}

class BitOutputStream implements OutputStream {
  // Add attributes
  private byte bite;

  // Creates a BitOutputStream to write bits to the file.
  BitOutputStream(File file) {

  }

  // Writes a bit '0' or '1' to the output stream.
  public void writeBit(char bit) {
  }

  // Write a string of bits to the ouput stream.
  public void writeBit(String bit) {

  }

  // This method must be invoked to close the stream.
  public void close() {

  }
}