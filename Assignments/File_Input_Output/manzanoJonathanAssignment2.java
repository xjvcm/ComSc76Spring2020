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
  public static void main(String[] args) throws IOException {
    // Hello World
    // System.out.pri*ntln("Hello world!");

    try (
      // Create Outputstream to the file
      BitOutputStream output =
          new BitOutputStream(new FileOutputStream("temp.dat"));
    ) {
      // for (int i = 1; 1 <= 10; i++) {
      //   output.write(i);

    }
  }
}

class BitOutputStream {
  // Add attributes
  protected FileOutputStream file;
  protected byte bite = 00000000;
  protected int count = 0;

  // Creates a BitOutputStream to write bits to the file.
  BitOutputStream(FileOutputStream file) {
    this.file = file;
  }

  // Writes a bit '0' or '1' to the output stream.
  public void writeBit(char bit) {
    bite += (byte)bit;
    bite = bite << 1;
    count += 1;
  }

  // Write a string of bits to the ouput stream.
  public void writeBit(String bit) {

  }

  // This method must be invoked to close the stream.
  public void close() {

  }
}