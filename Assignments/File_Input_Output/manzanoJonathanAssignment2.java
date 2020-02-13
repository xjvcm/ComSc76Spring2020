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

public static class BitOutputStream {
  // Add attributes
  private FileOutputStream output;
  protected int bite = 0;
  protected int count = 0;
  //The bits are all zeros except the last one
  //
  protected int mask = 1;

  // Creates a BitOutputStream to write bits to the file.
  public BitOutputStream(File file) throws IOException {
    output = new FileOutputStream(file);
  }

  // Writes a bit '0' or '1' to the output stream.
  public void writeBit(char bit) throws IOException{
    count++;
    bite = bite << 1;

    // bite += (byte)bit;

    if (bit == '1') {
      bite = bite | mask;
    }

    if (count == 8) {
      file.write(bite);
      count = 0;
    }
  }

  // Write a string of bits to the ouput stream.
  public void writeBit(String bitString) throws IOException {
    for (int i = 0; i <bitstring.length(); i++)
    writeBit(bitString.charAt(i));
  }

  // This method must be invoked to close the stream.
  public void close() {
    if (count > 0) {
      bite = bite << (8 - count);
      output.write(value);
    }

    output.close();
  }
}