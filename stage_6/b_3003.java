package stage_6;

import java.util.Scanner;

public class b_3003 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int[] composition = {1, 1, 2, 2, 2, 8};
    int[] input_arr = new int[composition.length];
    for(int i=0; i< composition.length; i++) {
      input_arr[i] = scan.nextInt();
    }
    for(int j=0; j< composition.length; j++) {
      System.out.print(composition[j] - input_arr[j]+" ");
    }
  }
}
