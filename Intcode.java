/*
 *  Jordan Chou
 *  December 26, 2019
 *  Advent of Code: Day 2
 */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Intcode {
  public static void main(String[] args) {
    int[] integers;
    Scanner scanner = null;
    String line = "";

    try {
      scanner = new Scanner(new File("int.txt"));

      // Store values as a String array
      while(scanner.hasNext())
        line = scanner.next();
      String[] values = line.split(",");
      integers = new int[values.length];

      // Store String array into int array
      for (int i = 0; i < integers.length; i++)
        integers[i] = Integer.parseInt(values[i]);

      integers[1] = 12;
      integers[2] = 2;

      // Check for opcode
      for (int i = 0; i < integers.length; i++) {
        // Opcode 99
        if (integers[i] == 99) {
          break;
        }

        // Opcode 1
        if (integers[i] == 1) {
          integers[integers[i+3]] = integers[integers[i+1]] + integers[integers[i+2]];
          i += 3;
        }

        // Opcode 2
        else if (integers[i] == 2) {
          integers[integers[i+3]] = integers[integers[i+1]] * integers[integers[i+2]];
          i += 3;
        }
      }

      System.out.println("The value at position 0 is " + integers[0]);
    }
    catch (IOException ex) {
      System.err.println("An IOException was caught");
      ex.printStackTrace();
    }
    finally {
      scanner.close();
    }



  }
}
