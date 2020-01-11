/*
 *  Jordan Chou
 *  December 26, 2019
 *  Advent of Code: Day 2
 */
import java.util.Arrays;

public class Intcode {
  public static void main(String[] args) {
    int[] integersMain = {1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,6,19,1,19,5,23,2,13,23,
                          27,1,10,27,31,2,6,31,35,1,9,35,39,2,10,39,43,1,43,9,47,1,47,
                          9,51,2,10,51,55,1,55,9,59,1,59,5,63,1,63,6,67,2,6,67,71,2,10,
                          71,75,1,75,5,79,1,9,79,83,2,83,10,87,1,87,6,91,1,13,91,95,2,
                          10,95,99,1,99,6,103,2,13,103,107,1,107,2,111,1,111,9,0,99,2,14,0,0
                        };
    int[] integers = integersMain.clone();

    while (integers[0] != 19690720 && integers[1] <= 98) {
      for (int x = 0; x <= 99; x++) {
        for (int y = 0; y <= 99; y++) {
          integers = integersMain.clone();
          // System.out.println(Arrays.toString(integers));
          integers[1] = x;
          integers[2] = y;
          System.out.println("Noun: "+ x + ", Verb: " + y);
          // Check for opcode
          for (int i = 0; i < integers.length; i++) {
            // Opcode 99
            if (integers[i] == 99) {
              i = 0;
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
            if (integers[0] == 19690720)
              break;
          }
        }
      }
    }
    int noun = integers[1];
    int verb = integers[2];
    System.out.println("The value at position 0 is " + integers[0]);
    System.out.println("The noun is " + noun);
    System.out.println("The verb is " + verb);
    System.out.println("The output is " + (100 * noun + verb));



  }
}
