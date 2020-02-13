/**
 * Programmer: Manzano, Jonathan
 * Course: ComSc-076-201
 * Instructor: Estrada
 * Assignment: File I/O
 * Due date: Feb. 13th, 2020
 *
 * Description:  This program implements a class name BitOutputStream for
 * writing a stream of bits to a file. The writeBit(char bit) or
 * writeBit(String bitString) methods stores the bit(s) in a byte variable.
 * When a byte is full, it is sent to the outputstream.  Now the byte is
 * reset to empty.  The program will close the stream by invoking the
 * close().  If a byte is netigher empty nor full, the close() method first
 * fills in zeros to make a full 8 bits in the byte, and then closes the
 * stream.
 */

import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;

public class manzanoJonathanAssignment2 {
  public static void main(String[] args) throws IOException {
    // Hello World
    // System.out.pri*ntln("Hello world!");


    // Instantiate BitOutputStream Object
    BitOutputStream output =
        new BitOutputStream(new File("testOutput.dat"));

    // invoke writeBit method
    output.writeBit('1');
    output.writeBit("0101");
    output.writeBit("010000100100001001101");

    // Close output stream
    output.close();


  }
}

class BitOutputStream {
  // Add attributes
  private FileOutputStream output;
  private int bite = 0;
  private int count = 0;
  //The bits are all zeros except the last one
  private int mask = 1;

  // Creates a BitOutputStream to write bits to the file.
  public BitOutputStream(File file) throws IOException {
    output = new FileOutputStream(file);
  }

  // Writes a bit '0' or '1' to the output stream.
  public void writeBit(char bit) throws IOException {
    count++;
    bite = bite << 1;

    // bite += (byte)bit;

    if (bit == '1') {
      bite = bit | mask;
    }

    if (count == 8) {
      output.write(bite);
      count = 0;
    }
  }

  // Write a string of bits to the ouput stream.
  public void writeBit(String bitString) throws IOException {
    for (int i = 0; i < bitString.length(); i++){
      writeBit(bitString.charAt(i));
    }
  }

  // This method must be invoked to close the stream.
  public void close() throws IOException {
    if (count > 0) {
      bite = bite << (8 - count);
      output.write(bite);
    }

    output.close();
  }
}