package stage_5;

import java.util.Scanner;

public class b_2675 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int test_amount = scan.nextInt();
    int[] count_arr = new int[test_amount];
    String[] line_arr = new String[test_amount];
    for(int i=0; i<test_amount; i++) {
      int count = scan.nextInt();
      String line = scan.next();
      count_arr[i] = count;
      line_arr[i] = line;
    }
    for(int j=0; j<test_amount; j++) {
        for(int l=0; l<line_arr[j].length(); l++) {
          for(int k=0; k<count_arr[j]; k++) {
            System.out.print(line_arr[j].toCharArray()[l]);
        }
      }
      System.out.println();
    }
  }
}
